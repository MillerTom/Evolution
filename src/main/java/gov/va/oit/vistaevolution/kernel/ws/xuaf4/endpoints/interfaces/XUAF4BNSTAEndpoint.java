package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces;

import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4BNSTARequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4BNSTAResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "XUAF4BNSTA", targetNamespace = "http://vistaevolution.va.gov")
public interface XUAF4BNSTAEndpoint {

	/**
	 * This extrinsic function returns Billing Facility Name located in the
	 * INSTITUTION file (#4).
	 * 
	 * 
	 * @param request
	 * 
	 *            Request Object that contains "XUAF4^BNSTA" input Parameters
	 * 
	 * @return XUAF4BNSTAResponse
	 * 
	 *         Response Object that contains "XUAF4^BNSTA" output Data
	 * 
	 * 
	 * @throws VistaWebServiceFault
	 */
	@WebMethod(action = "XUAF4BNSTAAction", operationName = "BNSTAXUAF4")
	public XUAF4BNSTAResponse BNSTA(
			@WebParam(name = "XUAF4BNSTARequest") XUAF4BNSTARequest request)
			throws VistaWebServiceFault;
}
