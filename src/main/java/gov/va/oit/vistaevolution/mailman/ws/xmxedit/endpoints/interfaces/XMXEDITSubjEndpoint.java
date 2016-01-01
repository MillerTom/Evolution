/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITSubjRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITSubjResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Christopher Schuck
 *
 */
@WebService(name = "XMXEDITSubj", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXEDITSubjEndpoint {

	@WebMethod(action = "XMXEDITSubjAction", operationName = "XMXEDITSubj")
	public XMXEDITSubjResponse subj(@WebParam(name = "XMXEDITSubjRequest") XMXEDITSubjRequest request)
		throws VistaWebServiceFault;
}
