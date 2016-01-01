package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces;

import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFDtRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFDtResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * 
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@WebService(name = "DILFDt", targetNamespace = "http://vistaevolution.va.gov")
public interface DILFDtEndpoint {

	/**
	 * 
	 * This procedure converts a user-supplied value into VA FileMan's internal
	 * date format and (optionally) into the standard VA FileMan external,
	 * readable date format.
	 * 
	 * @param request
	 * 
	 *            Domain Object that contains DILF^DT input Parameters
	 * 
	 * @return DILFDtResponse
	 * 
	 *         Domain Object that contains DILF^DT output data
	 * 
	 * @throws VistaWebServiceFault
	 */
	@WebMethod(action = "DILFDtAction", operationName = "DILFDt")
	public DILFDtResponse dt(
			@WebParam(name = "DILFDtRequest") DILFDtRequest request)
			throws VistaWebServiceFault;
}
