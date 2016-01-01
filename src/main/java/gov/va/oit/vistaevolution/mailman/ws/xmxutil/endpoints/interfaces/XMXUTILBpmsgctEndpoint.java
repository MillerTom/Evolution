
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILBpmsgctRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILBpmsgctResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * <pre>
 * This extrinsic function returns the number of new priority 
 * messages in a user's basket.
 * </pre>
 * 
 * @author rcollins
 *
 */
@WebService(name = "XMXUTILBpmsgct", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUTILBpmsgctEndpoint {    
    
    /**
     * <pre>
     * This RPC returns the number of new priority messages in a 
     * user's basket. If there's an error, it returns an error 
     * message.
     * </pre>
     * 
     * @param request -
     * 
     *         Domain Object that contains All Bpmsgct^XMXUTIL input
     *         Parameters
     * 
     * @return XMXUTILBpmsgctResponse -
     * 
     *         Domain Object that contains Bpmsgct^XMXUTIL output data
     * 
     * @throws VistaWebServiceFault
     */
    @WebMethod(action = "XMXUTILBpmsgctAction", operationName = "XMXUTILBpmsgct")
    public XMXUTILBpmsgctResponse bpmsgct(@WebParam(name = "XMXUTILBpmsgctRequest")XMXUTILBpmsgctRequest request) 
            throws VistaWebServiceFault;
}
