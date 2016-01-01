/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil.XMXUTILResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.XMXUTILBmsgctEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILBmsgctRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILBmsgctResponse;
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
@WebService(serviceName = "XMXUTILBmsgctService", portName = "XMXUTILBmsgctPort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.XMXUTILBmsgctEndpoint")
public class XMXUTILBmsgctEndpointImpl extends SpringBeanAutowiringSupport
		implements XMXUTILBmsgctEndpoint {
	
	private static final String RPCCALL = "XMWSOA NUMB OF MSG IN BSK";

	@Autowired
	private XMXUTILResponseFactory responseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	// Log4J setup
	private static final Logger LOGGER = Logger
			.getLogger(XMXUTILBmsgctEndpointImpl.class);
	
	public XMXUTILBmsgctEndpointImpl() {
		super();
	}

	public XMXUTILBmsgctEndpointImpl(XMXUTILResponseFactory responseFactory, IVistaLinkContext vistaLinkContext) {
		super();
		this.responseFactory = responseFactory;
		this.vistaLinkContext = vistaLinkContext;
	}

	/* (non-Javadoc)
	 * @see gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.XMXUTILBmsgctEndpoint#bmsgct(gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILBmsgctRequest)
	 */
	@Override
	public XMXUTILBmsgctResponse bmsgct(XMXUTILBmsgctRequest request)
			throws VistaWebServiceFault {
		
		try {
			List<String> params = new ArrayList<String>();

			params.add(request.getXmduz());
			params.add(request.getXmk());

			return this.responseFactory
					.createBmsgctFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));
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

	public void setResponseFactory(
			XMXUTILResponseFactory responseFactory) {
		this.responseFactory = responseFactory;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}

}
