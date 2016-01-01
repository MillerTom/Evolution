/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILNameRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILNameResponse;
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

@WebService(name = "XMXUTILName", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUTILNameEndpoint {

	@WebMethod(action = "XMXUTILNameAction", operationName = "XMXUTILName")
	public XMXUTILNameResponse name(
			@WebParam(name = "XMXUTILNameRequest") XMXUTILNameRequest request)
			throws VistaWebServiceFault;
}
