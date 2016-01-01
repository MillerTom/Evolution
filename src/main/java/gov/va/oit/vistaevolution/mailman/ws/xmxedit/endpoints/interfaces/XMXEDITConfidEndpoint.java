/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITConfidRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITConfidResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Christopher Schuck
 *
 */
@WebService(name = "XMXEDITConfid", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXEDITConfidEndpoint {

	@WebMethod(action = "XMXEDITConfidAction", operationName = "XMXEDITConfid")
	public XMXEDITConfidResponse confid(@WebParam(name = "XMXEDITConfidRequest") XMXEDITConfidRequest request)
		throws VistaWebServiceFault;
}
