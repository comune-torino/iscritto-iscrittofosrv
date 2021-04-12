
package it.csi.iscritto.iscrittofosrv.integration.service.nao.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per PraticaAnagrafe complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="PraticaAnagrafe">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="annoPratica" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dataApertura" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dataChiusura" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descBreveStatoPratica" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descBreveTipoPratica" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descStatoPratica" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descTipoPratica" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="numeroPratica" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PraticaAnagrafe", propOrder = {
    "annoPratica",
    "dataApertura",
    "dataChiusura",
    "descBreveStatoPratica",
    "descBreveTipoPratica",
    "descStatoPratica",
    "descTipoPratica",
    "numeroPratica"
})
@XmlSeeAlso({
    PraticaEmigrazione.class
})
public class PraticaAnagrafe {

    @XmlElement(required = true, nillable = true)
    protected String annoPratica;
    @XmlElement(required = true, nillable = true)
    protected String dataApertura;
    @XmlElement(required = true, nillable = true)
    protected String dataChiusura;
    @XmlElement(required = true, nillable = true)
    protected String descBreveStatoPratica;
    @XmlElement(required = true, nillable = true)
    protected String descBreveTipoPratica;
    @XmlElement(required = true, nillable = true)
    protected String descStatoPratica;
    @XmlElement(required = true, nillable = true)
    protected String descTipoPratica;
    @XmlElement(required = true, nillable = true)
    protected String numeroPratica;

    /**
     * Recupera il valore della proprietà annoPratica.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnoPratica() {
        return annoPratica;
    }

    /**
     * Imposta il valore della proprietà annoPratica.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnoPratica(String value) {
        this.annoPratica = value;
    }

    /**
     * Recupera il valore della proprietà dataApertura.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataApertura() {
        return dataApertura;
    }

    /**
     * Imposta il valore della proprietà dataApertura.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataApertura(String value) {
        this.dataApertura = value;
    }

    /**
     * Recupera il valore della proprietà dataChiusura.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataChiusura() {
        return dataChiusura;
    }

    /**
     * Imposta il valore della proprietà dataChiusura.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataChiusura(String value) {
        this.dataChiusura = value;
    }

    /**
     * Recupera il valore della proprietà descBreveStatoPratica.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescBreveStatoPratica() {
        return descBreveStatoPratica;
    }

    /**
     * Imposta il valore della proprietà descBreveStatoPratica.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescBreveStatoPratica(String value) {
        this.descBreveStatoPratica = value;
    }

    /**
     * Recupera il valore della proprietà descBreveTipoPratica.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescBreveTipoPratica() {
        return descBreveTipoPratica;
    }

    /**
     * Imposta il valore della proprietà descBreveTipoPratica.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescBreveTipoPratica(String value) {
        this.descBreveTipoPratica = value;
    }

    /**
     * Recupera il valore della proprietà descStatoPratica.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescStatoPratica() {
        return descStatoPratica;
    }

    /**
     * Imposta il valore della proprietà descStatoPratica.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescStatoPratica(String value) {
        this.descStatoPratica = value;
    }

    /**
     * Recupera il valore della proprietà descTipoPratica.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescTipoPratica() {
        return descTipoPratica;
    }

    /**
     * Imposta il valore della proprietà descTipoPratica.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescTipoPratica(String value) {
        this.descTipoPratica = value;
    }

    /**
     * Recupera il valore della proprietà numeroPratica.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroPratica() {
        return numeroPratica;
    }

    /**
     * Imposta il valore della proprietà numeroPratica.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroPratica(String value) {
        this.numeroPratica = value;
    }

}
