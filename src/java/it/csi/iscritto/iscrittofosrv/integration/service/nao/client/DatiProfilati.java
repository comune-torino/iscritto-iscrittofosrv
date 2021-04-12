
package it.csi.iscritto.iscrittofosrv.integration.service.nao.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per DatiProfilati complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="DatiProfilati">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="flgPaternitaMaternita" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="flgProtocolliRiservatiE" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="flgProtocolliRiservatiQ" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="flgRettificheGeneralita" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="flgSoggettiCancellati" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatiProfilati", propOrder = {
    "flgPaternitaMaternita",
    "flgProtocolliRiservatiE",
    "flgProtocolliRiservatiQ",
    "flgRettificheGeneralita",
    "flgSoggettiCancellati"
})
public class DatiProfilati {

    protected boolean flgPaternitaMaternita;
    protected boolean flgProtocolliRiservatiE;
    protected boolean flgProtocolliRiservatiQ;
    protected boolean flgRettificheGeneralita;
    protected boolean flgSoggettiCancellati;

    /**
     * Recupera il valore della proprietà flgPaternitaMaternita.
     * 
     */
    public boolean isFlgPaternitaMaternita() {
        return flgPaternitaMaternita;
    }

    /**
     * Imposta il valore della proprietà flgPaternitaMaternita.
     * 
     */
    public void setFlgPaternitaMaternita(boolean value) {
        this.flgPaternitaMaternita = value;
    }

    /**
     * Recupera il valore della proprietà flgProtocolliRiservatiE.
     * 
     */
    public boolean isFlgProtocolliRiservatiE() {
        return flgProtocolliRiservatiE;
    }

    /**
     * Imposta il valore della proprietà flgProtocolliRiservatiE.
     * 
     */
    public void setFlgProtocolliRiservatiE(boolean value) {
        this.flgProtocolliRiservatiE = value;
    }

    /**
     * Recupera il valore della proprietà flgProtocolliRiservatiQ.
     * 
     */
    public boolean isFlgProtocolliRiservatiQ() {
        return flgProtocolliRiservatiQ;
    }

    /**
     * Imposta il valore della proprietà flgProtocolliRiservatiQ.
     * 
     */
    public void setFlgProtocolliRiservatiQ(boolean value) {
        this.flgProtocolliRiservatiQ = value;
    }

    /**
     * Recupera il valore della proprietà flgRettificheGeneralita.
     * 
     */
    public boolean isFlgRettificheGeneralita() {
        return flgRettificheGeneralita;
    }

    /**
     * Imposta il valore della proprietà flgRettificheGeneralita.
     * 
     */
    public void setFlgRettificheGeneralita(boolean value) {
        this.flgRettificheGeneralita = value;
    }

    /**
     * Recupera il valore della proprietà flgSoggettiCancellati.
     * 
     */
    public boolean isFlgSoggettiCancellati() {
        return flgSoggettiCancellati;
    }

    /**
     * Imposta il valore della proprietà flgSoggettiCancellati.
     * 
     */
    public void setFlgSoggettiCancellati(boolean value) {
        this.flgSoggettiCancellati = value;
    }

}
