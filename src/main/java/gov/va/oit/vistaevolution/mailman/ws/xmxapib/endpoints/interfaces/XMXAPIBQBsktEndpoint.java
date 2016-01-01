package gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBQBsktRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBQBsktResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "XMXAPIBQBskt", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXAPIBQBsktEndpoint {

    @WebMethod(action = "XMXAPIBQBsktAction", operationName = "XMXAPIBQBskt")
    public XMXAPIBQBsktResponse qBskt(
	    @WebParam(name = "XMXAPIBQBsktRequest") XMXAPIBQBsktRequest request);

}
