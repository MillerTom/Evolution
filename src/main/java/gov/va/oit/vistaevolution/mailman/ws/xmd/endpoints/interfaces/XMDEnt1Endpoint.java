package gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMDEnt1Request;
import gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMDResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

/**
 * <em>ENT1^XMD: Forward a Message (Address Restrictions Waived)</em><br />
 * <br />
 * <b>Reference Type: </b> Supported <br />
 * <b>Category: </b> Creating/Sending/Forwarding Messages (Classic MailMan) <br />
 * <b>IA# : </b> 10070 <br />
 * <b>Description: </b> This API forwards a message. Addressing restrictions are
 * waived. (It's as if you set XMDF.) <br />
 * <b>Format : </b> ENT1^XMD <br />
 * 
 * @author rcollins
 * 
 */
@WebService(name = "XMDEnt1", targetNamespace = "http://vistaevolution.va.gov")
public interface XMDEnt1Endpoint {

	/**
	 * 
	 * @param request
	 */
	@WebMethod(action = "XMDEnt1Action", operationName = "XMDEnt1")
	public XMDResponse ent1(
			@WebParam(name = "XMDEnt1Request") XMDEnt1Request request)
			throws VistaWebServiceFault;
}
