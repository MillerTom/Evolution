package gov.va.oit.vistaevolution.mailman.ws.xmbgrp.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmbgrp.model.XMBGRPMgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmbgrp.model.XMBGRPMgResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@WebService(name = "XMBGRPMg", targetNamespace = "http://vistaevolution.va.gov")
public interface XMBGRPMgEndpoint {

	/**
	 * 
	 * This extrinsic function creates a new mail group or adds members to an
	 * existing mail group. Only local members can be added with this API. There
	 * is no API that adds any other type of member.
	 * 
	 * @param request
	 * 
	 *            Domain Object that contains All XMBGRP^MG input Parameters
	 * 
	 * @return XMBGRPMgResponse
	 * 
	 *         Domain Object that contains XMBGRP^MG output data
	 * 
	 * @throws VistaWebServiceFault
	 */

	@WebMethod(action = "XMBGRPMgAction", operationName = "XMBGRPMg")
	public XMBGRPMgResponse mg(
			@WebParam(name = "XMBGRPMgRequest") XMBGRPMgRequest request)
			throws VistaWebServiceFault;
}