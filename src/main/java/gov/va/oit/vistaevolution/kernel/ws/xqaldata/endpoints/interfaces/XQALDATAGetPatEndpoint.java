/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xqaldata.endpoints.interfaces;

import gov.va.oit.vistaevolution.kernel.ws.xqaldata.model.XQALDATAGetPatRequest;
import gov.va.oit.vistaevolution.kernel.ws.xqaldata.model.XQALDATAGetPatResponse;
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

@WebService(name = "XQALDATAGetPat", targetNamespace = "http://vistaevolution.va.gov")
public interface XQALDATAGetPatEndpoint {

	@WebMethod(action = "XQALDATAGetPatAction", operationName = "XQALDATAGetPat")
	public XQALDATAGetPatResponse getPat(
			@WebParam(name = "XQALDATAGetPatRequest")XQALDATAGetPatRequest request)
			throws VistaWebServiceFault;
}
