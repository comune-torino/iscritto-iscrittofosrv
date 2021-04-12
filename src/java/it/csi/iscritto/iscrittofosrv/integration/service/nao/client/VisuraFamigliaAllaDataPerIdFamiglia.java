
package it.csi.iscritto.iscrittofosrv.integration.service.nao.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="in0" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="in1" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
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
@XmlRootElement(name = "visuraFamigliaAllaDataPerIdFamiglia")
public class VisuraFamigliaAllaDataPerIdFamiglia {

    protected int in0;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar in1;
    protected DatiProfilati in2;
    protected UtenteServizio in3;

    /**
     * Recupera il valore della proprietà in0.
     * 
     */
    public int getIn0() {
        return in0;
    }

    /**
     * Imposta il valore della proprietà in0.
     * 
     */
    public void setIn0(int value) {
        this.in0 = value;
    }

    /**
     * Recupera il valore della proprietà in1.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getIn1() {
        return in1;
    }

    /**
     * Imposta il valore della proprietà in1.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setIn1(XMLGregorianCalendar value) {
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
