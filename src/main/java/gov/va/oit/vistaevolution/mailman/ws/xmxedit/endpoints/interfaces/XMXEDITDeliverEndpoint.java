/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITDeliverRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITDeliverResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * <pre>
 * This API sets/deletes the message delivery basket for all users. It does 
 * not set XMERR and ^TMP("XMERR",$J).
 * </pre>
 * @author rcollins
 *
 */
@WebService(name = "XMXEDITDeliver", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXEDITDeliverEndpoint {
    

    /**
     * <pre>
     * 
     * This RPC sets/deletes the message delivery basket for all users.  
     * If an error occurs then an error message is returned.
     * 
     * </pre>
     * 
     * @param request
     * 
     *        Domain Object that contains All Deliver^XMXEDIT input Parameters
     * 
     * @return XMXEDITDeliverResponse
     * 
     *         Domain Object that contains Deliver^XMXEDIT output data
     * 
     * @throws VistaWebServiceFault
     */
    @WebMethod(action = "XMXEDITDeliverAction", operationName = "XMXEDITDeliver")
    public XMXEDITDeliverResponse deliver(@WebParam(name = "XMXEDITDeliverRequest") XMXEDITDeliverRequest request)
        throws VistaWebServiceFault;
}
