/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xm.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xm.model.XMKillRequest;
import gov.va.oit.vistaevolution.mailman.ws.xm.model.XMKillResponse;
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

@WebService(name = "XMKill", targetNamespace = "http://vistaevolution.va.gov")
public interface XMKillEndpoint {

	@WebMethod(action = "KillXMAction", operationName = "KillXM")
	public XMKillResponse kill(
			@WebParam(name = "XMKillRequest") XMKillRequest request)
			throws VistaWebServiceFault;

}
