/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xm.endpoints;

import java.util.ArrayList;
import java.util.HashMap;

import gov.va.oit.vistaevolution.mailman.ws.xm.XMResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xm.endpoints.interfaces.XMKillEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xm.model.XMKillRequest;
import gov.va.oit.vistaevolution.mailman.ws.xm.model.XMKillResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.servlet.ServletContext;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.stereotype.Component;

/**
 * @author Stephen Combs (stephen.combs@synaptekcorp.com)
 * 
 */
@Component
@WebService(serviceName = "XMKillService", portName = "XMKillPort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xm.endpoints.interfaces.XMKillEndpoint")
public class XMKillEndpointImpl extends SpringBeanAutowiringSupport implements XMKillEndpoint {

	@Autowired
	private XMResponseFactory xmResponseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	@Resource
	WebServiceContext wsXMKillContext;
	
	// Log4J setup
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XMKillEndpointImpl.class);
	
	public XMKillEndpointImpl()
	{
		super();
	}
	
	public XMKillEndpointImpl(XMResponseFactory xmResponseFactory, IVistaLinkContext context)
	{
		super();
		this.xmResponseFactory = xmResponseFactory;
		this.vistaLinkContext = context;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gov.va.oit.vistaevolution.mailman.ws.xm.endpoints.interfaces.XMKillEndpoint
	 * #kill(gov.va.oit.vistaevolution.mailman.ws.xm.model.XMKillRequest)
	 */
	@Override
	public XMKillResponse kill(XMKillRequest request)
			throws VistaWebServiceFault {
		
		//takes in no parameters
		ArrayList<String> params = null;
		
		if (wsXMKillContext != null) {
			ServletContext servletContext = (ServletContext) wsXMKillContext
					.getMessageContext().get(MessageContext.SERVLET_CONTEXT);
			SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, servletContext);
		}

		return xmResponseFactory.createXMKillResponseFromString(
		 vistaLinkContext.makeRPCCall(new RPCIdentifier("XMWSOA KILL"),params));
	}
	
	public XMResponseFactory getXmResponseFactory() {
		return xmResponseFactory;
	}

	public void setXmResponseFactory(XMResponseFactory xmResponseFactory) {
		this.xmResponseFactory = xmResponseFactory;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}
	
}
