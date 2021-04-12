
package it.csi.iscritto.iscrittofosrv.integration.service.nao.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per BloccoCertificabilitaANA complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="BloccoCertificabilitaANA">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="descBlocco" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descBreveBlocco" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BloccoCertificabilitaANA", propOrder = {
    "descBlocco",
    "descBreveBlocco"
})
public class BloccoCertificabilitaANA {

    @XmlElement(required = true, nillable = true)
    protected String descBlocco;
    @XmlElement(required = true, nillable = true)
    protected String descBreveBlocco;

    /**
     * Recupera il valore della proprietà descBlocco.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescBlocco() {
        return descBlocco;
    }

    /**
     * Imposta il valore della proprietà descBlocco.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescBlocco(String value) {
        this.descBlocco = value;
    }

    /**
     * Recupera il valore della proprietà descBreveBlocco.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescBreveBlocco() {
        return descBreveBlocco;
    }

    /**
     * Imposta il valore della proprietà descBreveBlocco.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescBreveBlocco(String value) {
        this.descBreveBlocco = value;
    }

}
