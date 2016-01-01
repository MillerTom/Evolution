package gov.va.oit.vistaevolution.mailman.ws.xmcu1.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmcu1.model.XMCU1EncodeupRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.model.XMCU1EncodeupResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@WebService(name = "XMCU1Encodeup", targetNamespace = "http://vistaevolution.va.gov")
public interface XMCU1EncodeupEndpoint {

	/**
	 * 
	 * Takes a string, converts any ^ to ~U~, and returns the result.
	 * 
	 * @param request
	 * 
	 *            Domain Object that contains XMCU1^Encodeup input Parameter
	 * 
	 * @return XMCU1EncodeupResponse
	 * 
	 *         Domain Object that contains XMCU1^Encodeup output data
	 * 
	 * @throws VistaWebServiceFault
	 */

	@WebMethod(action = "XMCU1EncodeupAction", operationName = "XMCU1Encodeup")
	public XMCU1EncodeupResponse encodeup(
			@WebParam(name = "XMCU1EncodeupRequest") XMCU1EncodeupRequest request)
			throws VistaWebServiceFault;
}