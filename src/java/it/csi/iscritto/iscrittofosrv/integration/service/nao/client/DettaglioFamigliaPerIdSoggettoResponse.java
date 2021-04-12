
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
 *         &lt;element name="dettaglioFamigliaPerIdSoggettoReturn" type="{urn:SrvVisuraFamiglia}DettaglioFamiglia" minOccurs="0"/>
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
    "dettaglioFamigliaPerIdSoggettoReturn"
})
@XmlRootElement(name = "dettaglioFamigliaPerIdSoggettoResponse")
public class DettaglioFamigliaPerIdSoggettoResponse {

    protected DettaglioFamiglia dettaglioFamigliaPerIdSoggettoReturn;

    /**
     * Recupera il valore della proprietà dettaglioFamigliaPerIdSoggettoReturn.
     * 
     * @return
     *     possible object is
     *     {@link DettaglioFamiglia }
     *     
     */
    public DettaglioFamiglia getDettaglioFamigliaPerIdSoggettoReturn() {
        return dettaglioFamigliaPerIdSoggettoReturn;
    }

    /**
     * Imposta il valore della proprietà dettaglioFamigliaPerIdSoggettoReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link DettaglioFamiglia }
     *     
     */
    public void setDettaglioFamigliaPerIdSoggettoReturn(DettaglioFamiglia value) {
        this.dettaglioFamigliaPerIdSoggettoReturn = value;
    }

}
