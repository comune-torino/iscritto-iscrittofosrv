
package it.csi.iscritto.iscrittofosrv.integration.service.nao.client;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.1
 * 
 */
@WebFault(name = "fault", targetNamespace = "urn:SrvVisuraFamiglia")
public class FormalException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private FormalException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public FormalException_Exception(String message, FormalException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public FormalException_Exception(String message, FormalException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: it.csi.iscritto.iscrittofosrv.integration.service.nao.client.FormalException
     */
    public FormalException getFaultInfo() {
        return faultInfo;
    }

}
