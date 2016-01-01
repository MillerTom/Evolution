/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxsec2.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxsec2.model.XMXSEC2OptmsgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec2.model.XMXSEC2OptmsgResponse;
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
@WebService(name = "XMXSEC2Optmsg", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXSEC2OptmsgEndpoint {

	/**
	 * This RPC determines what the user can do with the message.
	 * 
	 * @param request
	 * 
	 *            Request Object that contains OPTMSG^XMXSEC2 input Parameters
	 * 
	 * @return XMXSEC2OptmsgResponse
	 * 
	 *         Response Object that contains OPTMSG^XMXSEC2 output Data
	 * 
	 * 
	 * @throws VistaWebServiceFault
	 */
	@WebMethod(action = "XMXSEC2OptmsgAction", operationName = "XMXSEC2Optmsg")
	@SOAPBinding(parameterStyle = ParameterStyle.BARE)
	public XMXSEC2OptmsgResponse optmsg(
			@WebParam(name = "XMXSEC2OptmsgRequest") XMXSEC2OptmsgRequest request)
			throws VistaWebServiceFault;
}
