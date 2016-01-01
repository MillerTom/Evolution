/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusnpi.endpoints.interfaces;

import gov.va.oit.vistaevolution.kernel.ws.xusnpi.model.XUSNPIQiRequest;
import gov.va.oit.vistaevolution.kernel.ws.xusnpi.model.XUSNPIQiResponse;
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
@WebService(name = "XUSNPIQi", targetNamespace = "http://vistaevolution.va.gov")
public interface XUSNPIQiEndpoint {

    @WebMethod(action = "XUSNPIQiAction", operationName = "XUSNPIQi")
    public XUSNPIQiResponse qi(@WebParam(name = "XUSNPIQiRequest") XUSNPIQiRequest request)
            throws VistaWebServiceFault;

}
