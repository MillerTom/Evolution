package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces;

import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFORefRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFORefResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * This extrinsic function converts a closed root to an open root. It converts
 * an ending close parenthesis to a comma. This prepares the root for further
 * use in internally processing, such as setting up or removing local or global
 * arrays.
 * 
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@WebService(name = "DILFORef", targetNamespace = "http://vistaevolution.va.gov")
public interface DILFORefEndpoint {

	@WebMethod(action = "DILFORefAction", operationName = "DILFORef")
	public DILFORefResponse oref(
			@WebParam(name = "DILFORefRequest") DILFORefRequest request)
			throws VistaWebServiceFault;
}
