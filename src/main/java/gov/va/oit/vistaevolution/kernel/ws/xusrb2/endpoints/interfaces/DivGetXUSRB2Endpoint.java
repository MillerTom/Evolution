/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusrb2.endpoints.interfaces;

import gov.va.oit.vistaevolution.kernel.ws.xusrb2.model.DivGetXUSRB2Request;
import gov.va.oit.vistaevolution.kernel.ws.xusrb2.model.DivGetXUSRB2Response;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Stephen Combs <stephen.combs@synaptekcorp.com>
 *
 */
@WebService(name = "DivGetXUSRB2", targetNamespace = "http://vistaevolution.va.gov")
public interface DivGetXUSRB2Endpoint {

	@WebMethod(action = "DivGetXUSRB2Action", operationName = "DivGetXUSRB2")
	public DivGetXUSRB2Response divget(@WebParam(name = "DivGetXUSRB2Request") DivGetXUSRB2Request request) throws VistaWebServiceFault;
	
}
