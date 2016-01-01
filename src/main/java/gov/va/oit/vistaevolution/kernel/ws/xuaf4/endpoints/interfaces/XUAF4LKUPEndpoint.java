package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces;

import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4LKUPRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4LKUPResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "XUAF4LKUP", targetNamespace = "http://vistaevolution.va.gov")
public interface XUAF4LKUPEndpoint {

	/**
	 * 
	 * @param request
	 * @return
	 * @throws VistaWebServiceFault
	 */
	@WebMethod(action = "XUAF4LKUPAction", operationName = "XUAF4LKUP")
	public XUAF4LKUPResponse LKUP(
			@WebParam(name = "XUAF4LKUPRequest") XUAF4LKUPRequest request)
			throws VistaWebServiceFault;
}