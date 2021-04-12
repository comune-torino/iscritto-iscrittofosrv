
package it.csi.iscritto.iscrittofosrv.integration.service.nao.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per DettaglioFamigliaStorico complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="DettaglioFamigliaStorico">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="componentiFamigliaAllaData" type="{urn:SrvVisuraFamiglia}ArrayOfComponenteFamigliaStorico"/>
 *         &lt;element name="dataInizioValiditaFamiglia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="flagFamigliaAIRE" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="idFamiglia" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="indirizzoEsternoAllaData" type="{urn:SrvVisuraFamiglia}IndirizzoEsterno"/>
 *         &lt;element name="indirizzoInternoAllaData" type="{urn:SrvVisuraFamiglia}IndirizzoInterno"/>
 *         &lt;element name="numComponentiAttivi" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numeroFamiglia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DettaglioFamigliaStorico", propOrder = {
    "componentiFamigliaAllaData",
    "dataInizioValiditaFamiglia",
    "flagFamigliaAIRE",
    "idFamiglia",
    "indirizzoEsternoAllaData",
    "indirizzoInternoAllaData",
    "numComponentiAttivi",
    "numeroFamiglia"
})
public class DettaglioFamigliaStorico {

    @XmlElement(required = true, nillable = true)
    protected ArrayOfComponenteFamigliaStorico componentiFamigliaAllaData;
    @XmlElement(required = true, nillable = true)
    protected String dataInizioValiditaFamiglia;
    protected boolean flagFamigliaAIRE;
    protected int idFamiglia;
    @XmlElement(required = true, nillable = true)
    protected IndirizzoEsterno indirizzoEsternoAllaData;
    @XmlElement(required = true, nillable = true)
    protected IndirizzoInterno indirizzoInternoAllaData;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer numComponentiAttivi;
    @XmlElement(required = true, nillable = true)
    protected String numeroFamiglia;

    /**
     * Recupera il valore della proprietà componentiFamigliaAllaData.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfComponenteFamigliaStorico }
     *     
     */
    public ArrayOfComponenteFamigliaStorico getComponentiFamigliaAllaData() {
        return componentiFamigliaAllaData;
    }

    /**
     * Imposta il valore della proprietà componentiFamigliaAllaData.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfComponenteFamigliaStorico }
     *     
     */
    public void setComponentiFamigliaAllaData(ArrayOfComponenteFamigliaStorico value) {
        this.componentiFamigliaAllaData = value;
    }

    /**
     * Recupera il valore della proprietà dataInizioValiditaFamiglia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataInizioValiditaFamiglia() {
        return dataInizioValiditaFamiglia;
    }

    /**
     * Imposta il valore della proprietà dataInizioValiditaFamiglia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataInizioValiditaFamiglia(String value) {
        this.dataInizioValiditaFamiglia = value;
    }

    /**
     * Recupera il valore della proprietà flagFamigliaAIRE.
     * 
     */
    public boolean isFlagFamigliaAIRE() {
        return flagFamigliaAIRE;
    }

    /**
     * Imposta il valore della proprietà flagFamigliaAIRE.
     * 
     */
    public void setFlagFamigliaAIRE(boolean value) {
        this.flagFamigliaAIRE = value;
    }

    /**
     * Recupera il valore della proprietà idFamiglia.
     * 
     */
    public int getIdFamiglia() {
        return idFamiglia;
    }

    /**
     * Imposta il valore della proprietà idFamiglia.
     * 
     */
    public void setIdFamiglia(int value) {
        this.idFamiglia = value;
    }

    /**
     * Recupera il valore della proprietà indirizzoEsternoAllaData.
     * 
     * @return
     *     possible object is
     *     {@link IndirizzoEsterno }
     *     
     */
    public IndirizzoEsterno getIndirizzoEsternoAllaData() {
        return indirizzoEsternoAllaData;
    }

    /**
     * Imposta il valore della proprietà indirizzoEsternoAllaData.
     * 
     * @param value
     *     allowed object is
     *     {@link IndirizzoEsterno }
     *     
     */
    public void setIndirizzoEsternoAllaData(IndirizzoEsterno value) {
        this.indirizzoEsternoAllaData = value;
    }

    /**
     * Recupera il valore della proprietà indirizzoInternoAllaData.
     * 
     * @return
     *     possible object is
     *     {@link IndirizzoInterno }
     *     
     */
    public IndirizzoInterno getIndirizzoInternoAllaData() {
        return indirizzoInternoAllaData;
    }

    /**
     * Imposta il valore della proprietà indirizzoInternoAllaData.
     * 
     * @param value
     *     allowed object is
     *     {@link IndirizzoInterno }
     *     
     */
    public void setIndirizzoInternoAllaData(IndirizzoInterno value) {
        this.indirizzoInternoAllaData = value;
    }

    /**
     * Recupera il valore della proprietà numComponentiAttivi.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumComponentiAttivi() {
        return numComponentiAttivi;
    }

    /**
     * Imposta il valore della proprietà numComponentiAttivi.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumComponentiAttivi(Integer value) {
        this.numComponentiAttivi = value;
    }

    /**
     * Recupera il valore della proprietà numeroFamiglia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroFamiglia() {
        return numeroFamiglia;
    }

    /**
     * Imposta il valore della proprietà numeroFamiglia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroFamiglia(String value) {
        this.numeroFamiglia = value;
    }

}
