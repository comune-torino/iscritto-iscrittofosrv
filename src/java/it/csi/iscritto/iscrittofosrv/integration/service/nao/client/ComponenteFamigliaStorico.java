
package it.csi.iscritto.iscrittofosrv.integration.service.nao.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per ComponenteFamigliaStorico complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="ComponenteFamigliaStorico">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codiceIstatRapportoParentela" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descBreveRapportoParentela" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descRapportoParentela" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="generalitaSoggettoAllaData" type="{urn:SrvVisuraFamiglia}Generalita"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ComponenteFamigliaStorico", propOrder = {
    "codiceIstatRapportoParentela",
    "descBreveRapportoParentela",
    "descRapportoParentela",
    "generalitaSoggettoAllaData"
})
public class ComponenteFamigliaStorico {

    @XmlElement(required = true, nillable = true)
    protected String codiceIstatRapportoParentela;
    @XmlElement(required = true, nillable = true)
    protected String descBreveRapportoParentela;
    @XmlElement(required = true, nillable = true)
    protected String descRapportoParentela;
    @XmlElement(required = true, nillable = true)
    protected Generalita generalitaSoggettoAllaData;

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
     * Recupera il valore della proprietà generalitaSoggettoAllaData.
     * 
     * @return
     *     possible object is
     *     {@link Generalita }
     *     
     */
    public Generalita getGeneralitaSoggettoAllaData() {
        return generalitaSoggettoAllaData;
    }

    /**
     * Imposta il valore della proprietà generalitaSoggettoAllaData.
     * 
     * @param value
     *     allowed object is
     *     {@link Generalita }
     *     
     */
    public void setGeneralitaSoggettoAllaData(Generalita value) {
        this.generalitaSoggettoAllaData = value;
    }

}
