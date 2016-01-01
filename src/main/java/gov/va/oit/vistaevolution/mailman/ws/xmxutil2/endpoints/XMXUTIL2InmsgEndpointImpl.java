/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.XMXUtil2ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2InmsgEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2InmsgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2InmsgResponse;
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
@WebService(serviceName = "XMXUTIL2InmsgService", 
portName = "XMXUTIL2InmsgServicePort", 
endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2InmsgEndpoint")
public class XMXUTIL2InmsgEndpointImpl extends SpringBeanAutowiringSupport
		implements XMXUTIL2InmsgEndpoint {

	private static final String RPCCALL = "XMWSOA INMSG";
	
	private static final Logger LOGGER = Logger
			.getLogger(XMXUTIL2InmsgEndpointImpl.class);
					
	@Autowired
	private XMXUtil2ResponseFactory responseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	public XMXUTIL2InmsgEndpointImpl() {
		super();
	}

	public XMXUTIL2InmsgEndpointImpl(IVistaLinkContext vistaLinkContext, XMXUtil2ResponseFactory responseFactory) {
		super();
		this.vistaLinkContext = vistaLinkContext;
		this.responseFactory = responseFactory;
	}

	/* (non-Javadoc)
	 * @see gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2InmsgEndpoint#inmsg(gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2InmsgRequest)
	 */
	@Override
	public XMXUTIL2InmsgResponse inmsg(XMXUTIL2InmsgRequest request)
			throws VistaWebServiceFault {
		try {

			List<String> params = new ArrayList<String>();
			
			params.add(request.getXmduz());
			params.add(request.getXmk());
			params.add(request.getXmz());
			params.add(request.getXmzrec());
			params.add(request.getXmflags());
			
            return this.responseFactory
                    .createInmsgFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));
			
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
