/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces;

import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4TFRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4TFResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@WebService(name = "XUAF4TF", targetNamespace = "http://vistaevolution.va.gov")
public interface XUAF4TFEndpoint {

	/**
	 * @param request
	 * @return
	 * @throws VistaWebServiceFault
	 */
	@WebMethod(action = "XUAF4TFAction", operationName = "XUAF4TF")
	public XUAF4TFResponse tf(@WebParam(name = "XUAF4TFRequest") XUAF4TFRequest request) throws VistaWebServiceFault;

}
