/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuser.endpoints.interfaces;

import gov.va.oit.vistaevolution.kernel.ws.xuser.model.XUSERDiv4Request;
import gov.va.oit.vistaevolution.kernel.ws.xuser.model.XUSERDiv4Response;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Leisa Martella
 * 
 */

@WebService(name = "XUSERDiv4", targetNamespace = "http://vistaevolution.va.gov")
public interface XUSERDiv4Endpoint {

	@WebMethod(action = "XUSERDiv4Action", operationName = "XUSERDiv4")
	public XUSERDiv4Response div4(
			@WebParam(name = "XUSERDiv4Request") XUSERDiv4Request request)
			throws VistaWebServiceFault;
}
