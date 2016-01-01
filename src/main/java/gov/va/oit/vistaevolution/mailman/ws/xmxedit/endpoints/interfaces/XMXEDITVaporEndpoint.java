/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITVaporRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITVaporResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Christopher Schuck
 *
 */
@WebService(name = "XMXEDITVapor", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXEDITVaporEndpoint {

	@WebMethod(action = "XMXEDITVaporAction", operationName = "XMXEDITVapor")
	public XMXEDITVaporResponse vapor(@WebParam(name = "XMXEDITVaporRequest") XMXEDITVaporRequest request)
		throws VistaWebServiceFault;
}
