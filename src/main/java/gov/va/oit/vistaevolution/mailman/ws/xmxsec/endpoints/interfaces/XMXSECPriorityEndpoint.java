/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxsec.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxsec.model.XMXSECPriorityRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.model.XMXSECPriorityResponse;
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
@WebService(name = "XMXSECPriority", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXSECPriorityEndpoint {

	/**
	 * This RPC returns a value indicating whether a message is "Priority" or
	 * not (0 = No; 1 = Yes).If there's an error, it returns an error message.
	 * 
	 * 
	 * @param request
	 * 
	 *            Request Object that contains PRIORITY^XMXSEC input Parameters
	 * 
	 * @return XMXSECInfoResponse
	 * 
	 *         Response Object that contains PRIORITY^XMXSEC output Data
	 * 
	 * 
	 * @throws VistaWebServiceFault
	 */
	@WebMethod(action = "XMXSECPriorityAction", operationName = "XMXSECPriority")
	@SOAPBinding(parameterStyle = ParameterStyle.BARE)
	public XMXSECPriorityResponse priority(
			@WebParam(name = "XMXSECPriorityRequest") XMXSECPriorityRequest request)
			throws VistaWebServiceFault;
}
