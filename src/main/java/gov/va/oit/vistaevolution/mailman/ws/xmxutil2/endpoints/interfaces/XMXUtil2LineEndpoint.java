/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2LineRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2LineResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@WebService(name = "XMXUTIL2Line", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUtil2LineEndpoint {

    /**
     * @param request
     * @return
     * @throws VistaWebServiceFault
     */
    @WebMethod(action = "XMXUTIL2LineAction", operationName = "XMXUTIL2Line")
    public XMXUtil2LineResponse line(
	    @WebParam(name = "XMXUtil2LineRequest") XMXUtil2LineRequest request)
	    throws VistaWebServiceFault;

}
