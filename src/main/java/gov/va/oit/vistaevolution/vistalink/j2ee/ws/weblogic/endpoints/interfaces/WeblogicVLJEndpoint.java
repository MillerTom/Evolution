/**
 * 
 */
package gov.va.oit.vistaevolution.vistalink.j2ee.ws.weblogic.endpoints.interfaces;

import gov.va.oit.vistaevolution.vistalink.j2ee.ws.weblogic.model.WeblogicVLJRequest;
import gov.va.oit.vistaevolution.vistalink.j2ee.ws.weblogic.model.WeblogicVLJResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

/**
 * @author Stephen Combs (stephen.combs@synaptekcorp.com)
 * 
 */

@WebService(name = "WeblogicVLJService", targetNamespace = "http://vistaevolution.va.gov")
public interface WeblogicVLJEndpoint {

	@WebMethod(action = "processRpcAction", operationName = "WeblogicVLJ")
	@SOAPBinding(parameterStyle = ParameterStyle.BARE)
	public WeblogicVLJResponse processRpc(
			@WebParam(name = "WeblogicVLJRequest") WeblogicVLJRequest request)
			throws VistaWebServiceFault;

}
