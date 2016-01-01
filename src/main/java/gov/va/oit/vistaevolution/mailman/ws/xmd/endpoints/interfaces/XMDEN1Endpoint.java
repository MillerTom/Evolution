/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMDEN1Request;
import gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMDResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@WebService(name = "XMDEN1", targetNamespace = "http://vistaevolution.va.gov")
public interface XMDEN1Endpoint {

	/**
	 * @param request
	 * @return
	 */
	@WebMethod(action = "XMDEN1Action", operationName = "XMDEN1")
	public XMDResponse en1(
			@WebParam(name = "XMDEN1Request") XMDEN1Request request)
			throws VistaWebServiceFault;

}
