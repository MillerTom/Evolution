package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces;

import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4MADDRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4MADDResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "XUAF4MADD", targetNamespace = "http://vistaevolution.va.gov")
public interface XUAF4MADDEndpoint {

	@WebMethod(action = "XUAF4MADDAction", operationName = "XUAF4MADD")
	public XUAF4MADDResponse MADD(
			@WebParam(name = "XUAF4MADDRequest") XUAF4MADDRequest request)
			throws VistaWebServiceFault;
}