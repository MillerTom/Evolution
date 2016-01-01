package gov.va.oit.vistaevolution.fileman.ws.ddr3.endpoints.interfaces;

import gov.va.oit.vistaevolution.fileman.ws.ddr3.model.DDR3ValCRequest;
import gov.va.oit.vistaevolution.fileman.ws.ddr3.model.DDR3ValCResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "DDR3ValC", targetNamespace = "http://vistaevolution.va.gov")
public interface DDR3ValCEndpoint {

	/**
	 * <em>VALC^DDR3</em>
	 * <p>
	 * This function allows the application to validate user input to a field
	 * before filling data. The call uses the database server VAL^DIE call.
	 * </p>
	 * @param request
	 *            This array contains the following parameters necessary to call
	 *            VAL^DIE:<pre>
	 *            "FILE" - file number
	 *            "IENS" - internal entry numbers
	 *            "FIELD" - field number
	 *            "VALUE" - user input value
	 * 
	 * @return This call passes back information in the [data] section and the
	 *         [errors] section.
	 */
	@WebMethod
	public DDR3ValCResponse valC(@WebParam(name = "DDR3ValCRequest") DDR3ValCRequest request)
			throws VistaWebServiceFault;

}
