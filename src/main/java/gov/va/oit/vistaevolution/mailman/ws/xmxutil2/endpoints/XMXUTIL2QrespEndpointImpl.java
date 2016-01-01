/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.XMXUtil2ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2QrespEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2QrespRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2QrespResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

/**
 * @author Christopher Schuck
 *
 */
@Component
@WebService(serviceName = "XMXUTIL2QrespService", portName = "XMXUTIL2QrespPort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2QrespEndpoint")
public class XMXUTIL2QrespEndpointImpl extends SpringBeanAutowiringSupport
		implements XMXUTIL2QrespEndpoint {

	private static final String RPCCALL = "XMWSOA IS MSG RESPONSE";

	@Autowired
	private XMXUtil2ResponseFactory responseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	// Log4J setup
	private static final Logger LOGGER = Logger
			.getLogger(XMXUTIL2QrespEndpointImpl.class);
	
	public XMXUTIL2QrespEndpointImpl() {
		super();
	}

	public XMXUTIL2QrespEndpointImpl(IVistaLinkContext vistaLinkContext, XMXUtil2ResponseFactory responseFactory) {
		super();
		this.vistaLinkContext = vistaLinkContext;
		this.responseFactory = responseFactory;
	}

	/* (non-Javadoc)
	 * @see gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2QrespEndpoint#qresp(gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2QrespRequest)
	 */
	@Override
	public XMXUTIL2QrespResponse qresp(XMXUTIL2QrespRequest request)
			throws VistaWebServiceFault {

		try {

			List<String> params = new ArrayList<String>();

			params.add(request.getXmz());

			if (request.getXmwhich() != null && !request.getXmwhich().equals("")) {
				params.add(request.getXmwhich());
			}

			return this.responseFactory
					.createQrespFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));
		} catch (VistaWebServiceFault e) {
			LOGGER.error(e);
			throw e;
		} catch (Exception e) {
			LOGGER.error(e);
			throw new VistaWebServiceFault(e);
		}
	}

	public XMXUtil2ResponseFactory getResponseFactory() {
		return responseFactory;
	}

	public void setResponseFactory(XMXUtil2ResponseFactory responseFactory) {
		this.responseFactory = responseFactory;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}

}
