package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces;

import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFCrefRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFCrefResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * 
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@WebService(name = "DILFCref", targetNamespace = "http://vistaevolution.va.gov")
public interface DILFCrefEndpoint {

	/**
	 * This extrinsic function converts the traditional open-root format to the
	 * closed-root format used by subscript indirection. It converts an ending
	 * comma to a close parenthesis. If the last character is an open
	 * parenthesis, the last character is dropped.
	 * 
	 * @param request
	 * 
	 *            Domain Object that contains DILF^CREF input Parameter
	 * 
	 * @return DILFCrefResponse
	 * 
	 *         Domain Object that contains DILF^CREF output data
	 * 
	 * @throws VistaWebServiceFault
	 */
	@WebMethod(action = "DILFCrefAction", operationName = "DILFCref")
	public DILFCrefResponse cref(
			@WebParam(name = "DILFCrefRequest") DILFCrefRequest request)
			throws VistaWebServiceFault;

}
