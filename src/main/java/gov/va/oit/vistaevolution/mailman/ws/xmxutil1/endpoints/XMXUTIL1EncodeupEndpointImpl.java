package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.XMXUTIL1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1EncodeupEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1EncodeupRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1EncodeupResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.LinkedList;
import java.util.List;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * @author Bill Blackmon <bill.blackmon@medsphere.com>
 * 
 */

@Component
@WebService(serviceName = "XMXUTIL1EncodeupService", portName = "XMXUTIL1EncodeupServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1EncodeupEndpoint")
public class XMXUTIL1EncodeupEndpointImpl extends SpringBeanAutowiringSupport implements XMXUTIL1EncodeupEndpoint {

	private static final Logger LOGGER = Logger.getLogger(XMXUTIL1EncodeupEndpointImpl.class);

	@Autowired
	private XMXUTIL1ResponseFactory responseFactory;

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	/**
	 * default no-arg constructor
	 */
	public XMXUTIL1EncodeupEndpointImpl() {
		super();
	}

	/**
	 * @param xuaf4ResponseFactory
	 * @param vistaLinkContext
	 */
	public XMXUTIL1EncodeupEndpointImpl( IVistaLinkContext vistaLinkContext, XMXUTIL1ResponseFactory xmxutil1ResponseFactory) {
		super();
		this.vistaLinkContext = vistaLinkContext;
		this.responseFactory = xmxutil1ResponseFactory;
	}

	/**
	 * XMXUTIL1EncodeupResponse Encodeup(XMXUTIL1EncodeupRequest request) throws
	 * VistaWebServiceFault;
	 * 
	 * @param request
	 * @return
	 * @throws VistaWebServiceFault
	 */

	@Override
	public XMXUTIL1EncodeupResponse encodeUp(XMXUTIL1EncodeupRequest request) throws VistaWebServiceFault {

		LOGGER.debug(request);

		try {
			RPCIdentifier rpcIdentifier = new RPCIdentifier("EVOLUTION", "XMWSOA ENCODEUP");

			List<Object> params = new LinkedList<Object>();
			params.add(request.getInput());
			XMXUTIL1EncodeupResponse response = responseFactory.createEncodeupResponse(vistaLinkContext.makeRPCCall(rpcIdentifier,
					params));
			LOGGER.debug(response);
			return response;
		} catch (NullPointerException e) {
			LOGGER.error(e);
			throw new VistaWebServiceFault(e);
		}
	}

} // end class
