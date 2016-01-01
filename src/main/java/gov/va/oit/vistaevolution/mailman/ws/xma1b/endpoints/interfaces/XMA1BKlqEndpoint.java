/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xma1b.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xma1b.model.XMA1BKlqRequest;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.model.XMA1BKlqResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

/**
 * @author Christopher Schuck
 *
 */
@WebService(name = "XMA1BKlq", targetNamespace = "http://vistaevolution.va.gov")
public interface XMA1BKlqEndpoint {
    
    
    /**
     * <pre>
     * This API Delete a message from a basket and put it in 
     * the "WASTE" basket. Unlike KL^XMA1B, the message is 
     * put in the "WASTE" basket.
     * <pre>
     * 
     * @param request
     *      
     *      Domain Object that contains All Klq^XMA1B input
     *      Parameters
     *            
     * @return XMA1BKlqResponse
     * 
     *      Domain Object that contains Klq^XMA1B output data
     * 
     * @throws VistaWebServiceFault
     */
	@WebMethod(action = "XMA1BKlqAction", operationName = "XMA1BKlq")
	public XMA1BKlqResponse klq(@WebParam(name = "XMA1BKlqRequest") XMA1BKlqRequest request)
	        throws VistaWebServiceFault;

}
