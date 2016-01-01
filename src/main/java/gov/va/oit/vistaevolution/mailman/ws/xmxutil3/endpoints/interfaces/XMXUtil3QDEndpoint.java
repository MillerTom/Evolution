package gov.va.oit.vistaevolution.mailman.ws.xmxutil3.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil3.model.XMXUtil3QDRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil3.model.XMXUtil3QDResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "XMXUtil3QD", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUtil3QDEndpoint {
    @WebMethod(action = "XMXUtil3QDAction", operationName = "XMXUtil3QD")
    public XMXUtil3QDResponse qd( @WebParam(name = "XMXUtil3QDRequest")XMXUtil3QDRequest request)
	    throws VistaWebServiceFault;

}
