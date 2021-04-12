package it.csi.iscritto.iscrittofosrv.integration.service.ricevuta.accettazione;

import java.util.Arrays;

import org.apache.commons.lang3.Validate;

import it.csi.iscritto.iscrittofosrv.dto.domanda.RicevutaAccettazione;
import it.csi.iscritto.iscrittofosrv.util.DateUtils;
import it.csi.iscritto.iscrittofosrv.util.Joiner;

public enum ContentEnum {
	TITLE("Servizi 0-6: %s"),
	PHRASE_001("Conferma accettazione del posto per:"),
	PHRASE_002("Il bambino/a: %s %s"),
	PHRASE_003("Anno scolastico: %s"),
	PHRASE_004("Domanda N\u00B0: %s"),
	PHRASE_005("Data invio: %s"),
	PHRASE_006("Operazione effettuata il giorno %s alle ore %s."),
	PHRASE_007_A("\u00C8 stato accettato il posto %s: %s"),
	PHRASE_007_B("\u00C8 stato accettato il posto nella sezione primavera: %s"),
	PHRASE_009("Indirizzo: %s"),
	PHRASE_010("%s"),
	PHRASE_011_A(
			"Sarai contattato dalla Divisione Servizi Educativi della Città di Torino per ",
			"fissare un appuntamento in cui ti saranno fornite le informazioni necessarie per iniziare ",
			"la frequenza del bambino o della bambina."),
	PHRASE_011_B(
			"Entro 3 giorni sarai contattato dalla Divisione Servizi Educativi della Citt\u00E0 di Torino per fissare un appuntamento in cui ",
			"ti saranno fornite tutte le informazioni necessarie per iniziare la frequenza del bambino o della bambina."),
	PHRASE_011_C(
			"Sei invitato/a a contattare telefonicamente la sezione primavera entro 3 giorni l'accettazione per ",
			"fissare un appuntamento in cui ti saranno fornite le informazioni necessarie per iniziare ",
			"la frequenza del bambino o della bambina."),
	PHRASE_012("L'adempimento degli obblighi vaccinali \u00E8 indispensabile per frequentare %s"),
	PHRASE_013("Informazioni utili"),
	PHRASE_014_1("Tipologia pasto"),
	PHRASE_014_2("La tipologia di pasto scelta \u00E8 quella %s."),
	PHRASE_014_3(
			"Potrai cambiarla in ogni momento accedendo dal giorno successivo l'accettazione al servizio Scelta pasti alternativi ",
			"del Portale Torinofacile con le stesse credenziali che hai usato per inserire la domanda."),
	PHRASE_014_4(
			"NB: In caso di allergie o intolleranze alimentari per le quali \u00E8 necessaria una dieta personalizzata, ",
			"rivolgiti all'ufficio Diete (011 01127556)."),
	PHRASE_015("Pagamento del servizio"),
	PHRASE_016_A("Il pagamento del servizio avviene versando direttamente al gestore la quota dovuta."),
	PHRASE_016_B(
			"Il pagamento del servizio avviene tramite addebito mensile sul Borsellino elettronico, a te intestato, accessibile tramite ",
			"le stesse credenziali che hai usato per inserire la domanda. Nei prossimi mesi riceverai una comunicazione da SORIS, ",
			"societ\u00E0 di riscossione incaricata dell'incasso delle quote dovute per la fruizione del servizio."),
	PHRASE_017("Tariffa"),
	PHRASE_017_A(
			"Con l'iscrizione al servizio viene assegnata la tariffa completa. I residenti a Torino possono fruire ",
			"delle tariffe agevolate. Per fruire della tariffa agevolata, devi avere un ISEE valido e presentare ",
			"richiesta di Prestazione agevolata ISEE compilandola sul portale Torinofacile o recandoti presso un CAF ",
			"convenzionato con la Citt\u00E0."),
	PHRASE_017_B(
			"La tariffa viene stabilita dal gestore in base a quanto definito nella Convenzione con la Citt\u00E0. ",
			"Maggiori informazioni sul sito della Citt\u00E0, nella sezione dedicata ai Servizi Educativi 0-2 anni "),
	PHRASE_018_A_1("Buono Servizi Prima Infanzia"),
	PHRASE_018_A_2(
			"Nel caso tu sia in possesso di un ISEE valido con indicatore uguale o inferiore a \u20AC15.000, ",
			"la presentazione della richiesta di prestazione agevolata varr\u00E0 come richiesta di accesso al ",
			"Buono Servizi Prima Infanzia della Regione Piemonte detto anche Buono Nidi."),
	PHRASE_018_A_3(
			"Possono accedere al Buono Servizi Prima Infanzia bambini e bambine residenti in Piemonte ",
			"che frequentano un nido comunale."),
	PHRASE_018_B("Devi presentare la copia della richiesta e dell'attestazione ISEE al nido d'infanzia convenzionato."),
	FOOTER("Il presente documento \u00E8 stato realizzato dall'applicativo IscritTO - Iscrizioni Online Nidi d'infanzia, in data %s, ore %s");

	private String[] template;

	private ContentEnum(String... template) {
		this.template = template;
	}

	public String getTemplate() {
		return Joiner.on("").join(Arrays.asList(this.template));
	}

	public String getText(RicevutaAccettazione ricevuta) {
		Validate.notNull(ricevuta);

		String text;
		switch (this) {
			case TITLE:
				String txt = "";
				if(ricevuta.getCodOrdineScuola().equals("NID")) {
					txt = "nidi d'infanzia";
				}else {
					txt = "scuole dell'infanzia";
				}
				text = String.format(this.getTemplate(),
					txt);
			break;
			case PHRASE_002:
				text = String.format(this.getTemplate(),
						ricevuta.getCognomeMinore(),
						ricevuta.getNomeMinore());
				break;
			case PHRASE_003:
				text = String.format(this.getTemplate(),
						ricevuta.getCodAnnoScolastico());
				break;
			case PHRASE_004:
				text = String.format(this.getTemplate(),
						ricevuta.getProtocolloDomanda());
				break;
			case PHRASE_005:
				text = String.format(this.getTemplate(),
						DateUtils.toStringDate(ricevuta.getDataConsegna(), DateUtils.DEFAULT_DATE_FORMAT));
				break;
			case PHRASE_006:
				text = String.format(this.getTemplate(),
						DateUtils.toStringDate(ricevuta.getDataOperazione(), DateUtils.DEFAULT_DATE_FORMAT),
						DateUtils.toStringDate(ricevuta.getDataOperazione(), "HH:mm:ss"));
				break;
			case PHRASE_007_A:
				String txt2 = "";
				if(ricevuta.getCodOrdineScuola().equals("NID")) {
					txt2 = "nel nido d'infanzia";
				}else {
					txt2 = "nella scuola dell'infanzia";
				}
				text = String.format(this.getTemplate(),
						txt2,
						ricevuta.getDescScuola());
				break;
			case PHRASE_007_B:
				text = String.format(this.getTemplate(),
						ricevuta.getDescScuola());
				break;
			case PHRASE_009:
				text = String.format(this.getTemplate(),
						ricevuta.getIndirizzoScuola());
				break;
			case PHRASE_010:
				text = String.format(this.getTemplate(),
						ricevuta.getDescTipoFrequenza());
				break;
			case PHRASE_012:
				String txt3 = "";
				if(ricevuta.getCodOrdineScuola().equals("NID")) {
					txt3 = "il nido d'infanzia";
				}else {
					txt3 = "la scuola dell'infanzia";
				}
				text = String.format(this.getTemplate(),
					txt3);
			break;
			case PHRASE_014_2:
				text = String.format(this.getTemplate(),
						ricevuta.getDescTipoPasto());
				break;
			default:
				text = this.getTemplate();
				break;
		}

		return text;
	}


}
