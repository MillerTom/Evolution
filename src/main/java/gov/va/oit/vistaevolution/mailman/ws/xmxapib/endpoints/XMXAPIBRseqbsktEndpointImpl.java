/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import gov.va.oit.vistaevolution.mailman.ws.xmxapib.XMXAPIBResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.interfaces.XMXAPIBRseqbsktEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBRseqbsktRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBRseqbsktResponse;
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
@WebService(serviceName = "XMXAPIBRseqbsktService", 
portName = "XMXAPIBRseqbsktServicePort", 
endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.interfaces.XMXAPIBRseqbsktEndpoint")
public class XMXAPIBRseqbsktEndpointImpl extends SpringBeanAutowiringSupport
		implements XMXAPIBRseqbsktEndpoint {
	
	private static final String RPCCALL = "XMWSOA RSEQBSKT";

	private static final Logger LOGGER = Logger
			.getLogger(XMXAPIBRseqbsktEndpointImpl.class);

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	@Autowired
	private XMXAPIBResponseFactory responseFactory;

	public XMXAPIBRseqbsktEndpointImpl() {
		super();
	}

	public XMXAPIBRseqbsktEndpointImpl(IVistaLinkContext vistaLinkContext, XMXAPIBResponseFactory responseFactory) {
		super();
		this.vistaLinkContext = vistaLinkContext;
		this.responseFactory = responseFactory;
	}

	/* (non-Javadoc)
	 * @see gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.interfaces.XMXAPIBRseqbsktEndpoint#rseqbskt(gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBRseqbsktRequest)
	 */
	@Override
	public XMXAPIBRseqbsktResponse rseqbskt(XMXAPIBRseqbsktRequest request)
			throws VistaWebServiceFault {
		try {

			List<String> params = new ArrayList<String>();
			
			params.add(request.getDuz());
			params.add(request.getXmDuz());
			params.add(request.getXmk());
			
            return this.responseFactory
                    .createRseqbsktFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));
			
		} catch (VistaWebServiceFault e) {
			LOGGER.error(e);
			throw e;
		} catch (Exception e) {
			LOGGER.error(e);
			throw new VistaWebServiceFault(e);
		}
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}

	public XMXAPIBResponseFactory getResponseFactory() {
		return responseFactory;
	}

	public void setResponseFactory(XMXAPIBResponseFactory responseFactory) {
		this.responseFactory = responseFactory;
	}
	
}
