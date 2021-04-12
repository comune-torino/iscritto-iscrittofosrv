
package it.csi.iscritto.iscrittofosrv.integration.service.nao.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per PraticaEmigrazione complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="PraticaEmigrazione">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:SrvVisuraFamiglia}PraticaAnagrafe">
 *       &lt;sequence>
 *         &lt;element name="flagRichiestaAccertamento" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PraticaEmigrazione", propOrder = {
    "flagRichiestaAccertamento"
})
public class PraticaEmigrazione
    extends PraticaAnagrafe
{

    protected boolean flagRichiestaAccertamento;

    /**
     * Recupera il valore della proprietà flagRichiestaAccertamento.
     * 
     */
    public boolean isFlagRichiestaAccertamento() {
        return flagRichiestaAccertamento;
    }

    /**
     * Imposta il valore della proprietà flagRichiestaAccertamento.
     * 
     */
    public void setFlagRichiestaAccertamento(boolean value) {
        this.flagRichiestaAccertamento = value;
    }

}
