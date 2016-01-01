/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxapig.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxapig.model.XMXAPIGJoinRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapig.model.XMXAPIGJoinResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Christopher Schuck
 *
 */
@WebService(name = "XMXAPIGJoin", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXAPIGJoinEndpoint {

	@WebMethod(action = "XMXAPIGJoinAction", operationName = "XMXAPIGJoin")
	public XMXAPIGJoinResponse join(@WebParam(name = "XMXAPIGJoinRequest") XMXAPIGJoinRequest request)
		throws VistaWebServiceFault;
}
