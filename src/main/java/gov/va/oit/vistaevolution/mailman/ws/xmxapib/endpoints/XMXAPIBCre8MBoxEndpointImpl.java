package gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxapib.XMXAPIBResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.interfaces.XMXAPIBCre8MBoxEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBCre8MBoxRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBCre8MBoxResponse;
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
@WebService(serviceName = "XMXAPIBCre8MBoxService", portName = "XMXAPIBCre8MBoxServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.interfaces.XMXAPIBCre8MBoxEndpoint")
public class XMXAPIBCre8MBoxEndpointImpl extends SpringBeanAutowiringSupport
	implements XMXAPIBCre8MBoxEndpoint {

    private static final Logger LOGGER = Logger
	    .getLogger(XMXAPIBCre8MBoxEndpointImpl.class);

    @Autowired
    private XMXAPIBResponseFactory responseFactory;

    @Autowired
    private IVistaLinkContext vistaLinkContext;

    public XMXAPIBCre8MBoxEndpointImpl() {
	super();
    }

    public XMXAPIBCre8MBoxEndpointImpl(IVistaLinkContext vistaLinkContext,
	    XMXAPIBResponseFactory responseFactory) {
	this.vistaLinkContext = vistaLinkContext;
	this.responseFactory = responseFactory;
    }

    @Override
    public XMXAPIBCre8MBoxResponse cr8MBox(XMXAPIBCre8MBoxRequest request) {
	LOGGER.debug(request);
	List<Object> params = getParameterArray(request);
	XMXAPIBCre8MBoxResponse response = responseFactory
		.createCre8MBoxResponse(vistaLinkContext.makeRPCCall(
			new RPCIdentifier(VistaConstants.CONTEXT,
				XMXAPIBConstants.CRE8MBOX_PRC), params));
	LOGGER.debug(response);
	return response;
    }

    private List<Object> getParameterArray(XMXAPIBCre8MBoxRequest request) {
	LinkedList<Object> params = new LinkedList<Object>();
	params.add(request.getDuz());
	params.add(request.getXmDuz());
	params.add(request.getXmDate());
	return params;
    }

}
