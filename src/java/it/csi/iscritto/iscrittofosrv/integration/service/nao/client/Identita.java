
package it.csi.iscritto.iscrittofosrv.integration.service.nao.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per Identita complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="Identita">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codFiscale" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cognome" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idProvider" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="livelloAutenticazione" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="mac" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nome" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rappresentazioneInterna" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="timestamp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Identita", propOrder = {
    "codFiscale",
    "cognome",
    "idProvider",
    "livelloAutenticazione",
    "mac",
    "nome",
    "rappresentazioneInterna",
    "timestamp"
})
public class Identita {

    @XmlElement(required = true, nillable = true)
    protected String codFiscale;
    @XmlElement(required = true, nillable = true)
    protected String cognome;
    @XmlElement(required = true, nillable = true)
    protected String idProvider;
    protected int livelloAutenticazione;
    @XmlElement(required = true, nillable = true)
    protected String mac;
    @XmlElement(required = true, nillable = true)
    protected String nome;
    @XmlElement(required = true, nillable = true)
    protected String rappresentazioneInterna;
    @XmlElement(required = true, nillable = true)
    protected String timestamp;

    /**
     * Recupera il valore della proprietà codFiscale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodFiscale() {
        return codFiscale;
    }

    /**
     * Imposta il valore della proprietà codFiscale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodFiscale(String value) {
        this.codFiscale = value;
    }

    /**
     * Recupera il valore della proprietà cognome.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Imposta il valore della proprietà cognome.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCognome(String value) {
        this.cognome = value;
    }

    /**
     * Recupera il valore della proprietà idProvider.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdProvider() {
        return idProvider;
    }

    /**
     * Imposta il valore della proprietà idProvider.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdProvider(String value) {
        this.idProvider = value;
    }

    /**
     * Recupera il valore della proprietà livelloAutenticazione.
     * 
     */
    public int getLivelloAutenticazione() {
        return livelloAutenticazione;
    }

    /**
     * Imposta il valore della proprietà livelloAutenticazione.
     * 
     */
    public void setLivelloAutenticazione(int value) {
        this.livelloAutenticazione = value;
    }

    /**
     * Recupera il valore della proprietà mac.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMac() {
        return mac;
    }

    /**
     * Imposta il valore della proprietà mac.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMac(String value) {
        this.mac = value;
    }

    /**
     * Recupera il valore della proprietà nome.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNome() {
        return nome;
    }

    /**
     * Imposta il valore della proprietà nome.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNome(String value) {
        this.nome = value;
    }

    /**
     * Recupera il valore della proprietà rappresentazioneInterna.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRappresentazioneInterna() {
        return rappresentazioneInterna;
    }

    /**
     * Imposta il valore della proprietà rappresentazioneInterna.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRappresentazioneInterna(String value) {
        this.rappresentazioneInterna = value;
    }

    /**
     * Recupera il valore della proprietà timestamp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * Imposta il valore della proprietà timestamp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimestamp(String value) {
        this.timestamp = value;
    }

}
