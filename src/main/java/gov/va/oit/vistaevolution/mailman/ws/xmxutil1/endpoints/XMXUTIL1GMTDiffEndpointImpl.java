package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.XMXUTIL1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1GMTDiffEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1GMTDiffRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1GMTDiffResponse;
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

@Component
@WebService(serviceName = "XMXUTIL1GMTDiffService", portName = "XMXUTIL1GMTDiffServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1GMTDiffEndpoint")
public class XMXUTIL1GMTDiffEndpointImpl extends SpringBeanAutowiringSupport implements XMXUTIL1GMTDiffEndpoint {

	private static final Logger LOGGER = Logger.getLogger(XMXUTIL1GMTDiffEndpointImpl.class);

	@Autowired
	private XMXUTIL1ResponseFactory responseFactory;

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	/**
	 * default no-arg constructor
	 */
	public XMXUTIL1GMTDiffEndpointImpl() {
		super();
	}

	/**
	 * @param xuaf4ResponseFactory
	 * @param vistaLinkContext
	 */
	public XMXUTIL1GMTDiffEndpointImpl(IVistaLinkContext vistaLinkContext, XMXUTIL1ResponseFactory xmxutil1ResponseFactory) {
		super();
		this.vistaLinkContext = vistaLinkContext;
		this.responseFactory = xmxutil1ResponseFactory;
	}

	/**
	 * @param request
	 * @return
	 * @throws VistaWebServiceFault
	 */

	@Override
	public XMXUTIL1GMTDiffResponse gmtDiff(XMXUTIL1GMTDiffRequest request) throws VistaWebServiceFault {
		LOGGER.debug(request);

		try {
			RPCIdentifier rpcIdentifier = new RPCIdentifier("EVOLUTION", "XMWSOA GMT DIFFERENCE");

			List<Object> params = new LinkedList<Object>();
			params.add(request.getTZ());
			XMXUTIL1GMTDiffResponse response = responseFactory.createGMTDiffResponse(vistaLinkContext.makeRPCCall(rpcIdentifier,
					params));
			LOGGER.debug(response);
			return response;
		} catch (NullPointerException e) {
			LOGGER.error(e);
			throw new VistaWebServiceFault(e);
		}
	}

}
