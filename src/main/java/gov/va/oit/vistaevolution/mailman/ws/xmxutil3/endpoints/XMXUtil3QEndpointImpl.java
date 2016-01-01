package gov.va.oit.vistaevolution.mailman.ws.xmxutil3.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil3.endpoints.interfaces.XMXUtil3QEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil3.model.XMXUtil3QRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil3.model.XMXUtil3QResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebService;

import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@Component
@WebService(serviceName = "XMXUtil3QService", portName = "XMXUtil3QServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxutil3.endpoints.interfaces.XMXUtil3QEndpoint")
public class XMXUtil3QEndpointImpl extends SpringBeanAutowiringSupport
	implements XMXUtil3QEndpoint {

    @Override
    public XMXUtil3QResponse q(XMXUtil3QRequest request)
	    throws VistaWebServiceFault {
	throw new VistaWebServiceFault(
		"This API has not been exposed because the RPC exposing it has a flaw.");
    }

}
