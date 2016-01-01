/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILTnmsgctRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILTnmsgctResponse;
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
@WebService(name = "XMXUTILTnmsgct", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUTILTnmsgctEndpoint {
	/**
	 * This extrinsic function returns the total number of new messages in a
	 * user's mailbox.
	 * 
	 * @param request
	 * 
	 *            Request Object that contains TNMSGCT^XMXUTIL input Parameters
	 * 
	 * @return XMXUTILTnmsgctResponse
	 * 
	 *         Response Object that contains TNMSGCT^XMXUTIL output Data
	 * 
	 * 
	 * @throws VistaWebServiceFault
	 */
	@WebMethod(action = "XMXUTILTnmsgctAction", operationName = "XMXUTILTnmsgct")
	@SOAPBinding(parameterStyle = ParameterStyle.BARE)
	public XMXUTILTnmsgctResponse tnmsgct(
			@WebParam(name = "XMXUTILTnmsgctRequest") XMXUTILTnmsgctRequest request)
			throws VistaWebServiceFault;
}
