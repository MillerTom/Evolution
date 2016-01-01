/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2InrespRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2InrespResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Christopher Schuck
 *
 */
@WebService(name = "XMXUTIL2Inresp", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUTIL2InrespEndpoint {

	@WebMethod(action = "XMXUTIL2InrespAction", operationName = "XMXUTIL2Inresp")
	public XMXUTIL2InrespResponse inresp(
			@WebParam(name = "XMXUTIL2InrespRequest") XMXUTIL2InrespRequest request)
			throws VistaWebServiceFault;

}
