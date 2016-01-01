/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints.interfaces;

import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLAhistoryRequest;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLAhistoryResponse;
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

@WebService(name = "XQALBUTLAhistory", targetNamespace = "http://vistaevolution.va.gov")
public interface XQALBUTLAhistoryEndpoint {

	@WebMethod(action = "XQALBUTLAhistoryAction", operationName = "XQALBUTLAhistory")
	public XQALBUTLAhistoryResponse ahistory(
			@WebParam(name = "XQALBUTLAhistoryRequest")XQALBUTLAhistoryRequest request)
			throws VistaWebServiceFault;
}
