
package it.csi.iscritto.iscrittofosrv.integration.service.nao.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="dettaglioMinimoFamigliePerIDReturn" type="{urn:SrvVisuraFamiglia}DettaglioMinimoFamiglia" maxOccurs="unbounded" minOccurs="0"/>
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
    "dettaglioMinimoFamigliePerIDReturn"
})
@XmlRootElement(name = "dettaglioMinimoFamigliePerIDResponse")
public class DettaglioMinimoFamigliePerIDResponse {

    protected List<DettaglioMinimoFamiglia> dettaglioMinimoFamigliePerIDReturn;

    /**
     * Gets the value of the dettaglioMinimoFamigliePerIDReturn property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dettaglioMinimoFamigliePerIDReturn property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDettaglioMinimoFamigliePerIDReturn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DettaglioMinimoFamiglia }
     * 
     * 
     */
    public List<DettaglioMinimoFamiglia> getDettaglioMinimoFamigliePerIDReturn() {
        if (dettaglioMinimoFamigliePerIDReturn == null) {
            dettaglioMinimoFamigliePerIDReturn = new ArrayList<DettaglioMinimoFamiglia>();
        }
        return this.dettaglioMinimoFamigliePerIDReturn;
    }

}
