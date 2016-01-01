/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.XMXUtil2ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUtil2ZSUBJEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2ZSUBJRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2ZSUBJResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.Arrays;
import java.util.List;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@Component
@WebService(serviceName = "XMXUtil2ZSUBJService", portName = "XMXUtil2ZSUBJServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUtil2ZSUBJEndpoint")
public class XMXUtil2ZSUBJEndpointImpl extends SpringBeanAutowiringSupport
	implements XMXUtil2ZSUBJEndpoint {
    private static final Logger LOGGER = Logger
	    .getLogger(XMXUtil2ZSUBJEndpointImpl.class);

    @Autowired
    private IVistaLinkContext vistaLinkContext;

    @Autowired
    private XMXUtil2ResponseFactory responseFactory;

    /**
     * Default no-arg Constuctor
     */
    public XMXUtil2ZSUBJEndpointImpl() {
	super();
    }

    /**
     * @param vistaLinkContext
     * @param xmxUtil2ResponseFactory
     */
    public XMXUtil2ZSUBJEndpointImpl(IVistaLinkContext vistaLinkContext,
	    XMXUtil2ResponseFactory responseFactory) {
	this.vistaLinkContext = vistaLinkContext;
	this.responseFactory = responseFactory;
    }

    /*
     * (non-Javadoc)
     * 
     * @see gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.
     * XMXUtil2ZSUBJEndpoint
     * #zsubj(gov.va.oit.vistaevolution.mailman.ws.xmxutil2.
     * model.XMXUtil2ZSUBJRequest)
     */
    @Override
    public XMXUtil2ZSUBJResponse zsubj(XMXUtil2ZSUBJRequest request)
	    throws VistaWebServiceFault {
	try {
	    LOGGER.debug(request);

	    List<String> params = Arrays.asList(request.getXmz());

	    String rawResponse = vistaLinkContext.makeRPCCall(
		    new RPCIdentifier("EVOLUTION", "XMWSOA MSG SUBJ"), params);

	    XMXUtil2ZSUBJResponse response = responseFactory
		    .createZSUBJResponse(rawResponse);
	    LOGGER.debug(response);
	    return response;
	} catch (NullPointerException e) {
	    LOGGER.error(e);
	    throw new VistaWebServiceFault(e);
	}
    }
}
