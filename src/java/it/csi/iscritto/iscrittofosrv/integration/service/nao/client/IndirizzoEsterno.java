
package it.csi.iscritto.iscrittofosrv.integration.service.nao.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per IndirizzoEsterno complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="IndirizzoEsterno">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="capEstero" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descrizioneIndirizzoPrimaParte" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descrizioneIndirizzoSecondaParte" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="luogo" type="{urn:SrvVisuraFamiglia}Luogo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IndirizzoEsterno", propOrder = {
    "capEstero",
    "descrizioneIndirizzoPrimaParte",
    "descrizioneIndirizzoSecondaParte",
    "luogo"
})
public class IndirizzoEsterno {

    @XmlElement(required = true, nillable = true)
    protected String capEstero;
    @XmlElement(required = true, nillable = true)
    protected String descrizioneIndirizzoPrimaParte;
    @XmlElement(required = true, nillable = true)
    protected String descrizioneIndirizzoSecondaParte;
    @XmlElement(required = true, nillable = true)
    protected Luogo luogo;

    /**
     * Recupera il valore della proprietà capEstero.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCapEstero() {
        return capEstero;
    }

    /**
     * Imposta il valore della proprietà capEstero.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCapEstero(String value) {
        this.capEstero = value;
    }

    /**
     * Recupera il valore della proprietà descrizioneIndirizzoPrimaParte.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrizioneIndirizzoPrimaParte() {
        return descrizioneIndirizzoPrimaParte;
    }

    /**
     * Imposta il valore della proprietà descrizioneIndirizzoPrimaParte.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrizioneIndirizzoPrimaParte(String value) {
        this.descrizioneIndirizzoPrimaParte = value;
    }

    /**
     * Recupera il valore della proprietà descrizioneIndirizzoSecondaParte.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrizioneIndirizzoSecondaParte() {
        return descrizioneIndirizzoSecondaParte;
    }

    /**
     * Imposta il valore della proprietà descrizioneIndirizzoSecondaParte.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrizioneIndirizzoSecondaParte(String value) {
        this.descrizioneIndirizzoSecondaParte = value;
    }

    /**
     * Recupera il valore della proprietà luogo.
     * 
     * @return
     *     possible object is
     *     {@link Luogo }
     *     
     */
    public Luogo getLuogo() {
        return luogo;
    }

    /**
     * Imposta il valore della proprietà luogo.
     * 
     * @param value
     *     allowed object is
     *     {@link Luogo }
     *     
     */
    public void setLuogo(Luogo value) {
        this.luogo = value;
    }

}
