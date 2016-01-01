/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1OptgrpRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1OptgrpResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@WebService(name = "XMXSEC1Optgrp", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXSEC1OptgrpEndpoint {

	/**
	 * This RPC determines what the user can do at the basket or message group
	 * level.
	 * 
	 * @param request
	 * 
	 *            Request Object that contains OPTGRP^XMXSEC1 input Parameters
	 * 
	 * @return XMXSEC1OptgrpResponse
	 * 
	 *         Response Object that contains OPTGRP^XMXSEC1 output Data
	 * 
	 * 
	 * @throws VistaWebServiceFault
	 */
	@WebMethod(action = "XMXSEC1OptgrpAction", operationName = "XMXSEC1Optgrp")
	public XMXSEC1OptgrpResponse optgrp(
			@WebParam(name = "XMXSEC1OptgrpRequest") XMXSEC1OptgrpRequest request)
			throws VistaWebServiceFault;
}
