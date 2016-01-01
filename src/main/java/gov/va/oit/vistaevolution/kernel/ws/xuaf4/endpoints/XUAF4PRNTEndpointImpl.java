package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints;

import gov.va.oit.vistaevolution.kernel.ws.xuaf4.XUAF4ResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4PRNTEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4PRNTRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4PRNTResponse;
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
 * @author Bill Blackmon <bill.blackmon@medsphere.com>
 * 
 */
@Component
@WebService(serviceName = "XUAF4PPRNTService", portName = "XUAF4PRNTServicePort", endpointInterface = "gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4PRNTEndpoint")
public class XUAF4PRNTEndpointImpl extends SpringBeanAutowiringSupport implements XUAF4PRNTEndpoint {

	private static final Logger LOGGER = Logger.getLogger(XUAF4PRNTEndpointImpl.class);

	@Autowired
	private XUAF4ResponseFactory responseFactory;

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	/**
	 * default no-arg constructor
	 */
	public XUAF4PRNTEndpointImpl() {
		super();
	}

	/**
	 * @param xuaf4ResponseFactory
	 * @param vistaLinkContext
	 */
	public XUAF4PRNTEndpointImpl(XUAF4ResponseFactory responseFactory, IVistaLinkContext vistaLinkContext) {
		super();
		this.vistaLinkContext = vistaLinkContext;
		this.responseFactory = responseFactory;
	}

	@Override
	public XUAF4PRNTResponse prnt(XUAF4PRNTRequest request) throws VistaWebServiceFault {
		LOGGER.debug(request);
		try {

			LinkedList<String> params = new LinkedList<String>();
			if (request.getSta() != null) {
				params.add(request.getSta());
			}
			XUAF4PRNTResponse response = responseFactory.createPRNTResponseFromString(vistaLinkContext.makeRPCCall(
					new RPCIdentifier("XU SOA PRNT"), params));

			return response;
		} catch (NullPointerException e) {
			LOGGER.error(e);
			throw new VistaWebServiceFault(e);
		}

	}

}
