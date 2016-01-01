/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces;

import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4ParentRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4ParentResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

/**
 * <em>PARENT^XUAF4( ):  Report Parent Facility </em>
 * 
 * <pre> This procedure returns an array in a variable passed to the procedure
 * that is populated with the parent facility or the VISN information for the
 * specified IEN.
 * </pre>
 * 
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@WebService(name = "XUAF4Parent", targetNamespace = "http://vistaevolution.va.gov")
public interface XUAF4ParentEndpoint {

	/**
	 * @param request
	 * @return
	 */
	@WebMethod(action = "XUAF4ParentAction", operationName = "XUAF4Parent")
	@SOAPBinding(parameterStyle = ParameterStyle.BARE)
	public XUAF4ParentResponse parent(
			@WebParam(name = "XUAF4ParentRequest") XUAF4ParentRequest request)
			throws VistaWebServiceFault;

}
