/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILBnmsgctRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILBnmsgctResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Christopher Schuck
 *
 */
@WebService(name = "XMXUTILBnmsgct", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUTILBnmsgctEndpoint {

	@WebMethod(action = "XMXUTILBnmsgctAction", operationName = "XMXUTILBnmsgct")
	public XMXUTILBnmsgctResponse bnmsgct(
			@WebParam(name = "XMXUTILBnmsgctRequest") XMXUTILBnmsgctRequest request)
			throws VistaWebServiceFault;

}
