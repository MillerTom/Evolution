package gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBListMsgsRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBListMsgsResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "XMXAPIBListMsgs", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXAPIBListMsgsEndpoint {

	@WebMethod(action = "ListMsgsXMXAPIBAction", operationName = "ListMsgsXMXAPIB")
	public XMXAPIBListMsgsResponse ListMsgs(@WebParam(name = "XMXAPIBListMsgsRequest") XMXAPIBListMsgsRequest request)
		throws VistaWebServiceFault;
}
