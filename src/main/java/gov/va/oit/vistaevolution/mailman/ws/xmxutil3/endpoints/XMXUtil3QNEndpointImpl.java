package gov.va.oit.vistaevolution.mailman.ws.xmxutil3.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil3.endpoints.interfaces.XMXUtil3QNEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil3.model.XMXUtil3QNRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil3.model.XMXUtil3QNResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebService;

import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@Component
@WebService(serviceName = "XMXUtil3QNService", portName = "XMXUtil3QNServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxutil3.endpoints.interfaces.XMXUtil3QNEndpoint")
public class XMXUtil3QNEndpointImpl extends SpringBeanAutowiringSupport
	implements XMXUtil3QNEndpoint {

    @Override
    public XMXUtil3QNResponse qn(XMXUtil3QNRequest request)
	    throws VistaWebServiceFault {
	throw new VistaWebServiceFault(
		"This API has not been exposed because the RPC exposing it has a flaw.");
    }

}
