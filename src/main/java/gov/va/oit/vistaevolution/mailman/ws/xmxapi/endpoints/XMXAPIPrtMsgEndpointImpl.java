package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxapi.XMXAPIResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIPrtMsgEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIArrayEntry;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIPrtMsgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIPrtMsgResponse;
import gov.va.oit.vistaevolution.util.AbstractResponseFactory;
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
@WebService(serviceName = "XMXAPIPrtMsgService", portName = "XMXAPIPrtMsgServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIPrtMsgEndpoint")
public class XMXAPIPrtMsgEndpointImpl extends SpringBeanAutowiringSupport
	implements XMXAPIPrtMsgEndpoint {

    public XMXAPIPrtMsgEndpointImpl() {
	super();
    }

    public XMXAPIPrtMsgEndpointImpl(XMXAPIResponseFactory responseFactory,
	    IVistaLinkContext vistaLinkContext2) {
	super();
	this.responseFactory = responseFactory;
	this.vistaLinkContext = vistaLinkContext2;
    }

    private static final Logger LOGGER = Logger
	    .getLogger(XMXAPIPrtMsgEndpointImpl.class);

    @Autowired
    private IVistaLinkContext vistaLinkContext;

    @Autowired
    private XMXAPIResponseFactory responseFactory;

    @Override
    public XMXAPIPrtMsgResponse prtMsg(XMXAPIPrtMsgRequest request)
	    throws VistaWebServiceFault {
	LOGGER.debug(request);
	LinkedList<Object> params = getParameters(request);
	XMXAPIPrtMsgResponse response;
	if (request.getXmk() != null) {
	    response = responseFactory
		    .createPrtMsgResponse(getVistaLinkContext().makeRPCCall(
			    new RPCIdentifier("XMWSOA PRTMSGS"), params));
	} else {
	    response = responseFactory
		    .createPrtMsgResponse(getVistaLinkContext().makeRPCCall(
			    new RPCIdentifier("XMWSOA PRTMSGM"), params));
	}
	LOGGER.debug(response);
	return response;

    }

    private LinkedList<Object> getParameters(XMXAPIPrtMsgRequest request) {
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

	// XMPRTTO
	parameters.add(request.getXmPrtTo());

	// XMINSTR
	if (request.getXmInstr() != null)
	    parameters.add(request.getXmInstr());
	else
	    parameters.add(new Object());

	// XMSUBJ
	if (request.getXmSubj() != null)
	    parameters.add(request.getXmSubj());
	else
	    parameters.add(new Object());

	// XMTO
	HashMap<Object, Object> xmTo = new HashMap<Object, Object>();
	if (request.getXmTo() != null) {

	    for (XMXAPIArrayEntry current : request.getXmTo()) {
		xmTo.put(current.getIndex(), current.getValue());
	    }

	}
	parameters.add(xmTo);

	return parameters;

    }

    public IVistaLinkContext getVistaLinkContext() {
	return vistaLinkContext;
    }

    public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
	this.vistaLinkContext = vistaLinkContext;
    }

    public AbstractResponseFactory getXmxapiResponseFactory() {
	return responseFactory;
    }

    public void setXmxapiResponseFactory(
	    XMXAPIResponseFactory xmxapiResponseFactory) {
	this.responseFactory = xmxapiResponseFactory;
    }

    public static Logger getLogger() {
	return LOGGER;
    }

}
