
package it.csi.iscritto.iscrittofosrv.integration.service.nao.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per UtenteServizio complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="UtenteServizio">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codiceUtente" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="identita" type="{urn:SrvVisuraFamiglia}Identita"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UtenteServizio", propOrder = {
    "codiceUtente",
    "identita"
})
public class UtenteServizio {

    @XmlElement(required = true, nillable = true)
    protected String codiceUtente;
    @XmlElement(required = true, nillable = true)
    protected Identita identita;

    /**
     * Recupera il valore della proprietà codiceUtente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceUtente() {
        return codiceUtente;
    }

    /**
     * Imposta il valore della proprietà codiceUtente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceUtente(String value) {
        this.codiceUtente = value;
    }

    /**
     * Recupera il valore della proprietà identita.
     * 
     * @return
     *     possible object is
     *     {@link Identita }
     *     
     */
    public Identita getIdentita() {
        return identita;
    }

    /**
     * Imposta il valore della proprietà identita.
     * 
     * @param value
     *     allowed object is
     *     {@link Identita }
     *     
     */
    public void setIdentita(Identita value) {
        this.identita = value;
    }

}
