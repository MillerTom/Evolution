package gov.va.oit.vistaevolution.mailman.ws.xmxapig.endpoints.interfaces;

// import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1EncodeupRequest;
// import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1EncodeupResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapig.model.XMXAPIGGotLocalRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapig.model.XMXAPIGGotLocalResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * 
 * @author Bill Blackmon <bill.blackmon@medsphere.com>
 * 
 **/

@WebService(name = "XMXAPIGGotLocal", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXAPIGGotLocalEndpoint {

    @WebMethod(action = "XMXAPIGGotLocalAction", operationName = "XMXAPIGGotLocal")
    public XMXAPIGGotLocalResponse GotLocal(
	    @WebParam(name = "XMXAPIGGotLocalRequest") XMXAPIGGotLocalRequest request)
	    throws VistaWebServiceFault;

}
