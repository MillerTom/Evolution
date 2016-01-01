/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces;

import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFIENSRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFIENSResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

/**
 * This extrinsic function converts a closed root to an open root. It converts
 * an ending close parenthesis to a comma. This prepares the root for further
 * use in internally processing, such as setting up or removing local or global
 * arrays.
 * 
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@WebService(name = "DILFIENS", targetNamespace = "http://vistaevolution.va.gov")
public interface DILFIENSEndpoint {

	/**
	 * @param request
	 * @return
	 */
	@WebMethod(action = "DILFIENSAction", operationName = "DILFIENS")
	@SOAPBinding(parameterStyle = ParameterStyle.BARE)
	public DILFIENSResponse createIENS(@WebParam(name = "DILFIENSRequest") DILFIENSRequest request);

}
