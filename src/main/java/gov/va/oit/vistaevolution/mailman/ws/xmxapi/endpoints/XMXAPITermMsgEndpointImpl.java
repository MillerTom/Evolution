package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxapi.XMXAPIResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPITermMsgEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIArrayEntry;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPITermMsgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPITermMsgResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.HashMap;
import java.util.LinkedList;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@Component
@WebService(serviceName = "XMXAPITermMsgService", portName = "XMXAPITermMsgServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPITermMsgEndpoint")
public class XMXAPITermMsgEndpointImpl extends SpringBeanAutowiringSupport
	implements XMXAPITermMsgEndpoint {

    private static final Logger LOGGER = Logger
	    .getLogger(XMXAPITermMsgEndpointImpl.class);

    @Autowired
    private XMXAPIResponseFactory responseFactory;

    @Autowired
    private IVistaLinkContext vistaLinkContext;

    public XMXAPITermMsgEndpointImpl() {
	super();
    }

    public XMXAPITermMsgEndpointImpl(XMXAPIResponseFactory responseFactory,
	    IVistaLinkContext vistaLinkContext) {
	this.responseFactory = responseFactory;
	this.vistaLinkContext = vistaLinkContext;
    }

    @Override
    public XMXAPITermMsgResponse termMsg(XMXAPITermMsgRequest request)
	    throws VistaWebServiceFault {
	LOGGER.debug(request);
	LinkedList<Object> params = getParameters(request);
	XMXAPITermMsgResponse response;
	if (request.getXmk() != null) {
	    response = responseFactory.createTermMsgResponse(vistaLinkContext
		    .makeRPCCall(new RPCIdentifier("EVOLUTION",
			    "XMWSOA TERMMSGS"), params));
	} else {
	    response = responseFactory.createTermMsgResponse(vistaLinkContext
		    .makeRPCCall(new RPCIdentifier("EVOLUTION",
			    "XMWSOA TERMMSGM"), params));
	}
	LOGGER.debug(response);
	return response;

    }

    private LinkedList<Object> getParameters(final XMXAPITermMsgRequest request) {
	LinkedList<Object> parameters = new LinkedList<Object>();

	// DUZ
	parameters.add(request.getDuz());

	// XMDUZ
	parameters.add(request.getXmDuz());

	// XMK
	if (request.getXmk() != null)
	    parameters.add(request.getXmk());

	// XMKZA
	HashMap<Object, Object> xmkza = new HashMap<Object, Object>();
	if (request.getXmkza() != null) {

	    for (XMXAPIArrayEntry current : request.getXmkza()) {
		xmkza.put(current.getIndex(), current.getValue());
	    }

	}
	parameters.add(xmkza);

	return parameters;
    }
}
