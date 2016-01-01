/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusrb1.endpoints.interfaces;

import gov.va.oit.vistaevolution.kernel.ws.xusrb1.model.XUSRB1EncrypRequest;
import gov.va.oit.vistaevolution.kernel.ws.xusrb1.model.XUSRB1EncrypResponse;
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

@WebService(name = "XUSRB1Encryp", targetNamespace = "http://vistaevolution.va.gov")
public interface XUSRB1EncrypEndpoint {

	@WebMethod(action = "XUSRB1EncrypAction", operationName = "XUSRB1Encryp")
	@SOAPBinding(parameterStyle = ParameterStyle.BARE)
	public XUSRB1EncrypResponse encryp(
			@WebParam(name = "XUSRB1EncrypRequest")XUSRB1EncrypRequest request)
			throws VistaWebServiceFault;
}
