
package gov.va.oit.vistaevolution.kernel.ws.xusrb.endpoints.interfaces;

import gov.va.oit.vistaevolution.kernel.ws.xusrb.model.XUSRBSetupResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * <pre>
 * 
 * This API sets up a VistALink user's partition 
 * in M prior to signon.
 * 
 * </pre>
 * @author rcollins
 *
 */
@WebService(name = "XUSRBSetup", targetNamespace = "http://vistaevolution.va.gov")
public interface XUSRBSetupEndpoint {
    
    
    /**
     * <pre>
     * 
     * This API sets up a VistALink user's partition 
     * in M prior to signon.
     *  
     * </pre>      
     * 
     * @return XUSRBSetupResponse:
     * 
     *         Domain Object that contains Setup^XUSRB output data
     * 
     * @throws VistaWebServiceFault
     */
    @WebMethod(action = "XUSRBSetupAction", operationName = "XUSRBSetup")
    public XUSRBSetupResponse setup() throws VistaWebServiceFault;
}
