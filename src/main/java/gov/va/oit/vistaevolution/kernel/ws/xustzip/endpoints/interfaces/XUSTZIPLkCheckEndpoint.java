/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xustzip.endpoints.interfaces;

import gov.va.oit.vistaevolution.kernel.ws.xustzip.model.XUSTZIPLkCheckRequest;
import gov.va.oit.vistaevolution.kernel.ws.xustzip.model.XUSTZIPLkCheckResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Leisa Martella
 * 
 */

@WebService(name = "XUSTZIPLkCheck", targetNamespace = "http://vistaevolution.va.gov")
public interface XUSTZIPLkCheckEndpoint {

	@WebMethod(action = "XUSTZIPLkCheckAction", operationName = "XUSTZIPLkCheck")
	public XUSTZIPLkCheckResponse lkCheck(
			@WebParam(name = "XUSTZIPLkCheck")XUSTZIPLkCheckRequest request)
			throws VistaWebServiceFault;
}
