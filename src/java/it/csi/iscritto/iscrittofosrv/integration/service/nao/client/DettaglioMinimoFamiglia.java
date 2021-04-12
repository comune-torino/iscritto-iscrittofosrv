
package it.csi.iscritto.iscrittofosrv.integration.service.nao.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per DettaglioMinimoFamiglia complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="DettaglioMinimoFamiglia">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="componenti" type="{urn:SrvVisuraFamiglia}ArrayOfDettaglioMinimoSoggetto"/>
 *         &lt;element name="idFamiglia" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="indirizzoInterno" type="{urn:SrvVisuraFamiglia}IndirizzoInterno"/>
 *         &lt;element name="numeroFamiglia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DettaglioMinimoFamiglia", propOrder = {
    "componenti",
    "idFamiglia",
    "indirizzoInterno",
    "numeroFamiglia"
})
public class DettaglioMinimoFamiglia {

    @XmlElement(required = true, nillable = true)
    protected ArrayOfDettaglioMinimoSoggetto componenti;
    protected int idFamiglia;
    @XmlElement(required = true, nillable = true)
    protected IndirizzoInterno indirizzoInterno;
    @XmlElement(required = true, nillable = true)
    protected String numeroFamiglia;

    /**
     * Recupera il valore della proprietà componenti.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDettaglioMinimoSoggetto }
     *     
     */
    public ArrayOfDettaglioMinimoSoggetto getComponenti() {
        return componenti;
    }

    /**
     * Imposta il valore della proprietà componenti.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDettaglioMinimoSoggetto }
     *     
     */
    public void setComponenti(ArrayOfDettaglioMinimoSoggetto value) {
        this.componenti = value;
    }

    /**
     * Recupera il valore della proprietà idFamiglia.
     * 
     */
    public int getIdFamiglia() {
        return idFamiglia;
    }

    /**
     * Imposta il valore della proprietà idFamiglia.
     * 
     */
    public void setIdFamiglia(int value) {
        this.idFamiglia = value;
    }

    /**
     * Recupera il valore della proprietà indirizzoInterno.
     * 
     * @return
     *     possible object is
     *     {@link IndirizzoInterno }
     *     
     */
    public IndirizzoInterno getIndirizzoInterno() {
        return indirizzoInterno;
    }

    /**
     * Imposta il valore della proprietà indirizzoInterno.
     * 
     * @param value
     *     allowed object is
     *     {@link IndirizzoInterno }
     *     
     */
    public void setIndirizzoInterno(IndirizzoInterno value) {
        this.indirizzoInterno = value;
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

}
