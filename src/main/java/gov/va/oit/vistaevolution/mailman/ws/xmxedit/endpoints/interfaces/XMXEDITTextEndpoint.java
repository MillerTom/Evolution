/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITTextRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITTextResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Christopher Schuck
 *
 */
@WebService(name = "XMXEDITText", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXEDITTextEndpoint {

	@WebMethod(action = "XMXEDITTextAction", operationName = "XMXEDITText")
	public XMXEDITTextResponse text(@WebParam(name = "XMXEDITTextRequest") XMXEDITTextRequest request)
		throws VistaWebServiceFault;
}
