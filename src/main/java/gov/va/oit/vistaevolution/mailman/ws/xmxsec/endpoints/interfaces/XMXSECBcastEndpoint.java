package gov.va.oit.vistaevolution.mailman.ws.xmxsec.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxsec.model.XMXSECBcastRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.model.XMXSECBcastResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

@WebService(name = "XMXSECBcast", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXSECBcastEndpoint {

	@WebMethod(action = "BcastXMXSECAction", operationName = "BcastXMXSEC")
	@SOAPBinding(parameterStyle = ParameterStyle.BARE)
	public XMXSECBcastResponse Bcast(@WebParam(name = "XMXSECBcastRequest") XMXSECBcastRequest request)
		throws VistaWebServiceFault;
}