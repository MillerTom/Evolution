package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1DecodeUpRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1DecodeUpResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

@WebService(name = "XMXUTIL1DecodeUp", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUTIL1DecodeUpEndpoint {

	@WebMethod(action = "DecodeUpXMXUTIL1Action", operationName = "DecodeUpXMXUTIL1")
	@SOAPBinding(parameterStyle = ParameterStyle.BARE)
	public XMXUTIL1DecodeUpResponse DecodeUp(@WebParam(name = "XMXUTIL1DecodeUpRequest") XMXUTIL1DecodeUpRequest request)
		throws VistaWebServiceFault;
}