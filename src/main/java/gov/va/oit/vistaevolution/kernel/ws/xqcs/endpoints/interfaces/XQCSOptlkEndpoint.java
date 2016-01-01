/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xqcs.endpoints.interfaces;

import gov.va.oit.vistaevolution.kernel.ws.xqcs.model.XQCSOptlkRequest;
import gov.va.oit.vistaevolution.kernel.ws.xqcs.model.XQCSOptlkResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@WebService(name = "XQCSOptlk", targetNamespace = "http://vistaevolution.va.gov")
public interface XQCSOptlkEndpoint {

	/**
	 * Lookup an Option Name in the Option File (#19) and Return its IEN. The
	 * API will store in the ^TMP("XQCS",$J) global the pointer(s) to the Remote
	 * Procedure File (#8994) for all RPC’s registered to this option.
	 * 
	 * @param request
	 * 
	 *            Domain Object that contains All XQCS^OPTLK input Parameters
	 * @return XQCSOptlkResponse
	 * 
	 *         Domain Object that contains XQCS^OPTLK output data
	 * 
	 * @throws VistaWebServiceFault
	 */
	@WebMethod(action = "XQCSOptlkAction", operationName = "XQCSOptlk")
	public XQCSOptlkResponse optlk(
			@WebParam(name = "XQCSOptlkRequest") XQCSOptlkRequest request)
			throws VistaWebServiceFault;

}
