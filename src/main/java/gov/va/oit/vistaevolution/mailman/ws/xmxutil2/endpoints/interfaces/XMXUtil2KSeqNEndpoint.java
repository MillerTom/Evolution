/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2KSeqNRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2KSeqNResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@WebService(name = "XMXUtil2KSeqN", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXUtil2KSeqNEndpoint {

    /**
     * @param request
     * @return
     * @throws VistaWebServiceFault
     */
    @WebMethod(action = "XMXUtil2KSeqNAction", operationName = "XMXUtil2KSeqN")
    public XMXUtil2KSeqNResponse kseqn(
	    @WebParam(name = "XMXUtil2KSeqNRequest") XMXUtil2KSeqNRequest request)
	    throws VistaWebServiceFault;

}
