package gov.va.oit.vistaevolution.mailman.ws.xmcu1.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmcu1.model.XMCU1DecodeupRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.model.XMCU1DecodeupResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@WebService(name = "XMCU1Decodeup", targetNamespace = "http://vistaevolution.va.gov")
public interface XMCU1DecodeupEndpoint {

	/**
	 * 
	 * Takes a string, converts any ~U~ to ^, and returns the result.
	 * 
	 * @param request
	 * 
	 *            Domain Object that contains All XMCU1^Decodeup input
	 *            Parameters
	 * 
	 * @return XMCU1DecodeupResponse
	 * 
	 *         Domain Object that contains XMCU1^Decodeup output data
	 * 
	 * @throws VistaWebServiceFault
	 */
	@WebMethod(action = "XMCU1DecodeupAction", operationName = "XMCU1Decodeup")
	public XMCU1DecodeupResponse decodeup(
			@WebParam(name = "XMCU1DecodeupRequest") XMCU1DecodeupRequest request)
			throws VistaWebServiceFault;
}
