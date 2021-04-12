
package it.csi.iscritto.iscrittofosrv.integration.service.nao.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per Soggetto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="Soggetto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="generalita" type="{urn:SrvVisuraFamiglia}Generalita"/>
 *         &lt;element name="genitori" type="{urn:SrvVisuraFamiglia}ArrayOfGenitore"/>
 *         &lt;element name="luogoNascita" type="{urn:SrvVisuraFamiglia}Luogo"/>
 *         &lt;element name="soggettoFamiglia" type="{urn:SrvVisuraFamiglia}SoggettoFamiglia"/>
 *         &lt;element name="statoSoggetto" type="{urn:SrvVisuraFamiglia}StatoSoggetto"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Soggetto", propOrder = {
    "generalita",
    "genitori",
    "luogoNascita",
    "soggettoFamiglia",
    "statoSoggetto"
})
@XmlSeeAlso({
    VisuraSoggetto.class
})
public class Soggetto {

    @XmlElement(required = true, nillable = true)
    protected Generalita generalita;
    @XmlElement(required = true, nillable = true)
    protected ArrayOfGenitore genitori;
    @XmlElement(required = true, nillable = true)
    protected Luogo luogoNascita;
    @XmlElement(required = true, nillable = true)
    protected SoggettoFamiglia soggettoFamiglia;
    @XmlElement(required = true, nillable = true)
    protected StatoSoggetto statoSoggetto;

    /**
     * Recupera il valore della proprietà generalita.
     * 
     * @return
     *     possible object is
     *     {@link Generalita }
     *     
     */
    public Generalita getGeneralita() {
        return generalita;
    }

    /**
     * Imposta il valore della proprietà generalita.
     * 
     * @param value
     *     allowed object is
     *     {@link Generalita }
     *     
     */
    public void setGeneralita(Generalita value) {
        this.generalita = value;
    }

    /**
     * Recupera il valore della proprietà genitori.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfGenitore }
     *     
     */
    public ArrayOfGenitore getGenitori() {
        return genitori;
    }

    /**
     * Imposta il valore della proprietà genitori.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfGenitore }
     *     
     */
    public void setGenitori(ArrayOfGenitore value) {
        this.genitori = value;
    }

    /**
     * Recupera il valore della proprietà luogoNascita.
     * 
     * @return
     *     possible object is
     *     {@link Luogo }
     *     
     */
    public Luogo getLuogoNascita() {
        return luogoNascita;
    }

    /**
     * Imposta il valore della proprietà luogoNascita.
     * 
     * @param value
     *     allowed object is
     *     {@link Luogo }
     *     
     */
    public void setLuogoNascita(Luogo value) {
        this.luogoNascita = value;
    }

    /**
     * Recupera il valore della proprietà soggettoFamiglia.
     * 
     * @return
     *     possible object is
     *     {@link SoggettoFamiglia }
     *     
     */
    public SoggettoFamiglia getSoggettoFamiglia() {
        return soggettoFamiglia;
    }

    /**
     * Imposta il valore della proprietà soggettoFamiglia.
     * 
     * @param value
     *     allowed object is
     *     {@link SoggettoFamiglia }
     *     
     */
    public void setSoggettoFamiglia(SoggettoFamiglia value) {
        this.soggettoFamiglia = value;
    }

    /**
     * Recupera il valore della proprietà statoSoggetto.
     * 
     * @return
     *     possible object is
     *     {@link StatoSoggetto }
     *     
     */
    public StatoSoggetto getStatoSoggetto() {
        return statoSoggetto;
    }

    /**
     * Imposta il valore della proprietà statoSoggetto.
     * 
     * @param value
     *     allowed object is
     *     {@link StatoSoggetto }
     *     
     */
    public void setStatoSoggetto(StatoSoggetto value) {
        this.statoSoggetto = value;
    }

}
