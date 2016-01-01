package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces;

import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFValuesRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFValuesResponse;
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
@WebService(name = "DILFValues", targetNamespace = "http://vistaevolution.va.gov")
public interface DILFValuesEndpoint {
	/**
	 * 
	 * @param request
	 */
	@WebMethod(action = "DILFValuesAction", operationName = "DILFValues")
	public DILFValuesResponse values(
			@WebParam(name = "DILFValuesRequest") DILFValuesRequest request)
			throws VistaWebServiceFault;
}
