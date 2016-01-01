/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.XMXUTIL1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUtil1INDTEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUtil1INDTRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUtil1INDTResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.LinkedList;

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
@WebService(serviceName = "XMXUtil1INDTService", portName = "XMXUtil1INDTServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUtil1INDTEndpoint")
public class XMXUtil1INDTEndpointImpl extends SpringBeanAutowiringSupport
	implements XMXUtil1INDTEndpoint {

    private static final Logger LOGGER = Logger
	    .getLogger(XMXUtil1INDTEndpointImpl.class);
    @Autowired
    private XMXUTIL1ResponseFactory responseFactory;

    @Autowired
    private IVistaLinkContext vistaLinkContext;

    /**
	 */
    public XMXUtil1INDTEndpointImpl() {
    }

    /**
     * @param vistaLinkContext
     * @param xmdResponseFactory
     */
    public XMXUtil1INDTEndpointImpl(IVistaLinkContext vistaLinkContext,
	    XMXUTIL1ResponseFactory responseFactory) {
	super();
	this.vistaLinkContext = vistaLinkContext;
	this.responseFactory = responseFactory;
    }

    /*
     * (non-Javadoc)
     * 
     * @see gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.
     * XMLUtil1INDTEndpoint
     * #en1(gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model
     * .XMLUtil1INDTRequest)
     */
    @Override
    public XMXUtil1INDTResponse indt(XMXUtil1INDTRequest request)
	    throws VistaWebServiceFault {
	try {
	    LOGGER.debug(request);

	    LinkedList<Object> params = new LinkedList<Object>();
	    params.add(request.getVistaDate());
	    String rawRpcResponse = vistaLinkContext.makeRPCCall(
		    new RPCIdentifier("EVOLUTION", "XMWSOA CONVERT FM2INT DT"),
		    params);

	    XMXUtil1INDTResponse response = responseFactory
		    .getINDTResponse(rawRpcResponse);

	    LOGGER.debug(response.toString());

	    return response;

	} catch (NullPointerException e) {
	    LOGGER.error(e);
	    throw new VistaWebServiceFault(e);
	}
    }

}
