/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmvvitae.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.model.XMVVITAEOtherRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.model.XMVVITAEOtherResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@WebService(name = "XMVVITAEOther", targetNamespace = "http://vistaevolution.va.gov")
public interface XMVVITAEOtherEndpoint {

	/**
	 * This RPC changes certain MailMan XMV settings when the user becomes a
	 * surrogate. XMDUZ should be a user with mailman privileges.
	 * 
	 * @param request
	 * 
	 *            Request Object that contains OTHER^XMVVITAE input Parameters
	 * 
	 * @return XMVVITAEOtherResponse
	 * 
	 *         Response Object that contains OTHER^XMVVITAE output Data
	 * 
	 * 
	 * @throws VistaWebServiceFault
	 */
	@WebMethod(action = "XMVVITAEOtherAction", operationName = "XMVVITAEOther")
	public XMVVITAEOtherResponse other(
			@WebParam(name = "XMVVITAEOtherRequest") XMVVITAEOtherRequest request)
			throws VistaWebServiceFault;
}
