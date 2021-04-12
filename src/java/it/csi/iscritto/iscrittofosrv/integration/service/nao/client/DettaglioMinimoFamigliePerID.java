
package it.csi.iscritto.iscrittofosrv.integration.service.nao.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per anonymous complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="in0" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="in1" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="in2" type="{urn:SrvVisuraFamiglia}DatiProfilati" minOccurs="0"/>
 *         &lt;element name="in3" type="{urn:SrvVisuraFamiglia}UtenteServizio" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "in0",
    "in1",
    "in2",
    "in3"
})
@XmlRootElement(name = "dettaglioMinimoFamigliePerID")
public class DettaglioMinimoFamigliePerID {

    @XmlElement(type = Integer.class)
    protected List<Integer> in0;
    protected boolean in1;
    protected DatiProfilati in2;
    protected UtenteServizio in3;

    /**
     * Gets the value of the in0 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the in0 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIn0().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getIn0() {
        if (in0 == null) {
            in0 = new ArrayList<Integer>();
        }
        return this.in0;
    }

    /**
     * Recupera il valore della proprietà in1.
     * 
     */
    public boolean isIn1() {
        return in1;
    }

    /**
     * Imposta il valore della proprietà in1.
     * 
     */
    public void setIn1(boolean value) {
        this.in1 = value;
    }

    /**
     * Recupera il valore della proprietà in2.
     * 
     * @return
     *     possible object is
     *     {@link DatiProfilati }
     *     
     */
    public DatiProfilati getIn2() {
        return in2;
    }

    /**
     * Imposta il valore della proprietà in2.
     * 
     * @param value
     *     allowed object is
     *     {@link DatiProfilati }
     *     
     */
    public void setIn2(DatiProfilati value) {
        this.in2 = value;
    }

    /**
     * Recupera il valore della proprietà in3.
     * 
     * @return
     *     possible object is
     *     {@link UtenteServizio }
     *     
     */
    public UtenteServizio getIn3() {
        return in3;
    }

    /**
     * Imposta il valore della proprietà in3.
     * 
     * @param value
     *     allowed object is
     *     {@link UtenteServizio }
     *     
     */
    public void setIn3(UtenteServizio value) {
        this.in3 = value;
    }

}
