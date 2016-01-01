package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxapi.XMXAPIResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIReplyMsgEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIArrayEntry;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIReplyMsgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIReplyMsgResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;

import java.util.HashMap;
import java.util.LinkedList;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@Component
@WebService(serviceName = "XMXAPIReplyMsgService", portName = "XMXAPIReplyMsgServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIReplyMsgEndpoint")
public class XMXAPIReplyMsgEndpointImpl extends SpringBeanAutowiringSupport
	implements XMXAPIReplyMsgEndpoint {

    private static final Logger LOGGER = Logger
	    .getLogger(XMXAPIReplyMsgEndpointImpl.class);

    @Autowired
    private XMXAPIResponseFactory responseFactory;

    @Autowired
    private IVistaLinkContext vistaLinkContext;

    public XMXAPIReplyMsgEndpointImpl() {
	super();
    }

    public XMXAPIReplyMsgEndpointImpl(IVistaLinkContext vistaLinkContext,
	    XMXAPIResponseFactory responseFactory) {
	this.vistaLinkContext = vistaLinkContext;
	this.responseFactory = responseFactory;
    }

    @Override
    public XMXAPIReplyMsgResponse replyMsg(XMXAPIReplyMsgRequest request) {
	LOGGER.debug(request);
	LinkedList<Object> params = getParameters(request);
	XMXAPIReplyMsgResponse response;
	if (request.getXmk() != null) {
	    response = responseFactory.createReplyMsgResponse(vistaLinkContext
		    .makeRPCCall(new RPCIdentifier("EVOLUTION",
			    "XMWSOA RPLYMSGS"), params));
	} else {
	    response = responseFactory.createReplyMsgResponse(vistaLinkContext
		    .makeRPCCall(new RPCIdentifier("EVOLUTION",
			    "XMWSOA RPLYMSGM"), params));
	}
	LOGGER.debug(response);
	return response;

    }

    private LinkedList<Object> getParameters(final XMXAPIReplyMsgRequest request) {
	LinkedList<Object> parameters = new LinkedList<Object>();

	// DUZ
	parameters.add(request.getDuz());

	// XMDUZ
	parameters.add(request.getXmDuz());

	// XMK
	if (request.getXmk() != null)
	    parameters.add(request.getXmk());

	// XMKZA
	parameters.add(request.getXmkz());

	// XMBODY
	HashMap<String, String> xmBody = new HashMap<String, String>();
	if (request.getXmBody() != null && !request.getXmBody().isEmpty()) {
	    int i = 1;
	    for (String current : request.getXmBody()) {
		xmBody.put(Integer.toString(i), current);
		i++;
	    }
	}
	parameters.add(xmBody);

	// XMInstr
	HashMap<String, String> xmInstr = new HashMap<String, String>();
	if (request.getXmInstr() != null) {
	    for (XMXAPIArrayEntry current : request.getXmInstr()) {
		xmInstr.put(current.getIndex(), current.getValue());
	    }
	}
	parameters.add(xmInstr);

	return parameters;
    }
}
