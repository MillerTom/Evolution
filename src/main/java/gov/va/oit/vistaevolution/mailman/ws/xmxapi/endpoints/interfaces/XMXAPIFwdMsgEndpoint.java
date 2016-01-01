/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIFwdMsgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIFwdMsgResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Leisa Martella
 * 
 */

@WebService(name = "XMXAPIFwdMsg", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXAPIFwdMsgEndpoint {

	@WebMethod(action = "XMXAPIFwdMsgAction", operationName = "XMXAPIFwdMsg")
	public XMXAPIFwdMsgResponse fwdMsg(
			@WebParam(name = "XMXAPIFwdMsgRequest") XMXAPIFwdMsgRequest request)
			throws VistaWebServiceFault;
}
