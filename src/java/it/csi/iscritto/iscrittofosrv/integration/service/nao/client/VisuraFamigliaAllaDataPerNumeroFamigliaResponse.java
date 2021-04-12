
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
 *         &lt;element name="visuraFamigliaAllaDataPerNumeroFamigliaReturn" type="{urn:SrvVisuraFamiglia}DettaglioFamigliaStorico" minOccurs="0"/>
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
    "visuraFamigliaAllaDataPerNumeroFamigliaReturn"
})
@XmlRootElement(name = "visuraFamigliaAllaDataPerNumeroFamigliaResponse")
public class VisuraFamigliaAllaDataPerNumeroFamigliaResponse {

    protected DettaglioFamigliaStorico visuraFamigliaAllaDataPerNumeroFamigliaReturn;

    /**
     * Recupera il valore della proprietà visuraFamigliaAllaDataPerNumeroFamigliaReturn.
     * 
     * @return
     *     possible object is
     *     {@link DettaglioFamigliaStorico }
     *     
     */
    public DettaglioFamigliaStorico getVisuraFamigliaAllaDataPerNumeroFamigliaReturn() {
        return visuraFamigliaAllaDataPerNumeroFamigliaReturn;
    }

    /**
     * Imposta il valore della proprietà visuraFamigliaAllaDataPerNumeroFamigliaReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link DettaglioFamigliaStorico }
     *     
     */
    public void setVisuraFamigliaAllaDataPerNumeroFamigliaReturn(DettaglioFamigliaStorico value) {
        this.visuraFamigliaAllaDataPerNumeroFamigliaReturn = value;
    }

}
