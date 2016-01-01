/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIMovemsgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIMovemsgResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@WebService(name = "XMXAPIMovemsg", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXAPIMovemsgEndpoint {

	/**
	 * This RPC moves messages from one basket to another.
	 * 
	 * 
	 * @param request
	 * 
	 *            Request Object that contains MOVEMSGM^XMXAPI input Parameters
	 * 
	 * @return XMXAPIMovemsgResponse
	 * 
	 *         Response Object that contains MOVEMSGM^XMXAPI output Data
	 * 
	 * 
	 * @throws VistaWebServiceFault
	 */
	@WebMethod(action = "XMXAPIMovemsgAction", operationName = "XMXAPIMovemsg")
	public XMXAPIMovemsgResponse movemsg(
			@WebParam(name = "XMXAPIMovemsgRequest") XMXAPIMovemsgRequest request)
			throws VistaWebServiceFault;
}
