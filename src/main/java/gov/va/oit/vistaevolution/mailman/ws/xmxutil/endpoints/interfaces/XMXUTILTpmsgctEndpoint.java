/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILTpmsgctRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILTpmsgctResponse;
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
@WebService(name = "XMXUTILTpmsgct", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUTILTpmsgctEndpoint {

	/**
	 * This extrinsic function returns the total number of new priority messages
	 * in a user's mailbox.
	 * 
	 * @param request
	 * 
	 *            Request Object that contains TPMSGCT^XMXUTIL input Parameters
	 * 
	 * @return XMXUTILTpmsgctResponse
	 * 
	 *         Response Object that contains TPMSGCT^XMXUTIL output Data
	 * 
	 * 
	 * @throws VistaWebServiceFault
	 */
	@WebMethod(action = "XMXUTILTpmsgctAction", operationName = "XMXUTILTpmsgct")
	@SOAPBinding(parameterStyle = ParameterStyle.BARE)
	public XMXUTILTpmsgctResponse tpmsgct(
			@WebParam(name = "XMXUTILTpmsgctRequest") XMXUTILTpmsgctRequest request)
			throws VistaWebServiceFault;
}
