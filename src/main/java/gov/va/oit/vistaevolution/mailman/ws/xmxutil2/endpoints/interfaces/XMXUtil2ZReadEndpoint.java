package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2ZReadRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2ZReadResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "XMXUtil2ZRead", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUtil2ZReadEndpoint {

	@WebMethod(action = "ZReadXMXUtil2Action", operationName = "ZReadXMXUtil2")
	public XMXUtil2ZReadResponse ZRead(@WebParam(name = "XMXUtil2ZReadRequest") XMXUtil2ZReadRequest request)
		throws VistaWebServiceFault;
}
