package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1ConvertRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1ConvertResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

@WebService(name = "XMXUTIL1Convert", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUTIL1ConvertEndpoint {

	@WebMethod(action = "ConvertXMXUTIL1Action", operationName = "ConvertXMXUTIL1")
	@SOAPBinding(parameterStyle = ParameterStyle.BARE)
	public XMXUTIL1ConvertResponse Convert(@WebParam(name = "XMXUTIL1ConvertRequest") XMXUTIL1ConvertRequest request)
		throws VistaWebServiceFault;
}
