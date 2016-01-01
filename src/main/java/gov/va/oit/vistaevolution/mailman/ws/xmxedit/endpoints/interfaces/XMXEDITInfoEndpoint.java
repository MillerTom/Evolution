/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITInfoRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITInfoResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * <pre>
 * 
 * This API toggles the message's "Information Only" flag. It does 
 * not set XMERR and ^TMP("XMERR",$J).
 * 
 * </pre>
 * 
 * @author rcollins
 *
 */
@WebService(name = "XMXEDITInfo", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXEDITInfoEndpoint {
 
    
    /**
     * <pre>
     * 
     * This RPC toggles the message's "Information Only" flag.
     * 
     * </pre>
     * 
     * @param request
     * 
     *        Domain Object that contains All Info^XMXEDIT input Parameters
     * 
     * @return XMXEDITInfoResponse
     * 
     *         Domain Object that contains Info^XMXEDIT output data
     * 
     * @throws VistaWebServiceFault
     */
    @WebMethod(action = "XMXEDITInfoAction", operationName = "XMXEDITInfo")
    public XMXEDITInfoResponse info(@WebParam(name = "XMXEDITInfoRequest") XMXEDITInfoRequest request)
        throws VistaWebServiceFault;
}
