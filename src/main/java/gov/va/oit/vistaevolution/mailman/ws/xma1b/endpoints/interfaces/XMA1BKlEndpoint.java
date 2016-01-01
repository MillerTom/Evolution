/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xma1b.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xma1b.model.XMA1BKlRequest;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.model.XMA1BKlResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Christopher Schuck
 *
 */
@WebService(name = "XMA1BKl", targetNamespace = "http://vistaevolution.va.gov")
public interface XMA1BKlEndpoint {
	
	@WebMethod(action = "XMA1BKlAction", operationName = "XMA1BKl")
	public XMA1BKlResponse kl(@WebParam(name = "XMA1BKlRequest") XMA1BKlRequest request) throws VistaWebServiceFault ;

}
