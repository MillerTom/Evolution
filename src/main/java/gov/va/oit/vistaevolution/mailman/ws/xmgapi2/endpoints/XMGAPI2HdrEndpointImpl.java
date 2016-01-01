/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmgapi2.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmgapi0.XMGAPI0ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmgapi2.XMGAPI2ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmgapi2.endpoints.interfaces.XMGAPI2HdrEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmgapi2.model.XMGAPI2HdrRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmgapi2.model.XMGAPI2HdrResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.LinkedList;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@Component
@WebService(serviceName = "XMGAPI2HdrService", portName = "XMGAPI2HdrServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmgapi2.endpoints.interfaces.XMGAPI2HdrEndpoint")
public class XMGAPI2HdrEndpointImpl extends SpringBeanAutowiringSupport implements XMGAPI2HdrEndpoint {
	private static final Logger LOGGER = Logger.getLogger(XMGAPI0ResponseFactory.class);

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	@Autowired
	private XMGAPI2ResponseFactory responseFactory;

	/**
	 * @param vistaLinkContext
	 * @param xmgapi0ResponseFactory
	 */
	public XMGAPI2HdrEndpointImpl(IVistaLinkContext vistaLinkContext, XMGAPI2ResponseFactory responseFactory) {
		super();
		this.setVistaLinkContext(vistaLinkContext);
		this.responseFactory = responseFactory;
	}

	/**
	 */
	public XMGAPI2HdrEndpointImpl() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see gov.va.oit.vistaevolution.mailman.ws.xmgapi0.endpoints.interfaces.
	 * SubChkXMGAPI0Endpoint#subChk(java.lang.String)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public XMGAPI2HdrResponse hdr(XMGAPI2HdrRequest request) throws VistaWebServiceFault {
		try {
			LOGGER.debug(request);

			LinkedList params = new LinkedList();
			params.add(request.getDuz());
			params.add(request.getXmduz());
			params.add(request.getMsg());
			params.add(request.getFlag());

			String rawResponse = getVistaLinkContext().makeRPCCall(new RPCIdentifier("EVOLUTION", "XMWSOA HDR"), params);

			XMGAPI2HdrResponse response = responseFactory.createXMGAPI2HdrResponseFromString(rawResponse);
			LOGGER.debug(response);

			return response;
		} catch (NullPointerException e) {
			LOGGER.error(e);
			throw new VistaWebServiceFault(e);
		}
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	private void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}

	public XMGAPI2ResponseFactory getResponseFactory() {
		return responseFactory;
	}

	public void setResponseFactory(XMGAPI2ResponseFactory responseFactory) {
		this.responseFactory = responseFactory;
	}

}
