package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPICre8XMZRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPICre8XMZResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "XMXAPICre8XMZ", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXAPICre8XMZEndpoint {
    @WebMethod(action = "XMXAPICre8XMZAction", operationName = "XMXAPICre8XMZ")
    public XMXAPICre8XMZResponse cre8Xmz(
	    @WebParam(name = "XMXAPICre8XMZRequest") XMXAPICre8XMZRequest request);

}
