package gov.va.oit.vistaevolution.mailman.ws.xmxutil3.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil3.endpoints.interfaces.XMXUtil3QDEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil3.model.XMXUtil3QDRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil3.model.XMXUtil3QDResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebService;

import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@Component
@WebService(serviceName = "XMXUtil3QDService", portName = "XMXUtil3QDServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxutil3.endpoints.interfaces.XMXUtil3QDEndpoint")
public class XMXUtil3QDEndpointImpl extends SpringBeanAutowiringSupport
	implements XMXUtil3QDEndpoint {

    @Override
    public XMXUtil3QDResponse qd(XMXUtil3QDRequest request)
	    throws VistaWebServiceFault {
	throw new VistaWebServiceFault(
		"This API has not been exposed because the RPC exposing it has a flaw.");
    }

}
