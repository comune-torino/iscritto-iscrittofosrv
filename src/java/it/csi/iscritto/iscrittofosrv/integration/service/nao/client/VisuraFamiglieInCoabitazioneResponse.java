
package it.csi.iscritto.iscrittofosrv.integration.service.nao.client;

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
 *         &lt;element name="visuraFamiglieInCoabitazioneReturn" type="{http://xml.apache.org/xml-soap}Vector" minOccurs="0"/>
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
    "visuraFamiglieInCoabitazioneReturn"
})
@XmlRootElement(name = "visuraFamiglieInCoabitazioneResponse")
public class VisuraFamiglieInCoabitazioneResponse {

    protected Vector visuraFamiglieInCoabitazioneReturn;

    /**
     * Recupera il valore della proprietà visuraFamiglieInCoabitazioneReturn.
     * 
     * @return
     *     possible object is
     *     {@link Vector }
     *     
     */
    public Vector getVisuraFamiglieInCoabitazioneReturn() {
        return visuraFamiglieInCoabitazioneReturn;
    }

    /**
     * Imposta il valore della proprietà visuraFamiglieInCoabitazioneReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link Vector }
     *     
     */
    public void setVisuraFamiglieInCoabitazioneReturn(Vector value) {
        this.visuraFamiglieInCoabitazioneReturn = value;
    }

}
