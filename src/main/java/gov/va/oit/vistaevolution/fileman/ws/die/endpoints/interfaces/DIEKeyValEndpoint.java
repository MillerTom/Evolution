package gov.va.oit.vistaevolution.fileman.ws.die.endpoints.interfaces;

import gov.va.oit.vistaevolution.fileman.ws.die.model.DIEKeyValRequest;
import gov.va.oit.vistaevolution.fileman.ws.die.model.DIEKeyValResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

@WebService(name = "DIEKeyVal", targetNamespace = "http://vistaevolution.va.gov")
public interface DIEKeyValEndpoint {

	/**
	 *
	 *	DDR KEY VALIDATOR
	 *
	 *	Validates that values passed in do not violate key integrity.  Underlying
	 *	DBS call is KEYVAL^DIE.
	 *	
	 *	Input Parameters:
	 *		VALUES 	A list containing the values to validate
	 *
	 *		Array of data used to create FDA for KEYVAL^DIE call.  Alternating lines
	 *		contain file#^IENS^field# and value associated with preceding file, record,
	 *		and field.
	 *
	 *	Results:
	 *		If values pass validation, 1 is returned in first node of array.  If
	 *		validation fails, 0 is returned in first node followed by error
	 *		information.
	 * 
	 */
	@WebMethod (action = "DIEKeyValAction", operationName = "DIEKeyVal" )
	public DIEKeyValResponse keyVal(
			@WebParam(name = "DIEKeyValRequest") DIEKeyValRequest request)
			throws VistaWebServiceFault;
}
