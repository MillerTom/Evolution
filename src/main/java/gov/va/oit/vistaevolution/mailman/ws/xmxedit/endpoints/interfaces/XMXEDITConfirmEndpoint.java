
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITConfirmRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITConfirmResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * <pre>
 * This API toggles the message's "Confirm Receipt Requested" 
 * flag. It does not set XMERR and ^TMP("XMERR",$J).
 * </pre>
 * 
 * @author rcollins
 *
 */
@WebService(name = "XMXEDITConfirm", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXEDITConfirmEndpoint { 
    
    /**
     * <pre>
     * This RPC returns a value indicating whether a message is 
     * "Confirm Receipt Requested" or not (0 = No; 1 = Yes).
     * </pre>
     * 
     * @param request
     * 
     *        Domain Object that contains All Confirm^XMXEDIT input Parameters
     * 
     * @return XMXEDITConfirmResponse
     * 
     *         Domain Object that contains Confirm^XMXEDIT output data
     * 
     * @throws VistaWebServiceFault
     */
    @WebMethod(action = "XMXEDITConfirmAction", operationName = "XMXEDITConfirm")
    public XMXEDITConfirmResponse confirm(@WebParam(name = "XMXEDITConfirmRequest") XMXEDITConfirmRequest request) 
            throws VistaWebServiceFault;
}
