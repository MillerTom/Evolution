/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.interfaces;

import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDVfileRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDVfileResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

/**
 * <pre>
 * This extrinsic function verifies that a file exists.
 * </pre>
 * @author Christopher Schuck
 *
 */
@WebService(name = "DILFDVfile", targetNamespace = "http://vistaevolution.va.gov")
public interface DILFDVfileEndpoint {
	
    
    /**
     * <pre>
     * This api verifies that a file exists.
     * </pre> 
     * 
     * @param DILFDVfileRequest
     * 
     *            Domain Object that contains All Vfile^DILFD input
     *            Parameters
     * 
     * @return DILFDVfileResponse
     * 
     *         Domain Object that contains Vfile^DILFD output data
     * 
     * @throws VistaWebServiceFault
     */
    @WebMethod(action = "DILFDVfieldAction", operationName = "DILFDVfield")
	public DILFDVfileResponse vfile(@WebParam(name = "DILFDVfileRequest") DILFDVfileRequest request) 
	        throws VistaWebServiceFault;
}
