package gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBListBsktRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBListBsktResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "XMXAPIBListBskt", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXAPIBListBsktEndpoint {

	@WebMethod(action = "ListBsktXMXAPIBAction", operationName = "ListBsktXMXAPIB")
	public XMXAPIBListBsktResponse ListBskt(@WebParam(name = "XMXAPIBListBsktRequest") XMXAPIBListBsktRequest request)
		throws VistaWebServiceFault;
}
