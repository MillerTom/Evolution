/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmvvitae.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.model.XMVVITAEInitRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.model.XMVVITAEInitResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@WebService(name = "XMVVITAEInit", targetNamespace = "http://vistaevolution.va.gov")
public interface XMVVITAEInitEndpoint {

	/**
	 * This RPC sets up vital user information in the VistA partition and should
	 * not be used for any other purpose. WARNING: This RPC is meant to be
	 * called once upon entry into MailMan.
	 * 
	 * 
	 * @param request
	 * 
	 *            Request Object that contains INIT^XMVVITAE input Parameters
	 * 
	 * @return XMVVITAEInitResponse
	 * 
	 *         Response Object that contains INIT^XMVVITAE output Data
	 * 
	 * 
	 * @throws VistaWebServiceFault
	 */
	@WebMethod(action = "XMVVITAEInitAction", operationName = "XMVVITAEInit")
	public XMVVITAEInitResponse init(
			@WebParam(name = "XMVVITAEInitRequest") XMVVITAEInitRequest request)
			throws VistaWebServiceFault;
}
