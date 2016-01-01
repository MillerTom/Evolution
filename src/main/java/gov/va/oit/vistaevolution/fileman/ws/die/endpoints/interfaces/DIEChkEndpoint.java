package gov.va.oit.vistaevolution.fileman.ws.die.endpoints.interfaces;

import gov.va.oit.vistaevolution.fileman.ws.die.model.DIEChkRequest;
import gov.va.oit.vistaevolution.fileman.ws.die.model.DIEChkResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "DIEChk", targetNamespace = "http://vistaevolution.va.gov")
public interface DIEChkEndpoint {

	/**
	 *
	 * DDR SOA DATA CHECKER
	 * 
	 * This RPC checks user-supplied data against the data dictionary definition of a
	 * field using CHK^DIE. If the input data passes the validation, the internal and,
	 * optionally, the external forms of the data are returned.
	 * 
	 * Inpt Parameters:
	 * 		"FILE"  (Required) File or subfile number.
	 * 		"FIELD" (Required) Field number for which data is being validated.
	 * 		"FLAGS" (Optional) Flags to control processing. The possible values are:
	 *  		    H Help (single "?") is returned if VALUE is not valid.
	 *  	E 		External value is returned in DDRDATA(0).
	 *  	"VALUE" (Required) Value to be validated, as entered by a user. VALUE can take
	 *  			several forms depending on the data type involved, such as a partial,
	 *  			unambiguous match for a pointer or any of the supported ways to input
	 *  	dates 	(e.g., "TODAY" or "11/3/93").
	 *  
	 *  Results:
	 *  	If VALUE is valid, the internal value is returned. If not valid, ^ is returned.
	 *  	If the E flag is passed, external value is returned in DDRDATA(0).
	 *    	If there is an error the error message is returned in DDRDATA("ERROR").
	 * 
	 * @param request
	 * 
	 *            Domain Object that contains All DIE^CHK input Parameters
	 * 
	 * @return DIEChkResponse
	 * 
	 *         Domain Object that contains DIE^CHK output data
	 * 
	 * @throws VistaWebServiceFault
	 */
	@WebMethod
	public DIEChkResponse chk(
			@WebParam(name = "DIEChkRequest") DIEChkRequest request)
			throws VistaWebServiceFault;
}