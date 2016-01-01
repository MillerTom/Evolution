
package gov.va.oit.vistaevolution.mailman.ws.xma21.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xma21.model.XMA21InstRequest;
import gov.va.oit.vistaevolution.mailman.ws.xma21.model.XMA21InstResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * <pre>
 *   Address Lookup (Classic MailMan)
 *   This API is a non-interactive address lookup.  
 *   XMY is not KILLed upon entry. 
 * </pre>
 * @author rcollins
 *
 */
@WebService(name = "XMA21Inst", targetNamespace = "http://vistaevolution.va.gov")
public interface XMA21InstEndpoint {
    
    
    /**
     * <pre>
     *   Address Lookup (Classic MailMan)
     *   This API is a non-interactive address lookup.  
     *   XMY is not KILLed upon entry. 
     * </pre>
     * 
     * @param request -
     * 
     *         Domain Object that contains All Inst^XMA21 input
     *         Parameters
     * 
     * @return XMA21InstResponse -
     * 
     *         Domain Object that contains Inst^XMA21 output data
     * 
     * @throws VistaWebServiceFault
     */
    @WebMethod(action = "XMA21InstAction", operationName = "XMA21Inst")
    public XMA21InstResponse inst(@WebParam(name = "XMA21InstRequest") XMA21InstRequest request)
            throws VistaWebServiceFault;
}
