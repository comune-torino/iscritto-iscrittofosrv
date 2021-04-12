
package it.csi.iscritto.iscrittofosrv.integration.service.nao.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per VisuraSoggetto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="VisuraSoggetto">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:SrvVisuraFamiglia}Soggetto">
 *       &lt;sequence>
 *         &lt;element name="bloccoCertificabilita" type="{urn:SrvVisuraFamiglia}BloccoCertificabilitaANA"/>
 *         &lt;element name="cittadinanza" type="{urn:SrvVisuraFamiglia}Cittadinanza"/>
 *         &lt;element name="codiceFiscale" type="{urn:SrvVisuraFamiglia}CodiceFiscale"/>
 *         &lt;element name="coniuge" type="{urn:SrvVisuraFamiglia}Coniuge"/>
 *         &lt;element name="dataIngressoIndirizzo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dataResidenza" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="datiAire" type="{urn:SrvVisuraFamiglia}DatiAIRE"/>
 *         &lt;element name="descBreveStatoResidenza" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descBreveTutelaInterdizione" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descrizioneStatoResidenza" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descrizioneTutelaInterdizione" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="eventoEmigrazione" type="{urn:SrvVisuraFamiglia}EventoEmigrazione"/>
 *         &lt;element name="flgBloccoCINVE" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="flgPraticheInCorso" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="indirizzoDomicilio" type="{urn:SrvVisuraFamiglia}IndirizzoInterno"/>
 *         &lt;element name="indirizzoResidenzaInterno" type="{urn:SrvVisuraFamiglia}IndirizzoInterno"/>
 *         &lt;element name="numeroTesseraElettoraleAttuale" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="statoCivile" type="{urn:SrvVisuraFamiglia}StatoCivile"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VisuraSoggetto", propOrder = {
    "bloccoCertificabilita",
    "cittadinanza",
    "codiceFiscale",
    "coniuge",
    "dataIngressoIndirizzo",
    "dataResidenza",
    "datiAire",
    "descBreveStatoResidenza",
    "descBreveTutelaInterdizione",
    "descrizioneStatoResidenza",
    "descrizioneTutelaInterdizione",
    "eventoEmigrazione",
    "flgBloccoCINVE",
    "flgPraticheInCorso",
    "indirizzoDomicilio",
    "indirizzoResidenzaInterno",
    "numeroTesseraElettoraleAttuale",
    "statoCivile"
})
public class VisuraSoggetto
    extends Soggetto
{

    @XmlElement(required = true, nillable = true)
    protected BloccoCertificabilitaANA bloccoCertificabilita;
    @XmlElement(required = true, nillable = true)
    protected Cittadinanza cittadinanza;
    @XmlElement(required = true, nillable = true)
    protected CodiceFiscale codiceFiscale;
    @XmlElement(required = true, nillable = true)
    protected Coniuge coniuge;
    @XmlElement(required = true, nillable = true)
    protected String dataIngressoIndirizzo;
    @XmlElement(required = true, nillable = true)
    protected String dataResidenza;
    @XmlElement(required = true, nillable = true)
    protected DatiAIRE datiAire;
    @XmlElement(required = true, nillable = true)
    protected String descBreveStatoResidenza;
    @XmlElement(required = true, nillable = true)
    protected String descBreveTutelaInterdizione;
    @XmlElement(required = true, nillable = true)
    protected String descrizioneStatoResidenza;
    @XmlElement(required = true, nillable = true)
    protected String descrizioneTutelaInterdizione;
    @XmlElement(required = true, nillable = true)
    protected EventoEmigrazione eventoEmigrazione;
    protected boolean flgBloccoCINVE;
    protected boolean flgPraticheInCorso;
    @XmlElement(required = true, nillable = true)
    protected IndirizzoInterno indirizzoDomicilio;
    @XmlElement(required = true, nillable = true)
    protected IndirizzoInterno indirizzoResidenzaInterno;
    @XmlElement(required = true, nillable = true)
    protected String numeroTesseraElettoraleAttuale;
    @XmlElement(required = true, nillable = true)
    protected StatoCivile statoCivile;

    /**
     * Recupera il valore della proprietà bloccoCertificabilita.
     * 
     * @return
     *     possible object is
     *     {@link BloccoCertificabilitaANA }
     *     
     */
    public BloccoCertificabilitaANA getBloccoCertificabilita() {
        return bloccoCertificabilita;
    }

    /**
     * Imposta il valore della proprietà bloccoCertificabilita.
     * 
     * @param value
     *     allowed object is
     *     {@link BloccoCertificabilitaANA }
     *     
     */
    public void setBloccoCertificabilita(BloccoCertificabilitaANA value) {
        this.bloccoCertificabilita = value;
    }

    /**
     * Recupera il valore della proprietà cittadinanza.
     * 
     * @return
     *     possible object is
     *     {@link Cittadinanza }
     *     
     */
    public Cittadinanza getCittadinanza() {
        return cittadinanza;
    }

    /**
     * Imposta il valore della proprietà cittadinanza.
     * 
     * @param value
     *     allowed object is
     *     {@link Cittadinanza }
     *     
     */
    public void setCittadinanza(Cittadinanza value) {
        this.cittadinanza = value;
    }

    /**
     * Recupera il valore della proprietà codiceFiscale.
     * 
     * @return
     *     possible object is
     *     {@link CodiceFiscale }
     *     
     */
    public CodiceFiscale getCodiceFiscale() {
        return codiceFiscale;
    }

    /**
     * Imposta il valore della proprietà codiceFiscale.
     * 
     * @param value
     *     allowed object is
     *     {@link CodiceFiscale }
     *     
     */
    public void setCodiceFiscale(CodiceFiscale value) {
        this.codiceFiscale = value;
    }

    /**
     * Recupera il valore della proprietà coniuge.
     * 
     * @return
     *     possible object is
     *     {@link Coniuge }
     *     
     */
    public Coniuge getConiuge() {
        return coniuge;
    }

    /**
     * Imposta il valore della proprietà coniuge.
     * 
     * @param value
     *     allowed object is
     *     {@link Coniuge }
     *     
     */
    public void setConiuge(Coniuge value) {
        this.coniuge = value;
    }

    /**
     * Recupera il valore della proprietà dataIngressoIndirizzo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataIngressoIndirizzo() {
        return dataIngressoIndirizzo;
    }

    /**
     * Imposta il valore della proprietà dataIngressoIndirizzo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataIngressoIndirizzo(String value) {
        this.dataIngressoIndirizzo = value;
    }

    /**
     * Recupera il valore della proprietà dataResidenza.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataResidenza() {
        return dataResidenza;
    }

    /**
     * Imposta il valore della proprietà dataResidenza.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataResidenza(String value) {
        this.dataResidenza = value;
    }

    /**
     * Recupera il valore della proprietà datiAire.
     * 
     * @return
     *     possible object is
     *     {@link DatiAIRE }
     *     
     */
    public DatiAIRE getDatiAire() {
        return datiAire;
    }

    /**
     * Imposta il valore della proprietà datiAire.
     * 
     * @param value
     *     allowed object is
     *     {@link DatiAIRE }
     *     
     */
    public void setDatiAire(DatiAIRE value) {
        this.datiAire = value;
    }

    /**
     * Recupera il valore della proprietà descBreveStatoResidenza.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescBreveStatoResidenza() {
        return descBreveStatoResidenza;
    }

    /**
     * Imposta il valore della proprietà descBreveStatoResidenza.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescBreveStatoResidenza(String value) {
        this.descBreveStatoResidenza = value;
    }

    /**
     * Recupera il valore della proprietà descBreveTutelaInterdizione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescBreveTutelaInterdizione() {
        return descBreveTutelaInterdizione;
    }

    /**
     * Imposta il valore della proprietà descBreveTutelaInterdizione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescBreveTutelaInterdizione(String value) {
        this.descBreveTutelaInterdizione = value;
    }

    /**
     * Recupera il valore della proprietà descrizioneStatoResidenza.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrizioneStatoResidenza() {
        return descrizioneStatoResidenza;
    }

    /**
     * Imposta il valore della proprietà descrizioneStatoResidenza.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrizioneStatoResidenza(String value) {
        this.descrizioneStatoResidenza = value;
    }

    /**
     * Recupera il valore della proprietà descrizioneTutelaInterdizione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrizioneTutelaInterdizione() {
        return descrizioneTutelaInterdizione;
    }

    /**
     * Imposta il valore della proprietà descrizioneTutelaInterdizione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrizioneTutelaInterdizione(String value) {
        this.descrizioneTutelaInterdizione = value;
    }

    /**
     * Recupera il valore della proprietà eventoEmigrazione.
     * 
     * @return
     *     possible object is
     *     {@link EventoEmigrazione }
     *     
     */
    public EventoEmigrazione getEventoEmigrazione() {
        return eventoEmigrazione;
    }

    /**
     * Imposta il valore della proprietà eventoEmigrazione.
     * 
     * @param value
     *     allowed object is
     *     {@link EventoEmigrazione }
     *     
     */
    public void setEventoEmigrazione(EventoEmigrazione value) {
        this.eventoEmigrazione = value;
    }

    /**
     * Recupera il valore della proprietà flgBloccoCINVE.
     * 
     */
    public boolean isFlgBloccoCINVE() {
        return flgBloccoCINVE;
    }

    /**
     * Imposta il valore della proprietà flgBloccoCINVE.
     * 
     */
    public void setFlgBloccoCINVE(boolean value) {
        this.flgBloccoCINVE = value;
    }

    /**
     * Recupera il valore della proprietà flgPraticheInCorso.
     * 
     */
    public boolean isFlgPraticheInCorso() {
        return flgPraticheInCorso;
    }

    /**
     * Imposta il valore della proprietà flgPraticheInCorso.
     * 
     */
    public void setFlgPraticheInCorso(boolean value) {
        this.flgPraticheInCorso = value;
    }

    /**
     * Recupera il valore della proprietà indirizzoDomicilio.
     * 
     * @return
     *     possible object is
     *     {@link IndirizzoInterno }
     *     
     */
    public IndirizzoInterno getIndirizzoDomicilio() {
        return indirizzoDomicilio;
    }

    /**
     * Imposta il valore della proprietà indirizzoDomicilio.
     * 
     * @param value
     *     allowed object is
     *     {@link IndirizzoInterno }
     *     
     */
    public void setIndirizzoDomicilio(IndirizzoInterno value) {
        this.indirizzoDomicilio = value;
    }

    /**
     * Recupera il valore della proprietà indirizzoResidenzaInterno.
     * 
     * @return
     *     possible object is
     *     {@link IndirizzoInterno }
     *     
     */
    public IndirizzoInterno getIndirizzoResidenzaInterno() {
        return indirizzoResidenzaInterno;
    }

    /**
     * Imposta il valore della proprietà indirizzoResidenzaInterno.
     * 
     * @param value
     *     allowed object is
     *     {@link IndirizzoInterno }
     *     
     */
    public void setIndirizzoResidenzaInterno(IndirizzoInterno value) {
        this.indirizzoResidenzaInterno = value;
    }

    /**
     * Recupera il valore della proprietà numeroTesseraElettoraleAttuale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroTesseraElettoraleAttuale() {
        return numeroTesseraElettoraleAttuale;
    }

    /**
     * Imposta il valore della proprietà numeroTesseraElettoraleAttuale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroTesseraElettoraleAttuale(String value) {
        this.numeroTesseraElettoraleAttuale = value;
    }

    /**
     * Recupera il valore della proprietà statoCivile.
     * 
     * @return
     *     possible object is
     *     {@link StatoCivile }
     *     
     */
    public StatoCivile getStatoCivile() {
        return statoCivile;
    }

    /**
     * Imposta il valore della proprietà statoCivile.
     * 
     * @param value
     *     allowed object is
     *     {@link StatoCivile }
     *     
     */
    public void setStatoCivile(StatoCivile value) {
        this.statoCivile = value;
    }

}
