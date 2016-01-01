/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMDRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMDResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@WebService(name = "XMD", targetNamespace = "http://vistaevolution.va.gov")
public interface XMDEndpoint {

	/**
	 * @param request
	 * @return
	 */
	@WebMethod(action = "XMDAction", operationName = "XMD")
	public XMDResponse xmd(@WebParam(name = "XMDRequest") XMDRequest request)
			throws VistaWebServiceFault;

}
