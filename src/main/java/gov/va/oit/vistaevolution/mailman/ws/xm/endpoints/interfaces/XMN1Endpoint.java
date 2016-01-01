/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xm.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xm.model.XMN1Request;
import gov.va.oit.vistaevolution.mailman.ws.xm.model.XMN1Response;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;


/**
 * @author Stephen Combs <Stephen.Combs@synaptekcorp.com>
 *
 */
@WebService(name = "XMN1", targetNamespace = "http://vistaevolution.va.gov")
public interface XMN1Endpoint {

	@WebMethod(action = "N1XMAction", operationName = "N1XM")
	public XMN1Response n1(
			@WebParam(name = "XMN1Request") XMN1Request request)
			throws VistaWebServiceFault;

}
