/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces;

import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFValue1Request;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFValue1Response;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 *
 */
@WebService(name = "DILFValue1", targetNamespace = "http://vistaevolution.va.gov")
public interface DILFValue1Endpoint {
	/**
	 * <em>$$VALUE1^DILF( ): FDA Value Retriever (Single)</em>
	 * <p>
	 * This extrinsic function returns the value associated with a particular
	 * file and field in a standard FDA. Only a single value is returned. If
	 * there is more than one node in the FDA array for the same field, the
	 * first value encountered by this function is returned. Use the
	 * VALUES^DILF( ): FDA Values Retriever API if you want more than one value
	 * returned.
	 * <p>
	 * Format <code>$$VALUE1^DILF(file,field,fda_root)</code>
	 * 
	 */
	/**
	 * 
	 * @param request
	 */
	@WebMethod(action = "DILFValue1Action", operationName = "DILFValue1")
	@SOAPBinding(parameterStyle = ParameterStyle.BARE)
	public DILFValue1Response value1(
			@WebParam(name = "DILFValue1Request") DILFValue1Request request)
			throws VistaWebServiceFault;
}
