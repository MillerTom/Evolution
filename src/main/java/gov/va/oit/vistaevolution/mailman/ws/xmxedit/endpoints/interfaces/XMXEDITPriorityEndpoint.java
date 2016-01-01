/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITPriorityRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITPriorityResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Christopher Schuck
 *
 */
@WebService(name = "XMXEDITPriority", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXEDITPriorityEndpoint {
	
	@WebMethod(action = "XMXEDITPriorityAction", operationName = "XMXEDITPriority")
	public XMXEDITPriorityResponse priority(@WebParam(name = "XMXEDITPriorityRequest") XMXEDITPriorityRequest request)
		throws VistaWebServiceFault;

}
