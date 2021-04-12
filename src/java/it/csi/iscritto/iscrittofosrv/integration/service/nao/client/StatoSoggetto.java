
package it.csi.iscritto.iscrittofosrv.integration.service.nao.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per StatoSoggetto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="StatoSoggetto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="descBreveStato" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descBreveStatoAnagrafico" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descStato" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descStatoAnagrafico" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StatoSoggetto", propOrder = {
    "descBreveStato",
    "descBreveStatoAnagrafico",
    "descStato",
    "descStatoAnagrafico"
})
public class StatoSoggetto {

    @XmlElement(required = true, nillable = true)
    protected String descBreveStato;
    @XmlElement(required = true, nillable = true)
    protected String descBreveStatoAnagrafico;
    @XmlElement(required = true, nillable = true)
    protected String descStato;
    @XmlElement(required = true, nillable = true)
    protected String descStatoAnagrafico;

    /**
     * Recupera il valore della proprietà descBreveStato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescBreveStato() {
        return descBreveStato;
    }

    /**
     * Imposta il valore della proprietà descBreveStato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescBreveStato(String value) {
        this.descBreveStato = value;
    }

    /**
     * Recupera il valore della proprietà descBreveStatoAnagrafico.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescBreveStatoAnagrafico() {
        return descBreveStatoAnagrafico;
    }

    /**
     * Imposta il valore della proprietà descBreveStatoAnagrafico.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescBreveStatoAnagrafico(String value) {
        this.descBreveStatoAnagrafico = value;
    }

    /**
     * Recupera il valore della proprietà descStato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescStato() {
        return descStato;
    }

    /**
     * Imposta il valore della proprietà descStato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescStato(String value) {
        this.descStato = value;
    }

    /**
     * Recupera il valore della proprietà descStatoAnagrafico.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescStatoAnagrafico() {
        return descStatoAnagrafico;
    }

    /**
     * Imposta il valore della proprietà descStatoAnagrafico.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescStatoAnagrafico(String value) {
        this.descStatoAnagrafico = value;
    }

}
