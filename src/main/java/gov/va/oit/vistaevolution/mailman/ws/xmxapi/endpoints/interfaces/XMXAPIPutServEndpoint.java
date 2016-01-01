package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIPutServRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIPutServResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "XMXAPIPutServ", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXAPIPutServEndpoint {

    @WebMethod(action = "XMXAPIPutServAction", operationName = "XMXAPIPutServ")
    public XMXAPIPutServResponse putMsg(
	    @WebParam(name = "XMXAPIPutServRequest") XMXAPIPutServRequest request);

}
