package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIVSubjRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIVSubjResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "XMXAPIVSubj", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXAPIVSubjEndpoint {

    @WebMethod(action = "XMXAPIVSubjAction", operationName = "XMXAPIVSubj")
    public XMXAPIVSubjResponse vsubj(
	    @WebParam(name = "XMXAPIVSubjRequest") XMXAPIVSubjRequest request);

}
