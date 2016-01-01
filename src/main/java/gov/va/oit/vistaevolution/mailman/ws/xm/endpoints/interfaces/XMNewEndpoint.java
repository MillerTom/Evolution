/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xm.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xm.model.XMNewRequest;
import gov.va.oit.vistaevolution.mailman.ws.xm.model.XMNewResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Leisa Martella
 *
 */
@WebService(name = "XMNew", targetNamespace = "http://vistaevolution.va.gov")
public interface XMNewEndpoint {

	@WebMethod(action = "NewXMAction", operationName = "NewXM")
	public XMNewResponse xmnew(
			@WebParam(name = "XMNewRequest") XMNewRequest request)
			throws VistaWebServiceFault;
}
