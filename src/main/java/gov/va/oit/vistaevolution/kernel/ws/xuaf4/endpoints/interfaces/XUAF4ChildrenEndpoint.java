/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces;

import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4ChildrenRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4ChildrenResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@WebService(name = "XUAF4Children", targetNamespace = "http://vistaevolution.va.gov")
public interface XUAF4ChildrenEndpoint {

	/**
	 * This API returns a list of all institutions that make up a given Veterans
	 * Integrated Service Network (VISN), parent institution entered in the
	 * "parent" input parameter.
	 * 
	 * @param request
	 * 
	 *            Domain Object that contains All XUAF4^CHILDREN input
	 *            Parameters
	 * 
	 * @return XUAF4ChildrenResponse
	 * 
	 *         Domain Object that contains XUAF4^CHILDREN output data
	 * 
	 * @throws VistaWebServiceFault
	 * 
	 */
	@WebMethod(action = "XUAF4ChildrenAction", operationName = "XUAF4Children")
	public XUAF4ChildrenResponse children(
			@WebParam(name = "XUAF4ChildrenRequest") XUAF4ChildrenRequest request)
			throws VistaWebServiceFault;
}
