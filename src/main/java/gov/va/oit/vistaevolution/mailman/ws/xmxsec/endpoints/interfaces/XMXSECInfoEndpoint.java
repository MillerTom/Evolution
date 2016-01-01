package gov.va.oit.vistaevolution.mailman.ws.xmxsec.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxsec.model.XMXSECInfoRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.model.XMXSECInfoResponse;
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
@WebService(name = "XMXSECInfo", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXSECInfoEndpoint {

	/**
	 * This RPC returns a value indicating whether a message is
	 * "Information    Only" or not (0 = No; 1 = Yes). If there's an error, it
	 * returns an error message.
	 * 
	 * @param request
	 * 
	 *            Request Object that contains INFO^XMXSEC input Parameters
	 * 
	 * @return XMXSECInfoResponse
	 * 
	 *         Response Object that contains INFO^XMXSEC output Data
	 * 
	 * 
	 * @throws VistaWebServiceFault
	 */
	@WebMethod(action = "XMXSECInfoAction", operationName = "XMXSECInfo")
	@SOAPBinding(parameterStyle = ParameterStyle.BARE)
	public XMXSECInfoResponse info(
			@WebParam(name = "XMXSECInfoRequest") XMXSECInfoRequest request)
			throws VistaWebServiceFault;
}
