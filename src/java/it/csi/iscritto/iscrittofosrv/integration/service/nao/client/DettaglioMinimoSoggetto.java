
package it.csi.iscritto.iscrittofosrv.integration.service.nao.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per DettaglioMinimoSoggetto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="DettaglioMinimoSoggetto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cessato" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="codiceIstatRapportoParentela" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descBreveRapportoParentela" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descBreveStatoResidenza" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descRapportoParentela" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descrizioneStatoResidenza" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="generalita" type="{urn:SrvVisuraFamiglia}Generalita"/>
 *         &lt;element name="statoSoggetto" type="{urn:SrvVisuraFamiglia}StatoSoggetto"/>
 *         &lt;element name="ultimoIndirizzoComeFamiglia" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ultimoIndirizzoInterno" type="{urn:SrvVisuraFamiglia}IndirizzoInterno"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DettaglioMinimoSoggetto", propOrder = {
    "cessato",
    "codiceIstatRapportoParentela",
    "descBreveRapportoParentela",
    "descBreveStatoResidenza",
    "descRapportoParentela",
    "descrizioneStatoResidenza",
    "generalita",
    "statoSoggetto",
    "ultimoIndirizzoComeFamiglia",
    "ultimoIndirizzoInterno"
})
public class DettaglioMinimoSoggetto {

    protected boolean cessato;
    @XmlElement(required = true, nillable = true)
    protected String codiceIstatRapportoParentela;
    @XmlElement(required = true, nillable = true)
    protected String descBreveRapportoParentela;
    @XmlElement(required = true, nillable = true)
    protected String descBreveStatoResidenza;
    @XmlElement(required = true, nillable = true)
    protected String descRapportoParentela;
    @XmlElement(required = true, nillable = true)
    protected String descrizioneStatoResidenza;
    @XmlElement(required = true, nillable = true)
    protected Generalita generalita;
    @XmlElement(required = true, nillable = true)
    protected StatoSoggetto statoSoggetto;
    protected boolean ultimoIndirizzoComeFamiglia;
    @XmlElement(required = true, nillable = true)
    protected IndirizzoInterno ultimoIndirizzoInterno;

    /**
     * Recupera il valore della proprietà cessato.
     * 
     */
    public boolean isCessato() {
        return cessato;
    }

    /**
     * Imposta il valore della proprietà cessato.
     * 
     */
    public void setCessato(boolean value) {
        this.cessato = value;
    }

    /**
     * Recupera il valore della proprietà codiceIstatRapportoParentela.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceIstatRapportoParentela() {
        return codiceIstatRapportoParentela;
    }

    /**
     * Imposta il valore della proprietà codiceIstatRapportoParentela.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceIstatRapportoParentela(String value) {
        this.codiceIstatRapportoParentela = value;
    }

    /**
     * Recupera il valore della proprietà descBreveRapportoParentela.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescBreveRapportoParentela() {
        return descBreveRapportoParentela;
    }

    /**
     * Imposta il valore della proprietà descBreveRapportoParentela.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescBreveRapportoParentela(String value) {
        this.descBreveRapportoParentela = value;
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
     * Recupera il valore della proprietà descRapportoParentela.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescRapportoParentela() {
        return descRapportoParentela;
    }

    /**
     * Imposta il valore della proprietà descRapportoParentela.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescRapportoParentela(String value) {
        this.descRapportoParentela = value;
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
     * Recupera il valore della proprietà generalita.
     * 
     * @return
     *     possible object is
     *     {@link Generalita }
     *     
     */
    public Generalita getGeneralita() {
        return generalita;
    }

    /**
     * Imposta il valore della proprietà generalita.
     * 
     * @param value
     *     allowed object is
     *     {@link Generalita }
     *     
     */
    public void setGeneralita(Generalita value) {
        this.generalita = value;
    }

    /**
     * Recupera il valore della proprietà statoSoggetto.
     * 
     * @return
     *     possible object is
     *     {@link StatoSoggetto }
     *     
     */
    public StatoSoggetto getStatoSoggetto() {
        return statoSoggetto;
    }

    /**
     * Imposta il valore della proprietà statoSoggetto.
     * 
     * @param value
     *     allowed object is
     *     {@link StatoSoggetto }
     *     
     */
    public void setStatoSoggetto(StatoSoggetto value) {
        this.statoSoggetto = value;
    }

    /**
     * Recupera il valore della proprietà ultimoIndirizzoComeFamiglia.
     * 
     */
    public boolean isUltimoIndirizzoComeFamiglia() {
        return ultimoIndirizzoComeFamiglia;
    }

    /**
     * Imposta il valore della proprietà ultimoIndirizzoComeFamiglia.
     * 
     */
    public void setUltimoIndirizzoComeFamiglia(boolean value) {
        this.ultimoIndirizzoComeFamiglia = value;
    }

    /**
     * Recupera il valore della proprietà ultimoIndirizzoInterno.
     * 
     * @return
     *     possible object is
     *     {@link IndirizzoInterno }
     *     
     */
    public IndirizzoInterno getUltimoIndirizzoInterno() {
        return ultimoIndirizzoInterno;
    }

    /**
     * Imposta il valore della proprietà ultimoIndirizzoInterno.
     * 
     * @param value
     *     allowed object is
     *     {@link IndirizzoInterno }
     *     
     */
    public void setUltimoIndirizzoInterno(IndirizzoInterno value) {
        this.ultimoIndirizzoInterno = value;
    }

}
