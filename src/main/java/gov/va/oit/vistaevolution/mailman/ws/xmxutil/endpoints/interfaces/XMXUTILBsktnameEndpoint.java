/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILBsktnameRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILBsktnameResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * <pre>
 * This extrinsic function returns the name of a user's basket.
 * </pre>
 * @author rcollins
 *
 */
@WebService(name = "XMXUTILBsktname", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUTILBsktnameEndpoint {
    
    
    /**
     * <pre>
     * This API returns the name of a user's basket.
     * </pre>
     * 
     * @param request -
     * 
     *         Domain Object that contains All Bsktname^XMXUTIL input
     *         Parameters
     * 
     * @return XMXUTILBsktnameResponse -
     * 
     *         Domain Object that contains Bsktname^XMXUTIL output data
     * 
     * @throws VistaWebServiceFault
     */
    @WebMethod(action = "XMXUTILBsktnameAction", operationName = "XMXUTILBsktname")
    public XMXUTILBsktnameResponse bsktname (@WebParam(name = "XMXUTILBsktnameRequest") XMXUTILBsktnameRequest request)
            throws VistaWebServiceFault;
    
}
