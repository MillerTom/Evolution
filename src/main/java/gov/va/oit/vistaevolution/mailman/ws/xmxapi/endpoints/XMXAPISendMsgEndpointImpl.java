package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxapi.XMXAPIResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPISendMsgEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIArrayEntry;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPISendMsgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPISendMsgResponse;
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
@WebService(serviceName = "XMXAPISendMsgService", portName = "XMXAPISendMsgServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPISendMsgEndpoint")
public class XMXAPISendMsgEndpointImpl extends SpringBeanAutowiringSupport
	implements XMXAPISendMsgEndpoint {

    private static final Logger LOGGER = Logger
	    .getLogger(XMXAPISendMsgEndpointImpl.class);

    private static final String RPC = "XMWSOA SENDMSG";

    @Autowired
    private XMXAPIResponseFactory responseFactory;

    @Autowired
    private IVistaLinkContext vistaLinkContext;

    public XMXAPISendMsgEndpointImpl(XMXAPIResponseFactory responseFactory,
	    IVistaLinkContext vistaLinkContext) {
	this.responseFactory = responseFactory;
	this.vistaLinkContext = vistaLinkContext;
    }

    public XMXAPISendMsgEndpointImpl() {
	super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.
     * XMXAPISendMsgEndpoint
     * #sendMsg(gov.va.oit.vistaevolution.mailman.ws.xmxapi.
     * model.XMXAPISendMsgRequest)
     */
    @Override
    public XMXAPISendMsgResponse sendMsg(XMXAPISendMsgRequest request) {
	LOGGER.debug(request);
	LinkedList<Object> params = getParameters(request);
	XMXAPISendMsgResponse response = responseFactory
		.createSendMsgResponse(vistaLinkContext.makeRPCCall(
			new RPCIdentifier(RPC), params));
	LOGGER.debug(response);
	return response;
    }

    private LinkedList<Object> getParameters(XMXAPISendMsgRequest request) {
	LinkedList<Object> parameters = new LinkedList<Object>();

	// DUZ
	parameters.add(request.getDuz());

	// XMDUZ
	parameters.add(request.getXmDuz());

	// XMSUBJ
	parameters.add(request.getXmSubj());

	// MSG
	parameters.add(request.getMsg());

	// xmTO
	if (request.getXmTo() != null) {
	    HashMap<Object, Object> xmto = new HashMap<Object, Object>();
	    for (XMXAPIArrayEntry current : request.getXmTo()) {
		xmto.put(current.getIndex(), current.getValue());
	    }
	    parameters.add(xmto);
	} else {
	    parameters.add("");
	}

	// XM INSTR
	HashMap<Object, Object> instr = new HashMap<Object, Object>();
	if (request.getXmInstr() != null) {
	    for (XMXAPIArrayEntry current : request.getXmInstr()) {
		instr.put(current.getIndex(), current.getValue());
	    }
	}
	parameters.add(instr);

	return parameters;

    }

}
