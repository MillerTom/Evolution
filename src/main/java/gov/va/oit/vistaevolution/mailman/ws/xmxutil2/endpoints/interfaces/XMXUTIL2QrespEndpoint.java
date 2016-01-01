/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2QrespRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2QrespResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Christopher Schuck
 *
 */
@WebService(name = "XMXUTIL2Qresp", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUTIL2QrespEndpoint {

	@WebMethod(action = "XMXUTIL2QrespAction", operationName = "XMXUTIL2Qresp")
	public XMXUTIL2QrespResponse qresp(
			@WebParam(name = "XMXUTIL2QrespRequest") XMXUTIL2QrespRequest request)
			throws VistaWebServiceFault;

}
