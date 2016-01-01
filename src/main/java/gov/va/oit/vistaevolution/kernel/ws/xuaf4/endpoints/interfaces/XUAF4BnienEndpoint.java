/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces;

import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4BnienRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4BnienResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@WebService(name = "XUAF4Bnien", targetNamespace = "http://vistaevolution.va.gov")
public interface XUAF4BnienEndpoint {

	/**
	 * Returns the Billing Facility Name. This is an undocumented Kernel API.
	 * 
	 * @param request
	 * 
	 *            Domain Object that contains All XUAF4^BNIEN input Parameters
	 * 
	 * @return XUAF4BnienResponse
	 * 
	 *         Domain Object that contains XUAF4^BNIEN output data
	 * 
	 * @throws VistaWebServiceFault
	 * 
	 */
	@WebMethod(action = "XUAF4BnienAction", operationName = "XUAF4Bnien")
	public XUAF4BnienResponse bnien(
			@WebParam(name = "XUAF4BnienRequest") XUAF4BnienRequest request)
			throws VistaWebServiceFault;
}
