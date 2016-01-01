package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPILateMsgsRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPILateMsgsResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "XMXAPILateMsgs", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXAPILateMsgsEndpoint {

	@WebMethod(action = "LateMsgsXMXAPIAction", operationName = "LateMsgsXMXAPI")
	public XMXAPILateMsgsResponse LateMsgs(@WebParam(name = "XMXAPILateMsgsRequest") XMXAPILateMsgsRequest request)
		throws VistaWebServiceFault;
}
