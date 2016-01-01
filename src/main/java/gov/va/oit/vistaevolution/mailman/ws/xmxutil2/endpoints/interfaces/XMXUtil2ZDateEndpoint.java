package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2DateRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2DateResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

@WebService(name = "XMXUtil2ZDate", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUtil2ZDateEndpoint {

	@WebMethod(action = "ZDateXMXUtil2Action", operationName = "ZDateXMXUtil2")
	@SOAPBinding(parameterStyle = ParameterStyle.BARE)
	public XMXUtil2DateResponse ZDate(@WebParam(name = "XMXUtil2DateRequest") XMXUtil2DateRequest request)
		throws VistaWebServiceFault;
}
