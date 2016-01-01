package gov.va.oit.vistaevolution.mailman.ws.xmbgrp.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmbgrp.model.XMBGRPDmRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmbgrp.model.XMBGRPDmResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@WebService(name = "XMBGRPDm", targetNamespace = "http://vistaevolution.va.gov")
public interface XMBGRPDmEndpoint {

	/**
	 * 
	 * This extrinsic function deletes local members from a mail group. Only
	 * local members can be deleted with this API. There is no API that deletes
	 * any other type of member.
	 * 
	 * @param request
	 * 
	 *            Domain Object that contains All XMBGRP^DM input Parameters
	 * 
	 * @return XMBGRPDmResponse
	 * 
	 *         Domain Object that contains XMBGRP^DM output data
	 * 
	 * @throws VistaWebServiceFault
	 */

	@WebMethod(action = "XMBGRPDmAction", operationName = "XMBGRPDm")
	public XMBGRPDmResponse dm(
			@WebParam(name = "XMBGRPDmRequest") XMBGRPDmRequest request)
			throws VistaWebServiceFault;
}