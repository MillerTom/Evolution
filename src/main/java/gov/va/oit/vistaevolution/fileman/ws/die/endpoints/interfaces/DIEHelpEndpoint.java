package gov.va.oit.vistaevolution.fileman.ws.die.endpoints.interfaces;

import gov.va.oit.vistaevolution.fileman.ws.die.model.DIEHelpRequest;
import gov.va.oit.vistaevolution.fileman.ws.die.model.DIEHelpResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "DIEHelp", targetNamespace = "http://vistaevolution.va.gov")
public interface DIEHelpEndpoint {

	/**
	 * <p>
	 * This procedure retrieves user-oriented help for a field from the Data Dictionary 
	 * and other sources. The help is returned in an array. You control the kind of help 
	 * obtained by using the FLAGS input parameter—either a specific kind of help, 
	 * the help normally returned with one or two question marks, or all available help for a field.	 
	 * </p>
	 * 
	 * @param request
	 * 
	 *            Domain Object that contains All DIE^Help input Parameters
	 * 
	 * @return DIEHelpResponse
	 * 
	 *         Domain Object that contains DIE^Help output data
	 * 
	 * @throws VistaWebServiceFault
	 */
	@WebMethod
	public DIEHelpResponse help(
			@WebParam(name = "DIEHelpRequest") DIEHelpRequest request)
			throws VistaWebServiceFault;
}