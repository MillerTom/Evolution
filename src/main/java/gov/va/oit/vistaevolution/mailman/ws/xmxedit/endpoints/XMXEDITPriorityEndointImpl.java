/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import gov.va.oit.vistaevolution.mailman.ws.xmxedit.XMXEDITResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITPriorityEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITPriorityRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITPriorityResponse;
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
@WebService(serviceName = "XMXEDITPriorityService", 
portName = "XMXEDITPriorityPort", 
endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITPriorityEndpoint")
public class XMXEDITPriorityEndointImpl extends SpringBeanAutowiringSupport
		implements XMXEDITPriorityEndpoint {

	private static final String RPCCALL = "XMWSOA PRIORITY";
	
	@Autowired
	private XMXEDITResponseFactory responseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	// Log4J setup
	private static final Logger LOGGER = Logger
				.getLogger(XMXEDITPriorityEndointImpl.class);
	
	public XMXEDITPriorityEndointImpl() {
		super();
	}

	public XMXEDITPriorityEndointImpl(IVistaLinkContext vistaLinkContext, XMXEDITResponseFactory responseFactory) {
		super();
		this.vistaLinkContext = vistaLinkContext;
		this.responseFactory = responseFactory;
	}

	/* (non-Javadoc)
	 * @see gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITPriorityEndpoint#priority(gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITPriorityRequest)
	 */
	@Override
	public XMXEDITPriorityResponse priority(XMXEDITPriorityRequest request)
			throws VistaWebServiceFault {
		try {
			
			List<Object> params = new ArrayList<Object>();
			
			params.add(request.getXmz());
			
			return this.responseFactory
                    .createPriorityFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));
			
		} catch (VistaWebServiceFault e) {
			LOGGER.error(e);
			throw e;
		} catch (Exception e) {
			LOGGER.error(e);
			throw new VistaWebServiceFault(e);
		}
	}

	public XMXEDITResponseFactory getResponseFactory() {
		return responseFactory;
	}

	public void setResponseFactory(XMXEDITResponseFactory responseFactory) {
		this.responseFactory = responseFactory;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}
	
}
