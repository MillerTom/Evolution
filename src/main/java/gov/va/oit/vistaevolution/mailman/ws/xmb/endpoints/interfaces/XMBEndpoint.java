/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmb.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmb.model.XmbRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmb.model.XmbResponse;
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

@WebService(name = "Xmb", targetNamespace = "http://vistaevolution.va.gov")
public interface XMBEndpoint {

	@WebMethod(action = "XmbAction", operationName = "Xmb")
	public XmbResponse xmb(
			@WebParam(name = "XmbRequest") XmbRequest request)
			throws VistaWebServiceFault;
}
