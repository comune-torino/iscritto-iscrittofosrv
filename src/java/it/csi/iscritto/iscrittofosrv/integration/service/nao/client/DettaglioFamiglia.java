
package it.csi.iscritto.iscrittofosrv.integration.service.nao.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per DettaglioFamiglia complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="DettaglioFamiglia">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:SrvVisuraFamiglia}TestataFamiglia">
 *       &lt;sequence>
 *         &lt;element name="componentiFamiglia" type="{http://xml.apache.org/xml-soap}Vector"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DettaglioFamiglia", propOrder = {
    "componentiFamiglia"
})
public class DettaglioFamiglia
    extends TestataFamiglia
{

    @XmlElement(required = true, nillable = true)
    protected Vector componentiFamiglia;

    /**
     * Recupera il valore della proprietà componentiFamiglia.
     * 
     * @return
     *     possible object is
     *     {@link Vector }
     *     
     */
    public Vector getComponentiFamiglia() {
        return componentiFamiglia;
    }

    /**
     * Imposta il valore della proprietà componentiFamiglia.
     * 
     * @param value
     *     allowed object is
     *     {@link Vector }
     *     
     */
    public void setComponentiFamiglia(Vector value) {
        this.componentiFamiglia = value;
    }

}
