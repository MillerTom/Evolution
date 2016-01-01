package gov.va.oit.vistaevolution.mailman.ws.xmxsec.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxsec.model.XMXSECConfidRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.model.XMXSECConfidResponse;
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
@WebService(name = "XMXSECConfid", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXSECConfidEndpoint {

	/**
	 * This extrinsic function returns a value indicating whether a message is
	 * "Confidential" or not (0 = No; 1 = Yes). It does not set XMERR and
	 * ^TMP("XMERR",$J).
	 * 
	 * @param request
	 * 
	 *            Request Object that contains CONFID^XMXSEC input Parameters
	 * 
	 * @return XMXSECInfoResponse
	 * 
	 *         Response Object that contains CONFID^XMXSEC output Data
	 * 
	 * @throws VistaWebServiceFault
	 */
	@WebMethod(action = "XMXSECConfidAction", operationName = "XMXSECConfid")
	@SOAPBinding(parameterStyle = ParameterStyle.BARE)
	public XMXSECConfidResponse confid(
			@WebParam(name = "XMXSECConfidRequest") XMXSECConfidRequest request)
			throws VistaWebServiceFault;
}
