/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2Inmsg2Request;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2Inmsg2Response;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * <pre>
 * 
 * This API returns message information (Part 2).
 * 
 * </pre>
 * 
 * @author rcollins
 *
 */
@WebService(name = "XMXUTIL2Inmsg2", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUTIL2Inmsg2Endpoint {
    
    
    
    /**
     * <pre>
     * 
     * This RPC returns message information (Part 2).
     * 
     * </pre>
     * 
     * @param request -
     * 
     *         Domain Object that contains All Inmsg2^XMXUTIL2 input
     *         Parameters
     * 
     * @return XMXUTIL2Inmsg2Response -
     * 
     *         Domain Object that contains Inmsg2^XMXUTIL2 output data
     * 
     * @throws VistaWebServiceFault
     */
    @WebMethod(action = "XMXUTIL2Inmsg2Action", operationName = "XMXUTIL2Inmsg2")
    public XMXUTIL2Inmsg2Response inmsg2(@WebParam(name = "XMXUTIL2Inmsg2Request") XMXUTIL2Inmsg2Request request)
        throws VistaWebServiceFault;
}
