/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import gov.va.med.vistalink.rpc.RpcRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.XMXEDITResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITTextEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITTextRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITTextResponse;
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
@WebService(serviceName="XMXEDITTextService",
portName="XMXEDITTextServicePort",
endpointInterface="gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITTextEndpoint")
public class XMXEDITTextEndpointImpl extends SpringBeanAutowiringSupport
		implements XMXEDITTextEndpoint {

	private static final String RPCCALL = "XMWSOA TEXT";
	
	@Autowired
	private XMXEDITResponseFactory responseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	// Log4J setup
	private static final Logger LOGGER = Logger
				.getLogger(XMXEDITTextEndpointImpl.class);
	
	public XMXEDITTextEndpointImpl() {
		super();
	}

	public XMXEDITTextEndpointImpl(IVistaLinkContext vistaLinkContext, XMXEDITResponseFactory responseFactory) {
		super();
		this.vistaLinkContext = vistaLinkContext;
		this.responseFactory = responseFactory;
	}

	/* (non-Javadoc)
	 * @see gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITTextEndpoint#text(gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITTextRequest)
	 */
	@Override
	public XMXEDITTextResponse text(XMXEDITTextRequest request)
			throws VistaWebServiceFault {
		
		try {
			List<Object> params = new ArrayList<Object>();
			
			params.add(request.getXmz());
			params.add(request.getXmbody());

			return this.responseFactory
					.createTextFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));   
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
