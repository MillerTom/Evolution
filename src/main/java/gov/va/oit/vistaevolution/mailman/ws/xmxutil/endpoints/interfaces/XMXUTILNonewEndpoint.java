/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILNonewRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILNonewResponse;
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
@WebService(name = "XMXUTILNonew", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUTILNonewEndpoint {

	/**
	 * This RPC makes a message not new and updates the new message counts.
	 * 
	 * 
	 * @param request
	 * 
	 *            Request Object that contains NONEW^XMXUTIL input Parameters
	 * 
	 * @return XMXUTILNonewResponse
	 * 
	 *         Response Object that contains NONEW^XMXUTIL output Data
	 * 
	 * 
	 * @throws VistaWebServiceFault
	 */
	@WebMethod(action = "XMXUTILNonewAction", operationName = "XMXUTILNonew")
	@SOAPBinding(parameterStyle = ParameterStyle.BARE)
	public XMXUTILNonewResponse nonew(
			@WebParam(name = "XMXUTILNonewRequest") XMXUTILNonewRequest request)
			throws VistaWebServiceFault;
}
