/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2BsktRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2BsktResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

/**
 * @author Christopher Schuck
 *
 */
@WebService(name = "XMXUTIL2Bskt", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUTIL2BsktEndpoint {

	@WebMethod(action = "BsktXMXUTIL2Action", operationName = "BsktXMXUTIL2")
	public XMXUTIL2BsktResponse bskt(
			@WebParam(name = "XMXUTIL2BsktRequest") XMXUTIL2BsktRequest request)
			throws VistaWebServiceFault;
	
}
