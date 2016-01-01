
package gov.va.oit.vistaevolution.fileman.ws.dialog.endpoints.interfaces;

import gov.va.oit.vistaevolution.fileman.ws.dialog.model.DIALOGEzBldRequest;
import gov.va.oit.vistaevolution.fileman.ws.dialog.model.DIALOGEzBldResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * <pre>
 * 
 * This extrinsic function returns the first line of text from an entry 
 * in the DIALOG file. It can be used when the text entry is only one 
 * line and when the output does not need to be put into an array.
 * For example, use it to extract a single word or short phrase to 
 * use as a text parameter to embed into another DIALOG file (#.84) entry. 
 * If the DIALOG entry has POST MESSAGE ACTION code, this code is executed 
 * after the message has been built but before quitting.
 * 
 * </pre>
 * 
 * @author Christopher Schuck
 *
 */
@WebService(name = "DIALOGEzBld", targetNamespace = "http://vistaevolution.va.gov")
public interface DIALOGEzBldEndpoint {
    
    
    /**
     * <pre>
     * 
     *  This RPC returns the first line of text from an entry 
     *  in the Dialog file using $$EZBLD^DIALOG.     
     * 
     * </pre>      
     * @param request
     * 
     *         Domain Object that contains All EzBld^DIALOG input
     *         Parameters
     * 
     * @return DIALOGEzBldRequest
     * 
     *         Domain Object that contains EzBld^DIALOG output data
     * 
     * @throws VistaWebServiceFault
     */
    @WebMethod(action = "DIALOGEzBldAction", operationName = "DIALOGEzBld")
	public DIALOGEzBldResponse ezbld(@WebParam(name = "DIALOGEzBldRequest") DIALOGEzBldRequest request)
	        throws VistaWebServiceFault;
}
