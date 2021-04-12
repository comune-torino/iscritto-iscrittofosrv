
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
 *         &lt;element name="dettaglioFamigliaPerNumeroFamigliaReturn" type="{urn:SrvVisuraFamiglia}DettaglioFamiglia" minOccurs="0"/>
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
    "dettaglioFamigliaPerNumeroFamigliaReturn"
})
@XmlRootElement(name = "dettaglioFamigliaPerNumeroFamigliaResponse")
public class DettaglioFamigliaPerNumeroFamigliaResponse {

    protected DettaglioFamiglia dettaglioFamigliaPerNumeroFamigliaReturn;

    /**
     * Recupera il valore della proprietà dettaglioFamigliaPerNumeroFamigliaReturn.
     * 
     * @return
     *     possible object is
     *     {@link DettaglioFamiglia }
     *     
     */
    public DettaglioFamiglia getDettaglioFamigliaPerNumeroFamigliaReturn() {
        return dettaglioFamigliaPerNumeroFamigliaReturn;
    }

    /**
     * Imposta il valore della proprietà dettaglioFamigliaPerNumeroFamigliaReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link DettaglioFamiglia }
     *     
     */
    public void setDettaglioFamigliaPerNumeroFamigliaReturn(DettaglioFamiglia value) {
        this.dettaglioFamigliaPerNumeroFamigliaReturn = value;
    }

}
