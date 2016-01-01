/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmvvitae.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.model.XMVVITAESelfRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.model.XMVVITAESelfResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@WebService(name = "XMVVITAESelf", targetNamespace = "http://vistaevolution.va.gov")
public interface XMVVITAESelfEndpoint {

	/**
	 * This RPC restores certain MailMan settings when the user becomes
	 * himself/herself again, after having been a surrogate.
	 * 
	 * 
	 * @param request
	 * 
	 *            Request Object that contains SELF^XMVVITAE input Parameters
	 * 
	 * @return XMVVITAESelfResponse
	 * 
	 *         Response Object that contains SELF^XMVVITAE output Data
	 * 
	 * 
	 * @throws VistaWebServiceFault
	 */
	@WebMethod(action = "XMVVITAESelfAction", operationName = "XMVVITAESelf")
	public XMVVITAESelfResponse self(
			@WebParam(name = "XMVVITAESelfRequest") XMVVITAESelfRequest request)
			throws VistaWebServiceFault;

}
