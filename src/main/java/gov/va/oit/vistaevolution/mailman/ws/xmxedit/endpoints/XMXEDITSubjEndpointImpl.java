/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import gov.va.oit.vistaevolution.mailman.ws.xmxedit.XMXEDITResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITSubjEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITSubjRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITSubjResponse;
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
@WebService(serviceName = "XMXEDITSubjService", 
portName = "XMXEDITSubjPort", 
endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITSubjEndpoint")
public class XMXEDITSubjEndpointImpl extends SpringBeanAutowiringSupport
		implements XMXEDITSubjEndpoint {

	private static final String RPCCALL = "XMWSOA SUBJ";
	
	@Autowired
	private XMXEDITResponseFactory responseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	// Log4J setup
	private static final Logger LOGGER = Logger
				.getLogger(XMXEDITSubjEndpointImpl.class);
	
	public XMXEDITSubjEndpointImpl() {
		super();
	}

	public XMXEDITSubjEndpointImpl(IVistaLinkContext vistaLinkContext, XMXEDITResponseFactory responseFactory) {
		super();
		this.vistaLinkContext = vistaLinkContext;
		this.responseFactory = responseFactory;
	}

	/* (non-Javadoc)
	 * @see gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITSubjEndpoint#subj(gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITSubjRequest)
	 */
	@Override
	public XMXEDITSubjResponse subj(XMXEDITSubjRequest request)
			throws VistaWebServiceFault {

		try {
			List<String> params = new ArrayList<String>();
			
			params.add(request.getXmz());
			params.add(request.getXmsubj());
			
			return this.responseFactory
                    .createSubjFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));
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
