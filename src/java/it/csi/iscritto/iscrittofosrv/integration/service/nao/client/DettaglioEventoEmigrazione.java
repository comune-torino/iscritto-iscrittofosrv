
package it.csi.iscritto.iscrittofosrv.integration.service.nao.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per DettaglioEventoEmigrazione complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="DettaglioEventoEmigrazione">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:SrvVisuraFamiglia}EventoEmigrazione">
 *       &lt;sequence>
 *         &lt;element name="pratica" type="{urn:SrvVisuraFamiglia}PraticaEmigrazione"/>
 *         &lt;element name="statoCivileAllEmigrazione" type="{urn:SrvVisuraFamiglia}StatoCivile"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DettaglioEventoEmigrazione", propOrder = {
    "pratica",
    "statoCivileAllEmigrazione"
})
public class DettaglioEventoEmigrazione
    extends EventoEmigrazione
{

    @XmlElement(required = true, nillable = true)
    protected PraticaEmigrazione pratica;
    @XmlElement(required = true, nillable = true)
    protected StatoCivile statoCivileAllEmigrazione;

    /**
     * Recupera il valore della proprietà pratica.
     * 
     * @return
     *     possible object is
     *     {@link PraticaEmigrazione }
     *     
     */
    public PraticaEmigrazione getPratica() {
        return pratica;
    }

    /**
     * Imposta il valore della proprietà pratica.
     * 
     * @param value
     *     allowed object is
     *     {@link PraticaEmigrazione }
     *     
     */
    public void setPratica(PraticaEmigrazione value) {
        this.pratica = value;
    }

    /**
     * Recupera il valore della proprietà statoCivileAllEmigrazione.
     * 
     * @return
     *     possible object is
     *     {@link StatoCivile }
     *     
     */
    public StatoCivile getStatoCivileAllEmigrazione() {
        return statoCivileAllEmigrazione;
    }

    /**
     * Imposta il valore della proprietà statoCivileAllEmigrazione.
     * 
     * @param value
     *     allowed object is
     *     {@link StatoCivile }
     *     
     */
    public void setStatoCivileAllEmigrazione(StatoCivile value) {
        this.statoCivileAllEmigrazione = value;
    }

}
