/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1MmdtRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1MmdtResponse;
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

@WebService(name = "XMXUTIL1Mmdt", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUTIL1MmdtEndpoint {

	@WebMethod(action = "XMXUTIL1MmdtAction", operationName = "XMXUTIL1Mmdt")
	public XMXUTIL1MmdtResponse mmdt(
			@WebParam(name = "XMXUTIL1MmdtRequest") XMXUTIL1MmdtRequest request)
			throws VistaWebServiceFault;
}
