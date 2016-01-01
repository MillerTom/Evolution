/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxsec2.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxsec2.model.XMXSEC2OpteditRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec2.model.XMXSEC2OpteditResponse;
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
@WebService(name = "XMXSEC2Optedit", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXSEC2OpteditEndpoint {

	/**
	 * If this RPC determines that the user can edit the message, then this RPC
	 * determines what, exactly, the user can edit.
	 * 
	 * @param request
	 * 
	 *            Request Object that contains OPTEDIT^XMXSEC2 input Parameters
	 * 
	 * @return XMXSEC2OpteditResponse
	 * 
	 *         Response Object that contains OPTEDIT^XMXSEC2 output Data
	 * 
	 * 
	 * @throws VistaWebServiceFault
	 */
	@WebMethod(action = "XMXSEC2OpteditAction", operationName = "XMXSEC2Optedit")
	@SOAPBinding(parameterStyle = ParameterStyle.BARE)
	public XMXSEC2OpteditResponse optedit(
			@WebParam(name = "XMXSEC2OpteditRequest") XMXSEC2OpteditRequest request)
			throws VistaWebServiceFault;
}
