package gov.va.oit.vistaevolution.mailman.ws.xma2r.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xma2r.model.XMA2REntRequest;
import gov.va.oit.vistaevolution.mailman.ws.xma2r.model.XMA2REntResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@WebService(name = "XMA2REnt", targetNamespace = "http://vistaevolution.va.gov")
public interface XMA2REntEndpoint {

	/**
	 * 
	 * Creates and sends a reply to a message and returns the message number of
	 * the reply. If the reply is not successful, returns a string with the text
	 * of the error. Unlike an answer, a reply is sent to all (local) recipients
	 * of the message to which you are replying.
	 * 
	 * @param request
	 * 
	 *            Domain Object that contains All XMA2R^ENT input Parameters
	 * 
	 * @return XMA2REntResponse
	 * 
	 *         Domain Object that contains XMA2R^ENT output data
	 * 
	 * @throws VistaWebServiceFault
	 */

	@WebMethod(action = "XMA2REntAction", operationName = "XMA2REnt")
	public XMA2REntResponse ent(
			@WebParam(name = "XMA2REntRequest") XMA2REntRequest request)
			throws VistaWebServiceFault;
}
