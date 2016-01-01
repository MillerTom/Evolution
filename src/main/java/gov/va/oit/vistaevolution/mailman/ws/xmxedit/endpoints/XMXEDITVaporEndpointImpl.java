/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxedit.XMXEDITResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITVaporEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITVaporRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITVaporResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * @author Christopher Schuck
 *
 */
@Component
@WebService(serviceName = "XMXEDITVaporService", 
portName = "XMXEDITVaporPort", 
endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITVaporEndpoint")
public class XMXEDITVaporEndpointImpl extends SpringBeanAutowiringSupport
		implements XMXEDITVaporEndpoint {

	private static final String RPCCALL = "XMWSOA VAPOR";
	
	@Autowired
	private XMXEDITResponseFactory responseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	// Log4J setup
	private static final Logger LOGGER = Logger
				.getLogger(XMXEDITVaporEndpointImpl.class);
	
	public XMXEDITVaporEndpointImpl() {
		super();
	}

	public XMXEDITVaporEndpointImpl(IVistaLinkContext vistaLinkContext, XMXEDITResponseFactory responseFactory) {
		super();
		this.vistaLinkContext = vistaLinkContext;
		this.responseFactory = responseFactory;
	}

	/* (non-Javadoc)
	 * @see gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITVaporEndpoint#vapor(gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITVaporRequest)
	 */
	@Override
	public XMXEDITVaporResponse vapor(XMXEDITVaporRequest request)
			throws VistaWebServiceFault {

		try {
			List<Object> params = new ArrayList<Object>();
			
			params.add(request.getXmz());
			params.add(request.getXmvapor());
			
			return this.responseFactory
                    .createVaporFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));
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
