/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusrb2.endpoints.interfaces;

import gov.va.oit.vistaevolution.kernel.ws.xusrb2.model.XUSRB2UserinfoRequest;
import gov.va.oit.vistaevolution.kernel.ws.xusrb2.model.XUSRB2UserinfoResponse;
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
@WebService(name = "XUSRB2Userinfo", targetNamespace = "http://vistaevolution.va.gov")
public interface XUSRB2UserinfoEndpoint {

	@WebMethod(action = "XUSRB2UserinfoAction", operationName = "XUSRB2Userinfo")
	public XUSRB2UserinfoResponse userinfo(@WebParam(name = "XUSRB2UserinfoRequest") XUSRB2UserinfoRequest request) throws VistaWebServiceFault;
	
}
