/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILNewsRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILNewsResponse;
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

@WebService(name = "XMXUTILNews", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUTILNewsEndpoint {

	@WebMethod(action = "XMXUTILNewsAction", operationName = "XMXUTILNews")
	public XMXUTILNewsResponse news(
			@WebParam(name = "XMXUTILNewsRequest") XMXUTILNewsRequest request)
			throws VistaWebServiceFault;
}
