/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xma1b.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xma1b.model.XMA1BS2Request;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.model.XMA1BS2Response;
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
@WebService(name = "XMA1BS2", targetNamespace = "http://vistaevolution.va.gov")
public interface XMA1BS2Endpoint {
	
	@WebMethod(action = "XMA1BS2Action", operationName = "XMA1BS2")
	@SOAPBinding(parameterStyle = ParameterStyle.BARE)
	public XMA1BS2Response s2(@WebParam(name = "XMA1BS2Request") XMA1BS2Request request) throws VistaWebServiceFault;
	
}
