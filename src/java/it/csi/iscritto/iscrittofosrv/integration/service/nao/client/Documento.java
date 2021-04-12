
package it.csi.iscritto.iscrittofosrv.integration.service.nao.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per Documento complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="Documento">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codice" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dataCessazione" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dataRilascio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idStato" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="stato" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Documento", propOrder = {
    "codice",
    "dataCessazione",
    "dataRilascio",
    "idStato",
    "stato"
})
@XmlSeeAlso({
    CodiceFiscale.class
})
public class Documento {

    @XmlElement(required = true, nillable = true)
    protected String codice;
    @XmlElement(required = true, nillable = true)
    protected String dataCessazione;
    @XmlElement(required = true, nillable = true)
    protected String dataRilascio;
    protected int idStato;
    @XmlElement(required = true, nillable = true)
    protected String stato;

    /**
     * Recupera il valore della proprietà codice.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodice() {
        return codice;
    }

    /**
     * Imposta il valore della proprietà codice.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodice(String value) {
        this.codice = value;
    }

    /**
     * Recupera il valore della proprietà dataCessazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataCessazione() {
        return dataCessazione;
    }

    /**
     * Imposta il valore della proprietà dataCessazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataCessazione(String value) {
        this.dataCessazione = value;
    }

    /**
     * Recupera il valore della proprietà dataRilascio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataRilascio() {
        return dataRilascio;
    }

    /**
     * Imposta il valore della proprietà dataRilascio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataRilascio(String value) {
        this.dataRilascio = value;
    }

    /**
     * Recupera il valore della proprietà idStato.
     * 
     */
    public int getIdStato() {
        return idStato;
    }

    /**
     * Imposta il valore della proprietà idStato.
     * 
     */
    public void setIdStato(int value) {
        this.idStato = value;
    }

    /**
     * Recupera il valore della proprietà stato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStato() {
        return stato;
    }

    /**
     * Imposta il valore della proprietà stato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStato(String value) {
        this.stato = value;
    }

}
