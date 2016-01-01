package gov.va.oit.vistaevolution.mailman.ws.xmxutil3.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil3.model.XMXUtil3QNRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil3.model.XMXUtil3QNResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "XMXUtil3QN", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUtil3QNEndpoint {
    @WebMethod(action = "XMXUtil3QNAction", operationName = "XMXUtil3QN")
    public XMXUtil3QNResponse qn(
	    @WebParam(name = "XMXUtil3QNRequest") XMXUtil3QNRequest request)
	    throws VistaWebServiceFault;

}
