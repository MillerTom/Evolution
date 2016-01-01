/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.XMXUtil2ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2InrespEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2InrespRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2InrespResponse;
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
@WebService(serviceName = "XMXUTIL2InrespService", 
portName = "XMXUTIL2InrespServicePort", 
endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2InrespEndpoint")
public class XMXUTIL2InrespEndpointImpl extends SpringBeanAutowiringSupport
		implements XMXUTIL2InrespEndpoint {

	private static final String RPCCALL = "XMWSOA INRESP";
	
	private static final Logger LOGGER = Logger
			.getLogger(XMXUTIL2InrespEndpointImpl.class);
					
	@Autowired
	private XMXUtil2ResponseFactory responseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	public XMXUTIL2InrespEndpointImpl() {
		super();
	}

	public XMXUTIL2InrespEndpointImpl(IVistaLinkContext vistaLinkContext, XMXUtil2ResponseFactory responseFactory) {
		super();
		this.vistaLinkContext = vistaLinkContext;
		this.responseFactory = responseFactory;
	}

	/* (non-Javadoc)
	 * @see gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2InrespEndpoint#inresp(gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2InrespRequest)
	 */
	@Override
	public XMXUTIL2InrespResponse inresp(XMXUTIL2InrespRequest request)
			throws VistaWebServiceFault {
		try {
			
			List<String> params = new ArrayList<String>();
			
			params.add(request.getXmduz());
			params.add(request.getXmz());
			params.add(request.getXmwhich());
			params.add(request.getXmflags());
			
            return this.responseFactory
                    .createInrespFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));
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
