package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2ZNodeRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2ZNodeResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

@WebService(name = "XMXUtil2ZNode", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUtil2ZNodeEndpoint {

	@WebMethod(action = "ZNodeXMXUtil2Action", operationName = "ZNodeXMXUtil2")
	@SOAPBinding(parameterStyle = ParameterStyle.BARE)
	public XMXUtil2ZNodeResponse ZNode(@WebParam(name = "XMXUtil2ZNodeRequest") XMXUtil2ZNodeRequest request)
		throws VistaWebServiceFault;
}
