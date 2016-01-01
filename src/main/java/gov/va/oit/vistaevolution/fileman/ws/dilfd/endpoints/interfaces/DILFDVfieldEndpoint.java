
package gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.interfaces;

import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDVfieldRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDVfieldResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

/**
 * <pre>
 * This extrinsic function verifies that a field in a 
 * specified file exists.
 * </pre>
 *  
 * @author Christopher Schuck
 *
 */
@WebService(name = "DILFDVfield", targetNamespace = "http://vistaevolution.va.gov")
public interface DILFDVfieldEndpoint {	
    
    /**
     * <pre>
     * This API verifies that a field in a specified file exists.
     * </pre> 
     * 
     * @param DILFDVfieldRequest
     * 
     *            Domain Object that contains All Vfield^DILFD input
     *            Parameters
     * 
     * @return DILFDVfieldResponse
     * 
     *         Domain Object that contains Vfield^DILFD output data
     * 
     * @throws VistaWebServiceFault
     */
    @WebMethod(action = "DILFDVfieldAction", operationName = "DILFDVfield")
	public DILFDVfieldResponse vfield(@WebParam(name = "DILFDVfieldRequest") DILFDVfieldRequest request)
                throws VistaWebServiceFault;
}
