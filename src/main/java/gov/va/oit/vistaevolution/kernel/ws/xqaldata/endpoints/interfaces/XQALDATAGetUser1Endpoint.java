/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xqaldata.endpoints.interfaces;

import gov.va.oit.vistaevolution.kernel.ws.xqaldata.model.XQALDATAGetUser1Request;
import gov.va.oit.vistaevolution.kernel.ws.xqaldata.model.XQALDATAGetUser1Response;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Leisa Martella
 * 
 */

@WebService(name = "XQALDATAGetUser1", targetNamespace = "http://vistaevolution.va.gov")
public interface XQALDATAGetUser1Endpoint {

	@WebMethod(action = "XQALDATAGetUser1Action", operationName = "XQALDATAGetUser1")
	public XQALDATAGetUser1Response getUser1(
			@WebParam(name = "XQALDATAGetUser1Request")XQALDATAGetUser1Request request)
			throws VistaWebServiceFault;
}
