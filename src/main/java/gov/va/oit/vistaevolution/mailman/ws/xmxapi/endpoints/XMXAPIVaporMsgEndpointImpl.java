package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxapi.XMXAPIResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIVaporMsgEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIArrayEntry;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIVaporMsgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIVaporMsgResponse;
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
@WebService(serviceName = "XMXAPIVaporMsgService", portName = "XMXAPIVaporMsgServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIVaporMsgEndpoint")
public class XMXAPIVaporMsgEndpointImpl extends SpringBeanAutowiringSupport
	implements XMXAPIVaporMsgEndpoint {

    private static final Logger LOGGER = Logger
	    .getLogger(XMXAPIVaporMsgEndpointImpl.class);

    @Autowired
    private XMXAPIResponseFactory responseFactory;

    @Autowired
    private IVistaLinkContext vistaLinkContext;

    public XMXAPIVaporMsgEndpointImpl(XMXAPIResponseFactory responseFactory,
	    IVistaLinkContext vistaLinkContext) {
	this.responseFactory = responseFactory;
	this.vistaLinkContext = vistaLinkContext;
    }

    @Override
    public XMXAPIVaporMsgResponse vaporMsg(XMXAPIVaporMsgRequest request)
	    throws VistaWebServiceFault {
	LOGGER.debug(request);
	LinkedList<Object> params = getParameters(request);
	XMXAPIVaporMsgResponse response;
	if (request.getXmk() != null) {
	    response = (XMXAPIVaporMsgResponse) responseFactory
		    .createVaporMsgResponse(vistaLinkContext.makeRPCCall(
			    new RPCIdentifier("EVOLUTION", "XMWSOA VAPORMSGS"),
			    params));
	} else {
	    response = (XMXAPIVaporMsgResponse) responseFactory
		    .createVaporMsgResponse(vistaLinkContext.makeRPCCall(
			    new RPCIdentifier("EVOLUTION", "XMWSOA VAPORMSGM"),
			    params));
	}
	LOGGER.debug(response);
	return response;

    }

    private LinkedList<Object> getParameters(final XMXAPIVaporMsgRequest request) {
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

	// XMVPDATE
	parameters.add(request.getXmVpDate());

	return parameters;
    }

    public XMXAPIVaporMsgEndpointImpl() {
	super();
    }

}
