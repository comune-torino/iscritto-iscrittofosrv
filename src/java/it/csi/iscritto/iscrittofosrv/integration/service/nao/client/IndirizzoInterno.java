
package it.csi.iscritto.iscrittofosrv.integration.service.nao.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per IndirizzoInterno complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="IndirizzoInterno">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bisTer" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bisTerInterno1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bisTerInterno2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cap" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="codVia" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="codicePiano" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="denominazioneCompattaVia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="denominazioneCorrente" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="denominazioneSecondariaVia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="denominazioneVia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descCircoscrizione" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descDistrettoAssistenza" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descPiano" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descSezioneVigiliUrbani" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idCircoscrizione" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idCivico" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idDistrettoAssistenza" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idSezioneVigiliUrbani" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idUiu" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="indicatoreAcquisizione" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="interno1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="interno2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nui" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numeroCompleto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="numeroPrimario" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numeroRadice" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="scala" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="secondario" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sedime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IndirizzoInterno", propOrder = {
    "bisTer",
    "bisTerInterno1",
    "bisTerInterno2",
    "cap",
    "codVia",
    "codicePiano",
    "denominazioneCompattaVia",
    "denominazioneCorrente",
    "denominazioneSecondariaVia",
    "denominazioneVia",
    "descCircoscrizione",
    "descDistrettoAssistenza",
    "descPiano",
    "descSezioneVigiliUrbani",
    "idCircoscrizione",
    "idCivico",
    "idDistrettoAssistenza",
    "idSezioneVigiliUrbani",
    "idUiu",
    "indicatoreAcquisizione",
    "interno1",
    "interno2",
    "nui",
    "numeroCompleto",
    "numeroPrimario",
    "numeroRadice",
    "scala",
    "secondario",
    "sedime"
})
public class IndirizzoInterno {

    @XmlElement(required = true, nillable = true)
    protected String bisTer;
    @XmlElement(required = true, nillable = true)
    protected String bisTerInterno1;
    @XmlElement(required = true, nillable = true)
    protected String bisTerInterno2;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer cap;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer codVia;
    @XmlElement(required = true, nillable = true)
    protected String codicePiano;
    @XmlElement(required = true, nillable = true)
    protected String denominazioneCompattaVia;
    @XmlElement(required = true, nillable = true)
    protected String denominazioneCorrente;
    @XmlElement(required = true, nillable = true)
    protected String denominazioneSecondariaVia;
    @XmlElement(required = true, nillable = true)
    protected String denominazioneVia;
    @XmlElement(required = true, nillable = true)
    protected String descCircoscrizione;
    @XmlElement(required = true, nillable = true)
    protected String descDistrettoAssistenza;
    @XmlElement(required = true, nillable = true)
    protected String descPiano;
    @XmlElement(required = true, nillable = true)
    protected String descSezioneVigiliUrbani;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer idCircoscrizione;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer idCivico;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer idDistrettoAssistenza;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer idSezioneVigiliUrbani;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer idUiu;
    @XmlElement(required = true, nillable = true)
    protected String indicatoreAcquisizione;
    @XmlElement(required = true, nillable = true)
    protected String interno1;
    @XmlElement(required = true, nillable = true)
    protected String interno2;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer nui;
    @XmlElement(required = true, nillable = true)
    protected String numeroCompleto;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer numeroPrimario;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer numeroRadice;
    @XmlElement(required = true, nillable = true)
    protected String scala;
    @XmlElement(required = true, nillable = true)
    protected String secondario;
    @XmlElement(required = true, nillable = true)
    protected String sedime;

    /**
     * Recupera il valore della proprietà bisTer.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBisTer() {
        return bisTer;
    }

    /**
     * Imposta il valore della proprietà bisTer.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBisTer(String value) {
        this.bisTer = value;
    }

    /**
     * Recupera il valore della proprietà bisTerInterno1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBisTerInterno1() {
        return bisTerInterno1;
    }

    /**
     * Imposta il valore della proprietà bisTerInterno1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBisTerInterno1(String value) {
        this.bisTerInterno1 = value;
    }

    /**
     * Recupera il valore della proprietà bisTerInterno2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBisTerInterno2() {
        return bisTerInterno2;
    }

    /**
     * Imposta il valore della proprietà bisTerInterno2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBisTerInterno2(String value) {
        this.bisTerInterno2 = value;
    }

    /**
     * Recupera il valore della proprietà cap.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCap() {
        return cap;
    }

    /**
     * Imposta il valore della proprietà cap.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCap(Integer value) {
        this.cap = value;
    }

    /**
     * Recupera il valore della proprietà codVia.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodVia() {
        return codVia;
    }

    /**
     * Imposta il valore della proprietà codVia.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodVia(Integer value) {
        this.codVia = value;
    }

    /**
     * Recupera il valore della proprietà codicePiano.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodicePiano() {
        return codicePiano;
    }

    /**
     * Imposta il valore della proprietà codicePiano.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodicePiano(String value) {
        this.codicePiano = value;
    }

    /**
     * Recupera il valore della proprietà denominazioneCompattaVia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDenominazioneCompattaVia() {
        return denominazioneCompattaVia;
    }

    /**
     * Imposta il valore della proprietà denominazioneCompattaVia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDenominazioneCompattaVia(String value) {
        this.denominazioneCompattaVia = value;
    }

    /**
     * Recupera il valore della proprietà denominazioneCorrente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDenominazioneCorrente() {
        return denominazioneCorrente;
    }

    /**
     * Imposta il valore della proprietà denominazioneCorrente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDenominazioneCorrente(String value) {
        this.denominazioneCorrente = value;
    }

    /**
     * Recupera il valore della proprietà denominazioneSecondariaVia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDenominazioneSecondariaVia() {
        return denominazioneSecondariaVia;
    }

    /**
     * Imposta il valore della proprietà denominazioneSecondariaVia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDenominazioneSecondariaVia(String value) {
        this.denominazioneSecondariaVia = value;
    }

    /**
     * Recupera il valore della proprietà denominazioneVia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDenominazioneVia() {
        return denominazioneVia;
    }

    /**
     * Imposta il valore della proprietà denominazioneVia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDenominazioneVia(String value) {
        this.denominazioneVia = value;
    }

    /**
     * Recupera il valore della proprietà descCircoscrizione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescCircoscrizione() {
        return descCircoscrizione;
    }

    /**
     * Imposta il valore della proprietà descCircoscrizione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescCircoscrizione(String value) {
        this.descCircoscrizione = value;
    }

    /**
     * Recupera il valore della proprietà descDistrettoAssistenza.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescDistrettoAssistenza() {
        return descDistrettoAssistenza;
    }

    /**
     * Imposta il valore della proprietà descDistrettoAssistenza.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescDistrettoAssistenza(String value) {
        this.descDistrettoAssistenza = value;
    }

    /**
     * Recupera il valore della proprietà descPiano.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescPiano() {
        return descPiano;
    }

    /**
     * Imposta il valore della proprietà descPiano.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescPiano(String value) {
        this.descPiano = value;
    }

    /**
     * Recupera il valore della proprietà descSezioneVigiliUrbani.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescSezioneVigiliUrbani() {
        return descSezioneVigiliUrbani;
    }

    /**
     * Imposta il valore della proprietà descSezioneVigiliUrbani.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescSezioneVigiliUrbani(String value) {
        this.descSezioneVigiliUrbani = value;
    }

    /**
     * Recupera il valore della proprietà idCircoscrizione.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdCircoscrizione() {
        return idCircoscrizione;
    }

    /**
     * Imposta il valore della proprietà idCircoscrizione.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdCircoscrizione(Integer value) {
        this.idCircoscrizione = value;
    }

    /**
     * Recupera il valore della proprietà idCivico.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdCivico() {
        return idCivico;
    }

    /**
     * Imposta il valore della proprietà idCivico.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdCivico(Integer value) {
        this.idCivico = value;
    }

    /**
     * Recupera il valore della proprietà idDistrettoAssistenza.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdDistrettoAssistenza() {
        return idDistrettoAssistenza;
    }

    /**
     * Imposta il valore della proprietà idDistrettoAssistenza.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdDistrettoAssistenza(Integer value) {
        this.idDistrettoAssistenza = value;
    }

    /**
     * Recupera il valore della proprietà idSezioneVigiliUrbani.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdSezioneVigiliUrbani() {
        return idSezioneVigiliUrbani;
    }

    /**
     * Imposta il valore della proprietà idSezioneVigiliUrbani.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdSezioneVigiliUrbani(Integer value) {
        this.idSezioneVigiliUrbani = value;
    }

    /**
     * Recupera il valore della proprietà idUiu.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdUiu() {
        return idUiu;
    }

    /**
     * Imposta il valore della proprietà idUiu.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdUiu(Integer value) {
        this.idUiu = value;
    }

    /**
     * Recupera il valore della proprietà indicatoreAcquisizione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndicatoreAcquisizione() {
        return indicatoreAcquisizione;
    }

    /**
     * Imposta il valore della proprietà indicatoreAcquisizione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndicatoreAcquisizione(String value) {
        this.indicatoreAcquisizione = value;
    }

    /**
     * Recupera il valore della proprietà interno1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterno1() {
        return interno1;
    }

    /**
     * Imposta il valore della proprietà interno1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterno1(String value) {
        this.interno1 = value;
    }

    /**
     * Recupera il valore della proprietà interno2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterno2() {
        return interno2;
    }

    /**
     * Imposta il valore della proprietà interno2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterno2(String value) {
        this.interno2 = value;
    }

    /**
     * Recupera il valore della proprietà nui.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNui() {
        return nui;
    }

    /**
     * Imposta il valore della proprietà nui.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNui(Integer value) {
        this.nui = value;
    }

    /**
     * Recupera il valore della proprietà numeroCompleto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroCompleto() {
        return numeroCompleto;
    }

    /**
     * Imposta il valore della proprietà numeroCompleto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroCompleto(String value) {
        this.numeroCompleto = value;
    }

    /**
     * Recupera il valore della proprietà numeroPrimario.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumeroPrimario() {
        return numeroPrimario;
    }

    /**
     * Imposta il valore della proprietà numeroPrimario.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumeroPrimario(Integer value) {
        this.numeroPrimario = value;
    }

    /**
     * Recupera il valore della proprietà numeroRadice.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumeroRadice() {
        return numeroRadice;
    }

    /**
     * Imposta il valore della proprietà numeroRadice.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumeroRadice(Integer value) {
        this.numeroRadice = value;
    }

    /**
     * Recupera il valore della proprietà scala.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScala() {
        return scala;
    }

    /**
     * Imposta il valore della proprietà scala.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScala(String value) {
        this.scala = value;
    }

    /**
     * Recupera il valore della proprietà secondario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecondario() {
        return secondario;
    }

    /**
     * Imposta il valore della proprietà secondario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecondario(String value) {
        this.secondario = value;
    }

    /**
     * Recupera il valore della proprietà sedime.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSedime() {
        return sedime;
    }

    /**
     * Imposta il valore della proprietà sedime.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSedime(String value) {
        this.sedime = value;
    }

}
