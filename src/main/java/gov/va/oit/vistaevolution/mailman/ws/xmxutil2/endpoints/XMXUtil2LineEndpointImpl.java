/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.XMXUtil2ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUtil2LineEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2LineRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2LineResponse;
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
@WebService(serviceName = "XMXUTIL2LineService", portName = "XMXUTIL2LinePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUtil2LineEndpoint")
public class XMXUtil2LineEndpointImpl extends SpringBeanAutowiringSupport
	implements XMXUtil2LineEndpoint {

    private static final Logger LOGGER = Logger
	    .getLogger(XMXUtil2LineEndpointImpl.class);

    @Autowired
    private IVistaLinkContext vistaLinkContext;

    @Autowired
    private XMXUtil2ResponseFactory responseFactory;

    /**
     * 
     * @param vistaLinkContext
     * @param xmdResponseFactory
     */
    public XMXUtil2LineEndpointImpl(IVistaLinkContext vistaLinkContext,
	    XMXUtil2ResponseFactory responseFactory) {
	super();
	this.vistaLinkContext = vistaLinkContext;
	this.responseFactory = responseFactory;
    }

    /**
     * Default constructor.
     */
    public XMXUtil2LineEndpointImpl() {
	super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.
     * XMXUtil2LineEndpoint
     * #line(gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model
     * .XMLUtil2LineRequest)
     */
    @Override
    public XMXUtil2LineResponse line(XMXUtil2LineRequest request)
	    throws VistaWebServiceFault {

	try {
	    LOGGER.debug(request);
	    List<String> parameters = Arrays.asList(request.getIen());
	    XMXUtil2LineResponse response;
	    response = responseFactory.createLineResponse(vistaLinkContext
		    .makeRPCCall(new RPCIdentifier("EVOLUTION",
			    "XMWSOA NUMB OF LINES IN MSG"), parameters));
	    LOGGER.debug(response);
	    return response;
	} catch (NullPointerException e) {
	    LOGGER.error(e);
	    throw new VistaWebServiceFault(e);
	}
    }
}
