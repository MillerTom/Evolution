package gov.va.oit.vistaevolution.mailman.ws.xmxutil3.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil3.model.XMXUtil3QXRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil3.model.XMXUtil3QXResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "XMXUtil3QX", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUtil3QXEndpoint {
    @WebMethod(action = "XMXUtil3QXAction", operationName = "XMXUtil3QX")
    public XMXUtil3QXResponse qx(
	    @WebParam(name = "XMXUtil3QXRequest") XMXUtil3QXRequest request)
	    throws VistaWebServiceFault;

}
