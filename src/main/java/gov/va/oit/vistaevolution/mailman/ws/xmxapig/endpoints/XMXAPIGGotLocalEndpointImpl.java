package gov.va.oit.vistaevolution.mailman.ws.xmxapig.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxapig.XMXAPIGResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapig.endpoints.interfaces.XMXAPIGGotLocalEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapig.model.XMXAPIGGotLocalRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapig.model.XMXAPIGGotLocalResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.LinkedList;

import javax.jws.WebService;

import org.apache.log4j.Logger;
// import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * 
 * @author Joshua.Zangari
 * 
 */
@Component
@WebService(serviceName = "XMXAPIGGotLocalService", portName = "XMXAPIGGotLocalPort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxapig.endpoints.interfaces.XMXAPIGGotLocalEndpoint")
public class XMXAPIGGotLocalEndpointImpl extends SpringBeanAutowiringSupport
	implements XMXAPIGGotLocalEndpoint {

    private static final Logger LOGGER = Logger
	    .getLogger(XMXAPIGGotLocalEndpointImpl.class);

    @Autowired
    private XMXAPIGResponseFactory responseFactory;

    @Autowired
    private IVistaLinkContext vistaLinkContext;

    private static final String RPC_NAME = "XMWSOA GOTLOCAL";

    /**
     * default no-arg constructor
     */
    public XMXAPIGGotLocalEndpointImpl() {
    }

    /**
     * @param xuaf4ResponseFactory
     * @param vistaLinkContext
     */
    public XMXAPIGGotLocalEndpointImpl(XMXAPIGResponseFactory responseFactory,
	    IVistaLinkContext vistaLinkContext) {
	super();

	this.setVistaLinkContext(vistaLinkContext);
	this.setResponseFactory(responseFactory);
    }

    @Override
    public XMXAPIGGotLocalResponse GotLocal(XMXAPIGGotLocalRequest request)
	    throws VistaWebServiceFault {

	LOGGER.debug(request);
	LinkedList<Object> params = new LinkedList<Object>();

	params.add(request.getGROUP());

	XMXAPIGGotLocalResponse response;
	response = responseFactory.createGotLocalResponse(getVistaLinkContext()
		.makeRPCCall(new RPCIdentifier(RPC_NAME), params));
	LOGGER.debug(response);
	return response;
    }

    public IVistaLinkContext getVistaLinkContext() {
	return vistaLinkContext;
    }

    protected void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
	this.vistaLinkContext = vistaLinkContext;
    }

    public XMXAPIGResponseFactory getResponseFactory() {
	return responseFactory;
    }

    protected void setResponseFactory(XMXAPIGResponseFactory responseFactory2) {
	this.responseFactory = responseFactory2;
    }

} // end class
