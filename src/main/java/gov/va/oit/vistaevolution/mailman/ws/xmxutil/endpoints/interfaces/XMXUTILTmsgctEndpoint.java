/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILTmsgctRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILTmsgctResponse;
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
@WebService(name = "XMXUTILTmsgct", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUTILTmsgctEndpoint {

	/**
	 * This extrinsic function returns the total number of messages in a user's
	 * mailbox.
	 * 
	 * @param request
	 * 
	 *            Request Object that contains TMSGCT^XMXUTIL input Parameters
	 * 
	 * @return XMXUTILTmsgctResponse
	 * 
	 *         Response Object that contains TMSGCT^XMXUTIL output Data
	 * 
	 * 
	 * @throws VistaWebServiceFault
	 */
	@WebMethod(action = "XMXUTILTmsgctAction", operationName = "XMXUTILTmsgct")
	@SOAPBinding(parameterStyle = ParameterStyle.BARE)
	public XMXUTILTmsgctResponse tmsgct(
			@WebParam(name = "XMXUTILTmsgctRequest") XMXUTILTmsgctRequest request)
			throws VistaWebServiceFault;
}
