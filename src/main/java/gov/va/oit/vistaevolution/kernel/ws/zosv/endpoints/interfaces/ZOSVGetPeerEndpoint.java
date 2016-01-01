/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.zosv.endpoints.interfaces;

import gov.va.oit.vistaevolution.kernel.ws.zosv.model.ZOSVGetPeerRequest;
import gov.va.oit.vistaevolution.kernel.ws.zosv.model.ZOSVGetPeerResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Stephen Combs <stephen.combs@synaptekcorp.com>
 *
 */
@WebService(name = "ZosvGetPeer", targetNamespace = "http://vistaevolution.va.gov")
public interface ZOSVGetPeerEndpoint {

	@WebMethod(action = "ZOSVGetPeerAction", operationName = "GetPeerZOSV")
	public ZOSVGetPeerResponse getPeer( 
			@WebParam(name="ZOSVGetPeerRequest") ZOSVGetPeerRequest request) 
			throws VistaWebServiceFault;
	
}
