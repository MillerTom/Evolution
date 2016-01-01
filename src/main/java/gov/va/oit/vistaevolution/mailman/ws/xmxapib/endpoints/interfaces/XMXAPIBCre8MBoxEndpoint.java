package gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBCre8MBoxRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBCre8MBoxResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "XMXAPIBCre8MBox", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXAPIBCre8MBoxEndpoint {

    @WebMethod(action = "XMXAPIBCre8MBoxAction", operationName = "XMXAPIBCre8MBox")
    public XMXAPIBCre8MBoxResponse cr8MBox(
	    @WebParam(name = "XMXAPIBCre8MBoxRequest") XMXAPIBCre8MBoxRequest request);

}
