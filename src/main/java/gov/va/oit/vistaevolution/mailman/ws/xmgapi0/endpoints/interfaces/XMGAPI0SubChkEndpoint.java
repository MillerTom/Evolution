/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmgapi0.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmgapi0.model.XMGAPI0SubChkRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmgapi0.model.XMGAPI0SubChkResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@WebService(name = "XMGAPI0SubChk", targetNamespace = "http://vistaevolution.va.gov")
public interface XMGAPI0SubChkEndpoint {

	/**
	 * @param string
	 * @return
	 */
	@WebMethod(action = "XMGAPI0SubChkAction", operationName = "XMGAPI0SubChk")
	public XMGAPI0SubChkResponse subChk(
			@WebParam(name = "XMGAPI0SubChkRequest") XMGAPI0SubChkRequest request)
			throws VistaWebServiceFault;

}
