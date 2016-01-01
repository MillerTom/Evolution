package gov.va.oit.vistaevolution.kernel.ws.xusrb.endpoints.interfaces;

import gov.va.oit.vistaevolution.kernel.ws.xusrb.model.XUSRBCheckAVRequest;
import gov.va.oit.vistaevolution.kernel.ws.xusrb.model.XUSRBCheckAVResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * This extrinsic function checks an Access/Verify code 
 * pair (delimited by a semi-colon) and returns whether 
 * or not it is a valid pair.
 * @author Stephen Combs<stephen.combs@synaptekcorp.com>
 * 
 */
@WebService(name = "XUSRBCheckAV", targetNamespace = "http://vistaevolution.va.gov")
public interface XUSRBCheckAVEndpoint {
	/**
	 * This API validates a VistALink user's credentials for signon to M.
	 * 
	 * @param request
	 * 
	 *            Domain Object that contains All XUSRB^CHECKAV input Parameters
	 * @return XUSRBCheckAVResponse
	 * 
	 *         Domain Object that contains XUSRB^CHECKAV output data
	 * 
	 * @throws VistaWebServiceFault
	 */
	@WebMethod(action = "CheckAVXUSRBAction", operationName = "CheckAVXUSRB")
	public XUSRBCheckAVResponse checkAV(
			@WebParam(name = "XUSRBCheckAVRequest") XUSRBCheckAVRequest request)
			throws VistaWebServiceFault;
}
