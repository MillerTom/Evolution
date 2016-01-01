package gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxapib.XMXAPIBResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.interfaces.XMXAPIBQBsktEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBQBsktRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBQBsktResponse;
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
@WebService(serviceName = "XMXAPIBQBsktService", portName = "XMXAPIBQBsktServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.interfaces.XMXAPIBQBsktEndpoint")
public class XMXAPIBQBsktEndpointImpl extends SpringBeanAutowiringSupport
	implements XMXAPIBQBsktEndpoint {

    private static final Logger LOGGER = Logger
	    .getLogger(XMXAPIBQBsktEndpointImpl.class);

    @Autowired
    private XMXAPIBResponseFactory responseFactory;

    @Autowired
    private IVistaLinkContext vistaLinkContext;

    public XMXAPIBQBsktEndpointImpl(IVistaLinkContext vistaLinkContext,
	    XMXAPIBResponseFactory responseFactory) {
	this.vistaLinkContext = vistaLinkContext;
	this.responseFactory = responseFactory;
    }

    public XMXAPIBQBsktEndpointImpl() {
	super();
    }

    @Override
    public XMXAPIBQBsktResponse qBskt(XMXAPIBQBsktRequest request) {
	LOGGER.debug(request);
	List<Object> params = getParameterArray(request);
	XMXAPIBQBsktResponse response = responseFactory
		.createQBsktResponse(vistaLinkContext.makeRPCCall(
			new RPCIdentifier(VistaConstants.CONTEXT,
				XMXAPIBConstants.QBSKT_RPC), params));
	LOGGER.debug(response);
	return response;
    }

    private List<Object> getParameterArray(XMXAPIBQBsktRequest request) {
	LinkedList<Object> params = new LinkedList<Object>();
	params.add(request.getDuz());
	params.add(request.getXmDuz());
	params.add(request.getXmk());
	return params;
    }

}
