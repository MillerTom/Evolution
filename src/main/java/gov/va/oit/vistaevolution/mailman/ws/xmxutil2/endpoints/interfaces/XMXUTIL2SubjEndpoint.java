/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2SubjRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2SubjResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Christopher Schuck
 *
 */
@WebService(name = "XMXUTIL2Subj", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUTIL2SubjEndpoint {

	@WebMethod(action = "XMXUTIL2SubjAction", operationName = "XMXUTIL2Subj")
	public XMXUTIL2SubjResponse subj(
			@WebParam(name = "XMXUTIL2SubjRequest") XMXUTIL2SubjRequest request)
			throws VistaWebServiceFault;

}
