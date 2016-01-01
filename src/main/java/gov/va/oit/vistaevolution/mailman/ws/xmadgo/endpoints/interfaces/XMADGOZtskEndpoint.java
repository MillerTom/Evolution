/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmadgo.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmadgo.model.XMADGOZtskRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmadgo.model.XMADGOZtskResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Leisa Martella
 * 
 */

@WebService(name = "XMADGOZtskCheck", targetNamespace = "http://vistaevolution.va.gov")
public interface XMADGOZtskEndpoint {

	@WebMethod(action = "XMADGOZtskAction", operationName = "XMADGOZtsk")
	public XMADGOZtskResponse ztsk(
			@WebParam(name = "XMADGOZtsk")XMADGOZtskRequest request)
			throws VistaWebServiceFault;
}
