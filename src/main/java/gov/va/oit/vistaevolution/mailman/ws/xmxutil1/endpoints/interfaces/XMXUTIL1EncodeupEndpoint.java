package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1EncodeupRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1EncodeupResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * 
 * @author Bill Blackmon <bill.blackmon@medsphere.com>
 * 
 **/

@WebService(name = "XMXUTIL1Encodeup", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUTIL1EncodeupEndpoint {
	
	
	
	@WebMethod(action = "XMXUTIL1EncodeupAction", operationName = "XMXUTIL1Encodeup")
	
	/**
	 * @param request
	 * @return XMXUTIL1EncodeupResponse
	 */
	public XMXUTIL1EncodeupResponse encodeUp(XMXUTIL1EncodeupRequest request)
			throws VistaWebServiceFault;
	
	

}	// end class
