/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1TimeDiffRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1TimeDiffResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * <pre>
 * 
 * This extrinsic function returns +-hhmm when given the decimal 
 * time difference (between time zones).
 * 
 * </pre>
 * 
 * @author rcollins
 *
 */
@WebService(name = "XMXUTIL1TimeDiff", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUTIL1TimeDiffEndpoint {    
    
    /**
     * <pre>
     * 
     * This RPC returns +-hhmm when given the decimal time difference 
     * (between time zones).  If there's an error, it returns an error 
     * message.
     * 
     * </pre>
     * 
     * @param request -
     * 
     *         Domain Object that contains All TimeDiff^XMXUTIL1 input
     *         Parameters
     * 
     * @return XMXUTIL1TimeDiffResponse -
     * 
     *         Domain Object that contains TimeDiff^XMXUTIL1 output data
     * 
     * @throws VistaWebServiceFault
     */
    @WebMethod(action = "XMXUTIL1TimeDiffAction", operationName = "XMXUTIL1TimeDiff")
    public XMXUTIL1TimeDiffResponse timediff(@WebParam(name = "XMXUTIL1TimeDiffRequest") XMXUTIL1TimeDiffRequest request)
        throws VistaWebServiceFault;        
    
}
