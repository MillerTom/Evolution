package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIReplyMsgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIReplyMsgResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "XMXAPIReplyMsg", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXAPIReplyMsgEndpoint {
    @WebMethod(action = "XMXAPIReplyMsgAction", operationName = "XMXAPIReplyMsg")
    public XMXAPIReplyMsgResponse replyMsg(
	    @WebParam(name = "XMXAPIReplyMsgRequest") XMXAPIReplyMsgRequest request);

}
