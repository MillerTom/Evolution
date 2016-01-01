/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces;

import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4STARequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4STAResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@WebService(name = "XUAF4STA", targetNamespace = "http://vistaevolution.va.gov")
public interface XUAF4STAEndpoint {

	/**
	 * @param request
	 * @return
	 * @throws VistaWebServiceFault
	 */
	@WebMethod(action = "XUAF4STAAction", operationName = "XUAF4STA")
	public XUAF4STAResponse sta(@WebParam(name = "XUAF4STARequest") XUAF4STARequest request) throws VistaWebServiceFault;

}
