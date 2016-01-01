/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces;

import gov.va.oit.vistaevolution.fileman.ws.dilf.model.AbstractDILFFDARequest;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFFDAResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@WebService(name = "DILFFDA", targetNamespace = "http://vistaevolution.va.gov")
public interface DILFFDAEndpoint {

	/**
	 * FDA Loader This procedure can be used to load data into the FDA. It
	 * accepts either the traditional DA( ) array or the IENS for specifying the
	 * entry. No validation of VALUE is done.
	 * @throws VistaWebServiceFault 
	 */
	@WebMethod
	public DILFFDAResponse FDA(
			@WebParam(name = "FDADILFRequest") AbstractDILFFDARequest request) throws VistaWebServiceFault;
}
