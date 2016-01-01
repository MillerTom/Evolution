/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1ZonediffRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1ZonediffResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@WebService(name = "XMXUTIL1Zonediff", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUTIL1ZonediffEndpoint {

	/**
	 * This API, given the time zone (or time difference +-hhmm from Greenwich
	 * Mean Time [GMT]), returns the number of hours and minutes difference
	 * between the input and the local time zone.
	 * 
	 * @param request
	 * 
	 *            Request Object that contains ZONEDIFF^XMXUTIL1 input
	 *            Parameters
	 * 
	 * @return XMXUTIL1ZonediffResponse
	 * 
	 *         Response Object that contains ZONEDIFF^XMXUTIL1 output Data
	 * 
	 * 
	 * @throws VistaWebServiceFault
	 */
	@WebMethod(action = "XMXUTIL1ZonediffAction", operationName = "XMXUTIL1Zonediff")
	public XMXUTIL1ZonediffResponse zonediff(
			@WebParam(name = "XMXUTIL1ZonediffRequest") XMXUTIL1ZonediffRequest request)
			throws VistaWebServiceFault;
}
