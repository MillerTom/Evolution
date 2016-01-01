/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILNetNameRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILNetNameResponse;
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

@WebService(name = "XMXUTILNetName", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUTILNetNameEndpoint {

	@WebMethod(action = "XMXUTILNetName", operationName = "XMXUTILNetName")
	public XMXUTILNetNameResponse netName(
			@WebParam(name = "XMXUTILNetNameRequest") XMXUTILNetNameRequest request)
			throws VistaWebServiceFault;
}
