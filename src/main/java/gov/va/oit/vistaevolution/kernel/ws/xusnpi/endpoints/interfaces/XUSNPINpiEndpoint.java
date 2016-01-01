/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusnpi.endpoints.interfaces;

import gov.va.oit.vistaevolution.kernel.ws.xusnpi.model.XUSNPINpiRequest;
import gov.va.oit.vistaevolution.kernel.ws.xusnpi.model.XUSNPINpiResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Christopher Schuck
 *
 */
@WebService(name = "XUSNPINpi", targetNamespace = "http://vistaevolution.va.gov")
public interface XUSNPINpiEndpoint {

    @WebMethod(action = "XUSNPINpiAction", operationName = "XUSNPINpi")
    public XUSNPINpiResponse npi(@WebParam(name = "XUSNPINpiRequest") XUSNPINpiRequest request)
            throws VistaWebServiceFault;

}
