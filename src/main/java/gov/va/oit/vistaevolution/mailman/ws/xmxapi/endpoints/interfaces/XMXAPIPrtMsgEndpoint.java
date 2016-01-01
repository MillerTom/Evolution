package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIPrtMsgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIPrtMsgResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "XMXAPIPrtMsg", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXAPIPrtMsgEndpoint {

    @WebMethod(action = "XMXAPIPrtMsgAction", operationName = "XMXAPIPrtMsg")
    public XMXAPIPrtMsgResponse prtMsg(
	    @WebParam(name = "XMXAPIPrtMsgRequest") XMXAPIPrtMsgRequest request)
	    throws VistaWebServiceFault;
}
