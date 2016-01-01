package gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1CopyRecpRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1CopyRecpResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

@WebService(name = "XMXSEC1CopyRecp", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXSEC1CopyRecpEndpoint {

	@WebMethod(action = "CopyRecpXMXSEC1Action", operationName = "CopyRecpXMXSEC1")
	@SOAPBinding(parameterStyle = ParameterStyle.BARE)
	public XMXSEC1CopyRecpResponse CopyRecp(@WebParam(name = "XMXSEC1CopyRecpRequest") XMXSEC1CopyRecpRequest request)
		throws VistaWebServiceFault;
}
