package gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1CopyLimsRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1CopyLimsResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

@WebService(name = "XMXSEC1CopyLims", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXSEC1CopyLimsEndpoint {

	@WebMethod(action = "CopyLimsXMXSEC1Action", operationName = "CopyLimsXMXSEC1")
	@SOAPBinding(parameterStyle = ParameterStyle.BARE)
	public XMXSEC1CopyLimsResponse CopyLims(@WebParam(name = "XMXSEC1CopyLimsRequest") XMXSEC1CopyLimsRequest request)
		throws VistaWebServiceFault;
}
