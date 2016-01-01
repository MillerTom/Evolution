
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1ScrubRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1ScrubResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * <pre>
 * 
 * This extrinsic function strips control characters and 
 * leading/trailing spaces from a string.
 * 
 * </pre>
 * 
 * @author rcollins
 *
 */
@WebService(name = "XMXUTIL1Scrub", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUTIL1ScrubEndpoint {
   
    
    /**
     * <pre>
     * 
     * This RPC strips control characters and leading/trailing spaces 
     * from a string.  If there's an error, it returns an error message.
     * 
     * </pre>
     * 
     * @param request -
     * 
     *         Domain Object that contains All Scrub^XMXUTIL1 input
     *         Parameters
     * 
     * @return XMXUTIL1ScrubResponse -
     * 
     *         Domain Object that contains Scrub^XMXUTIL1 output data
     * 
     * @throws VistaWebServiceFault
     */
    @WebMethod(action = "XMXUTIL1ScrubAction", operationName = "XMXUTIL1Scrub")
    public XMXUTIL1ScrubResponse scrub(@WebParam(name = "XMXUTIL1ScrubRequest") XMXUTIL1ScrubRequest request) 
            throws VistaWebServiceFault;
}
