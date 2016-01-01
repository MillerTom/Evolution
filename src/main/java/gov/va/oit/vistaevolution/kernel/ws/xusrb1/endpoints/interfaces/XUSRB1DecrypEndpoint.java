/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusrb1.endpoints.interfaces;

import gov.va.oit.vistaevolution.kernel.ws.xusrb1.model.XUSRB1DecrypRequest;
import gov.va.oit.vistaevolution.kernel.ws.xusrb1.model.XUSRB1DecrypResponse;
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

@WebService(name = "XUSRB1Decryp", targetNamespace = "http://vistaevolution.va.gov")
public interface XUSRB1DecrypEndpoint {

	@WebMethod(action = "XUSRB1DecrypAction", operationName = "XUSRB1Decryp")
	@SOAPBinding(parameterStyle = ParameterStyle.BARE)
	public XUSRB1DecrypResponse decryp(
			@WebParam(name = "XUSRB1DecrypRequest")XUSRB1DecrypRequest request)
			throws VistaWebServiceFault;
}
