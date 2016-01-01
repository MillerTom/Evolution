/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIFiltrMsgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIFiltrMsgResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Leisa Martella
 * 
 */

@WebService(name = "XMXAPIFiltrMsg", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXAPIFiltrMsgEndpoint {

	@WebMethod(action = "XMXAPIFiltrMsgAction", operationName = "XMXAPIFiltrMsg")
	public XMXAPIFiltrMsgResponse filtrMsg(
			@WebParam(name = "XMXAPIFiltrMsgRequest") XMXAPIFiltrMsgRequest request)
			throws VistaWebServiceFault;
}
