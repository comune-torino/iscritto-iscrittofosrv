package it.csi.iscritto.iscrittofosrv.integration.service.validation.impl;

import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.buildMessage;
import static it.csi.iscritto.iscrittofosrv.util.converter.ConvertUtils.toUpper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import it.csi.iscritto.iscrittofosrv.dto.materna.DomandaMaterna;
import it.csi.iscritto.iscrittofosrv.dto.nao.AnagraficaComponente;
import it.csi.iscritto.iscrittofosrv.dto.nao.ComponenteFamiglia;
import it.csi.iscritto.iscrittofosrv.dto.nao.DettaglioFamiglia;
import it.csi.iscritto.iscrittofosrv.dto.nao.InfoNao;
import it.csi.iscritto.iscrittofosrv.dto.nido.Anagrafica;
import it.csi.iscritto.iscrittofosrv.dto.nido.ComponentiNucleo;
import it.csi.iscritto.iscrittofosrv.dto.nido.DomandaNido;
import it.csi.iscritto.iscrittofosrv.dto.nido.Minore;
import it.csi.iscritto.iscrittofosrv.dto.nido.SoggettoNucleo;
import it.csi.iscritto.iscrittofosrv.exception.ServiceException;
import it.csi.iscritto.iscrittofosrv.integration.service.validation.ErrorCodeEnum;
import it.csi.iscritto.iscrittofosrv.integration.service.validation.NaoValidationService;
import it.csi.iscritto.iscrittofosrv.util.Constants;
import it.csi.iscritto.iscrittofosrv.util.DateUtils;
import it.csi.iscritto.iscrittofosrv.util.converter.ConvertUtils;
import it.csi.iscritto.iscrittofosrv.util.validation.Errors;

@Repository
@Primary
public class NaoValidationServiceImpl implements NaoValidationService {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".integration.service");
	public static final int ETA_MAGGIORENNE = 18;

	@Override
	public Errors validateSoggettiNao(InfoNao infoNao, DomandaNido domandaNido) throws ServiceException {
		final String methodName = "validateSoggettiNao";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Errors errors = new Errors();
		if (!Boolean.TRUE.equals(domandaNido.getNao())) {
			return errors;
		}

		if (Boolean.TRUE.equals(infoNao.getErroreNao())) {
			errors.addError(ErrorCodeEnum.VAL_NAO_001.buildBlockingError());
			return errors;
		}

		Set<String> cfComponentiNao = ConvertUtils.toSet(
				getCfComponenti(getComponenti(infoNao.getDettaglioFamiglia())));

		List<String> cfSoggetti = getCfSoggettiNao(domandaNido, infoNao.getAnnoLimiteNido());

		for (String cfSoggetto : cfSoggetti) {
			if (!cfComponentiNao.contains(cfSoggetto)) {
				errors.addError(ErrorCodeEnum.VAL_NAO_002.buildBlockingError(cfSoggetto));
			}
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return errors;
	}

	@Override
	public Errors validateSoggettiNao(InfoNao infoNao, DomandaMaterna domandaMaterna) throws ServiceException {
		final String methodName = "validateSoggettiNao";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Errors errors = new Errors();
		if (!Boolean.TRUE.equals(domandaMaterna.getNao())) {
			return errors;
		}

		if (Boolean.TRUE.equals(infoNao.getErroreNao())) {
			errors.addError(ErrorCodeEnum.VAL_NAO_001.buildBlockingError());
			return errors;
		}

		// TODO: da completare

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return errors;
	}

	//////////////////////////////////////////////////////////////////////

	private static List<ComponenteFamiglia> getComponenti(DettaglioFamiglia dettaglioFamiglia) {
		List<ComponenteFamiglia> result = new ArrayList<>();
		if (dettaglioFamiglia != null) {
			// richiedente
			ComponenteFamiglia richiedente = dettaglioFamiglia.getRichiedente();
			if (richiedente != null) {
				result.add(richiedente);
			}

			// coniuge
			ComponenteFamiglia coniuge = dettaglioFamiglia.getConiuge();
			if (coniuge != null) {
				result.add(coniuge);
			}

			// componenti maggiorenni
			List<ComponenteFamiglia> maggiorenni = dettaglioFamiglia.getMaggiorenni();
			if (CollectionUtils.isNotEmpty(maggiorenni)) {
				for (ComponenteFamiglia comp : maggiorenni) {
					if (comp != null) {
						result.add(comp);
					}
				}
			}

			// componenti minorenni
			List<ComponenteFamiglia> minorenni = dettaglioFamiglia.getMinorenni();
			if (CollectionUtils.isNotEmpty(minorenni)) {
				for (ComponenteFamiglia comp : minorenni) {
					if (comp != null) {
						result.add(comp);
					}
				}
			}
		}

		return result;
	}

	private static List<String> getCfComponenti(List<ComponenteFamiglia> componenti) {
		List<String> result = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(componenti)) {
			for (ComponenteFamiglia componente : componenti) {
				AnagraficaComponente anagrafica = componente.getAnagrafica();
				if (anagrafica == null) {
					continue;
				}

				String codiceFiscale = anagrafica.getCodiceFiscale();
				if (StringUtils.isBlank(codiceFiscale)) {
					continue;
				}

				result.add(toUpper(codiceFiscale));
			}
		}

		return result;
	}

	private static List<String> getCfSoggettiNao(DomandaNido domandaNido, Integer annoLimite) {
		List<String> result = new ArrayList<>();

		if (Boolean.TRUE.equals(domandaNido.getNao())) {
			result.add(toUpper(domandaNido.getRichiedente().getAnagrafica().getCodiceFiscale()));

			Minore minore = domandaNido.getMinore();
			if (Boolean.TRUE.equals(minore.getPresenzaNucleo())) {
				result.add(toUpper(minore.getAnagrafica().getCodiceFiscale()));
			}

			List<SoggettoNucleo> soggetti = getSoggettiNucleo(domandaNido);
			for (SoggettoNucleo soggetto : soggetti) {
				if (toCheck(soggetto, annoLimite)) {
					result.add(toUpper(soggetto.getAnagrafica().getCodiceFiscale()));
				}
			}
		}

		return result;
	}

	private static List<SoggettoNucleo> getSoggettiNucleo(DomandaNido domandaNido) {
		List<SoggettoNucleo> result = new ArrayList<>();
		ComponentiNucleo componentiNucleo = domandaNido.getComponentiNucleo();
		if (componentiNucleo != null) {
			List<SoggettoNucleo> soggetti = componentiNucleo.getSoggetti();
			if (CollectionUtils.isNotEmpty(soggetti)) {
				result.addAll(soggetti);
			}
		}

		return result;
	}

	private static boolean toCheck(SoggettoNucleo soggetto, Integer annoLimite) {
		if (soggetto == null || annoLimite == null) {
			return false;
		}

		Anagrafica anagrafica = soggetto.getAnagrafica();
		if (anagrafica == null) {
			return false;
		}

		boolean isMinorenne;
		try {
			Date dataNascita = DateUtils.toDate(soggetto.getAnagrafica().getDataNascita(), DateUtils.DEFAULT_DATE_FORMAT);
			isMinorenne = isMinorenne(dataNascita, annoLimite);
		}
		catch (Exception e) {
			return false;
		}

		boolean problemiSalute = soggetto.getProblemiSalute() == null
				? false
				: Boolean.TRUE.equals(soggetto.getProblemiSalute().getStato());

		// tutti i minorenni o i maggiorenni con problemi di salute
		return isMinorenne || problemiSalute;
	}

	private static boolean isMinorenne(Date dataNascita, int annoLimite) {
		try {
			Date dataLimite = DateUtils.toDate(String.format("31/12/%d", annoLimite), DateUtils.DEFAULT_DATE_FORMAT);
			Date dataMaggioreEta = DateUtils.addYears(dataNascita, ETA_MAGGIORENNE);

			return dataMaggioreEta.compareTo(dataLimite) > 0;
		}
		catch (Exception e) {
			return false;
		}
	}

}
