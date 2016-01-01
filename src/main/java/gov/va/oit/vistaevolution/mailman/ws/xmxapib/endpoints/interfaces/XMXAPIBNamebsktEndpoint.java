/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBNamebsktRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBNamebsktResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@WebService(name = "XMXAPIBNamebskt", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXAPIBNamebsktEndpoint {

	/**
	 * This RPC restores certain MailMan settings when the user becomes
	 * himself/herself again, after having been a surrogate. NOTE: This RPC is
	 * meant to be called whenever the user returns from being a surrogate.
	 * 
	 * 
	 * @param request
	 * 
	 *            Request Object that contains NAMEBSKT^XMXAPIB input Parameters
	 * 
	 * @return XMXAPIBNamebsktResponse
	 * 
	 *         Response Object that contains NAMEBSKT^XMXAPIB output Data
	 * 
	 * 
	 * @throws VistaWebServiceFault
	 */
	@WebMethod(action = "XMXAPIBNamebsktAction", operationName = "XMXAPIBNamebskt")
	@SOAPBinding(parameterStyle = ParameterStyle.BARE)
	public XMXAPIBNamebsktResponse namebskt(
			@WebParam(name = "XMXAPIBNamebsktRequest") XMXAPIBNamebsktRequest request)
			throws VistaWebServiceFault;
}
