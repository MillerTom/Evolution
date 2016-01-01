/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILKvaporRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILKvaporResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Christopher Schuck
 *
 */
@WebService(name = "XMXUTILKvapor", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUTILKvaporEndpoint {

	@WebMethod(action = "XMXUTILKvaporAction", operationName = "XMXUTILKvapor")
	public XMXUTILKvaporResponse kvapor(
			@WebParam(name = "XMXUTILKvaporRequest") XMXUTILKvaporRequest request)
			throws VistaWebServiceFault;

}
