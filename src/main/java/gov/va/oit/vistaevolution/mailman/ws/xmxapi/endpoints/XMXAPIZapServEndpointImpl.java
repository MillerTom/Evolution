package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIZapServEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIZapServRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIZapServResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebService;

import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@Component
@WebService(serviceName = "XMXAPIZapServService", portName = "XMXAPIZapServServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIZapServEndpoint")
public class XMXAPIZapServEndpointImpl extends SpringBeanAutowiringSupport
	implements XMXAPIZapServEndpoint {

    @Override
    public XMXAPIZapServResponse zapServ(XMXAPIZapServRequest request)
	    throws VistaWebServiceFault {
	throw new VistaWebServiceFault(
		"This API has not been exposed because the RPC exposing it has a flaw.");
    }

}
