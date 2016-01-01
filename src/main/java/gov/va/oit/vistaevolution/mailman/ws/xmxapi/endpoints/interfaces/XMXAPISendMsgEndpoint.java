package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPISendMsgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPISendMsgResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "XMXAPISendMsg", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXAPISendMsgEndpoint {

    @WebMethod(action = "XMXAPISendMsgAction", operationName = "XMXAPISendMsg")
    public XMXAPISendMsgResponse sendMsg(
	    @WebParam(name = "XMXAPISendMsgRequest") XMXAPISendMsgRequest request);

}
