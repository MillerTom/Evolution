package gov.va.oit.vistaevolution.mailman.ws.xmxutil3.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil3.model.XMXUtil3QLRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil3.model.XMXUtil3QLResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "XMXUtil3QL", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUtil3QLEndpoint {

    @WebMethod(action = "XMXUtil3QLAction", operationName = "XMXUtil3QL")
    public XMXUtil3QLResponse ql(
	    @WebParam(name = "XMXUtil3QLRequest") XMXUtil3QLRequest request)
	    throws VistaWebServiceFault;

}
