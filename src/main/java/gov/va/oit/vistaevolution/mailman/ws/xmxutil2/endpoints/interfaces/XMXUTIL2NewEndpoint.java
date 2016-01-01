/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2NewRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2NewResponse;
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

@WebService(name = "XMXUTIL2New", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUTIL2NewEndpoint {

	@WebMethod(action = "XMXUTIL2NewAction", operationName = "XMXUTIL2New")
	public XMXUTIL2NewResponse xmxutil2New(
			@WebParam(name = "XMXUTIL2NewRequest") XMXUTIL2NewRequest request)
			throws VistaWebServiceFault;
}
