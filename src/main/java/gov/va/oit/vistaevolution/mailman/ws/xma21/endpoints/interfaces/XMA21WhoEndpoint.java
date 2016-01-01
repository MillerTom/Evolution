/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xma21.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xma21.model.XMA21WhoRequest;
import gov.va.oit.vistaevolution.mailman.ws.xma21.model.XMA21WhoResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Christopher Schuck
 *
 */
@WebService(name = "XMA21Who", targetNamespace = "http://vistaevolution.va.gov")
public interface XMA21WhoEndpoint {
	
	@WebMethod(action = "XMA21WhoAction", operationName = "XMA21Who")
	public XMA21WhoResponse who(@WebParam(name = "XMA21WhoRequest") XMA21WhoRequest request) throws VistaWebServiceFault;

}
