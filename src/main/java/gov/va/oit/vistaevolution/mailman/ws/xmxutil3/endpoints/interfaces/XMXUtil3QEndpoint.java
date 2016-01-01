package gov.va.oit.vistaevolution.mailman.ws.xmxutil3.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil3.model.XMXUtil3QRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil3.model.XMXUtil3QResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "XMXUtil3Q", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUtil3QEndpoint {

    @WebMethod(action = "XMXUtil3QAction", operationName = "XMXUtil3Q")
    public XMXUtil3QResponse q(
	    @WebParam(name = "XMXUtil3QRequest") XMXUtil3QRequest request)
	    throws VistaWebServiceFault;

}
