package gov.va.oit.vistaevolution.kernel.ws.xusrb.endpoints.interfaces;

import gov.va.oit.vistaevolution.kernel.ws.xusrb.model.XUSRBValidAVRequest;
import gov.va.oit.vistaevolution.kernel.ws.xusrb.model.XUSRBValidAVResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@WebService(name = "XUSRBValidAV", targetNamespace = "http://vistaevolution.va.gov")
public interface XUSRBValidAVEndpoint {
	/**
	 * This API validates a VistALink user's credentials for signon to M.
	 * 
	 * @param request
	 * 
	 *            Domain Object that contains All XUSRB^VALIDAV input Parameters
	 * @return XUSRBValidAVResponse
	 * 
	 *         Domain Object that contains XUSRB^VALIDAV output data
	 * 
	 * @throws VistaWebServiceFault
	 */
	@WebMethod(action = "XUSRBValidAVAction", operationName = "XUSRBValidAV")
	public XUSRBValidAVResponse validAV(
			@WebParam(name = "XUSRBValidAVRequest") XUSRBValidAVRequest request)
			throws VistaWebServiceFault;
}
