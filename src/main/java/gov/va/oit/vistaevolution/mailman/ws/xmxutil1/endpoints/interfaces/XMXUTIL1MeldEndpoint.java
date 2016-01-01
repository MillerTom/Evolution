/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1MeldRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1MeldResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

/**
 * @author Leisa Martella
 * 
 */

@WebService(name = "XMXUTIL1Meld", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUTIL1MeldEndpoint {

	@WebMethod(action = "XMXUTIL1MeldAction", operationName = "XMXUTIL1Meld")
	public XMXUTIL1MeldResponse meld(
			@WebParam(name = "XMXUTIL1MeldRequest") XMXUTIL1MeldRequest request)
			throws VistaWebServiceFault;
}
