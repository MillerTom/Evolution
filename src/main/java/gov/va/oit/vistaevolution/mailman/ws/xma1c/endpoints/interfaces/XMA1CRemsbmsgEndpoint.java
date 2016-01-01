/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xma1c.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xma1c.model.XMA1CRemsbmsgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xma1c.model.XMA1CRemsbmsgResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

/**
 * <pre>
 *   
 *   This API deletes a message from a server basket. 
 *   The message is not put in the "WASTE" basket. All server 
 *   baskets belong to the Postmaster, so it is not necessary to 
 *   specify which user. Software applications should call this 
 *   API when they have processed the server message, otherwise 
 *   it will never be removed from the basket. The MailMan purge 
 *   routines do not touch messages in server baskets.
 *   
 * </pre>
 * 
 * @author Christopher Schuck
 *
 */
@WebService(name = "XMA1CRemsbmsg", targetNamespace = "http://vistaevolution.va.gov")
public interface XMA1CRemsbmsgEndpoint {
    

    /**
     * <pre>
     *   
     *  This RPC deletes a message from a server basket. The message is not put in
     *  the "WASTE" basket. All server baskets belong to the Postmaster, so it is
     *  not necessary to specify which user. Software applications should call
     *  this API when they have processed the server message, otherwise it will
     *  never be removed from the basket. The MailMan purge routines do not touch
     *  messages in server baskets.
     *   
     * </pre>
     * 
     * @param request
     * 
     *         Domain Object that contains All Remsbmsg^XMA1C input
     *         Parameters
     * 
     * @return XMA1CRemsbmsgResponse
     * 
     *         Domain Object that contains Remsbmsg^XMA1C output data
     * 
     * @throws VistaWebServiceFault
     */
	@WebMethod(action = "XMA1CRemsbmsgAction", operationName = "XMA1CRemsbmsg")
	public XMA1CRemsbmsgResponse remsbmsg(@WebParam(name = "XMA1CRemsbmsgRequest") XMA1CRemsbmsgRequest request)
	        throws VistaWebServiceFault;
}
