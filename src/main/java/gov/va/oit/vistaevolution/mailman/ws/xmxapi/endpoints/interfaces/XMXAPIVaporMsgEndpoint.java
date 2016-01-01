package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIVaporMsgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIVaporMsgResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "XMXAPIVaporMsg", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXAPIVaporMsgEndpoint {
    @WebMethod(action = "XMXAPIVaporMsgAction", operationName = "XMXAPIVaporMsg")
    public XMXAPIVaporMsgResponse vaporMsg(
	    @WebParam(name = "XMXAPIVaporMsgRequest") XMXAPIVaporMsgRequest request);

}
