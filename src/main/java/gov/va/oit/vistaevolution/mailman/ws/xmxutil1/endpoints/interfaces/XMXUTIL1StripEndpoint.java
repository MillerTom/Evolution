/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1StripRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1StripResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Christopher Schuck
 *
 */
@WebService(name = "XMXUTIL1Strip", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUTIL1StripEndpoint {

    @WebMethod(action = "XMXUTIL1StripAction", operationName = "XMXUTIL1Strip")
    public XMXUTIL1StripResponse strip(@WebParam(name = "XMXUTIL1StripRequest") XMXUTIL1StripRequest request) 
            throws VistaWebServiceFault;

}
