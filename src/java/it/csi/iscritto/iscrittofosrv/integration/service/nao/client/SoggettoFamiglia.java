
package it.csi.iscritto.iscrittofosrv.integration.service.nao.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per SoggettoFamiglia complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="SoggettoFamiglia">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codiceIstatRapportoParentela" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dataIngressoInFamiglia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dataUscitaDaFamiglia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descBreveRapportoParentela" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descRapportoParentela" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="numeroFamiglia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tipoMovimentazione" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SoggettoFamiglia", propOrder = {
    "codiceIstatRapportoParentela",
    "dataIngressoInFamiglia",
    "dataUscitaDaFamiglia",
    "descBreveRapportoParentela",
    "descRapportoParentela",
    "numeroFamiglia",
    "tipoMovimentazione"
})
public class SoggettoFamiglia {

    @XmlElement(required = true, nillable = true)
    protected String codiceIstatRapportoParentela;
    @XmlElement(required = true, nillable = true)
    protected String dataIngressoInFamiglia;
    @XmlElement(required = true, nillable = true)
    protected String dataUscitaDaFamiglia;
    @XmlElement(required = true, nillable = true)
    protected String descBreveRapportoParentela;
    @XmlElement(required = true, nillable = true)
    protected String descRapportoParentela;
    @XmlElement(required = true, nillable = true)
    protected String numeroFamiglia;
    @XmlElement(required = true, nillable = true)
    protected String tipoMovimentazione;

    /**
     * Recupera il valore della proprietà codiceIstatRapportoParentela.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceIstatRapportoParentela() {
        return codiceIstatRapportoParentela;
    }

    /**
     * Imposta il valore della proprietà codiceIstatRapportoParentela.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceIstatRapportoParentela(String value) {
        this.codiceIstatRapportoParentela = value;
    }

    /**
     * Recupera il valore della proprietà dataIngressoInFamiglia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataIngressoInFamiglia() {
        return dataIngressoInFamiglia;
    }

    /**
     * Imposta il valore della proprietà dataIngressoInFamiglia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataIngressoInFamiglia(String value) {
        this.dataIngressoInFamiglia = value;
    }

    /**
     * Recupera il valore della proprietà dataUscitaDaFamiglia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataUscitaDaFamiglia() {
        return dataUscitaDaFamiglia;
    }

    /**
     * Imposta il valore della proprietà dataUscitaDaFamiglia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataUscitaDaFamiglia(String value) {
        this.dataUscitaDaFamiglia = value;
    }

    /**
     * Recupera il valore della proprietà descBreveRapportoParentela.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescBreveRapportoParentela() {
        return descBreveRapportoParentela;
    }

    /**
     * Imposta il valore della proprietà descBreveRapportoParentela.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescBreveRapportoParentela(String value) {
        this.descBreveRapportoParentela = value;
    }

    /**
     * Recupera il valore della proprietà descRapportoParentela.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescRapportoParentela() {
        return descRapportoParentela;
    }

    /**
     * Imposta il valore della proprietà descRapportoParentela.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescRapportoParentela(String value) {
        this.descRapportoParentela = value;
    }

    /**
     * Recupera il valore della proprietà numeroFamiglia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroFamiglia() {
        return numeroFamiglia;
    }

    /**
     * Imposta il valore della proprietà numeroFamiglia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroFamiglia(String value) {
        this.numeroFamiglia = value;
    }

    /**
     * Recupera il valore della proprietà tipoMovimentazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoMovimentazione() {
        return tipoMovimentazione;
    }

    /**
     * Imposta il valore della proprietà tipoMovimentazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoMovimentazione(String value) {
        this.tipoMovimentazione = value;
    }

}
