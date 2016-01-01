/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmgapi2.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmgapi2.model.XMGAPI2HdrRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmgapi2.model.XMGAPI2HdrResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@WebService(name = "XMGAPI2Hdr", targetNamespace = "http://vistaevolution.va.gov")
public interface XMGAPI2HdrEndpoint {

	/**
	 * @param string
	 * @return
	 */
	@WebMethod(action = "XMGAPI2HdrAction", operationName = "XMGAPI2Hdr")
	public XMGAPI2HdrResponse hdr(@WebParam(name = "XMGAPI2HdrRequest") XMGAPI2HdrRequest request) throws VistaWebServiceFault;

}
