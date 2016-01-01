package gov.va.oit.vistaevolution.mailman.ws.xmxsec.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxsec.model.XMXSECClosedRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.model.XMXSECClosedResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

/**
 * 
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@WebService(name = "XMXSECClosed", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXSECClosedEndpoint {

	/**
	 * This extrinsic function returns a value indicating whether a message is
	 * "Closed" or not (0 = No; 1 = Yes). It does not set XMERR and
	 * ^TMP("XMERR",$J).
	 * 
	 * @param request
	 * 
	 *            Request Object that contains CLOSED^XMXSEC input Parameters
	 * 
	 * @return XMXSECInfoResponse
	 * 
	 *         Response Object that contains CLOSED^XMXSEC output Data
	 * 
	 * @throws VistaWebServiceFault
	 */
	@WebMethod(action = "XMXSECClosedAction", operationName = "XMXSECClosed")
	@SOAPBinding(parameterStyle = ParameterStyle.BARE)
	public XMXSECClosedResponse closed(
			@WebParam(name = "XMXSECClosedRequest") XMXSECClosedRequest request)
			throws VistaWebServiceFault;
}
