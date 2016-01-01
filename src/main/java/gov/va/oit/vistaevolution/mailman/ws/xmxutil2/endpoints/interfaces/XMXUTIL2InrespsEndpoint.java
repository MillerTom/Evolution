/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2InrespsRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2InrespsResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * <pre>
 * 
 * This API returns the number of responses to a message 
 * and the number of the last response that the user has read.
 * 
 * </pre>
 * @author rcollins
 *
 */
@WebService(name = "XMXUTIL2Inresps", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUTIL2InrespsEndpoint {
    
    
    /**
     * <pre>
     * 
     * This RPC returns the number of responses to a message and the 
     * number of the last response that the user has read.
     * 
     * </pre>
     * 
     * @param request -
     * 
     *         Domain Object that contains All Inresps^XMXUTIL2 input
     *         Parameters
     * 
     * @return XMXUTIL2InrespsResponse -
     * 
     *         Domain Object that contains Inresps^XMXUTIL2 output data
     * 
     * @throws VistaWebServiceFault
     */
    @WebMethod(action = "XMXUTIL2InrespsAction", operationName = "XMXUTIL2Inresps")
    public XMXUTIL2InrespsResponse inresps(@WebParam(name = "XMXUTIL2InrespsRequest")XMXUTIL2InrespsRequest request)
        throws VistaWebServiceFault;
    
}
