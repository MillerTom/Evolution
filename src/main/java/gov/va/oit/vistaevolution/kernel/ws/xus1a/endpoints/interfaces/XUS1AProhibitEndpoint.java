/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xus1a.endpoints.interfaces;

import gov.va.oit.vistaevolution.kernel.ws.xus1a.model.XUS1AProhibitRequest;
import gov.va.oit.vistaevolution.kernel.ws.xus1a.model.XUS1AProhibitResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Christopher Schuck
 *
 */
@WebService(name = "XUS1AProhibit", targetNamespace = "http://vistaevolution.va.gov")
public interface XUS1AProhibitEndpoint {

	@WebMethod(action = "XUS1AProhibitAction", operationName = "XUS1AProhibit")
	public XUS1AProhibitResponse prohibit(@WebParam(name = "XUS1AProhibitRequest") XUS1AProhibitRequest request)
            throws VistaWebServiceFault;
}
