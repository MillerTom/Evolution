package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxapi.XMXAPIResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPISendBullEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIArrayEntry;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPISendBullRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPISendBullResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@Component
@WebService(serviceName = "XMXAPISendBullService", portName = "XMXAPISendBullServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPISendBullEndpoint")
public class XMXAPISendBullEndpointImpl extends SpringBeanAutowiringSupport
	implements XMXAPISendBullEndpoint {

    private static final Logger LOGGER = Logger
	    .getLogger(XMXAPISendBullEndpointImpl.class);

    @Autowired
    private XMXAPIResponseFactory responseFactory;

    @Autowired
    private IVistaLinkContext vistaLinkContext;

    public XMXAPISendBullEndpointImpl(XMXAPIResponseFactory responseFactory,
	    IVistaLinkContext vistaLinkContext) {
	this.responseFactory = responseFactory;
	this.vistaLinkContext = vistaLinkContext;
    }

    public XMXAPISendBullEndpointImpl() {
	super();
    }

    @Override
    public XMXAPISendBullResponse sendBull(XMXAPISendBullRequest request) {
	LOGGER.debug(request);
	try {
	    LinkedList<Object> parameterMap = getParameters(request);

	    RPCIdentifier rpcIdentifier = new RPCIdentifier("EVOLUTION",
		    "XMWSOA SENDBULL");

	    XMXAPISendBullResponse response = responseFactory
		    .createXMXAPISendBullResponse(vistaLinkContext.makeRPCCall(
			    rpcIdentifier, parameterMap));
	    LOGGER.debug(response);
	    return response;
	} catch (NullPointerException e) {
	    LOGGER.error(e);
	    throw new VistaWebServiceFault(e);
	}
    }

    private LinkedList<Object> getParameters(final XMXAPISendBullRequest request) {
	LinkedList<Object> parameters = new LinkedList<Object>();

	// DUZ
	parameters.add(request.getDuz());

	// XMDUZ
	parameters.add(request.getXmDuz());

	// XMK
	parameters.add(request.getXmbn());

	HashMap<String, String> msg = new HashMap<String, String>();
	if (request.getMsg() != null && !request.getMsg().isEmpty()) {
	    int i = 1;
	    for (String current : request.getMsg()) {
		msg.put(Integer.toString(i), current);
		i++;
	    }
	}
	parameters.add(msg);

	// XMKZA
	parameters.add(getHashMapForArray(request.getXmParm()));

	// XMTO
	parameters.add(getHashMapForArray(request.getXmTo()));

	// XMINSTR
	parameters.add(getHashMapForArray(request.getXmInstr()));

	return parameters;
    }

    public HashMap<Object, Object> getHashMapForArray(
	    final List<XMXAPIArrayEntry> xmParm2) {
	HashMap<Object, Object> xmParm = new HashMap<Object, Object>();
	if (xmParm2 != null) {

	    for (XMXAPIArrayEntry current : xmParm2) {
		xmParm.put(current.getIndex(), current.getValue());
	    }

	}
	return xmParm;
    }

}
