
package it.csi.iscritto.iscrittofosrv.integration.service.nao.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per StatoCivile complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="StatoCivile">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dataInizioValidita" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descBreveStatoCivile" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descBreveStatoCivileDichiarato" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descStatoCivile" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descStatoCivileDichiarato" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idConiugeDichiarato" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="statoCivileAttualeDocumentato" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StatoCivile", propOrder = {
    "dataInizioValidita",
    "descBreveStatoCivile",
    "descBreveStatoCivileDichiarato",
    "descStatoCivile",
    "descStatoCivileDichiarato",
    "idConiugeDichiarato",
    "statoCivileAttualeDocumentato"
})
public class StatoCivile {

    @XmlElement(required = true, nillable = true)
    protected String dataInizioValidita;
    @XmlElement(required = true, nillable = true)
    protected String descBreveStatoCivile;
    @XmlElement(required = true, nillable = true)
    protected String descBreveStatoCivileDichiarato;
    @XmlElement(required = true, nillable = true)
    protected String descStatoCivile;
    @XmlElement(required = true, nillable = true)
    protected String descStatoCivileDichiarato;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer idConiugeDichiarato;
    @XmlElement(required = true, type = Boolean.class, nillable = true)
    protected Boolean statoCivileAttualeDocumentato;

    /**
     * Recupera il valore della proprietà dataInizioValidita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataInizioValidita() {
        return dataInizioValidita;
    }

    /**
     * Imposta il valore della proprietà dataInizioValidita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataInizioValidita(String value) {
        this.dataInizioValidita = value;
    }

    /**
     * Recupera il valore della proprietà descBreveStatoCivile.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescBreveStatoCivile() {
        return descBreveStatoCivile;
    }

    /**
     * Imposta il valore della proprietà descBreveStatoCivile.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescBreveStatoCivile(String value) {
        this.descBreveStatoCivile = value;
    }

    /**
     * Recupera il valore della proprietà descBreveStatoCivileDichiarato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescBreveStatoCivileDichiarato() {
        return descBreveStatoCivileDichiarato;
    }

    /**
     * Imposta il valore della proprietà descBreveStatoCivileDichiarato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescBreveStatoCivileDichiarato(String value) {
        this.descBreveStatoCivileDichiarato = value;
    }

    /**
     * Recupera il valore della proprietà descStatoCivile.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescStatoCivile() {
        return descStatoCivile;
    }

    /**
     * Imposta il valore della proprietà descStatoCivile.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescStatoCivile(String value) {
        this.descStatoCivile = value;
    }

    /**
     * Recupera il valore della proprietà descStatoCivileDichiarato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescStatoCivileDichiarato() {
        return descStatoCivileDichiarato;
    }

    /**
     * Imposta il valore della proprietà descStatoCivileDichiarato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescStatoCivileDichiarato(String value) {
        this.descStatoCivileDichiarato = value;
    }

    /**
     * Recupera il valore della proprietà idConiugeDichiarato.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdConiugeDichiarato() {
        return idConiugeDichiarato;
    }

    /**
     * Imposta il valore della proprietà idConiugeDichiarato.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdConiugeDichiarato(Integer value) {
        this.idConiugeDichiarato = value;
    }

    /**
     * Recupera il valore della proprietà statoCivileAttualeDocumentato.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isStatoCivileAttualeDocumentato() {
        return statoCivileAttualeDocumentato;
    }

    /**
     * Imposta il valore della proprietà statoCivileAttualeDocumentato.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setStatoCivileAttualeDocumentato(Boolean value) {
        this.statoCivileAttualeDocumentato = value;
    }

}
