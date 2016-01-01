package gov.va.oit.vistaevolution.mailman.ws.xmcu1.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmcu1.model.XMCU1RtranRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.model.XMCU1RtranResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@WebService(name = "XMCU1Rtran", targetNamespace = "http://vistaevolution.va.gov")
public interface XMCU1RtranEndpoint {

	/**
	 * 
	 * This extrinsic function takes a string that had been converted by
	 * $$STRAN^XMCU1(), undoes the conversion, and returns the result. Printable
	 * characters are converted back into control characters.
	 * 
	 * @param request
	 * 
	 *            Domain Object that contains All XMCU1^Rtran input Parameter
	 * 
	 * @return XMCU1RtranResponse
	 * 
	 *         Domain Object that contains XMCU1^Rtran output data
	 * 
	 * @throws VistaWebServiceFault
	 */
	@WebMethod(action = "XMCU1RtranAction", operationName = "XMCU1Rtran")
	public XMCU1RtranResponse rtran(
			@WebParam(name = "XMCU1RtranRequest") XMCU1RtranRequest request)
			throws VistaWebServiceFault;
}