/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxedit.XMXEDITResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITConfidEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITConfidRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITConfidResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@WebService(serviceName = "XMXEDITConfidService", 
portName = "XMXEDITConfidPort", 
endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITConfidEndpoint")
public class XMXEDITConfidEndpointImpl extends SpringBeanAutowiringSupport
		implements XMXEDITConfidEndpoint {

	private static final String RPCCALL = "XMWSOA CONFID TOGGLE";
	
	@Autowired
	private XMXEDITResponseFactory responseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	// Log4J setup
	private static final Logger LOGGER = Logger
				.getLogger(XMXEDITConfidEndpointImpl.class);
	
	public XMXEDITConfidEndpointImpl() {
		super();
	}

	public XMXEDITConfidEndpointImpl(IVistaLinkContext vistaLinkContext, XMXEDITResponseFactory responseFactory) {
		super();
		this.vistaLinkContext = vistaLinkContext;
		this.responseFactory = responseFactory;
	}

	/* (non-Javadoc)
	 * @see gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITConfidEndpoint#confid(gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITConfidRequest)
	 */
	@Override
	public XMXEDITConfidResponse confid(XMXEDITConfidRequest request)
			throws VistaWebServiceFault {
		
		try {
			List<Object> params = new ArrayList<Object>();
			
			params.add(request.getXmz());
			
			Map<String, String> hMap = new HashMap<String, String>();
			hMap.put("FLAGS", request.getXminstr());
			params.add(hMap);
			
			return this.responseFactory
                    .createConfidFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));
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
