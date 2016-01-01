
package gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.interfaces;

import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDFldnumRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDFldnumResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

/**
 * <pre>
 * This extrinsic function returns a field number when passed a 
 * file number and a field name.
 * </pre>
 * 
 * @author Christopher Schuck
 *
 */
@WebService(name = "DILFDFldnum", targetNamespace = "http://vistaevolution.va.gov")
public interface DILFDFldnumEndpoint {
    
    
    /**
     * <pre>
     * This API returns a field number when passed a file number and a field name.
     * </pre>
     * 
     * 
     * @param DILFDFldnumRequest
     * 
     *            Domain Object that contains All Fldnum^DILFD input
     *            Parameters
     * 
     * @return DILFDFldnumResponse
     * 
     *         Domain Object that contains Fldnum^DILFD output data
     * 
     * @throws VistaWebServiceFault
     */
    @WebMethod(action = "DILFDFldnumAction", operationName = "DILFDFldnum")
	public DILFDFldnumResponse fldnum(@WebParam(name = "DILFDFldnumRequest") DILFDFldnumRequest request)
	        throws VistaWebServiceFault;
}
