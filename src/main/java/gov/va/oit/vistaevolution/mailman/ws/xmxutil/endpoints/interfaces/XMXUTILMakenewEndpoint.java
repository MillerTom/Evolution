/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILMakenewRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILMakenewResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@WebService(name = "XMXUTILMakenew", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUTILMakenewEndpoint {

	/**
	 * This RPC makes a message new and updates the new message counts.
	 * 
	 * 
	 * @param request
	 * 
	 *            Request Object that contains MAKENEW^XMXUTIL input Parameters
	 * 
	 * @return XMXUTILMakenewResponse
	 * 
	 *         Response Object that contains MAKENEW^XMXUTIL output Data
	 * 
	 * 
	 * @throws VistaWebServiceFault
	 */
	@WebMethod(action = "XMXUTILMakenewAction", operationName = "XMXUTILMakenew")
	public XMXUTILMakenewResponse makenew(
			@WebParam(name = "XMXUTILMakenewRequest") XMXUTILMakenewRequest request)
			throws VistaWebServiceFault;

}
