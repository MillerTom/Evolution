package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIAnsrMsgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIAnsrMsgResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "XMXAPIAnsrMsg", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXAPIAnsrMsgEndpoint {
    @WebMethod(action = "XMXAPIAnsrMsgAction", operationName = "XMXAPIAnsrMsg")
    public XMXAPIAnsrMsgResponse ansrMsg(
	    @WebParam(name = "XMXAPIAnsrMsgRequest") XMXAPIAnsrMsgRequest request)
	    throws VistaWebServiceFault;

}
