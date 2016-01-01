/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1TstampResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@WebService(name = "XMXUTIL1Tstamp", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUTIL1TstampEndpoint {

	/**
	 * This extrinsic function returns a timestamp ($H expressed in seconds).
	 * 
	 * @param request
	 * 
	 *            Request Object that contains TSTAMP^XMXUTIL1 input Parameters
	 * 
	 * @return XMXUTIL1TstampResponse
	 * 
	 *         Response Object that contains TSTAMP^XMXUTIL1 output Data
	 * 
	 * 
	 * @throws VistaWebServiceFault
	 */
	@WebMethod(action = "XMXUTIL1TstampAction", operationName = "XMXUTIL1Tstamp")
	@SOAPBinding(parameterStyle = ParameterStyle.BARE)
	public XMXUTIL1TstampResponse tstamp() throws VistaWebServiceFault;
}
