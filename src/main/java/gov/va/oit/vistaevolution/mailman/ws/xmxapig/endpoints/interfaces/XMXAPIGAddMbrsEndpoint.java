/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxapig.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxapig.model.XMXAPIGAddMbrsRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapig.model.XMXAPIGAddMbrsResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@WebService(name = "XMXAPIGAddMbrs", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXAPIGAddMbrsEndpoint {

	/**
	 * @param request
	 * @return
	 */
	@WebMethod(action = "XMXAPIGAddMbrsAction", operationName = "XMXAPIGAddMbrs")
	public XMXAPIGAddMbrsResponse addMbrs(
			@WebParam(name = "XMXAPIGAddMbrsRequest") XMXAPIGAddMbrsRequest request)
			throws VistaWebServiceFault;

}
