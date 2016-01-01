/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmgapi0.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmgapi0.XMGAPI0ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmgapi0.endpoints.interfaces.XMGAPI0SubChkEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmgapi0.model.XMGAPI0SubChkRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmgapi0.model.XMGAPI0SubChkResponse;
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
@WebService(serviceName = "XMGAPI0SubChkService", portName = "XMGAPI0SubChkServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmgapi0.endpoints.interfaces.XMGAPI0SubChkEndpoint")
public class XMGAPI0SubChkEndpointImpl extends SpringBeanAutowiringSupport
		implements XMGAPI0SubChkEndpoint {
	private static final Logger LOGGER = Logger
			.getLogger(XMGAPI0ResponseFactory.class);

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	@Autowired
	private XMGAPI0ResponseFactory responseFactory;

	/**
	 * @param vistaLinkContext
	 * @param xmgapi0ResponseFactory
	 */
	public XMGAPI0SubChkEndpointImpl(IVistaLinkContext vistaLinkContext,
			XMGAPI0ResponseFactory xmgapi0ResponseFactory) {
		super();
		this.setVistaLinkContext(vistaLinkContext);
		this.setResponseFactory(xmgapi0ResponseFactory);
	}

	/**
	 */
	public XMGAPI0SubChkEndpointImpl() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see gov.va.oit.vistaevolution.mailman.ws.xmgapi0.endpoints.interfaces.
	 * SubChkXMGAPI0Endpoint#subChk(java.lang.String)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public XMGAPI0SubChkResponse subChk(XMGAPI0SubChkRequest request)
			throws VistaWebServiceFault {
		try {
			LOGGER.debug(request);

			LinkedList params = new LinkedList();
			params.add(request.getXmSUB());

			String rawResponse = getVistaLinkContext().makeRPCCall(
					new RPCIdentifier("EVOLUTION", "XMWSOA SUBCHK"), params);

			XMGAPI0SubChkResponse response = responseFactory
					.createXMGAPI0SubChkResponseFromString(rawResponse);
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

	public XMGAPI0ResponseFactory getResponseFactory() {
		return responseFactory;
	}

	private void setResponseFactory(
			XMGAPI0ResponseFactory xmgapi0ResponseFactory) {
		this.responseFactory = xmgapi0ResponseFactory;
	}

}
