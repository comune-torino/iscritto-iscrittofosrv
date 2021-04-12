
package it.csi.iscritto.iscrittofosrv.integration.service.nao.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per EventoEmigrazione complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="EventoEmigrazione">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="annoPraticaEmigrazione" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dataEvento" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descTipoPraticaEmigrazione" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="flgExAIRE" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="indirizzoEmigrazione" type="{urn:SrvVisuraFamiglia}IndirizzoEsterno"/>
 *         &lt;element name="numeroPraticaEmigrazione" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EventoEmigrazione", propOrder = {
    "annoPraticaEmigrazione",
    "dataEvento",
    "descTipoPraticaEmigrazione",
    "flgExAIRE",
    "indirizzoEmigrazione",
    "numeroPraticaEmigrazione"
})
@XmlSeeAlso({
    DettaglioEventoEmigrazione.class
})
public class EventoEmigrazione {

    @XmlElement(required = true, nillable = true)
    protected String annoPraticaEmigrazione;
    @XmlElement(required = true, nillable = true)
    protected String dataEvento;
    @XmlElement(required = true, nillable = true)
    protected String descTipoPraticaEmigrazione;
    protected boolean flgExAIRE;
    @XmlElement(required = true, nillable = true)
    protected IndirizzoEsterno indirizzoEmigrazione;
    @XmlElement(required = true, nillable = true)
    protected String numeroPraticaEmigrazione;

    /**
     * Recupera il valore della proprietà annoPraticaEmigrazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnoPraticaEmigrazione() {
        return annoPraticaEmigrazione;
    }

    /**
     * Imposta il valore della proprietà annoPraticaEmigrazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnoPraticaEmigrazione(String value) {
        this.annoPraticaEmigrazione = value;
    }

    /**
     * Recupera il valore della proprietà dataEvento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataEvento() {
        return dataEvento;
    }

    /**
     * Imposta il valore della proprietà dataEvento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataEvento(String value) {
        this.dataEvento = value;
    }

    /**
     * Recupera il valore della proprietà descTipoPraticaEmigrazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescTipoPraticaEmigrazione() {
        return descTipoPraticaEmigrazione;
    }

    /**
     * Imposta il valore della proprietà descTipoPraticaEmigrazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescTipoPraticaEmigrazione(String value) {
        this.descTipoPraticaEmigrazione = value;
    }

    /**
     * Recupera il valore della proprietà flgExAIRE.
     * 
     */
    public boolean isFlgExAIRE() {
        return flgExAIRE;
    }

    /**
     * Imposta il valore della proprietà flgExAIRE.
     * 
     */
    public void setFlgExAIRE(boolean value) {
        this.flgExAIRE = value;
    }

    /**
     * Recupera il valore della proprietà indirizzoEmigrazione.
     * 
     * @return
     *     possible object is
     *     {@link IndirizzoEsterno }
     *     
     */
    public IndirizzoEsterno getIndirizzoEmigrazione() {
        return indirizzoEmigrazione;
    }

    /**
     * Imposta il valore della proprietà indirizzoEmigrazione.
     * 
     * @param value
     *     allowed object is
     *     {@link IndirizzoEsterno }
     *     
     */
    public void setIndirizzoEmigrazione(IndirizzoEsterno value) {
        this.indirizzoEmigrazione = value;
    }

    /**
     * Recupera il valore della proprietà numeroPraticaEmigrazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroPraticaEmigrazione() {
        return numeroPraticaEmigrazione;
    }

    /**
     * Imposta il valore della proprietà numeroPraticaEmigrazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroPraticaEmigrazione(String value) {
        this.numeroPraticaEmigrazione = value;
    }

}
