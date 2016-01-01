package gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.interfaces;

import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDExternalRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDExternalResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * 
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@WebService(name = "DILFDExternal", targetNamespace = "http://vistaevolution.va.gov")
public interface DILFDExternalEndpoint {

	/**
	 * This extrinsic function converts any internal value to its external
	 * format. It decodes codes, makes VA FileMan dates readable, and follows
	 * pointer or variable pointer chains to resolve their values. OUTPUT
	 * transforms are applied to their fields.
	 * 
	 * 
	 * @param dILFDExternalRequest
	 * 
	 *            Domain Object that contains All DILFD^External input
	 *            Parameters
	 * 
	 * @return DILFDExternalResponse
	 * 
	 *         Domain Object that contains DILFD^External output data
	 * 
	 * @throws VistaWebServiceFault
	 */
	@WebMethod(action = "DILFDExternalAction", operationName = "DILFDExternal")
	public DILFDExternalResponse external(
			@WebParam(name = "DILFDExternalRequest") DILFDExternalRequest request)
			throws VistaWebServiceFault;

}
