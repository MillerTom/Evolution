/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmgapi0.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmgapi0.XMGAPI0ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmgapi0.endpoints.interfaces.XMGAPI0SubGetEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmgapi0.model.XMGAPI0SubGetResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmgapi0.model.XMGAPI0SubgetRequest;
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
@WebService(serviceName = "XMGAPI0SubGetService", portName = "XMGAPI0SubGetServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmgapi0.endpoints.interfaces.XMGAPI0SubGetEndpoint")
public class XMGAPI0SubGetEndpointImpl extends SpringBeanAutowiringSupport
		implements XMGAPI0SubGetEndpoint {

	private static final Logger LOGGER = Logger
			.getLogger(XMGAPI0SubGetEndpointImpl.class);

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	@Autowired
	private XMGAPI0ResponseFactory xmgapi0ResponseFactory;

	/**
	 * Constructor accepting {@link IVistaLinkContext} and
	 * {@link XMGAPI0ResponseFactory} objects to instantiate dependencies.
	 * 
	 * @param vistaLinkContext
	 * @param xmgapi0ResponseFactory
	 */
	public XMGAPI0SubGetEndpointImpl(IVistaLinkContext vistaLinkContext,
			XMGAPI0ResponseFactory xmgapi0ResponseFactory) {
		super();
		this.setVistaLinkContext(vistaLinkContext);
		this.setXmgapi0ResponseFactory(xmgapi0ResponseFactory);
	}

	/**
	 * Default empty constructor.
	 */
	public XMGAPI0SubGetEndpointImpl() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see gov.va.oit.vistaevolution.mailman.ws.xmgapi0.endpoints.endpoints.
	 * SubGetXMGAPI0Enpoint#subGet()
	 */
	@Override
	public XMGAPI0SubGetResponse subGet(XMGAPI0SubgetRequest request)
			throws VistaWebServiceFault {
		try {
			LOGGER.debug(request);

			LinkedList<Object> params = new LinkedList<Object>();
			params.add(request.getXMZ());

			XMGAPI0SubGetResponse response = xmgapi0ResponseFactory
					.createXMGAPI0SubGetResponseFromString(getVistaLinkContext()
							.makeRPCCall(new RPCIdentifier("XMWSOA SUBGET"),
									params));

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

	public XMGAPI0ResponseFactory getXmgapi0ResponseFactory() {
		return xmgapi0ResponseFactory;
	}

	private void setXmgapi0ResponseFactory(
			XMGAPI0ResponseFactory xmgapi0ResponseFactory) {
		this.xmgapi0ResponseFactory = xmgapi0ResponseFactory;
	}

}
