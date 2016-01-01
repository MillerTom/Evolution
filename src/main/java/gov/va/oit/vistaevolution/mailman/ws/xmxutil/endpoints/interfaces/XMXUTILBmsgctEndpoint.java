/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILBmsgctRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILBmsgctResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Christopher Schuck
 *
 */
@WebService(name = "XMXUTILBmsgct", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUTILBmsgctEndpoint {

	@WebMethod(action = "XMXUTILBmsgctAction", operationName = "XMXUTILBmsgct")
	public XMXUTILBmsgctResponse bmsgct(
			@WebParam(name = "XMXUTILBmsgctRequest") XMXUTILBmsgctRequest request)
			throws VistaWebServiceFault;

}
