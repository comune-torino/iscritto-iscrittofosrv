
package it.csi.iscritto.iscrittofosrv.integration.service.nao.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per DatiAIRE complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="DatiAIRE">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dataCancellazioneAIRE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dataIngressoIndirizzo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dataIscrizioneAIRE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descMotivoCancellazione" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descMotivoIscrizione" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="indirizzoResidenza" type="{urn:SrvVisuraFamiglia}IndirizzoEsterno"/>
 *         &lt;element name="numeroIndividualeAIRE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatiAIRE", propOrder = {
    "dataCancellazioneAIRE",
    "dataIngressoIndirizzo",
    "dataIscrizioneAIRE",
    "descMotivoCancellazione",
    "descMotivoIscrizione",
    "indirizzoResidenza",
    "numeroIndividualeAIRE"
})
public class DatiAIRE {

    @XmlElement(required = true, nillable = true)
    protected String dataCancellazioneAIRE;
    @XmlElement(required = true, nillable = true)
    protected String dataIngressoIndirizzo;
    @XmlElement(required = true, nillable = true)
    protected String dataIscrizioneAIRE;
    @XmlElement(required = true, nillable = true)
    protected String descMotivoCancellazione;
    @XmlElement(required = true, nillable = true)
    protected String descMotivoIscrizione;
    @XmlElement(required = true, nillable = true)
    protected IndirizzoEsterno indirizzoResidenza;
    @XmlElement(required = true, nillable = true)
    protected String numeroIndividualeAIRE;

    /**
     * Recupera il valore della proprietà dataCancellazioneAIRE.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataCancellazioneAIRE() {
        return dataCancellazioneAIRE;
    }

    /**
     * Imposta il valore della proprietà dataCancellazioneAIRE.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataCancellazioneAIRE(String value) {
        this.dataCancellazioneAIRE = value;
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
     * Recupera il valore della proprietà dataIscrizioneAIRE.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataIscrizioneAIRE() {
        return dataIscrizioneAIRE;
    }

    /**
     * Imposta il valore della proprietà dataIscrizioneAIRE.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataIscrizioneAIRE(String value) {
        this.dataIscrizioneAIRE = value;
    }

    /**
     * Recupera il valore della proprietà descMotivoCancellazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescMotivoCancellazione() {
        return descMotivoCancellazione;
    }

    /**
     * Imposta il valore della proprietà descMotivoCancellazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescMotivoCancellazione(String value) {
        this.descMotivoCancellazione = value;
    }

    /**
     * Recupera il valore della proprietà descMotivoIscrizione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescMotivoIscrizione() {
        return descMotivoIscrizione;
    }

    /**
     * Imposta il valore della proprietà descMotivoIscrizione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescMotivoIscrizione(String value) {
        this.descMotivoIscrizione = value;
    }

    /**
     * Recupera il valore della proprietà indirizzoResidenza.
     * 
     * @return
     *     possible object is
     *     {@link IndirizzoEsterno }
     *     
     */
    public IndirizzoEsterno getIndirizzoResidenza() {
        return indirizzoResidenza;
    }

    /**
     * Imposta il valore della proprietà indirizzoResidenza.
     * 
     * @param value
     *     allowed object is
     *     {@link IndirizzoEsterno }
     *     
     */
    public void setIndirizzoResidenza(IndirizzoEsterno value) {
        this.indirizzoResidenza = value;
    }

    /**
     * Recupera il valore della proprietà numeroIndividualeAIRE.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroIndividualeAIRE() {
        return numeroIndividualeAIRE;
    }

    /**
     * Imposta il valore della proprietà numeroIndividualeAIRE.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroIndividualeAIRE(String value) {
        this.numeroIndividualeAIRE = value;
    }

}
