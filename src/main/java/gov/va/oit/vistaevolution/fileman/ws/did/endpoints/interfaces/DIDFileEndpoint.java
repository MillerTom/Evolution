/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.did.endpoints.interfaces;

import gov.va.oit.vistaevolution.fileman.ws.did.model.DIDFileRequest;
import gov.va.oit.vistaevolution.fileman.ws.did.model.DIDFileResponse;
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
@WebService(name = "DIDFile", targetNamespace = "http://vistaevolution.va.gov")
public interface DIDFileEndpoint {
	/**
	 * DD File Retriever: This procedure retrieves the values of the file-level
	 * attributes for the specified file. It does not return subfile attributes.
	 * 
	 * @param request
	 *            Populated request object for file web method.
	 * @throws VistaWebServiceFault 
	 */
	@WebMethod(action = "DIDFileAction", operationName = "DIDFile")
	@SOAPBinding(parameterStyle = ParameterStyle.BARE)
	public DIDFileResponse file(
			@WebParam(name = "DIDFileRequest") DIDFileRequest request) throws VistaWebServiceFault;
}