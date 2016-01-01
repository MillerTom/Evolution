package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPITaskBullRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPITaskBullResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "XMXAPITaskBull", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXAPITaskBullEndpoint {

	@WebMethod(action = "XMXAPITaskBullAction", operationName = "XMXAPITaskBull")
	public XMXAPITaskBullResponse taskBulletin(@WebParam(name = "XMXAPITaskBullRequest") XMXAPITaskBullRequest request);

}
