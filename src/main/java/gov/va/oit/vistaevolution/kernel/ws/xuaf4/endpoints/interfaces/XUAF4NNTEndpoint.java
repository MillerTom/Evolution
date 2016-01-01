package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces;

import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4NNTRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4NNTResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * <em>$$PADD^XUAF4( ): Institution Physical Address:</em> This function returns
 * the official intuition physical address for the entered IEN.
 * 
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@WebService(name = "XUAF4NNT", targetNamespace = "http://vistaevolution.va.gov")
public interface XUAF4NNTEndpoint {

	/**
	 * 
	 * @param request
	 * @return
	 * @throws VistaWebServiceFault
	 */
	@WebMethod(action = "XUAF4NNTAction", operationName = "XUAF4NNT")
	public XUAF4NNTResponse NNT(
			@WebParam(name = "XUAF4NNTRequest") XUAF4NNTRequest request)
			throws VistaWebServiceFault;

}
