/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints.interfaces;

import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLAlertDatRequest;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLAlertDatResponse;
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

@WebService(name = "XQALBUTLAlertDat", targetNamespace = "http://vistaevolution.va.gov")
public interface XQALBUTLAlertDatEndpoint {

	@WebMethod(action = "XQALBUTLAlertDatAction", operationName = "XQALBUTLAlertDat")
	public XQALBUTLAlertDatResponse alertDat(
			@WebParam(name = "XQALBUTLAlertDatRequest")XQALBUTLAlertDatRequest request)
			throws VistaWebServiceFault;
}
