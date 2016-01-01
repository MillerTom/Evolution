package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1CtrlRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1CtrlResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

@WebService(name = "XMXUTIL1Ctrl", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUTIL1CtrlEndpoint {

	@WebMethod(action = "CtrlXMXUTIL1Action", operationName = "CtrlXMXUTIL1")
	@SOAPBinding(parameterStyle = ParameterStyle.BARE)
	public XMXUTIL1CtrlResponse Ctrl(@WebParam(name = "XMXUTIL1CtrlRequest") XMXUTIL1CtrlRequest request)
		throws VistaWebServiceFault;
}
