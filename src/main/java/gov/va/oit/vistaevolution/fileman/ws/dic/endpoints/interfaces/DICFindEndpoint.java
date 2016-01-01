package gov.va.oit.vistaevolution.fileman.ws.dic.endpoints.interfaces;

import gov.va.oit.vistaevolution.fileman.ws.dic.model.DICFindRequest;
import gov.va.oit.vistaevolution.fileman.ws.dic.model.DICFindResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@WebService(name = "DICFind", targetNamespace = "http://vistaevolution.va.gov")
public interface DICFindEndpoint {

	/**
	 * 
	 * This procedure finds records in a file based on input value(s). The
	 * caller must specify a file number and the input values to be used for the
	 * lookup. The caller can also specify the index(s) to be used in the
	 * search, the data to output, and a number of records to retrieve. The
	 * caller can also pass screening logic. By default, the Finder returns the
	 * IEN and the .01 field of the entries along with all identifiers. The
	 * developer can override the default output and return other information
	 * for the entries. This call was designed as a non-interactive lookup, to
	 * find entries that are at least a partial match to the lookup values input
	 * to the call. This procedure cannot file data or add new records. Note(The
	 * Finder does not honor the Special Lookup or Post-Lookup Action nodes
	 * defined in the data dictionary for a file.)
	 * 
	 * 
	 * @param request
	 * 
	 *            Domain Object that contains All DIC^Find input parameters
	 * 
	 * @return DICFindResponse
	 * 
	 *         Domain Object that contains DIC^Find output data
	 * 
	 * @throws VistaWebServiceFault
	 */
	@WebMethod(action = "DICFindAction", operationName = "DICFind")
	public DICFindResponse find(
			@WebParam(name = "DICFindRequest") DICFindRequest request)
			throws VistaWebServiceFault;
}