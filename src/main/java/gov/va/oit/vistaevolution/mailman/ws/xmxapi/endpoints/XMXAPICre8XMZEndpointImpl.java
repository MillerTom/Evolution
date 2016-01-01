package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxapi.XMXAPIResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPICre8XMZEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPICre8XMZRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPICre8XMZResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;

import java.util.LinkedList;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@Component
@WebService(serviceName = "XMXAPICre8XMZService", portName = "XMXAPICre8XMZServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPICre8XMZEndpoint")
public class XMXAPICre8XMZEndpointImpl extends SpringBeanAutowiringSupport
	implements XMXAPICre8XMZEndpoint {

    private static final Logger LOGGER = Logger
	    .getLogger(XMXAPICre8XMZEndpointImpl.class);

    @Autowired
    private XMXAPIResponseFactory responseFactory;

    @Autowired
    private IVistaLinkContext vistaLinkContext;

    public XMXAPICre8XMZEndpointImpl() {
	super();
    }

    public XMXAPICre8XMZEndpointImpl(XMXAPIResponseFactory responseFactory,
	    IVistaLinkContext vistaLinkContext) {
	this.responseFactory = responseFactory;
	this.vistaLinkContext = vistaLinkContext;
    }

    @Override
    public XMXAPICre8XMZResponse cre8Xmz(XMXAPICre8XMZRequest request) {
	LOGGER.debug(request);
	LinkedList<Object> params = new LinkedList<Object>();
	params.add(request.getXmSubj());
	String rawResponse;

	rawResponse = vistaLinkContext.makeRPCCall(new RPCIdentifier(
		"EVOLUTION", "XMWSOA CRE8XMZ"), params);

	XMXAPICre8XMZResponse response = responseFactory
		.createCre8XMZResponse(rawResponse);
	LOGGER.debug(response);
	return response;
    }

}
