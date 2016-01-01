package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIZapServRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIZapServResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "XMXAPIZapServ", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXAPIZapServEndpoint {

    @WebMethod(action = "XMXAPIZapServAction", operationName = "XMXAPIZapServ")
    public XMXAPIZapServResponse zapServ(
	    @WebParam(name = "XMXAPIZapServRequest") XMXAPIZapServRequest request)
	    throws VistaWebServiceFault;
}
