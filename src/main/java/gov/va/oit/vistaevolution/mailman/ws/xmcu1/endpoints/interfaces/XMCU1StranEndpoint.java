package gov.va.oit.vistaevolution.mailman.ws.xmcu1.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmcu1.model.XMCU1StranRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.model.XMCU1StranResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@WebService(name = "XMCU1Stran", targetNamespace = "http://vistaevolution.va.gov")
public interface XMCU1StranEndpoint {

	/**
	 * 
	 * Takes a string, converts any control characters to printable characters,
	 * and returns “~” concatenated with the result.
	 * 
	 * @param request
	 * 
	 *            Domain Object that contains All XMCU1^Stran input Parameter
	 * 
	 * @return XMCU1StranResponse
	 * 
	 *         Domain Object that contains XMCU1^Stran output data
	 * 
	 * @throws VistaWebServiceFault
	 */
	@WebMethod(action = "XMCU1StranAction", operationName = "XMCU1Stran")
	public XMCU1StranResponse stran(
			@WebParam(name = "XMCU1StranRequest") XMCU1StranRequest request)
			throws VistaWebServiceFault;
}