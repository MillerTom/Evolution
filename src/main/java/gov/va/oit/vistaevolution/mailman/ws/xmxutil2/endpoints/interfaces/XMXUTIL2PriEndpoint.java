/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2PriRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2PriResponse;
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

@WebService(name = "XMXUTIL2Pri", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUTIL2PriEndpoint {

	@WebMethod(action = "XMXUTIL2PriAction", operationName = "XMXUTIL2Pri")
	public XMXUTIL2PriResponse xmxutil2Pri(
			@WebParam(name = "XMXUTIL2PriRequest") XMXUTIL2PriRequest request)
			throws VistaWebServiceFault;
}
