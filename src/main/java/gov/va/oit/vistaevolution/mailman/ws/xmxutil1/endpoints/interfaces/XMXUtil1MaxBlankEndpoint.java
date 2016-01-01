/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUtil1MaxBlankRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUtil1MaxBlankResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@WebService(name = "XMXUtil1MaxBlank", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUtil1MaxBlankEndpoint {

	/**
	 * @param request
	 * @return
	 */
	@WebMethod(action = "XMXUtil1MaxBlankAction", operationName = "XMXUtil1MaxBlank")
	public XMXUtil1MaxBlankResponse maxBlank(
			@WebParam(name = "XMXUtil1MaxBlankRequest") XMXUtil1MaxBlankRequest request)
			throws VistaWebServiceFault;

}
