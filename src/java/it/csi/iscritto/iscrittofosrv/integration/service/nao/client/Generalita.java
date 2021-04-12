
package it.csi.iscritto.iscrittofosrv.integration.service.nao.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per Generalita complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="Generalita">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codiceFiscale" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cognome" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dataNascita" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dataNascitaOriginale" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idSoggetto" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nome" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nomeCompleto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="numeroIndividuale" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="oraMinutiNascita" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="protocolloRiservato" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sesso" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Generalita", propOrder = {
    "codiceFiscale",
    "cognome",
    "dataNascita",
    "dataNascitaOriginale",
    "idSoggetto",
    "nome",
    "nomeCompleto",
    "numeroIndividuale",
    "oraMinutiNascita",
    "protocolloRiservato",
    "sesso"
})
public class Generalita {

    @XmlElement(required = true, nillable = true)
    protected String codiceFiscale;
    @XmlElement(required = true, nillable = true)
    protected String cognome;
    @XmlElement(required = true, nillable = true)
    protected String dataNascita;
    @XmlElement(required = true, nillable = true)
    protected String dataNascitaOriginale;
    protected int idSoggetto;
    @XmlElement(required = true, nillable = true)
    protected String nome;
    @XmlElement(required = true, nillable = true)
    protected String nomeCompleto;
    @XmlElement(required = true, nillable = true)
    protected String numeroIndividuale;
    @XmlElement(required = true, nillable = true)
    protected String oraMinutiNascita;
    protected int protocolloRiservato;
    @XmlElement(required = true, nillable = true)
    protected String sesso;

    /**
     * Recupera il valore della proprietà codiceFiscale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    /**
     * Imposta il valore della proprietà codiceFiscale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceFiscale(String value) {
        this.codiceFiscale = value;
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
     * Recupera il valore della proprietà dataNascita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataNascita() {
        return dataNascita;
    }

    /**
     * Imposta il valore della proprietà dataNascita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataNascita(String value) {
        this.dataNascita = value;
    }

    /**
     * Recupera il valore della proprietà dataNascitaOriginale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataNascitaOriginale() {
        return dataNascitaOriginale;
    }

    /**
     * Imposta il valore della proprietà dataNascitaOriginale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataNascitaOriginale(String value) {
        this.dataNascitaOriginale = value;
    }

    /**
     * Recupera il valore della proprietà idSoggetto.
     * 
     */
    public int getIdSoggetto() {
        return idSoggetto;
    }

    /**
     * Imposta il valore della proprietà idSoggetto.
     * 
     */
    public void setIdSoggetto(int value) {
        this.idSoggetto = value;
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
     * Recupera il valore della proprietà nomeCompleto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    /**
     * Imposta il valore della proprietà nomeCompleto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeCompleto(String value) {
        this.nomeCompleto = value;
    }

    /**
     * Recupera il valore della proprietà numeroIndividuale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroIndividuale() {
        return numeroIndividuale;
    }

    /**
     * Imposta il valore della proprietà numeroIndividuale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroIndividuale(String value) {
        this.numeroIndividuale = value;
    }

    /**
     * Recupera il valore della proprietà oraMinutiNascita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOraMinutiNascita() {
        return oraMinutiNascita;
    }

    /**
     * Imposta il valore della proprietà oraMinutiNascita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOraMinutiNascita(String value) {
        this.oraMinutiNascita = value;
    }

    /**
     * Recupera il valore della proprietà protocolloRiservato.
     * 
     */
    public int getProtocolloRiservato() {
        return protocolloRiservato;
    }

    /**
     * Imposta il valore della proprietà protocolloRiservato.
     * 
     */
    public void setProtocolloRiservato(int value) {
        this.protocolloRiservato = value;
    }

    /**
     * Recupera il valore della proprietà sesso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSesso() {
        return sesso;
    }

    /**
     * Imposta il valore della proprietà sesso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSesso(String value) {
        this.sesso = value;
    }

}
