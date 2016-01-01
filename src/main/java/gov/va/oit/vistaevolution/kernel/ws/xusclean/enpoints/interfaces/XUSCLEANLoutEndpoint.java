package gov.va.oit.vistaevolution.kernel.ws.xusclean.enpoints.interfaces;

import gov.va.oit.vistaevolution.kernel.ws.xusclean.model.XUSCLEANLoutRequest;
import gov.va.oit.vistaevolution.kernel.ws.xusclean.model.XUSCLEANLoutResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

/**
 * <pre>
 * This API enters the user’s logout time in the sign-on log 
 * </pre>      
 * 
 * @author rcollins
 *
 */
@WebService(name = "XUSCLEANLout", targetNamespace = "http://vistaevolution.va.gov")
public interface XUSCLEANLoutEndpoint {
    
    
    /**
     * <pre>
     * This API enters the user’s logout time in the sign-on log 
     * </pre>      
     * 
     * @param request
     * 
     *         Domain Object that contains All LOUT^XUSCLEAN input
     *         Parameters
     * 
     * @return XUSCLEANLoutResponse
     * 
     *         Domain Object that contains LOUT^XUSCLEAN output data
     * 
     * @throws VistaWebServiceFault
     */
    @WebMethod(action = "XUSCLEANLoutAction", operationName = "XUSCLEANLout")
    @SOAPBinding(parameterStyle = ParameterStyle.BARE)
    public XUSCLEANLoutResponse lout(@WebParam(name = "XUSCLEANLoutRequest")XUSCLEANLoutRequest request) 
            throws VistaWebServiceFault;
}
