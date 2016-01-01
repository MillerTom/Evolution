package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1GMTDiffRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1GMTDiffResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * 
 * @author Bill Blackmon <bill.blackmon@medsphere.com>
 * 
 **/

@WebService(name = "XMXUTIL1GMTDiff", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUTIL1GMTDiffEndpoint {

	/**
	 * @param request
	 * @return XMXUTIL1GMTDiffResponse
	 */

	@WebMethod(action = "XMXUTIL1GMTDiffAction", operationName = "XMXUTIL1GMTDiff")
	public XMXUTIL1GMTDiffResponse gmtDiff(XMXUTIL1GMTDiffRequest request) throws VistaWebServiceFault;

} 
