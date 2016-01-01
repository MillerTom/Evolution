package gov.va.oit.vistaevolution.kernel.ws.xusrb1.endpoints.interfaces;

import gov.va.oit.vistaevolution.kernel.ws.xusrb1.model.XUSRB1SendkeysRequest;
import gov.va.oit.vistaevolution.kernel.ws.xusrb1.model.XUSRB1SendkeysResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

/**
 * <pre>
 * 
 * This API returns an array of encryption keys in a 
 * root specified in the call.
 * 
 * </pre>
 * 
 * @author rcollins
 *
 */
@WebService(name = "XUSRB1Sendkeys", targetNamespace = "http://vistaevolution.va.gov")
public interface XUSRB1SendkeysEndpoint {
    
    
    /**
     * <pre>
     * 
     * This API returns an array of encryption keys in a 
     * root specified in the call.
     *  
     * </pre>      
     * @param request
     * 
     *         Domain Object that contains All Sendkeys^XUSRB1 input
     *         Parameters
     * 
     * @return XUSRB1SendkeysResponse
     * 
     *         Domain Object that contains Sendkeys^XUSRB1 output data
     * 
     * @throws VistaWebServiceFault
     */
    @WebMethod(action = "XUSRB1SendkeysAction", operationName = "XUSRB1Sendkeys")
    @SOAPBinding(parameterStyle = ParameterStyle.BARE)
    public XUSRB1SendkeysResponse sendkeys(@WebParam(name = "XUSRB1SendkeysRequest") XUSRB1SendkeysRequest request)
            throws VistaWebServiceFault;
    
}
