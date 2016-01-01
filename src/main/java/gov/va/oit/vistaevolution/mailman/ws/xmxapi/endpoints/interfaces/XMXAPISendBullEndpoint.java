package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPISendBullRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPISendBullResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "XMXAPISendBull", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXAPISendBullEndpoint {

    @WebMethod(action = "XMXAPISendBullAction", operationName = "XMXAPISendBull")
    public XMXAPISendBullResponse sendBull(
	    @WebParam(name = "XMXAPISendBullRequest") XMXAPISendBullRequest request);

}
