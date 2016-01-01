/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2ZSUBJRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2ZSUBJResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@WebService(name = "XMXUtil2ZSUBJ", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUtil2ZSUBJEndpoint {

	/**
	 * @param request
	 * @return
	 */
	@WebMethod(action = "XMXUtil2ZSUBJAction", operationName = "XMXUtil2ZSUBJ")
	public XMXUtil2ZSUBJResponse zsubj(
			@WebParam(name = "XMXUtil2ZSUBJRequest") XMXUtil2ZSUBJRequest request)
			throws VistaWebServiceFault;

}
