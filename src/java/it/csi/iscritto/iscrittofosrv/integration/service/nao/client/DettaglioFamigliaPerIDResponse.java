
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
 *         &lt;element name="dettaglioFamigliaPerIDReturn" type="{urn:SrvVisuraFamiglia}DettaglioFamiglia" minOccurs="0"/>
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
    "dettaglioFamigliaPerIDReturn"
})
@XmlRootElement(name = "dettaglioFamigliaPerIDResponse")
public class DettaglioFamigliaPerIDResponse {

    protected DettaglioFamiglia dettaglioFamigliaPerIDReturn;

    /**
     * Recupera il valore della proprietà dettaglioFamigliaPerIDReturn.
     * 
     * @return
     *     possible object is
     *     {@link DettaglioFamiglia }
     *     
     */
    public DettaglioFamiglia getDettaglioFamigliaPerIDReturn() {
        return dettaglioFamigliaPerIDReturn;
    }

    /**
     * Imposta il valore della proprietà dettaglioFamigliaPerIDReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link DettaglioFamiglia }
     *     
     */
    public void setDettaglioFamigliaPerIDReturn(DettaglioFamiglia value) {
        this.dettaglioFamigliaPerIDReturn = value;
    }

}
