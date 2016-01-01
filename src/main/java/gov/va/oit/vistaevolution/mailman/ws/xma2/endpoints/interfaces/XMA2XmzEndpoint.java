/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xma2.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xma2.model.XMA2XmzRequest;
import gov.va.oit.vistaevolution.mailman.ws.xma2.model.XMA2XmzResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

/**
 * @author Leisa Martella
 * 
 */

@WebService(name = "XMA2Xmz", targetNamespace = "http://vistaevolution.va.gov")
public interface XMA2XmzEndpoint {

	@WebMethod(action = "XMA2XmzAction", operationName = "XMA2Xmz")
	public XMA2XmzResponse xmz(
			@WebParam(name = "XMA2XmzRequest") XMA2XmzRequest request)
			throws VistaWebServiceFault;
}
