/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2FromRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2FromResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 */
@WebService(name = "XMXUTIL2From", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUtil2FromEndpoint {

    /**
     * @param request
     * @return
     * @throws VistaWebServiceFault
     */
    @WebMethod(action = "XMXUTIL2FromAction", operationName = "XMXUTIL2From")
    public XMXUtil2FromResponse from(
	    @WebParam(name = "XMXUtil2FromRequest") XMXUtil2FromRequest request)
	    throws VistaWebServiceFault;

}
