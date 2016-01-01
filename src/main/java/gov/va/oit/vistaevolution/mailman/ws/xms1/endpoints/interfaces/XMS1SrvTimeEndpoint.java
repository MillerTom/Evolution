/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xms1.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xms1.model.XMS1SrvTimeRequest;
import gov.va.oit.vistaevolution.mailman.ws.xms1.model.XMS1SrvTimeResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * <pre>
 * 
 * This extrinsic function sets the LAST READ DATE/TIME field 
 * (#2) and STATUS field (#5) of a (server) message recipient 
 * in the RECIPIENT Multiple field of a message in the MESSAGE 
 * file (#3.9). Field #2 is set to the current date/time. Field 
 * #5 is set to the STATUS parameter.
 * 
 * </pre>
 * 
 * @author rcollins
 *
 */
@WebService(name = "XMS1SrvTime", targetNamespace = "http://vistaevolution.va.gov")
public interface XMS1SrvTimeEndpoint {
    
    
    /**
     * <pre>
     * 
     *  This RPC sets the LAST READ DATE/TIME field (#2)
     *  (#2):MESSAGE File (#3.9) and STATUS field (#5) (#5):MESSAGE File (#3.9) of
     *  a (server) message recipient in the RECIPIENT Multiple field of a message
     *  in the MESSAGE file (#3.9). Field #2 is set to the current date/time.
     *  Field #5 is set to the STATUS parameter
     *  
     *   Returns:
     *     0 if no error
     *     -1^[error text]
     * 
     * </pre>
     * 
     * @param request
     * 
     *              Domain Object that contains All SrvTime^XMS1 input Parameters
     * 
     * @return XMS1SrvTimeResponse
     * 
     *              Domain Object that contains SrvTime^XMS1 output data
     * 
     * @throws VistaWebServiceFault
     */
    @WebMethod(action = "XMS1SrvTimeAction", operationName = "XMS1SrvTime")
    public XMS1SrvTimeResponse srvtime(@WebParam(name = "XMS1SrvTimeRequest") XMS1SrvTimeRequest request)
        throws VistaWebServiceFault;
        
    
}
