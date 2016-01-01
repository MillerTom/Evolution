/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil.XMXUTILResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.XMXUTILKvaporEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILKvaporRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILKvaporResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * @author Christopher Schuck
 *
 */
@Component
@WebService(serviceName = "XMXUTILKvaporService", 
portName = "XMXUTILKvaporPort", 
endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.XMXUTILKvaporEndpoint")
public class XMXUTILKvaporEndpointImpl extends SpringBeanAutowiringSupport
		implements XMXUTILKvaporEndpoint {

	private static final String RPCCALL = "XMWSOA KVAPOR";

	@Autowired
	private XMXUTILResponseFactory responseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	// Log4J setup
	private static final Logger LOGGER = Logger
			.getLogger(XMXUTILKvaporEndpointImpl.class);
	
	public XMXUTILKvaporEndpointImpl() {
		super();
	}

	public XMXUTILKvaporEndpointImpl(XMXUTILResponseFactory responseFactory, IVistaLinkContext vistaLinkContext) {
		super();
		this.responseFactory = responseFactory;
		this.vistaLinkContext = vistaLinkContext;
	}

	/* (non-Javadoc)
	 * @see gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.XMXUTILKvaporEndpoint#kvapor(gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILKvaporRequest)
	 */
	@Override
	public XMXUTILKvaporResponse kvapor(XMXUTILKvaporRequest request)
			throws VistaWebServiceFault {
		try {
			List<String> params = new ArrayList<String>();

			params.add(request.getXmduz());
			params.add(request.getXmk());
			params.add(request.getXmz());
			params.add(request.getXmvapor());

			return this.responseFactory
					.createKvaporFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));
		} catch (VistaWebServiceFault e) {
			LOGGER.error(e);
			throw e;
		} catch (Exception e) {
			LOGGER.error(e);
			throw new VistaWebServiceFault(e);
		}
	}

	public XMXUTILResponseFactory getResponseFactory() {
		return responseFactory;
	}

	public void setResponseFactory(XMXUTILResponseFactory responseFactory) {
		this.responseFactory = responseFactory;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}
	
}
