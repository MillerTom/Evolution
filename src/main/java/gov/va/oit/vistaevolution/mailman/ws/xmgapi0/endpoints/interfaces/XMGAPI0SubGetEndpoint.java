/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmgapi0.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmgapi0.model.XMGAPI0SubGetResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmgapi0.model.XMGAPI0SubgetRequest;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * RPC Broker Validate Message Subject: This procedure checks the subject of a
 * message and returns a validated processed message subject and removes the
 * control characters from the subject. If the subject is set to the empty
 * string “” the function does not report that the subject is too short. But if
 * the subject is 1 or 2 characters in length then the error messages is
 * displayed.
 * 
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@WebService(name = "XMGAPI0SubGet", targetNamespace = "http://vistaevolution.va.gov")
public interface XMGAPI0SubGetEndpoint {

	/**
	 * 
	 * @param XMZ
	 * @return
	 * @throws VistaWebServiceFault
	 */
	@WebMethod(action = "XMGAPI0SubGetAction", operationName = "XMGAPI0SubGet")
	public XMGAPI0SubGetResponse subGet(
			@WebParam(name = "XMGAPI0SubgetRequest") XMGAPI0SubgetRequest XMZ)
			throws VistaWebServiceFault;

}