
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
 *         &lt;element name="visuraFamigliaAllaDataPerIdSoggettoReturn" type="{urn:SrvVisuraFamiglia}DettaglioFamigliaStorico" minOccurs="0"/>
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
    "visuraFamigliaAllaDataPerIdSoggettoReturn"
})
@XmlRootElement(name = "visuraFamigliaAllaDataPerIdSoggettoResponse")
public class VisuraFamigliaAllaDataPerIdSoggettoResponse {

    protected DettaglioFamigliaStorico visuraFamigliaAllaDataPerIdSoggettoReturn;

    /**
     * Recupera il valore della proprietà visuraFamigliaAllaDataPerIdSoggettoReturn.
     * 
     * @return
     *     possible object is
     *     {@link DettaglioFamigliaStorico }
     *     
     */
    public DettaglioFamigliaStorico getVisuraFamigliaAllaDataPerIdSoggettoReturn() {
        return visuraFamigliaAllaDataPerIdSoggettoReturn;
    }

    /**
     * Imposta il valore della proprietà visuraFamigliaAllaDataPerIdSoggettoReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link DettaglioFamigliaStorico }
     *     
     */
    public void setVisuraFamigliaAllaDataPerIdSoggettoReturn(DettaglioFamigliaStorico value) {
        this.visuraFamigliaAllaDataPerIdSoggettoReturn = value;
    }

}
