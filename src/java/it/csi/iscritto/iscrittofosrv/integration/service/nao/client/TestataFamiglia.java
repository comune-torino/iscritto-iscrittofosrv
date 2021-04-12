
package it.csi.iscritto.iscrittofosrv.integration.service.nao.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per TestataFamiglia complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="TestataFamiglia">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dataFineValiditaFamiglia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dataInizioValiditaFamiglia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="flgFamigliaAIRE" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="idFamiglia" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="indirizzoResidenzaFamiglia" type="{urn:SrvVisuraFamiglia}IndirizzoInterno"/>
 *         &lt;element name="intestatarioScheda" type="{urn:SrvVisuraFamiglia}VisuraSoggetto"/>
 *         &lt;element name="numComponentiAttivi" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numeroFamiglia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tipoProtocolloRiservato" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TestataFamiglia", propOrder = {
    "dataFineValiditaFamiglia",
    "dataInizioValiditaFamiglia",
    "flgFamigliaAIRE",
    "idFamiglia",
    "indirizzoResidenzaFamiglia",
    "intestatarioScheda",
    "numComponentiAttivi",
    "numeroFamiglia",
    "tipoProtocolloRiservato"
})
@XmlSeeAlso({
    DettaglioFamiglia.class
})
public class TestataFamiglia {

    @XmlElement(required = true, nillable = true)
    protected String dataFineValiditaFamiglia;
    @XmlElement(required = true, nillable = true)
    protected String dataInizioValiditaFamiglia;
    protected boolean flgFamigliaAIRE;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer idFamiglia;
    @XmlElement(required = true, nillable = true)
    protected IndirizzoInterno indirizzoResidenzaFamiglia;
    @XmlElement(required = true, nillable = true)
    protected VisuraSoggetto intestatarioScheda;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer numComponentiAttivi;
    @XmlElement(required = true, nillable = true)
    protected String numeroFamiglia;
    @XmlElement(required = true, nillable = true)
    protected String tipoProtocolloRiservato;

    /**
     * Recupera il valore della proprietà dataFineValiditaFamiglia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataFineValiditaFamiglia() {
        return dataFineValiditaFamiglia;
    }

    /**
     * Imposta il valore della proprietà dataFineValiditaFamiglia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataFineValiditaFamiglia(String value) {
        this.dataFineValiditaFamiglia = value;
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
     * Recupera il valore della proprietà flgFamigliaAIRE.
     * 
     */
    public boolean isFlgFamigliaAIRE() {
        return flgFamigliaAIRE;
    }

    /**
     * Imposta il valore della proprietà flgFamigliaAIRE.
     * 
     */
    public void setFlgFamigliaAIRE(boolean value) {
        this.flgFamigliaAIRE = value;
    }

    /**
     * Recupera il valore della proprietà idFamiglia.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdFamiglia() {
        return idFamiglia;
    }

    /**
     * Imposta il valore della proprietà idFamiglia.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdFamiglia(Integer value) {
        this.idFamiglia = value;
    }

    /**
     * Recupera il valore della proprietà indirizzoResidenzaFamiglia.
     * 
     * @return
     *     possible object is
     *     {@link IndirizzoInterno }
     *     
     */
    public IndirizzoInterno getIndirizzoResidenzaFamiglia() {
        return indirizzoResidenzaFamiglia;
    }

    /**
     * Imposta il valore della proprietà indirizzoResidenzaFamiglia.
     * 
     * @param value
     *     allowed object is
     *     {@link IndirizzoInterno }
     *     
     */
    public void setIndirizzoResidenzaFamiglia(IndirizzoInterno value) {
        this.indirizzoResidenzaFamiglia = value;
    }

    /**
     * Recupera il valore della proprietà intestatarioScheda.
     * 
     * @return
     *     possible object is
     *     {@link VisuraSoggetto }
     *     
     */
    public VisuraSoggetto getIntestatarioScheda() {
        return intestatarioScheda;
    }

    /**
     * Imposta il valore della proprietà intestatarioScheda.
     * 
     * @param value
     *     allowed object is
     *     {@link VisuraSoggetto }
     *     
     */
    public void setIntestatarioScheda(VisuraSoggetto value) {
        this.intestatarioScheda = value;
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

    /**
     * Recupera il valore della proprietà tipoProtocolloRiservato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoProtocolloRiservato() {
        return tipoProtocolloRiservato;
    }

    /**
     * Imposta il valore della proprietà tipoProtocolloRiservato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoProtocolloRiservato(String value) {
        this.tipoProtocolloRiservato = value;
    }

}
