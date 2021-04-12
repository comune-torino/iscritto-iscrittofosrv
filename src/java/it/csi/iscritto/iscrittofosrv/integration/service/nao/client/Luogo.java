
package it.csi.iscritto.iscrittofosrv.integration.service.nao.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per Luogo complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="Luogo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="capComune" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codCatComune" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codCatNazione" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codCieNazione" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codIstatComune" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codIstatNazione" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codIstatProvincia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codMctcNazione" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codMinisteroInterniNazione" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="codTerritorioNazione" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codiceMFLuogo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codiceMFNazione" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codiceMinisteroComune" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dataFineValiditaLuogo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dataInizioValiditaLuogo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descLuogo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descNazione" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descProvincia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="flgAppartenenzaUENazione" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="idLuogo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idNazione" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idProvincia" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="siglaProvincia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="statoLuogo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tipoLuogo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Luogo", propOrder = {
    "capComune",
    "codCatComune",
    "codCatNazione",
    "codCieNazione",
    "codIstatComune",
    "codIstatNazione",
    "codIstatProvincia",
    "codMctcNazione",
    "codMinisteroInterniNazione",
    "codTerritorioNazione",
    "codiceMFLuogo",
    "codiceMFNazione",
    "codiceMinisteroComune",
    "dataFineValiditaLuogo",
    "dataInizioValiditaLuogo",
    "descLuogo",
    "descNazione",
    "descProvincia",
    "flgAppartenenzaUENazione",
    "idLuogo",
    "idNazione",
    "idProvincia",
    "siglaProvincia",
    "statoLuogo",
    "tipoLuogo"
})
public class Luogo {

    @XmlElement(required = true, nillable = true)
    protected String capComune;
    @XmlElement(required = true, nillable = true)
    protected String codCatComune;
    @XmlElement(required = true, nillable = true)
    protected String codCatNazione;
    @XmlElement(required = true, nillable = true)
    protected String codCieNazione;
    @XmlElement(required = true, nillable = true)
    protected String codIstatComune;
    @XmlElement(required = true, nillable = true)
    protected String codIstatNazione;
    @XmlElement(required = true, nillable = true)
    protected String codIstatProvincia;
    @XmlElement(required = true, nillable = true)
    protected String codMctcNazione;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer codMinisteroInterniNazione;
    @XmlElement(required = true, nillable = true)
    protected String codTerritorioNazione;
    @XmlElement(required = true, nillable = true)
    protected String codiceMFLuogo;
    @XmlElement(required = true, nillable = true)
    protected String codiceMFNazione;
    @XmlElement(required = true, nillable = true)
    protected String codiceMinisteroComune;
    @XmlElement(required = true, nillable = true)
    protected String dataFineValiditaLuogo;
    @XmlElement(required = true, nillable = true)
    protected String dataInizioValiditaLuogo;
    @XmlElement(required = true, nillable = true)
    protected String descLuogo;
    @XmlElement(required = true, nillable = true)
    protected String descNazione;
    @XmlElement(required = true, nillable = true)
    protected String descProvincia;
    protected boolean flgAppartenenzaUENazione;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer idLuogo;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer idNazione;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer idProvincia;
    @XmlElement(required = true, nillable = true)
    protected String siglaProvincia;
    protected int statoLuogo;
    @XmlElement(required = true, nillable = true)
    protected String tipoLuogo;

    /**
     * Recupera il valore della proprietà capComune.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCapComune() {
        return capComune;
    }

    /**
     * Imposta il valore della proprietà capComune.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCapComune(String value) {
        this.capComune = value;
    }

    /**
     * Recupera il valore della proprietà codCatComune.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodCatComune() {
        return codCatComune;
    }

    /**
     * Imposta il valore della proprietà codCatComune.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodCatComune(String value) {
        this.codCatComune = value;
    }

    /**
     * Recupera il valore della proprietà codCatNazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodCatNazione() {
        return codCatNazione;
    }

    /**
     * Imposta il valore della proprietà codCatNazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodCatNazione(String value) {
        this.codCatNazione = value;
    }

    /**
     * Recupera il valore della proprietà codCieNazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodCieNazione() {
        return codCieNazione;
    }

    /**
     * Imposta il valore della proprietà codCieNazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodCieNazione(String value) {
        this.codCieNazione = value;
    }

    /**
     * Recupera il valore della proprietà codIstatComune.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodIstatComune() {
        return codIstatComune;
    }

    /**
     * Imposta il valore della proprietà codIstatComune.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodIstatComune(String value) {
        this.codIstatComune = value;
    }

    /**
     * Recupera il valore della proprietà codIstatNazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodIstatNazione() {
        return codIstatNazione;
    }

    /**
     * Imposta il valore della proprietà codIstatNazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodIstatNazione(String value) {
        this.codIstatNazione = value;
    }

    /**
     * Recupera il valore della proprietà codIstatProvincia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodIstatProvincia() {
        return codIstatProvincia;
    }

    /**
     * Imposta il valore della proprietà codIstatProvincia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodIstatProvincia(String value) {
        this.codIstatProvincia = value;
    }

    /**
     * Recupera il valore della proprietà codMctcNazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodMctcNazione() {
        return codMctcNazione;
    }

    /**
     * Imposta il valore della proprietà codMctcNazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodMctcNazione(String value) {
        this.codMctcNazione = value;
    }

    /**
     * Recupera il valore della proprietà codMinisteroInterniNazione.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodMinisteroInterniNazione() {
        return codMinisteroInterniNazione;
    }

    /**
     * Imposta il valore della proprietà codMinisteroInterniNazione.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodMinisteroInterniNazione(Integer value) {
        this.codMinisteroInterniNazione = value;
    }

    /**
     * Recupera il valore della proprietà codTerritorioNazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTerritorioNazione() {
        return codTerritorioNazione;
    }

    /**
     * Imposta il valore della proprietà codTerritorioNazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTerritorioNazione(String value) {
        this.codTerritorioNazione = value;
    }

    /**
     * Recupera il valore della proprietà codiceMFLuogo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceMFLuogo() {
        return codiceMFLuogo;
    }

    /**
     * Imposta il valore della proprietà codiceMFLuogo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceMFLuogo(String value) {
        this.codiceMFLuogo = value;
    }

    /**
     * Recupera il valore della proprietà codiceMFNazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceMFNazione() {
        return codiceMFNazione;
    }

    /**
     * Imposta il valore della proprietà codiceMFNazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceMFNazione(String value) {
        this.codiceMFNazione = value;
    }

    /**
     * Recupera il valore della proprietà codiceMinisteroComune.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceMinisteroComune() {
        return codiceMinisteroComune;
    }

    /**
     * Imposta il valore della proprietà codiceMinisteroComune.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceMinisteroComune(String value) {
        this.codiceMinisteroComune = value;
    }

    /**
     * Recupera il valore della proprietà dataFineValiditaLuogo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataFineValiditaLuogo() {
        return dataFineValiditaLuogo;
    }

    /**
     * Imposta il valore della proprietà dataFineValiditaLuogo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataFineValiditaLuogo(String value) {
        this.dataFineValiditaLuogo = value;
    }

    /**
     * Recupera il valore della proprietà dataInizioValiditaLuogo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataInizioValiditaLuogo() {
        return dataInizioValiditaLuogo;
    }

    /**
     * Imposta il valore della proprietà dataInizioValiditaLuogo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataInizioValiditaLuogo(String value) {
        this.dataInizioValiditaLuogo = value;
    }

    /**
     * Recupera il valore della proprietà descLuogo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescLuogo() {
        return descLuogo;
    }

    /**
     * Imposta il valore della proprietà descLuogo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescLuogo(String value) {
        this.descLuogo = value;
    }

    /**
     * Recupera il valore della proprietà descNazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescNazione() {
        return descNazione;
    }

    /**
     * Imposta il valore della proprietà descNazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescNazione(String value) {
        this.descNazione = value;
    }

    /**
     * Recupera il valore della proprietà descProvincia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescProvincia() {
        return descProvincia;
    }

    /**
     * Imposta il valore della proprietà descProvincia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescProvincia(String value) {
        this.descProvincia = value;
    }

    /**
     * Recupera il valore della proprietà flgAppartenenzaUENazione.
     * 
     */
    public boolean isFlgAppartenenzaUENazione() {
        return flgAppartenenzaUENazione;
    }

    /**
     * Imposta il valore della proprietà flgAppartenenzaUENazione.
     * 
     */
    public void setFlgAppartenenzaUENazione(boolean value) {
        this.flgAppartenenzaUENazione = value;
    }

    /**
     * Recupera il valore della proprietà idLuogo.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdLuogo() {
        return idLuogo;
    }

    /**
     * Imposta il valore della proprietà idLuogo.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdLuogo(Integer value) {
        this.idLuogo = value;
    }

    /**
     * Recupera il valore della proprietà idNazione.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdNazione() {
        return idNazione;
    }

    /**
     * Imposta il valore della proprietà idNazione.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdNazione(Integer value) {
        this.idNazione = value;
    }

    /**
     * Recupera il valore della proprietà idProvincia.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdProvincia() {
        return idProvincia;
    }

    /**
     * Imposta il valore della proprietà idProvincia.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdProvincia(Integer value) {
        this.idProvincia = value;
    }

    /**
     * Recupera il valore della proprietà siglaProvincia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSiglaProvincia() {
        return siglaProvincia;
    }

    /**
     * Imposta il valore della proprietà siglaProvincia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiglaProvincia(String value) {
        this.siglaProvincia = value;
    }

    /**
     * Recupera il valore della proprietà statoLuogo.
     * 
     */
    public int getStatoLuogo() {
        return statoLuogo;
    }

    /**
     * Imposta il valore della proprietà statoLuogo.
     * 
     */
    public void setStatoLuogo(int value) {
        this.statoLuogo = value;
    }

    /**
     * Recupera il valore della proprietà tipoLuogo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoLuogo() {
        return tipoLuogo;
    }

    /**
     * Imposta il valore della proprietà tipoLuogo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoLuogo(String value) {
        this.tipoLuogo = value;
    }

}
