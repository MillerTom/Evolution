/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.XMXUtil2ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUtil2KSeqNEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2KSeqNRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUtil2KSeqNResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.Arrays;

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
@WebService(serviceName = "XMXUtil2KSeqNService", portName = "XMXUtil2KSeqNServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUtil2KSeqNEndpoint")
public class XMXUtil2KSeqNEndpointImpl extends SpringBeanAutowiringSupport
	implements XMXUtil2KSeqNEndpoint {

    private static final Logger LOGGER = Logger
	    .getLogger(XMXUtil2KSeqNEndpointImpl.class);
    @Autowired
    private IVistaLinkContext vistaLinkContext;

    @Autowired
    private XMXUtil2ResponseFactory responseFactory;

    /**
     * @param vistaLinkContext
     * @param xmdResponseFactory
     */
    public XMXUtil2KSeqNEndpointImpl(IVistaLinkContext vistaLinkContext,
	    XMXUtil2ResponseFactory responseFactory) {
	this.vistaLinkContext = vistaLinkContext;
	this.responseFactory = responseFactory;
    }

    public XMXUtil2KSeqNEndpointImpl() {
	super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.
     * XMXUtil2KSEQNEndpoint
     * #kseqn(gov.va.oit.vistaevolution.mailman.ws.xmxutil2.
     * model.XMXUtil2KSEQNRequest)
     */
    @Override
    public XMXUtil2KSeqNResponse kseqn(XMXUtil2KSeqNRequest request)
	    throws VistaWebServiceFault {
	LOGGER.debug(request);

	XMXUtil2KSeqNResponse response = responseFactory
		.getKSeqNResponse(vistaLinkContext
			.makeRPCCall(new RPCIdentifier("EVOLUTION",
				"XMWSOA GET MSG SEQ NO"), Arrays.asList(
				request.getDuz(), request.getXmk(),
				request.getXmz())));
	LOGGER.debug(response);
	return response;
    }

}
