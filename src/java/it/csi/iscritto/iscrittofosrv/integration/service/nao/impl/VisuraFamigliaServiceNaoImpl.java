package it.csi.iscritto.iscrittofosrv.integration.service.nao.impl;

import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_ERROR;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.buildMessage;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import it.csi.iscritto.iscrittofosrv.dto.common.CallerInfo;
import it.csi.iscritto.iscrittofosrv.dto.domanda.DatiFasciaEta;
import it.csi.iscritto.iscrittofosrv.dto.nao.AnagraficaComponente;
import it.csi.iscritto.iscrittofosrv.dto.nao.AnnoLimite;
import it.csi.iscritto.iscrittofosrv.dto.nao.ComponenteFamiglia;
import it.csi.iscritto.iscrittofosrv.dto.nao.DettaglioFamiglia;
import it.csi.iscritto.iscrittofosrv.dto.nao.InfoNao;
import it.csi.iscritto.iscrittofosrv.dto.nao.LuogoNascitaComponente;
import it.csi.iscritto.iscrittofosrv.dto.nao.PropertyAnnoLimite;
import it.csi.iscritto.iscrittofosrv.dto.nao.ResidenzaFamiglia;
import it.csi.iscritto.iscrittofosrv.exception.ServiceException;
import it.csi.iscritto.iscrittofosrv.integration.converter.nao.ComponenteFamigliaConverter;
import it.csi.iscritto.iscrittofosrv.integration.converter.nao.DettaglioFamigliaConverter;
import it.csi.iscritto.iscrittofosrv.integration.converter.nao.ResidenzaFamigliaConverter;
import it.csi.iscritto.iscrittofosrv.integration.service.domanda.DomandaSrvBean;
import it.csi.iscritto.iscrittofosrv.integration.service.luoghi.LuoghiSrvBean;
import it.csi.iscritto.iscrittofosrv.integration.service.nao.AbstractServiceNao;
import it.csi.iscritto.iscrittofosrv.integration.service.nao.VisuraFamigliaServiceNao;
import it.csi.iscritto.iscrittofosrv.integration.service.nao.client.JavaServiceDesc;
import it.csi.iscritto.iscrittofosrv.integration.service.nao.client.VisuraSoggetto;
import it.csi.iscritto.iscrittofosrv.integration.service.scuole.ScuoleSrvBean;
import it.csi.iscritto.iscrittofosrv.util.Constants;
import it.csi.iscritto.iscrittofosrv.util.DateUtils;
import it.csi.iscritto.iscrittofosrv.util.NaoUtils;
import it.csi.iscritto.serviscritto.dto.luoghi.Luogo;

@Repository
@Primary
public class VisuraFamigliaServiceNaoImpl extends AbstractServiceNao implements VisuraFamigliaServiceNao {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".integration.service");

	@Autowired
	private JavaServiceDesc srvVisuraFamiglia;

	@Autowired
	private LuoghiSrvBean luoghiSrvBean;

	@Autowired
	private ScuoleSrvBean scuoleSrvBean;

	@Autowired
	private DomandaSrvBean domandaSrvBean;

	@Override
	public InfoNao dettaglioFamigliaPerCodiceFiscale(CallerInfo callerInfo, String codiceFiscale) throws ServiceException {
		final String methodName = "dettaglioFamigliaPerCodiceFiscale";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notBlank(codiceFiscale, "codice fiscale nullo");

		InfoNao result = new InfoNao();

		List<DatiFasciaEta> datiFasceEta;
		List<AnnoLimite> anniLimiteMaterna;
		AnnoLimite annoLimiteNido;
		try {
			datiFasceEta = this.domandaSrvBean.getFasceEta(callerInfo);

			annoLimiteNido = this.getAnnoLimiteNido();
			result.setAnnoLimiteNido(annoLimiteNido.getAnnoLimite());

			anniLimiteMaterna = this.getAnniLimiteMaterna();
			Map<String, PropertyAnnoLimite> index = new LinkedHashMap<>();
			for (AnnoLimite al : anniLimiteMaterna) {
				index.put(al.getCodiceAnnoScolastico(), new PropertyAnnoLimite(al.getAnnoLimite()));
			}

			result.setAnniScolasticiMaterna(index);
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		//////////////////////////////////////////////////////////////////////

		try {
			it.csi.iscritto.iscrittofosrv.integration.service.nao.client.DettaglioFamiglia response =
					this.srvVisuraFamiglia.dettaglioFamigliaPerCodiceFiscale(
							codiceFiscale, this.buildDatiProfilati(), this.buildUtenteServizio());

			List<VisuraSoggetto> soggetti = ComponenteFamigliaConverter.unwrap(response.getComponentiFamiglia());

			List<ComponenteFamiglia> componenti = new ComponenteFamigliaConverter(codiceFiscale, annoLimiteNido, datiFasceEta, anniLimiteMaterna)
					.convertAll(soggetti);

			this.populateLuogoNascita(componenti);
			this.populateNazionalita(componenti, soggetti);

			ResidenzaFamiglia residenzaFamiglia = new ResidenzaFamigliaConverter().convert(
					response.getIndirizzoResidenzaFamiglia());

			DettaglioFamigliaConverter.Data data = new DettaglioFamigliaConverter.Data();
			data.setResidenzaFamiglia(residenzaFamiglia);
			data.setComponentiFamiglia(componenti);

			DettaglioFamiglia dettaglioFamiglia = new DettaglioFamigliaConverter().convert(data);
			result.setDettaglioFamiglia(dettaglioFamiglia);
			result.setErroreNao(false);
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			result.setErroreNao(true);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	//////////////////////////////////////////////////////////////////////

	private void populateLuogoNascita(List<ComponenteFamiglia> componenti) throws ServiceException, ParseException {
		final String methodName = "populateLuogoNascita";

		for (ComponenteFamiglia componente : componenti) {
			String dataNascita = componente.getAnagrafica().getDataNascita();
			String istatComune = componente.getLuogoNascita().getCodComune();

			if (StringUtils.isNoneBlank(dataNascita, istatComune)) {
				List<Luogo> rows = this.luoghiSrvBean.findByIstatComuneAllaData(
						DateUtils.toDate(dataNascita, DateUtils.DEFAULT_DATE_FORMAT), istatComune);

				int size = CollectionUtils.size(rows);
				if (size == 0) {
					String message = String.format("dato non trovato per istatComune: %s; dataNascita: %s", istatComune, dataNascita);
					log.warn(buildMessage(getClass(), methodName, message));

					continue;
				}

				if (size > 1) {
					String message = String.format("trovati %d risultati", size);
					log.warn(buildMessage(getClass(), methodName, message));
				}

				Luogo row = rows.get(0);
				LuogoNascitaComponente luogoNascita = componente.getLuogoNascita();

				luogoNascita.setCodRegione(row.getIstatRegione());
				luogoNascita.setDescRegione(row.getDescRegione());
			}
		}
	}

	private void populateNazionalita(List<ComponenteFamiglia> componenti, List<VisuraSoggetto> soggetti) throws ServiceException {
		final String methodName = "populateNazionalita";

		if (CollectionUtils.isEmpty(componenti) || CollectionUtils.isEmpty(soggetti)) {
			return;
		}

		Map<String, Luogo> index = new HashMap<>();
		for (ComponenteFamiglia componente : componenti) {
			AnagraficaComponente anagrafica = componente.getAnagrafica();
			if (anagrafica == null) {
				continue;
			}

			String cfComponenteFamiglia = NaoUtils.getCfComponenteFamiglia(componente);
			VisuraSoggetto soggetto = NaoUtils.findByCf(cfComponenteFamiglia, soggetti);
			String istatStato = NaoUtils.getIstatCittadinanza(soggetto);

			log.info(buildMessage(getClass(), methodName, "istatStato: " + istatStato));

			if (StringUtils.isBlank(istatStato)) {
				log.warn(buildMessage(getClass(), methodName, "istat stato non presente"));
				continue;
			}

			if (!index.containsKey(istatStato)) {
				Luogo luogo = this.luoghiSrvBean.findByIstatStatoAllaData(new Date(), istatStato);
				if (luogo != null) {
					index.put(istatStato, luogo);
				}
			}

			Luogo luogo = index.get(istatStato);
			if (luogo == null) {
				log.warn(buildMessage(getClass(), methodName, "luogo non trovato"));
				continue;
			}

			anagrafica.setCodiceCittadinanza(luogo.getCodice());
			anagrafica.setDescrizioneCittadinanza(luogo.getDescCittadinanza());
		}
	}

	private AnnoLimite getAnnoLimiteNido() throws ServiceException {
		final String methodName = "getAnnoLimiteNido";

		String codAnno = this.scuoleSrvBean.getCodAnnoNidi(new Date());
		AnnoLimite annoLimite = new AnnoLimite(codAnno, getAnnoLimite(codAnno));

		log.info(buildMessage(getClass(), methodName, String.format(
				"codice anno scolastico nido: %s; anno limite nido: %s",
				annoLimite.getCodiceAnnoScolastico(),
				annoLimite.getAnnoLimite())));

		return annoLimite;
	}

	private List<AnnoLimite> getAnniLimiteMaterna() throws ServiceException {
		final String methodName = "getAnniLimiteMaterna";

		List<AnnoLimite> result = new ArrayList<>();
		List<String> values = this.scuoleSrvBean.getCodAnniMaterne(new Date());
		if (CollectionUtils.isNotEmpty(values)) {
			for (String value : values) {
				AnnoLimite annoLimite = new AnnoLimite(value, getAnnoLimite(value));

				log.info(buildMessage(getClass(), methodName, String.format(
						"codice anno scolastico materna: %s; anno limite materna: %s",
						annoLimite.getCodiceAnnoScolastico(),
						annoLimite.getAnnoLimite())));

				result.add(annoLimite);
			}
		}

		return result;
	}

	private static Integer getAnnoLimite(String codAnno) {
		if (StringUtils.isNotBlank(codAnno)) {
			StringTokenizer tokenizer = new StringTokenizer(codAnno, "-");
			if (tokenizer.hasMoreElements()) {
				return Integer.valueOf(tokenizer.nextToken());
			}
		}

		return null;
	}

}
