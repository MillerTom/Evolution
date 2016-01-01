/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUtil1INDTRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUtil1INDTResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@WebService(name = "XMXUtil1INDT", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUtil1INDTEndpoint {

	/**
	 * @param request
	 * @return
	 */
	@WebMethod(action = "XMXUtil1INDTAction", operationName = "XMXUtil1INDT")
	public XMXUtil1INDTResponse indt(
			@WebParam(name = "XMXUtil1INDTRequest") XMXUtil1INDTRequest request)
			throws VistaWebServiceFault;

}
