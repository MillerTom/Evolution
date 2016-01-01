package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIAnsrMsgEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIAnsrMsgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIAnsrMsgResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIArrayEntry;
import gov.va.oit.vistaevolution.util.StrUtils;
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
@WebService(serviceName = "XMXAPIAnsrMsgService", portName = "XMXAPIAnsrMsgServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIAnsrMsgEndpoint")
public class XMXAPIAnsrMsgEndpointImpl extends SpringBeanAutowiringSupport
	implements XMXAPIAnsrMsgEndpoint {

    private static final Logger LOGGER = Logger
	    .getLogger(XMXAPIAnsrMsgEndpointImpl.class);

    @Autowired
    private IVistaLinkContext vistaLinkContext;

    public XMXAPIAnsrMsgEndpointImpl() {
	super();
    }

    public XMXAPIAnsrMsgEndpointImpl(IVistaLinkContext vistaLinkContext) {
	this.vistaLinkContext = vistaLinkContext;
    }

    @Override
    public XMXAPIAnsrMsgResponse ansrMsg(XMXAPIAnsrMsgRequest request) {

	LOGGER.debug(request);
	LinkedList<Object> params = getParameters(request);
	String rawResponse;
	if (!StrUtils.hasNoValue(request.getXmk())) {
	    rawResponse = vistaLinkContext.makeRPCCall(new RPCIdentifier(
		    "EVOLUTION", "XMWSOA ANSRMSGM"), params);
	} else {
	    rawResponse = vistaLinkContext.makeRPCCall(new RPCIdentifier(
		    "EVOLUTION", "XMWSOA ANSRMSGS"), params);
	}

	XMXAPIAnsrMsgResponse response = new XMXAPIAnsrMsgResponse();
	response.setXmz(rawResponse);
	LOGGER.debug(response);
	return response;
    }

    private LinkedList<Object> getParameters(XMXAPIAnsrMsgRequest request) {
	LinkedList<Object> parameters = new LinkedList<Object>();

	// Duz
	parameters.add(request.getDuz());

	// XMK
	if (!StrUtils.hasNoValue(request.getXmk())) {
	    parameters.add(request.getXmk());
	}

	// XMKZ
	parameters.add(request.getXmkz());

	// Subject
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

	// XMINSTR
	HashMap<Object, Object> instr = new HashMap<Object, Object>();
	if (request.getXmInstr() != null) {

	    for (XMXAPIArrayEntry current : request.getXmInstr()) {
		instr.put(current.getIndex(), current.getValue());
	    }
	    parameters.add(instr);

	} else
	    parameters.add(instr);

	return parameters;

    }
}
