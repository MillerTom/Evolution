package gov.va.oit.vistaevolution.mailman.ws.xmxutil3.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil3.endpoints.interfaces.XMXUtil3QXEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil3.model.XMXUtil3QXRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil3.model.XMXUtil3QXResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebService;

import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@Component
@WebService(serviceName = "XMXUtil3QXService", portName = "XMXUtil3QXServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxutil3.endpoints.interfaces.XMXUtil3QXEndpoint")
public class XMXUtil3QXEndpointImpl extends SpringBeanAutowiringSupport
	implements XMXUtil3QXEndpoint {

    @Override
    public XMXUtil3QXResponse qx(XMXUtil3QXRequest request)
	    throws VistaWebServiceFault {
	throw new VistaWebServiceFault(
		"This API has not been exposed because the RPC exposing it has a flaw.");
    }

}
