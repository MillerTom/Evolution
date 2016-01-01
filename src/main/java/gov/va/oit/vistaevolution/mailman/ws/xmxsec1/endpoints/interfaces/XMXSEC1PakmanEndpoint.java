/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1PakmanRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1PakmanResponse;
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

@WebService(name = "XMXSEC1Pakman", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXSEC1PakmanEndpoint {

	@WebMethod(action = "XMXSEC1PakmanAction", operationName = "XMXSEC1Pakman")
	public XMXSEC1PakmanResponse xmxsec1Pakman(
			@WebParam(name = "XMXSEC1Pakman") XMXSEC1PakmanRequest request)
			throws VistaWebServiceFault;
}
