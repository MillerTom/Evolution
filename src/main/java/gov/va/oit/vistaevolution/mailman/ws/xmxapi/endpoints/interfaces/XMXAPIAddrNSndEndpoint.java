package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces;

import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIAddrNSndRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIAddrNSndResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "XMXAPIAddrNSnd", targetNamespace = "http://vistaevolution.va.gov")
public interface XMXAPIAddrNSndEndpoint {

    @WebMethod(action = "XMXAPIAddrNSndAction", operationName = "XMXAPIAddrNSnd")
    public XMXAPIAddrNSndResponse addrNSnd(
	    @WebParam(name = "XMXAPIAddrNSndRequest") XMXAPIAddrNSndRequest request)
	    throws VistaWebServiceFault;
}
