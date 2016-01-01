/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxapig.endpoints;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import gov.va.oit.vistaevolution.mailman.ws.xmxapig.XMXAPIGResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapig.endpoints.interfaces.XMXAPIGJoinEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapig.model.XMXAPIGJoinRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapig.model.XMXAPIGJoinResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.XMXEDITConfidEndpointImpl;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

/**
 * @author Christopher Schuck
 *
 */
@Component
@WebService(serviceName = "XMXAPIGJoinService", 
portName = "XMXAPIGJoinPort", 
endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxapig.endpoints.interfaces.XMXAPIGJoinEndpoint")
public class XMXAPIGJoinEndpointImpl extends SpringBeanAutowiringSupport
		implements XMXAPIGJoinEndpoint {
	
	private static final String RPCCALL = "XMWSOA JOIN";
	
	// Log4J setup
		private static final Logger LOGGER = Logger
					.getLogger(XMXAPIGJoinEndpointImpl.class);
		
	@Autowired
	private XMXAPIGResponseFactory responseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;

	public XMXAPIGJoinEndpointImpl() {
		super();
	}

	public XMXAPIGJoinEndpointImpl(IVistaLinkContext vistaLinkContext, XMXAPIGResponseFactory responseFactory) {
		super();
		this.vistaLinkContext = vistaLinkContext;
		this.responseFactory = responseFactory;
	}

	/* (non-Javadoc)
	 * @see gov.va.oit.vistaevolution.mailman.ws.xmxapig.endpoints.interfaces.XMXAPIGJoinEndpoint#join(gov.va.oit.vistaevolution.mailman.ws.xmxapig.model.XMXAPIGJoinRequest)
	 */
	@Override
	public XMXAPIGJoinResponse join(XMXAPIGJoinRequest request)
			throws VistaWebServiceFault {
		
		try {
			List<Object> params = new ArrayList<Object>();
			
			params.add(request.getDuz());
			params.add(request.getXmduz());
			params.add(request.getXmgroup());
			/*
			Map<String, Object> hMap = new HashMap<String, Object>();
			hMap.put("XMINSTR", request.getXminstr());
			params.add(hMap);
			*/
			params.add(request.getXminstr());
			
			return this.responseFactory
                    .createJoinFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));
		} catch (VistaWebServiceFault e) {
			LOGGER.error(e);
			throw e;
		} catch (Exception e) {
			LOGGER.error(e);
			throw new VistaWebServiceFault(e);
		}
	}

	public XMXAPIGResponseFactory getResponseFactory() {
		return responseFactory;
	}

	public void setResponseFactory(XMXAPIGResponseFactory responseFactory) {
		this.responseFactory = responseFactory;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}

}
