package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2RespRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2RespResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * <pre>
 * 
 * This extrinsic function returns the number of responses 
 * to a message.
 * 
 * </pre>
 * 
 * @author rcollins
 *
 */
@WebService(name = "XMXUTIL2Resp", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUTIL2RespEndpoint {
    
    /**
     * <pre>
     * 
     * This RPC returns the number of responses to a message.  
     * If there's an error, it returns an error message.
     * 
     * </pre>
     * 
     * @param request -
     * 
     *         Domain Object that contains All Resp^XMXUTIL2 input
     *         Parameters
     * 
     * @return XMXUTIL2RespResponse -
     * 
     *         Domain Object that contains Resp^XMXUTIL2 output data
     * 
     * @throws VistaWebServiceFault
     */
    @WebMethod(action = "XMXUTIL2RespAction", operationName = "XMXUTIL2Resp")
    public XMXUTIL2RespResponse resp(@WebParam(name = "XMXUTIL2RespRequest") XMXUTIL2RespRequest request)
        throws VistaWebServiceFault;
}
