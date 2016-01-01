package gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBQMBoxRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBQMBoxResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "XMXAPIBQMBox", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXAPIBQMBoxEndpoint {
    @WebMethod(action = "XMXAPIBQMBoxAction", operationName = "XMXAPIBQMBox")
    public XMXAPIBQMBoxResponse qMBox(
	    @WebParam(name = "XMXAPIBQMBoxRequest") XMXAPIBQMBoxRequest request);

}
