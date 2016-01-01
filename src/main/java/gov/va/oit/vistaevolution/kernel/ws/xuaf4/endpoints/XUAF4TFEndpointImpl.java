/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints;

import gov.va.oit.vistaevolution.kernel.ws.xuaf4.XUAF4ResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4TFEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4TFRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4TFResponse;
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
@WebService(serviceName = "XUAF4TFService", portName = "XUAF4TFServicePort", endpointInterface = "gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4TFEndpoint")
public class XUAF4TFEndpointImpl extends SpringBeanAutowiringSupport implements XUAF4TFEndpoint {

	private static final Logger LOGGER = Logger.getLogger(XUAF4TFEndpointImpl.class);

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	@Autowired
	private XUAF4ResponseFactory responseFactory;

	/**
	 * @param xuaf4ResponseFactory
	 * @param vistaLinkContext
	 */
	public XUAF4TFEndpointImpl(XUAF4ResponseFactory responseFactory, IVistaLinkContext vistaLinkContext) {
		super();
		this.responseFactory = responseFactory;
		this.vistaLinkContext = vistaLinkContext;
	}

	/**
	 * @param xuaf4ResponseFactory
	 * @param vistaLinkContext
	 */
	public XUAF4TFEndpointImpl() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.unit.XUAF4TFEndpoint
	 * #TF(gov.va.oit.vistaevolution.kernel.ws.xuaf4.moel.XUAF4TFRequest)
	 */
	@Override
	public XUAF4TFResponse tf(XUAF4TFRequest request) throws VistaWebServiceFault {
		LOGGER.debug(request);
		try {
			LinkedList<Object> params = new LinkedList<Object>();
			if (request.getIEN() != null) {
				params.add(request.getIEN());
			}

			RPCIdentifier rpcIdentifier = new RPCIdentifier("EVOLUTION", "XU SOA TF");

			XUAF4TFResponse response = responseFactory.createTFXUAF4Response(vistaLinkContext.makeRPCCall(rpcIdentifier, params));
			LOGGER.debug(response);
			return response;
		} catch (NullPointerException e) {
			LOGGER.error(e);
			throw new VistaWebServiceFault(e);
		}
	}



}
