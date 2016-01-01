package gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxapib.XMXAPIBResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.interfaces.XMXAPIBQMBoxEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBQMBoxRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBQMBoxResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.utils.XMXAPIBConstants;
import gov.va.oit.vistaevolution.util.VistaConstants;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;

import java.util.LinkedList;
import java.util.List;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@Component
@WebService(serviceName = "XMXAPIBQMBoxService", portName = "XMXAPIBQMBoxServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.interfaces.XMXAPIBQMBoxEndpoint")
public class XMXAPIBQMBoxEndpointImpl extends SpringBeanAutowiringSupport
	implements XMXAPIBQMBoxEndpoint {
    private static final Logger LOGGER = Logger
	    .getLogger(XMXAPIBQMBoxEndpointImpl.class);

    @Autowired
    private XMXAPIBResponseFactory responseFactory;

    @Autowired
    private IVistaLinkContext vistaLinkContext;

    public XMXAPIBQMBoxEndpointImpl(IVistaLinkContext vistaLinkContext,
	    XMXAPIBResponseFactory responseFactory) {
	this.vistaLinkContext = vistaLinkContext;
	this.responseFactory = responseFactory;
    }

    public XMXAPIBQMBoxEndpointImpl() {
	super();
    }

    @Override
    public XMXAPIBQMBoxResponse qMBox(XMXAPIBQMBoxRequest request) {
	LOGGER.debug(request);
	List<Object> params = getParameterArray(request);
	XMXAPIBQMBoxResponse response = responseFactory
		.createQMBoxResponse(vistaLinkContext.makeRPCCall(
			new RPCIdentifier(VistaConstants.CONTEXT,
				XMXAPIBConstants.QMBOX_RPC), params));
	LOGGER.debug(response);
	return response;
    }

    private List<Object> getParameterArray(XMXAPIBQMBoxRequest request) {
	LinkedList<Object> params = new LinkedList<Object>();
	params.add(request.getDuz());
	params.add(request.getXmDuz());
	return params;
    }

}
