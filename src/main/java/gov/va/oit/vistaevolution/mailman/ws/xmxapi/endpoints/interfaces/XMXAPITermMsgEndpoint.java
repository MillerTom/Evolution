package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPITermMsgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPITermMsgResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "XMXAPITermMsg", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXAPITermMsgEndpoint {
    @WebMethod(action = "XMXAPITermMsgAction", operationName = "XMXAPITermMsg")
    public XMXAPITermMsgResponse termMsg(
	    @WebParam(name = "XMXAPITermMsgRequest") XMXAPITermMsgRequest request);

}
