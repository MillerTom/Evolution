package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2ZFromRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2ZFromResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

@WebService(name = "XMXUtil2ZFrom", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUtil2ZFromEndpoint {

	@WebMethod(action = "ZFromXMXUtil2Action", operationName = "ZFromXMXUtil2")
	@SOAPBinding(parameterStyle = ParameterStyle.BARE)
	public XMXUtil2ZFromResponse ZFrom(@WebParam(name = "XMXUtil2FromRequest") XMXUtil2ZFromRequest request)
		throws VistaWebServiceFault;
}
