
package it.csi.iscritto.iscrittofosrv.integration.service.nao.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per Cittadinanza complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="Cittadinanza">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codCIE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codIstat" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descFemminile" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descMaschile" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="flagAppartenenzaUE" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="flagBuonVicinato" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="flagSpazioEconomicoEuropeo" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Cittadinanza", propOrder = {
    "codCIE",
    "codIstat",
    "descFemminile",
    "descMaschile",
    "flagAppartenenzaUE",
    "flagBuonVicinato",
    "flagSpazioEconomicoEuropeo"
})
public class Cittadinanza {

    @XmlElement(required = true, nillable = true)
    protected String codCIE;
    @XmlElement(required = true, nillable = true)
    protected String codIstat;
    @XmlElement(required = true, nillable = true)
    protected String descFemminile;
    @XmlElement(required = true, nillable = true)
    protected String descMaschile;
    protected boolean flagAppartenenzaUE;
    protected boolean flagBuonVicinato;
    protected boolean flagSpazioEconomicoEuropeo;

    /**
     * Recupera il valore della proprietà codCIE.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodCIE() {
        return codCIE;
    }

    /**
     * Imposta il valore della proprietà codCIE.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodCIE(String value) {
        this.codCIE = value;
    }

    /**
     * Recupera il valore della proprietà codIstat.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodIstat() {
        return codIstat;
    }

    /**
     * Imposta il valore della proprietà codIstat.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodIstat(String value) {
        this.codIstat = value;
    }

    /**
     * Recupera il valore della proprietà descFemminile.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescFemminile() {
        return descFemminile;
    }

    /**
     * Imposta il valore della proprietà descFemminile.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescFemminile(String value) {
        this.descFemminile = value;
    }

    /**
     * Recupera il valore della proprietà descMaschile.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescMaschile() {
        return descMaschile;
    }

    /**
     * Imposta il valore della proprietà descMaschile.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescMaschile(String value) {
        this.descMaschile = value;
    }

    /**
     * Recupera il valore della proprietà flagAppartenenzaUE.
     * 
     */
    public boolean isFlagAppartenenzaUE() {
        return flagAppartenenzaUE;
    }

    /**
     * Imposta il valore della proprietà flagAppartenenzaUE.
     * 
     */
    public void setFlagAppartenenzaUE(boolean value) {
        this.flagAppartenenzaUE = value;
    }

    /**
     * Recupera il valore della proprietà flagBuonVicinato.
     * 
     */
    public boolean isFlagBuonVicinato() {
        return flagBuonVicinato;
    }

    /**
     * Imposta il valore della proprietà flagBuonVicinato.
     * 
     */
    public void setFlagBuonVicinato(boolean value) {
        this.flagBuonVicinato = value;
    }

    /**
     * Recupera il valore della proprietà flagSpazioEconomicoEuropeo.
     * 
     */
    public boolean isFlagSpazioEconomicoEuropeo() {
        return flagSpazioEconomicoEuropeo;
    }

    /**
     * Imposta il valore della proprietà flagSpazioEconomicoEuropeo.
     * 
     */
    public void setFlagSpazioEconomicoEuropeo(boolean value) {
        this.flagSpazioEconomicoEuropeo = value;
    }

}
