package gov.va.oit.vistaevolution.mailman.ws.xmxutil3.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil3.endpoints.interfaces.XMXUtil3QLEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil3.model.XMXUtil3QLRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil3.model.XMXUtil3QLResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebService;

import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@Component
@WebService(serviceName = "XMXUtil3QLService", portName = "XMXUtil3QLServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxutil3.endpoints.interfaces.XMXUtil3QLEndpoint")
public class XMXUtil3QLEndpointImpl extends SpringBeanAutowiringSupport
	implements XMXUtil3QLEndpoint {

    @Override
    public XMXUtil3QLResponse ql(XMXUtil3QLRequest request)
	    throws VistaWebServiceFault {
	throw new VistaWebServiceFault(
		"This API has not been exposed because the RPC exposing it has a flaw.");
    }

}
