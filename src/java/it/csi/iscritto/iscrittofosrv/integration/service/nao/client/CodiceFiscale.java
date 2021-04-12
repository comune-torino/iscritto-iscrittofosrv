
package it.csi.iscritto.iscrittofosrv.integration.service.nao.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per CodiceFiscale complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="CodiceFiscale">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:SrvVisuraFamiglia}Documento">
 *       &lt;sequence>
 *         &lt;element name="dataValidazione" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descStatoCodiceFiscale" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="flgModificato" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="flgValidato" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CodiceFiscale", propOrder = {
    "dataValidazione",
    "descStatoCodiceFiscale",
    "flgModificato",
    "flgValidato"
})
public class CodiceFiscale
    extends Documento
{

    @XmlElement(required = true, nillable = true)
    protected String dataValidazione;
    @XmlElement(required = true, nillable = true)
    protected String descStatoCodiceFiscale;
    @XmlElement(required = true, type = Boolean.class, nillable = true)
    protected Boolean flgModificato;
    protected boolean flgValidato;

    /**
     * Recupera il valore della proprietà dataValidazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataValidazione() {
        return dataValidazione;
    }

    /**
     * Imposta il valore della proprietà dataValidazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataValidazione(String value) {
        this.dataValidazione = value;
    }

    /**
     * Recupera il valore della proprietà descStatoCodiceFiscale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescStatoCodiceFiscale() {
        return descStatoCodiceFiscale;
    }

    /**
     * Imposta il valore della proprietà descStatoCodiceFiscale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescStatoCodiceFiscale(String value) {
        this.descStatoCodiceFiscale = value;
    }

    /**
     * Recupera il valore della proprietà flgModificato.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFlgModificato() {
        return flgModificato;
    }

    /**
     * Imposta il valore della proprietà flgModificato.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFlgModificato(Boolean value) {
        this.flgModificato = value;
    }

    /**
     * Recupera il valore della proprietà flgValidato.
     * 
     */
    public boolean isFlgValidato() {
        return flgValidato;
    }

    /**
     * Imposta il valore della proprietà flgValidato.
     * 
     */
    public void setFlgValidato(boolean value) {
        this.flgValidato = value;
    }

}
