package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces;

import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4F4Request;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4F4Response;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "XUAF4F4", targetNamespace = "http://vistaevolution.va.gov")
public interface XUAF4F4Endpoint {

	/*
	 * This procedure returns the Internal Entry Number (IEN) and other
	 * institution data, including historical information, for a given STATION
	 * NUMBER (#99) in the INSTITUTION file (#4).
	 * 
	 * Callers will supply the following parameters in a domain request model:
	 * sta (required): The VA Station Number to search the file for array
	 * (required): a reference array which will be used to return values flag
	 * (optional): specifying to search A - active entries or M - Medical
	 * Facilities date (optional): VA FileMan internal date
	 * 
	 * @param F4Request
	 * 
	 * Domain Object that contains All XUAF4^F4 input Parameters
	 * 
	 * @return F4Response
	 * 
	 * Domain Object that contains XUAF4^F4 output data
	 * 
	 * @throws VistaWebServiceFault
	 */
	@WebMethod(action = "XUAF4F4Action", operationName = "F4XUAF4")
	public XUAF4F4Response F4(
			@WebParam(name = "XUAF4F4Request") XUAF4F4Request request)
			throws VistaWebServiceFault;

}
