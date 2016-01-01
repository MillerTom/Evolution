/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xma1c.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xma1c.model.XMA1CSetsbRequest;
import gov.va.oit.vistaevolution.mailman.ws.xma1c.model.XMA1CSetsbResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Christopher Schuck
 *
 */
@WebService(name = "XMA1CSetsb", targetNamespace = "http://vistaevolution.va.gov")
public interface XMA1CSetsbEndpoint {
	
	@WebMethod(action = "XMA1CSetsbAction", operationName = "XMA1CSetsb")
	public XMA1CSetsbResponse setsb(@WebParam(name = "XMA1CSetsbRequest") XMA1CSetsbRequest request)
			throws VistaWebServiceFault;
}
