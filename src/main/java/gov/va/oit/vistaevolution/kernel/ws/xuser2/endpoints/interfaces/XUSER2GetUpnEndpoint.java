/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuser2.endpoints.interfaces;

import gov.va.oit.vistaevolution.kernel.ws.xuser2.model.XUSER2GetUpnRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuser2.model.XUSER2GetUpnResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Leisa Martella
 * 
 */

@WebService(name = "XUSER2GetUpn", targetNamespace = "http://vistaevolution.va.gov")
public interface XUSER2GetUpnEndpoint {

	@WebMethod(action = "XUSER2GetUpnAction", operationName = "XUSER2GetUpn")
	public XUSER2GetUpnResponse getUpn(
			@WebParam(name = "XUSER2GetUpnRequest") XUSER2GetUpnRequest request)
			throws VistaWebServiceFault;
}
