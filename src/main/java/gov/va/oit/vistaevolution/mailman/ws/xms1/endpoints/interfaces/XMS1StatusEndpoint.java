/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xms1.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xms1.model.XMS1StatusRequest;
import gov.va.oit.vistaevolution.mailman.ws.xms1.model.XMS1StatusResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Leisa Martella
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */

@WebService(name = "XMS1Status", targetNamespace = "http://vistaevolution.va.gov")
public interface XMS1StatusEndpoint {

	/**
	 * 
	 * This extrinsic function returns the STATUS field (#5) of a (server)
	 * recipient from the RECIPIENT multiple of a message in the MESSAGE file
	 * (#3.9). If the recipient cannot be found, it returns null.
	 * 
	 * @param request
	 * 
	 *            Domain Object that contains All XMS1^STATUS input Parameters
	 * 
	 * @return XMS1StatusResponse
	 * 
	 *         Domain Object that contains XMS1^STATUS output data
	 * 
	 * @throws VistaWebServiceFault
	 */
	@WebMethod(action = "XMS1StatusAction", operationName = "XMS1Status")
	public XMS1StatusResponse status(
			@WebParam(name = "XMS1StatusRequest") XMS1StatusRequest request)
			throws VistaWebServiceFault;
}
