
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2Inmsg1Request;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2Inmsg1Response;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * <pre>
 * 
 * This API returns message information (Part 1).
 * 
 * </pre>
 * 
 * @author rcollins
 *
 */
@WebService(name = "XMXUTIL2Inmsg1", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUTIL2Inmsg1Endpoint {
    

    /**
     * <pre>
     * 
     * This RPC returns message information (Part 1).
     * 
     * </pre>
     * 
     * @param request -
     * 
     *         Domain Object that contains All Inmsg1^XMXUTIL2 input
     *         Parameters
     * 
     * @return XMXUTIL2Inmsg1Response -
     * 
     *         Domain Object that contains Inmsg1^XMXUTIL2 output data
     * 
     * @throws VistaWebServiceFault
     */
    @WebMethod(action = "XMXUTIL2Inmsg1Action", operationName = "XMXUTIL2Inmsg1")
    public XMXUTIL2Inmsg1Response inmsg1(@WebParam(name = "XMXUTIL2Inmsg1Request") XMXUTIL2Inmsg1Request request)
        throws VistaWebServiceFault;
}
