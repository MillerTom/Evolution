
package gov.va.oit.vistaevolution.kernel.ws.xusap.endpoints.interfaces;

import gov.va.oit.vistaevolution.kernel.ws.xusap.model.XUSAPActiveRequest;
import gov.va.oit.vistaevolution.kernel.ws.xusap.model.XUSAPActiveResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

/**
 * @author Stephen Combs <Stephen.Combs@Synaptekcorp.com>
 *
 */
@WebService(name = "XUSAPActive", targetNamespace = "http://vistaevolution.va.gov")
public interface XUSAPActiveEndpoint {
    
    
    /**
     * VistaLink - This extrinsic function checks if user IEN passed in is linked to an active user
     * 
     * @throws VistaWebServiceFault
     */
    @WebMethod(action = "XUSAPActiveAction", operationName = "XUSAPActive")
    public XUSAPActiveResponse active(@WebParam(name = "XUSAPActiveRequest") XUSAPActiveRequest request)
            throws VistaWebServiceFault;
}
