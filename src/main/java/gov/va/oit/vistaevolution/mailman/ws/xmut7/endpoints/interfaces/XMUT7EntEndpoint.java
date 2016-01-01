/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmut7.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmut7.model.XMUT7EntRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmut7.model.XMUT7EntResponse;
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

@WebService(name = "XMUT7Ent", targetNamespace = "http://vistaevolution.va.gov")
public interface XMUT7EntEndpoint {

	@WebMethod(action = "XMUT7EntAction", operationName = "XMUT7Ent")
	@SOAPBinding(parameterStyle = ParameterStyle.BARE)
	public XMUT7EntResponse ent(
			@WebParam(name = "XMUT7EntRequest") XMUT7EntRequest request)
			throws VistaWebServiceFault;
}
