/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.XMXUtil2ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUtil2FromEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2FromRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2FromResponse;
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
@WebService(serviceName = "XMXUTIL2FromService", portName = "XMXUTIL2FromPort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUtil2FromEndpoint")
public class XMXUtil2FromEndpointImpl extends SpringBeanAutowiringSupport
	implements XMXUtil2FromEndpoint {

    private static final Logger LOGGER = Logger
	    .getLogger(XMXUtil2FromEndpointImpl.class);

    @Autowired
    private IVistaLinkContext vistaLinkContext;

    @Autowired
    private XMXUtil2ResponseFactory responseFactory;

    /**
     * 
     * @param vistaLinkContext
     * @param xmdResponseFactory
     */
    public XMXUtil2FromEndpointImpl(IVistaLinkContext vistaLinkContext,
	    XMXUtil2ResponseFactory responseFactory) {
	super();
	this.vistaLinkContext = vistaLinkContext;
	this.responseFactory = responseFactory;
    }

    /**
     * Default constructor.
     */
    public XMXUtil2FromEndpointImpl() {
	super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.
     * XMXUtil2FromEndpoint
     * #line(gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model
     * .XMLUtil2FromRequest)
     */
    @Override
    public XMXUtil2FromResponse from(XMXUtil2FromRequest request)
	    throws VistaWebServiceFault {

	try {
	    LOGGER.debug(request);
	    List<String> parameters = Arrays.asList(request.getXmz());
	    XMXUtil2FromResponse response;
	    response = responseFactory.createFromResponse(vistaLinkContext
		    .makeRPCCall(new RPCIdentifier("EVOLUTION",
			    "XMWSOA GET MSG FROM INFO"), parameters));
	    LOGGER.debug(response);
	    return response;
	} catch (NullPointerException e) {
	    LOGGER.error(e);
	    throw new VistaWebServiceFault(e);
	}
    }
}
