package gov.va.oit.vistaevolution.fileman.ws.ddr2.endpoints.interfaces;

import gov.va.oit.vistaevolution.fileman.ws.ddr2.model.DDR2Find1CRequest;
import gov.va.oit.vistaevolution.fileman.ws.ddr2.model.DDR2Find1CResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Leisa Martella
 * 
 */

@WebService(name = "DDR2Find1C", targetNamespace = "http://vistaevolution.va.gov")
public interface DDR2Find1CEndpoint {

	@WebMethod(action="DDR2Find1C", operationName="DDR2Find1C")
	public DDR2Find1CResponse find1C(
			@WebParam(name = "DDR2Find1CRequest") DDR2Find1CRequest request)
			throws VistaWebServiceFault;
}
