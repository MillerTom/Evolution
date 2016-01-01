package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxapi.XMXAPIResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIAddrNSndEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIAddrNSndRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIAddrNSndResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIArrayEntry;
import gov.va.oit.vistaevolution.util.AbstractResponseFactory;
import gov.va.oit.vistaevolution.util.StrUtils;
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
@WebService(serviceName = "XMXAPIAddrNSndService", portName = "XMXAPIAddrNSndServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIAddrNSndEndpoint")
public class XMXAPIAddrNSndEndpointImpl extends SpringBeanAutowiringSupport
	implements XMXAPIAddrNSndEndpoint {

    public XMXAPIAddrNSndEndpointImpl() {
	super();
    }

    public XMXAPIAddrNSndEndpointImpl(XMXAPIResponseFactory responseFactory,
	    IVistaLinkContext vistaLinkContext2) {
	super();
	this.xmxapiResponseFactory = responseFactory;
	this.vistaLinkContext = vistaLinkContext2;
    }

    private static final String RPC = "XMWSOA ADDRNSND";
    private static final Logger LOGGER = Logger
	    .getLogger(XMXAPIAddrNSndEndpointImpl.class);

    @Autowired
    private IVistaLinkContext vistaLinkContext;

    @Autowired
    private XMXAPIResponseFactory xmxapiResponseFactory;

    public XMXAPIAddrNSndResponse addrNSnd(XMXAPIAddrNSndRequest request)
	    throws VistaWebServiceFault {
	LinkedList<Object> params = getParameters(request);
	return xmxapiResponseFactory
		.createAddrNSendResponseFromString(getVistaLinkContext()
			.makeRPCCall(new RPCIdentifier(RPC), params));

    }

    private LinkedList<Object> getParameters(XMXAPIAddrNSndRequest request) {
	LinkedList<Object> parameters = new LinkedList<Object>();

	// DUZ
	parameters.add(request.getDuz());

	// XMDUZ
	parameters.add(request.getXmDuz());

	// XMSUBJ
	if (StrUtils.hasNoValue(request.getXmSubj())) {
	    parameters.add("");
	} else {
	    parameters.add(request.getXmSubj());
	}

	// MSG
	HashMap<String, String> msg = new HashMap<String, String>();
	if (request.getMsg() != null && !request.getMsg().isEmpty()) {
	    int i = 1;
	    for (String current : request.getMsg()) {
		msg.put(Integer.toString(i), current);
		i++;
	    }
	}
	parameters.add(msg);

	// xmStrip
	if (StrUtils.hasNoValue(request.getXmStrip())) {
	    parameters.add(new Object());
	} else {
	    parameters.add(request.getXmStrip());
	}

	// xmTO
	HashMap<Object, Object> xmto = new HashMap<Object, Object>();
	if (request.getXmTo() != null) {

	    for (XMXAPIArrayEntry current : request.getXmTo()) {
		xmto.put(current.getIndex(), current.getValue());
	    }

	}
	parameters.add(xmto);

	// xmINSTR
	HashMap<Object, Object> instr = new HashMap<Object, Object>();
	if (request.getXmInstr() != null) {

	    for (XMXAPIArrayEntry current : request.getXmInstr()) {
		instr.put(current.getIndex(), current.getValue());
	    }
	}
	parameters.add(instr);

	return parameters;

    }

    public IVistaLinkContext getVistaLinkContext() {
	return vistaLinkContext;
    }

    public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
	this.vistaLinkContext = vistaLinkContext;
    }

    public AbstractResponseFactory getXmxapiResponseFactory() {
	return xmxapiResponseFactory;
    }

    public void setXmxapiResponseFactory(
	    XMXAPIResponseFactory xmxapiResponseFactory) {
	this.xmxapiResponseFactory = xmxapiResponseFactory;
    }

    public static Logger getLogger() {
	return LOGGER;
    }

}
