/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusnpi.endpoints.interfaces;

import gov.va.oit.vistaevolution.kernel.ws.xusnpi.model.XUSNPIChkDgtRequest;
import gov.va.oit.vistaevolution.kernel.ws.xusnpi.model.XUSNPIChkDgtResponse;
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

@WebService(name = "XUSNPIChkDgt", targetNamespace = "http://vistaevolution.va.gov")
public interface XUSNPIChkDgtEndpoint {

	@WebMethod(action = "XUSNPIChkDgtAction", operationName = "XUSNPIChkDgt")
	public XUSNPIChkDgtResponse chkDgt(
			@WebParam(name = "XUSNPIChkDgtRequest")XUSNPIChkDgtRequest request)
			throws VistaWebServiceFault;
}
