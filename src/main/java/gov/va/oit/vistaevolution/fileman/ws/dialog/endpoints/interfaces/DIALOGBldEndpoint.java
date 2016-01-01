
package gov.va.oit.vistaevolution.fileman.ws.dialog.endpoints.interfaces;

import gov.va.oit.vistaevolution.fileman.ws.dialog.model.DIALOGBldRequest;
import gov.va.oit.vistaevolution.fileman.ws.dialog.model.DIALOGBldResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

/**
 * <pre>
 * 
 * This entry point performs the following functions:
 * 
 *      1 Extracts a dialogue from a VA FileMan 
 *      DIALOG file (#.84) entry
 *      
 *      2 Substitutes dialogue parameters into the 
 *      text if requested
 *      
 *      3 Returns the text in an array
 *      
 * If the DIALOG entry has POST MESSAGE ACTION code, 
 * this code is executed after the message has been 
 * built, but before quitting.
 * 
 * </pre>
 * 
 * @author Christopher Schuck
 *
 */
@WebService(name = "DIALOGBld", targetNamespace = "http://vistaevolution.va.gov")
public interface DIALOGBldEndpoint {
    
    
    /**
     * <pre>
     * 
     * This API performs the following functions:
     * 
     *      1 Extracts a dialogue from a VA FileMan 
     *      DIALOG file (#.84) entry
     *      
     *      2 Substitutes dialogue parameters into the 
     *      text if requested
     *      
     *      3 Returns the text in an array
     *      
     * If the DIALOG entry has POST MESSAGE ACTION code, 
     * this code is executed after the message has been 
     * built, but before quitting.       
     * 
     * </pre>      
     * @param request
     * 
     *         Domain Object that contains All Bld^DIALOG input
     *         Parameters
     * 
     * @return DIALOGBldRequest
     * 
     *         Domain Object that contains Bld^DIALOG output data
     * 
     * @throws VistaWebServiceFault
     */
    @WebMethod(action = "DIALOGBldAction", operationName = "DIALOGBld")
	public DIALOGBldResponse bld(@WebParam(name = "DIALOGBldRequest") DIALOGBldRequest request)
	        throws VistaWebServiceFault;
}
