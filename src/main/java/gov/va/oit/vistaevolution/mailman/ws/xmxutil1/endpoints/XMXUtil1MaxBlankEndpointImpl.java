/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.XMXUTIL1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUtil1MaxBlankEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUtil1MaxBlankRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUtil1MaxBlankResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.LinkedList;
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
@WebService(serviceName = "XMXUtil1MaxBlankService", portName = "XMXUtil1MaxBlankServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUtil1MaxBlankEndpoint")
public class XMXUtil1MaxBlankEndpointImpl extends SpringBeanAutowiringSupport implements XMXUtil1MaxBlankEndpoint {

	private static final Logger LOG = Logger.getLogger(XMXUtil1MaxBlankEndpointImpl.class);

	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	@Autowired
	private XMXUTIL1ResponseFactory responseFactory;

	

	/**
	 * Default no-arg constructor.
	 */
	public XMXUtil1MaxBlankEndpointImpl() {
		
	}

	public XMXUtil1MaxBlankEndpointImpl(IVistaLinkContext vistaLinkContext, XMXUTIL1ResponseFactory responseFactory) {
		this.vistaLinkContext = vistaLinkContext;
		this.responseFactory = responseFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.
	 * XMXUtil1MaxBlankEndpoint
	 * #maxBlank(gov.va.oit.vistaevolution.mailman.ws.xmxutil1
	 * .model.XMXUtil1MaxBlankRequest)
	 */
	@Override
	public XMXUtil1MaxBlankResponse maxBlank(XMXUtil1MaxBlankRequest request) throws VistaWebServiceFault {
		
		LOG.debug(request);

		try {
			RPCIdentifier rpcIdentifier = new RPCIdentifier("EVOLUTION", "XMWSOA REDUCE SPACE");

			List<Object> params = new LinkedList<Object>();
			params.add(request.getInput());
			XMXUtil1MaxBlankResponse response = responseFactory.createMaxBlankResponse(vistaLinkContext.makeRPCCall(rpcIdentifier,
					params));
			LOG.debug(response);
			return response;
		} catch (NullPointerException e) {
			LOG.error(e);
			throw new VistaWebServiceFault(e);
		}
//		LinkedList<Object> params = new LinkedList<Object>();
//		params.add(request.getInput());
//
//		RPCIdentifier rpcId = new RPCIdentifier("EVOLUTION", "XMWSOA REDUCE SPACE");
//		String rawResponse = getVistaLinkContext().makeRPCCall(rpcId, params);
//
//		LOG.debug(this.toString() + ": RPC responded with with:\n" + rawResponse);
//
//		XMXUtil1MaxBlankResponse response = new XMXUtil1MaxBlankResponse(rawResponse);
//
//		LOG.debug(this.toString() + " is responding to SOAP Request\n:" + request.toString() + " \nWith Response XML:\n"
//				+ response.toString());
//
//		return response;

	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	protected void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}

}
