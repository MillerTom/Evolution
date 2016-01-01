/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xqcs.endpoints.interfaces;

import gov.va.oit.vistaevolution.kernel.ws.xqcs.model.XQCSChkRequest;
import gov.va.oit.vistaevolution.kernel.ws.xqcs.model.XQCSChkResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@WebService(name = "XQCSChk", targetNamespace = "http://vistaevolution.va.gov")
public interface XQCSChkEndpoint {

	/**
	 * This extrinsic function returns a 1 if the user passed in is allowed to
	 * use the option passed in (and, if an RPC is passed in, the RPC is valid),
	 * or a message string explaining why the option or RPC is not allowed. If M
	 * code exists in the RULES field for a corresponding RPC, the software sets
	 * a flag and executes the field's code. If the flag is returned as less
	 * than 1, the request for use of that RPC is denied. Rules are written by
	 * the package developer and are not required.
	 * 
	 * 
	 * @param request
	 * 
	 *            Domain Object that contains All XQCS^CHK input Parameters
	 * 
	 * @return XQCSChkResponse
	 * 
	 *         Domain Object that contains XQCS^CHK output data
	 * 
	 * @throws VistaWebServiceFault
	 * 
	 */

	@WebMethod(action = "XQCSChkAction", operationName = "XQCSChk")
	public XQCSChkResponse chk(
			@WebParam(name = "XQCSChkRequest") XQCSChkRequest request)
			throws VistaWebServiceFault;
}
