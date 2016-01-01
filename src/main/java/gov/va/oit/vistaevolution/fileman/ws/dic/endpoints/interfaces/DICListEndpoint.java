package gov.va.oit.vistaevolution.fileman.ws.dic.endpoints.interfaces;

import gov.va.oit.vistaevolution.fileman.ws.dic.model.DICListRequest;
import gov.va.oit.vistaevolution.fileman.ws.dic.model.DICListResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@WebService(name = "DICList", targetNamespace = "http://vistaevolution.va.gov")
public interface DICListEndpoint {

	/**
	 * 
	 * This procedure returns a sorted list of entries from a file. Callers must
	 * specify a file number. Callers can also specify the index to be used in
	 * sorting the output, starting location, number of records to retrieve
	 * and/or partial match value. They can also pass screening logic. By
	 * default, the Lister returns the .01 field of the entries, along with the
	 * index values used to retrieve them, and all identifiers for the entries.
	 * The developer can override the default output and return other
	 * information for the entries. This call is designed to populate a GUI
	 * Listbox gadget. It merely returns a list of entries from an index.
	 * Starting values must be in the same format as the index, unlike a lookup
	 * that allows search values to be in external format. The caller can make
	 * an initial call to the Lister to return a number of records "n" from the
	 * file and follow that by subsequent calls to return the next "n" records.
	 * 
	 * @param request
	 * 
	 *            Domain Object that contains All DIC^List input Parameters
	 * 
	 * @return DICListResponse
	 * 
	 *         Domain Object that contains DIC^List output data
	 * 
	 * @throws VistaWebServiceFault
	 */
	@WebMethod(action = "DICListAction", operationName = "DICList")
	public DICListResponse list(
			@WebParam(name = "DICListRequest") DICListRequest request)
			throws VistaWebServiceFault;
}