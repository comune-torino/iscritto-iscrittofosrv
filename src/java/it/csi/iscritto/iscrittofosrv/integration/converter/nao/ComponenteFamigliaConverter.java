package it.csi.iscritto.iscrittofosrv.integration.converter.nao;

import static it.csi.iscritto.iscrittofosrv.util.DateUtils.DEFAULT_DATE_FORMAT;
import static it.csi.iscritto.iscrittofosrv.util.DateUtils.NAO_DATE_FORMAT;
import static it.csi.iscritto.iscrittofosrv.util.DateUtils.getDiffYears;
import static it.csi.iscritto.iscrittofosrv.util.DateUtils.toDate;
import static it.csi.iscritto.iscrittofosrv.util.DateUtils.withoutTime;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_ERROR;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.buildMessage;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.trim;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;

import it.csi.iscritto.iscrittofosrv.dto.domanda.DatiFasciaEta;
import it.csi.iscritto.iscrittofosrv.dto.nao.AnnoLimite;
import it.csi.iscritto.iscrittofosrv.dto.nao.ComponenteFamiglia;
import it.csi.iscritto.iscrittofosrv.integration.dao.TipoScuola;
import it.csi.iscritto.iscrittofosrv.integration.service.nao.client.Coniuge;
import it.csi.iscritto.iscrittofosrv.integration.service.nao.client.Generalita;
import it.csi.iscritto.iscrittofosrv.integration.service.nao.client.Vector;
import it.csi.iscritto.iscrittofosrv.integration.service.nao.client.VisuraSoggetto;
import it.csi.iscritto.iscrittofosrv.util.Constants;
import it.csi.iscritto.iscrittofosrv.util.DateUtils;
import it.csi.iscritto.iscrittofosrv.util.FasciaEtaUtils;
import it.csi.iscritto.iscrittofosrv.util.converter.AbstractConverter;
import it.csi.iscritto.iscrittofosrv.util.converter.ConvertUtils;

public class ComponenteFamigliaConverter extends AbstractConverter<VisuraSoggetto, ComponenteFamiglia> {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".converter");

	public static final int MAX_ANNI_NIDO = 3;
	public static final int ETA_MINORE = 16;
	public static final String RESIDENTE_VIVO = "RV";

	private String cfRichiedente;
	private AnnoLimite annoLimiteNido;
	private List<DatiFasciaEta> datiFasceEta;
	private List<AnnoLimite> anniLimiteMaterna;

	public ComponenteFamigliaConverter(String cfRichiedente, AnnoLimite annoLimiteNido, List<DatiFasciaEta> datiFasceEta, List<AnnoLimite> anniLimiteMaterna) {
		this.cfRichiedente = Validate.notBlank(cfRichiedente);
		this.annoLimiteNido = annoLimiteNido;
		this.datiFasceEta = datiFasceEta;
		this.anniLimiteMaterna = anniLimiteMaterna;
	}

	@Override
	protected void beforeConversion(List<VisuraSoggetto> sourceList) {
		ConvertUtils.remove(sourceList, new Predicate<VisuraSoggetto>() {
			@Override
			public boolean evaluate(VisuraSoggetto item) {
				return !isResidenteVivo(item);
			}
		});
	}

	@Override
	public ComponenteFamiglia convert(VisuraSoggetto source) {
		ComponenteFamiglia target = null;
		if (source != null) {
			Generalita generalita = Optional.ofNullable(source.getGeneralita()).orElse(new Generalita());
			boolean iscrizioneNido = iscrizione(generalita, this.annoLimiteNido.getAnnoLimite(), MAX_ANNI_NIDO);
			target = new ComponenteFamiglia();

			target.setAnagrafica(new AnagraficaComponenteConverter().convert(generalita));
			target.setAnni(getAnni(target.getAnagrafica().getDataNascita()));
			target.setNumeroIndividuale(generalita.getNumeroIndividuale());
			target.setNumeroIndividualeConiuge(Optional.ofNullable(source.getConiuge()).orElse(new Coniuge()).getNumeroIndividuale());

			target.setRichiedente(this.cfRichiedente.equalsIgnoreCase(generalita.getCodiceFiscale()));
			target.setLuogoNascita(new LuogoNascitaConverter().convert(source.getLuogoNascita())); // dati regione gestiti esternamente
			target.setIscrizioneNido(iscrizioneNido);
			target.setIscrizioneMaterna(iscrizioneMaterna(generalita, this.datiFasceEta, this.anniLimiteMaterna));
			target.setConiugeRichiedente(null); // gestito in afterConversion
		}

		return target;
	}

	@Override
	protected void afterConversion(List<ComponenteFamiglia> targetList) {
		ComponenteFamiglia richiedente = DettaglioFamigliaConverter.getRichiedente(targetList);
		if (richiedente == null) {
			return;
		}

		String numRichiedente = richiedente.getNumeroIndividuale();
		if (isBlank(numRichiedente)) {
			return;
		}

		for (ComponenteFamiglia item : targetList) {
			if (isMaggiore(item)) {
				item.setConiugeRichiedente(numRichiedente.equalsIgnoreCase(item.getNumeroIndividualeConiuge()));
			}
		}
	}

	public static final List<String> iscrizioneMaterna(Generalita generalita, List<DatiFasciaEta> datiFasceEta, List<AnnoLimite> anniLimiteMaterna) {
		List<String> result = new ArrayList<>();

		Set<String> anniScolastici = new HashSet<>();
		for (AnnoLimite annoLimite : anniLimiteMaterna) {
			anniScolastici.add(annoLimite.getCodiceAnnoScolastico());
		}

		List<DatiFasciaEta> values = filterByDataNascita(TipoScuola.MAT, generalita, datiFasceEta);
		for (DatiFasciaEta value : values) {
			String annoScolastico = value.getCodAnnoScolastico();
			if (anniScolastici.contains(annoScolastico)) {
				result.add(annoScolastico);
			}
		}

		ConvertUtils.removeDuplicates(result);
		Collections.sort(result);

		return result;
	}

	public static final List<DatiFasciaEta> filterByDataNascita(TipoScuola tipoScuola, Generalita generalita, List<DatiFasciaEta> datiFasceEta) {
		final String methodName = "filterByDataNascita";

		try {
			Date dataNascita = withoutTime(toDate(generalita.getDataNascita(), NAO_DATE_FORMAT));
			return FasciaEtaUtils.filterByDataNascita(tipoScuola, dataNascita, datiFasceEta);
		}
		catch (Exception e) {
			log.error(buildMessage(ComponenteFamigliaConverter.class, methodName, LOG_ERROR), e);
			return new ArrayList<>();
		}
	}

	public static final List<VisuraSoggetto> unwrap(Vector vector) {
		List<VisuraSoggetto> result = new ArrayList<>();

		if (vector != null) {
			List<VisuraSoggetto> items = vector.getItems();
			if (CollectionUtils.isNotEmpty(items)) {
				result.addAll(items);
			}
		}

		return result;
	}

	public static final boolean isMaggiore(ComponenteFamiglia componente) {
		return componente.getAnni() != null && componente.getAnni().intValue() >= ETA_MINORE;
	}

	public static final boolean isMinore(ComponenteFamiglia componente) {
		return componente.getAnni() != null && componente.getAnni().intValue() < ETA_MINORE;
	}

	public static final boolean isResidenteVivo(VisuraSoggetto soggetto) {
		return soggetto.getStatoSoggetto() != null && RESIDENTE_VIVO.equalsIgnoreCase(trim(soggetto.getStatoSoggetto().getDescBreveStato()));
	}

	private static Integer getAnni(String dataNascita) {
		final String methodName = "getAnni";

		try {
			return getDiffYears(toDate(dataNascita, DEFAULT_DATE_FORMAT));
		}
		catch (Exception e) {
			log.error(buildMessage(ComponenteFamigliaConverter.class, methodName, LOG_ERROR), e);
		}

		return null;
	}

	public static final boolean iscrizione(Generalita generalita, Integer annoLimite, int maxAnni) {
		final String methodName = "iscrizione";

		if (annoLimite == null) {
			log.error(buildMessage(ComponenteFamigliaConverter.class, methodName, "anno limite nullo"));
			return false;
		}

		try {
			Date dataLimite = DateUtils.toDate(String.format("31/12/%d", annoLimite), DateUtils.DEFAULT_DATE_FORMAT);
			Date dataNascita = DateUtils.toDate(generalita.getDataNascita(), NAO_DATE_FORMAT);
			Date maxEta = DateUtils.addYears(dataNascita, maxAnni);

			return maxEta.compareTo(dataLimite) > 0;
		}
		catch (Exception e) {
			log.error(buildMessage(ComponenteFamigliaConverter.class, methodName, LOG_ERROR), e);
			return false;
		}
	}

}
