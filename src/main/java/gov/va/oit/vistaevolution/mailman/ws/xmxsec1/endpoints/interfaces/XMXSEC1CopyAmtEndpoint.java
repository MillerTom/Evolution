package gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1CopyAmtRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1CopyAmtResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;


@WebService(name = "XMXSEC1CopyAmt", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXSEC1CopyAmtEndpoint {

	@WebMethod(action = "CopyAmtXMXSEC1Action", operationName = "CopyAmtXMXSEC1")
	@SOAPBinding(parameterStyle = ParameterStyle.BARE)
	public XMXSEC1CopyAmtResponse CopyAmt(@WebParam(name = "XMXSEC1CopyAmtRequest") XMXSEC1CopyAmtRequest request)
		throws VistaWebServiceFault;
}
