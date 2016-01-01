/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1SsPrivRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1SsPrivResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

/**
 * @author Christopher Schuck
 *
 */
@WebService(name = "XMXSEC1SsPriv", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXSEC1SsPrivEndpoint {

	/**
	 * 
	 * @param request unused placeholder parameter, null can be passed in
	 * @return 1 or 0 depending on whether or not the user can conduct a super search
	 * @throws VistaWebServiceFault
	 */
	@WebMethod(action = "XMXSEC1SsPrivAction", operationName = "XMXSEC1SsPriv")
	public XMXSEC1SsPrivResponse sspriv(@WebParam(name = "XMXSEC1SsPrivRequest") XMXSEC1SsPrivRequest request)
		throws VistaWebServiceFault;

}
