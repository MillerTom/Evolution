package gov.va.oit.vistaevolution.mailman.ws.xma2r.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xma2r.model.XMA2REntaRequest;
import gov.va.oit.vistaevolution.mailman.ws.xma2r.model.XMA2REntaResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@WebService(name = "XMA2REnta", targetNamespace = "http://vistaevolution.va.gov")
public interface XMA2REntaEndpoint {

	/**
	 * 
	 * Creates and sends an answer to a message and returns the message number
	 * of the answer. If the answer is not successful, it returns a string with
	 * the text of the error. Unlike a reply, an answer is sent only to the
	 * sender of the original message. It makes no difference whether the sender
	 * is local or remote.
	 * 
	 * @param request
	 * 
	 *            Domain Object that contains All XMA2R^ENTA input Parameters
	 * 
	 * @return XMA2REntaResponse
	 * 
	 *         Domain Object that contains XMA2R^ENTA output data
	 * 
	 * @throws VistaWebServiceFault
	 */
	@WebMethod(action = "XMA2REntaAction", operationName = "XMA2REnta")
	public XMA2REntaResponse enta(
			@WebParam(name = "XMA2REntaRequest") XMA2REntaRequest request)
			throws VistaWebServiceFault;
}
