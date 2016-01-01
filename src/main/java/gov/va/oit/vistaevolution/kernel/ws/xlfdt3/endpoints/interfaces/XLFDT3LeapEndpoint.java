/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xlfdt3.endpoints.interfaces;

import gov.va.oit.vistaevolution.kernel.ws.xlfdt3.model.XLFDT3LeapRequest;
import gov.va.oit.vistaevolution.kernel.ws.xlfdt3.model.XLFDT3LeapResponse;
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

@WebService(name = "XLFDT3Leap", targetNamespace = "http://vistaevolution.va.gov")
public interface XLFDT3LeapEndpoint {

	@WebMethod(action = "XLFDT3LeapAction", operationName = "XLFDT3Leap")
	public XLFDT3LeapResponse leap(
			@WebParam(name = "XLFDT3LeapRequest")XLFDT3LeapRequest request)
			throws VistaWebServiceFault;
}
