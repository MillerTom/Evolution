
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITClosedRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITClosedResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * <pre>
 * This API toggles the message's "Closed" flag. It sets XMERR 
 * and ^TMP("XMERR",$J), if an error occurs.
 * </pre>
 * 
 * @author rcollins
 *
 */
@WebService(name = "XMXEDITClosed", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXEDITClosedEndpoint {
    
    
    /**
     * <pre>
     * This RPC toggles the message's "Closed" flag.
     * </pre>
     * 
     * @param request
     * 
     *        Domain Object that contains All CLOSED^XMXEDIT input Parameters
     * 
     * @return XMXEDITClosedResponse
     * 
     *         Domain Object that contains CLOSED^XMXEDIT output data
     * 
     * @throws VistaWebServiceFault
     */
    @WebMethod(action = "XMXEDITClosedAction", operationName = "XMXEDITClosed")
    public XMXEDITClosedResponse closed(@WebParam(name = "XMXEDITClosedRequest") XMXEDITClosedRequest request) 
            throws VistaWebServiceFault ;
}
