package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces;

import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFDaRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFDaResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * 
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@WebService(name = "DILFDa", targetNamespace = "http://vistaevolution.va.gov")
public interface DILFDaEndpoint {

	/**
	 * This procedure converts an IENS into an array with the structure of a
	 * DA() array.
	 * 
	 * @param request
	 * 
	 *            Domain Object that contains DILF^DA input Parameters
	 * 
	 * @return DILFDaResponse
	 * 
	 *         Domain Object that contains DILF^DA output data
	 * 
	 * @throws VistaWebServiceFault
	 */
	@WebMethod(action = "DILFDaAction", operationName = "DILFDa")
	public DILFDaResponse da(
			@WebParam(name = "DILFDaRequest") DILFDaRequest request)
			throws VistaWebServiceFault;
}