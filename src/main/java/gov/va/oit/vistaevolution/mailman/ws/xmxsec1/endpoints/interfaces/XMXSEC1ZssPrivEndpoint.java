package gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1ZssPrivRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1ZssPrivResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "XMXSEC1ZssPriv", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXSEC1ZssPrivEndpoint {

	@WebMethod(action = "ZssPrivXMXSEC1Action", operationName = "ZssPrivXMXSEC1")
	public XMXSEC1ZssPrivResponse ZssPriv(@WebParam(name = "XMXSEC1ZssPrivRequest") XMXSEC1ZssPrivRequest request)
		throws VistaWebServiceFault;
}
