/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmrent.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmrent.model.XMRENTNetRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmrent.model.XMRENTNetResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

/**
 * @author Leisa Martella
 * 
 */

@WebService(name = "XMRENTNet", targetNamespace = "http://vistaevolution.va.gov")
public interface XMRENTNetEndpoint {

	@WebMethod(action = "XMRENTNetAction", operationName = "XMRENTNet")
	public XMRENTNetResponse xmrentNet(
			@WebParam(name = "XMRENTNet") XMRENTNetRequest request)
			throws VistaWebServiceFault;
}
