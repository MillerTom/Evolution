/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2InmsgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2InmsgResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Christopher Schuck
 *
 */
@WebService(name = "XMXUTIL2Inmsg", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUTIL2InmsgEndpoint {

	@WebMethod(action = "XMXUTIL2InmsgAction", operationName = "XMXUTIL2Inmsg")
	public XMXUTIL2InmsgResponse inmsg(
			@WebParam(name = "XMXUTIL2InmsgRequest") XMXUTIL2InmsgRequest request)
			throws VistaWebServiceFault;
}
