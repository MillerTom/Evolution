/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.dialog.endpoints.interfaces;

import gov.va.oit.vistaevolution.fileman.ws.dialog.model.DIALOGMsgRequest;
import gov.va.oit.vistaevolution.fileman.ws.dialog.model.DIALOGMsgResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

/**
 * <pre>
 * 
 * This procedure takes text from one of the VA FileMan dialogue arrays 
 * (for errors, help text, or other text) or from a similarly structured 
 * local array, writes it and/or moves it into a simple local array. 
 *   
 * The subscripting of these arrays will tell the developer whether the 
 * dialogue is a "Help" message, an "Error" message, or other dialog, 
 * such as a prompt. Different combinations of these messages may be 
 * returned from the DBS calls. In addition, error messages will be 
 * returned whenever an error occurs, either in the way the call was 
 * made or in attempting to interact with the database. 
 *
 * With the DBS calls, it becomes the job of the developer to display 
 * dialogue to the end user as needed, perhaps in a GUI box or in the 
 * bottom portion of a screen-oriented form. The developer can also save 
 * error messages in a file. 
 *
 * MSG^DIALOG is designed to make it easier for the developer to use the 
 * dialogue arrays. The developer can use MSG^DIALOG to do simple formatting 
 * of the dialogue and to either write dialogue to the current device or to 
 * move the dialogue to a simple local array for further processing.
 * 
 * </pre>
 * 
 * @author Christopher Schuck
 *
 */
@WebService(name = "DIALOGMsg", targetNamespace = "http://vistaevolution.va.gov")
public interface DIALOGMsgEndpoint {
        
    
    /**
     * <pre>
     * 
     *  This procedure takes text from one of the VA FileMan dialogue 
     *  arrays (for errors, help text, or other text) or from a similarly 
     *  structured local array, writes it and/or moves it into a simple 
     *  local array.      
     * 
     * </pre>      
     * @param request
     * 
     *         Domain Object that contains All DIALOGMsg^DIALOG input
     *         Parameters
     * 
     * @return DIALOGMsgRequest
     * 
     *         Domain Object that contains DIALOGMsg^DIALOG output data
     * 
     * @throws VistaWebServiceFault
     */
    @WebMethod(action = "DIALOGMsgAction", operationName = "DIALOGMsg")
    @SOAPBinding(parameterStyle = ParameterStyle.BARE)
	public DIALOGMsgResponse msg(@WebParam(name = "DIALOGMsgRequest") DIALOGMsgRequest request)
        throws VistaWebServiceFault;
}
