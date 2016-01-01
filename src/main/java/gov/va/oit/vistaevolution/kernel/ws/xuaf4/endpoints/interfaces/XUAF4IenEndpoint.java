/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces;

import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4IenRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4IenResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@WebService(name = "XUAF4Ien", targetNamespace = "http://vistaevolution.va.gov")
public interface XUAF4IenEndpoint {

	/**
	 * This extrinsic function returns the Internal Entry Number (IEN) of the
	 * entry for a given STATION NUMBER field (#99) in the INSTITUTION file
	 * (#4).
	 * 
	 * @param request
	 * 
	 *            Domain Object that contains All XUAF4^IEN input Parameters
	 * 
	 * @return XUAF4IenResponse
	 * 
	 *         Domain Object that contains XUAF4^IEN output data
	 * 
	 * @throws VistaWebServiceFault
	 * 
	 */
	@WebMethod(action = "XUAF4IenAction", operationName = "XUAF4Ien")
	public XUAF4IenResponse ien(
			@WebParam(name = "XUAF4IenRequest") XUAF4IenRequest request)
			throws VistaWebServiceFault;

}
