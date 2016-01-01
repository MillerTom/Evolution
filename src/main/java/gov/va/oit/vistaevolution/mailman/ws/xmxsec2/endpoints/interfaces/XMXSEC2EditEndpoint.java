package gov.va.oit.vistaevolution.mailman.ws.xmxsec2.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxsec2.model.XMXSEC2EditRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec2.model.XMXSEC2EditResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

@WebService(name = "XMXSEC2Edit", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXSEC2EditEndpoint {

	@WebMethod(action = "EditXMXSEC2Action", operationName = "EditXMXSEC2")
	@SOAPBinding(parameterStyle = ParameterStyle.BARE)
	public XMXSEC2EditResponse Edit(@WebParam(name = "XMXSEC2EditRequest") XMXSEC2EditRequest request)
		throws VistaWebServiceFault;
}
