/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.did.endpoints.interfaces;

import gov.va.oit.vistaevolution.fileman.ws.did.model.DIDFieldRequest;
import gov.va.oit.vistaevolution.fileman.ws.did.model.DIDFieldResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@WebService(name = "DIDField", targetNamespace = "http://vistaevolution.va.gov")
public interface DIDFieldEndpoint {

	/**
	 * DD field Retriever: This function retrieves the values of the
	 * specified-level attributes for the specified field.
	 * 
	 * @param request
	 *            Populated request object for file web method.
	 * @throws VistaWebServiceFault 
	 */
	@WebMethod(action="DIDFieldAction" ,operationName="DIDField")
	@SOAPBinding(parameterStyle = ParameterStyle.BARE)
	public DIDFieldResponse field(
			@WebParam(name = "DIDFieldRequest") DIDFieldRequest request) throws VistaWebServiceFault;

}
