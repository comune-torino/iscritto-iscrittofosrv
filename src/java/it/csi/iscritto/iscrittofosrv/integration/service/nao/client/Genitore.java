
package it.csi.iscritto.iscrittofosrv.integration.service.nao.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per Genitore complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="Genitore">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codRuolo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cognome" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cognomeDichiarato" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dataFineValidita" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dataInizioValidita" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descRuolo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="flgCognomeNomeCorretti" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="genitoreDocumentato" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="idRuolo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idSoggetto" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nome" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nomeDichiarato" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Genitore", propOrder = {
    "codRuolo",
    "cognome",
    "cognomeDichiarato",
    "dataFineValidita",
    "dataInizioValidita",
    "descRuolo",
    "flgCognomeNomeCorretti",
    "genitoreDocumentato",
    "idRuolo",
    "idSoggetto",
    "nome",
    "nomeDichiarato"
})
public class Genitore {

    @XmlElement(required = true, nillable = true)
    protected String codRuolo;
    @XmlElement(required = true, nillable = true)
    protected String cognome;
    @XmlElement(required = true, nillable = true)
    protected String cognomeDichiarato;
    @XmlElement(required = true, nillable = true)
    protected String dataFineValidita;
    @XmlElement(required = true, nillable = true)
    protected String dataInizioValidita;
    @XmlElement(required = true, nillable = true)
    protected String descRuolo;
    protected boolean flgCognomeNomeCorretti;
    @XmlElement(required = true, type = Boolean.class, nillable = true)
    protected Boolean genitoreDocumentato;
    protected int idRuolo;
    protected int idSoggetto;
    @XmlElement(required = true, nillable = true)
    protected String nome;
    @XmlElement(required = true, nillable = true)
    protected String nomeDichiarato;

    /**
     * Recupera il valore della proprietà codRuolo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodRuolo() {
        return codRuolo;
    }

    /**
     * Imposta il valore della proprietà codRuolo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodRuolo(String value) {
        this.codRuolo = value;
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
     * Recupera il valore della proprietà cognomeDichiarato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCognomeDichiarato() {
        return cognomeDichiarato;
    }

    /**
     * Imposta il valore della proprietà cognomeDichiarato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCognomeDichiarato(String value) {
        this.cognomeDichiarato = value;
    }

    /**
     * Recupera il valore della proprietà dataFineValidita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataFineValidita() {
        return dataFineValidita;
    }

    /**
     * Imposta il valore della proprietà dataFineValidita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataFineValidita(String value) {
        this.dataFineValidita = value;
    }

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
     * Recupera il valore della proprietà descRuolo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescRuolo() {
        return descRuolo;
    }

    /**
     * Imposta il valore della proprietà descRuolo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescRuolo(String value) {
        this.descRuolo = value;
    }

    /**
     * Recupera il valore della proprietà flgCognomeNomeCorretti.
     * 
     */
    public boolean isFlgCognomeNomeCorretti() {
        return flgCognomeNomeCorretti;
    }

    /**
     * Imposta il valore della proprietà flgCognomeNomeCorretti.
     * 
     */
    public void setFlgCognomeNomeCorretti(boolean value) {
        this.flgCognomeNomeCorretti = value;
    }

    /**
     * Recupera il valore della proprietà genitoreDocumentato.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isGenitoreDocumentato() {
        return genitoreDocumentato;
    }

    /**
     * Imposta il valore della proprietà genitoreDocumentato.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setGenitoreDocumentato(Boolean value) {
        this.genitoreDocumentato = value;
    }

    /**
     * Recupera il valore della proprietà idRuolo.
     * 
     */
    public int getIdRuolo() {
        return idRuolo;
    }

    /**
     * Imposta il valore della proprietà idRuolo.
     * 
     */
    public void setIdRuolo(int value) {
        this.idRuolo = value;
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
     * Recupera il valore della proprietà nomeDichiarato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeDichiarato() {
        return nomeDichiarato;
    }

    /**
     * Imposta il valore della proprietà nomeDichiarato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeDichiarato(String value) {
        this.nomeDichiarato = value;
    }

}
