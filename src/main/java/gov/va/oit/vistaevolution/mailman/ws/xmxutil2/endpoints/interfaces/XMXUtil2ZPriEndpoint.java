package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2ZPriRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2ZPriResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "XMXUtil2ZPri", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUtil2ZPriEndpoint {

	@WebMethod(action = "ZPriXMXUtil2Action", operationName = "ZPriXMXUtil2")
	public XMXUtil2ZPriResponse ZPri(@WebParam(name = "XMXUtil2ZPriRequest") XMXUtil2ZPriRequest request)
		throws VistaWebServiceFault;
}
