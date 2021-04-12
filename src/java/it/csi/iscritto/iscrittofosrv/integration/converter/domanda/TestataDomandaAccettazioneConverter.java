package it.csi.iscritto.iscrittofosrv.integration.converter.domanda;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import it.csi.iscritto.iscrittofosrv.dto.domanda.DatiCondizionePunteggio;
import it.csi.iscritto.iscrittofosrv.dto.domanda.TestataDomandaAccettazione;
import it.csi.iscritto.iscrittofosrv.util.Constants;
import it.csi.iscritto.iscrittofosrv.util.DateUtils;
import it.csi.iscritto.iscrittofosrv.util.LoggingUtils;
import it.csi.iscritto.iscrittofosrv.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.CondizionePunteggio;

public class TestataDomandaAccettazioneConverter
		extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaAccettazione, TestataDomandaAccettazione> {

	@Override
	public TestataDomandaAccettazione convert(it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaAccettazione source) {
		TestataDomandaAccettazione target = null;
		if (source != null) {
			target = new TestataDomandaAccettazione();

			target.setAnnoScolastico(source.getAnnoScolastico());
			target.setCodOrdineScuola(source.getCodOrdineScuola());
			target.setCodStatoDomanda(source.getCodStatoDomanda());
			target.setCognomeMinore(source.getCognomeMinore());
			target.setDataInvio(DateUtils.toStringDate(source.getDataInvio(), DateUtils.DEFAULT_DATE_FORMAT));
			target.setDataUltimaModifica(DateUtils.toStringDate(source.getDataUltimaModifica(), DateUtils.DEFAULT_DATE_FORMAT));
			target.setElencoCondizioniPunteggio(convertCondizioni(source.getElencoCondizioniPunteggio()));
			target.setElencoPreferenze(new DomandaNidoConverter.NidoConverter(DateUtils.CUSTOM_DATE_FORMAT).convertAll(source.getElencoPreferenze()));
			target.setIdDomandaIscrizione(source.getIdDomandaIscrizione());
			target.setNomeMinore(source.getNomeMinore());
			target.setProtocollo(source.getProtocollo());
			target.setTelefonoRichiedente(source.getTelefonoRichiedente());
			target.setCodiceTipoPasto(source.getCodTipoPasto());
		}

		return target;
	}

	public TestataDomandaAccettazione convertMaterna(it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaAccettazione source) {
		TestataDomandaAccettazione target = null;
		Logger log = Logger.getLogger("");
		log.info("@@ 3 FOSRV convertMaterna");
		//LoggingUtils.stampa(source, true, 3);
		if (source != null) {
			target = new TestataDomandaAccettazione();

			target.setAnnoScolastico(source.getAnnoScolastico());
			target.setCodOrdineScuola(source.getCodOrdineScuola());
			target.setCodStatoDomanda(source.getCodStatoDomanda());
			target.setCognomeMinore(source.getCognomeMinore());
			target.setDataInvio(DateUtils.toStringDate(source.getDataInvio(), DateUtils.DEFAULT_DATE_FORMAT));
			target.setDataUltimaModifica(DateUtils.toStringDate(source.getDataUltimaModifica(), DateUtils.DEFAULT_DATE_FORMAT));
			target.setElencoCondizioniPunteggio(convertCondizioni(source.getElencoCondizioniPunteggio()));
			target.setElencoPreferenzeMaterna(new DomandaMaternaConverter.MaternaConverter(DateUtils.CUSTOM_DATE_FORMAT).convertAll(source.getElencoPreferenzeMaterna()));
			target.setIdDomandaIscrizione(source.getIdDomandaIscrizione());
			target.setNomeMinore(source.getNomeMinore());
			target.setProtocollo(source.getProtocollo());
			target.setTelefonoRichiedente(source.getTelefonoRichiedente());
			target.setCodiceTipoPasto(source.getCodTipoPasto());
			target.setIrc(source.getIrc());
		}
	//	LoggingUtils.stampa(target, true, 3);
		return target;
	}


	private static List<DatiCondizionePunteggio> convertCondizioni(CondizionePunteggio[] condizioniPunteggio) {
		List<DatiCondizionePunteggio> result = new ArrayList<>();

		if (ArrayUtils.isEmpty(condizioniPunteggio)) {
			return result;
		}

		Map<String, List<CondizionePunteggio>> index = indexByCod(condizioniPunteggio);
		for (Map.Entry<String, List<CondizionePunteggio>> entry : index.entrySet()) {
			List<CondizionePunteggio> partition = entry.getValue();

			CondizionePunteggio condizionePunteggio = getUltimaCondizione(partition);
			DatiCondizionePunteggio dcp = new DatiCondizionePunteggio();

			dcp.setDescrizione(condizionePunteggio.getDescrizione());
			dcp.setOccorrenze(Boolean.FALSE.equals(condizionePunteggio.getValidata()) ? 0 : condizionePunteggio.getRicorrenza());
			dcp.setMaxOccorrenze(getMaxOccorrenze(partition));
			dcp.setInAttesa(condizionePunteggio.getValidata() == null ? "S" : "N");
			dcp.setNote(condizionePunteggio.getNote());

			result.add(dcp);
		}

		return result;
	}

	private static Map<String, List<CondizionePunteggio>> indexByCod(CondizionePunteggio[] condizioniPunteggio) {
		Map<String, List<CondizionePunteggio>> index = new LinkedHashMap<>();
		if (ArrayUtils.isNotEmpty(condizioniPunteggio)) {
			for (CondizionePunteggio condizionePunteggio : condizioniPunteggio) {
				String key = condizionePunteggio.getCodice();

				if (StringUtils.isBlank(key)) {
					continue;
				}

				if (!index.containsKey(key)) {
					index.put(key, new ArrayList<>());
				}

				index.get(key).add(condizionePunteggio);
			}
		}

		return index;
	}

	private static int getMaxOccorrenze(List<CondizionePunteggio> condizioniPunteggio) {
		int result = 0;
		if (CollectionUtils.isNotEmpty(condizioniPunteggio)) {
			for (CondizionePunteggio condizionePunteggio : condizioniPunteggio) {
				Integer ricorrenza = condizionePunteggio.getRicorrenza();
				if (ricorrenza != null) {
					result = Math.max(result, ricorrenza.intValue());
				}
			}
		}

		return result;
	}

	private static CondizionePunteggio getUltimaCondizione(List<CondizionePunteggio> condizioniPunteggio) {
		if (CollectionUtils.isNotEmpty(condizioniPunteggio)) {
			for (CondizionePunteggio condizionePunteggio : condizioniPunteggio) {
				if (StringUtils.isBlank(condizionePunteggio.getDataFineValidita())) {
					return condizionePunteggio;
				}
			}
		}

		return null;
	}

}
