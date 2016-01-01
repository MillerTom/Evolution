/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIMovemsgsRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIMovemsgsResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@WebService(name = "XMXAPIMovemsgs", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXAPIMovemsgsEndpoint {

	/**
	 * This RPC moves messages from one basket to another.
	 * 
	 * 
	 * @param request
	 * 
	 *            Request Object that contains MOVEMSGS^XMXAPI input Parameters
	 * 
	 * @return XMXAPIMovemsgsResponse
	 * 
	 *         Response Object that contains MOVEMSGS^XMXAPI output Data
	 * 
	 * 
	 * @throws VistaWebServiceFault
	 */
	@WebMethod(action = "XMXAPIMovemsgsAction", operationName = "XMXAPIMovemsgs")
	public XMXAPIMovemsgsResponse movemsgs(
			@WebParam(name = "XMXAPIMovemsgsRequest") XMXAPIMovemsgsRequest request)
			throws VistaWebServiceFault;

}
