/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints;

import gov.va.oit.vistaevolution.kernel.ws.xuaf4.XUAF4ResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4STAEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4STARequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4STAResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapig.endpoints.XMXAPIGAddMbrsEndpointImpl;
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
@WebService(serviceName = "XUAF4STAService", portName = "XUAF4STAServicePort", endpointInterface = "gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4STAEndpoint")
public class XUAF4STAEndpointImpl  extends SpringBeanAutowiringSupport implements XUAF4STAEndpoint {
	private static final Logger LOGGER = Logger.getLogger(XMXAPIGAddMbrsEndpointImpl.class);
	
	@Autowired
	private XUAF4ResponseFactory xuaf4ResponseFactory;

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	/**
	 * Default no-arg constructor
	 */
	public XUAF4STAEndpointImpl() {
		super();
	}

	/**
	 * @param xuaf4ResponseFactory
	 * @param vistaLinkContext
	 */
	public XUAF4STAEndpointImpl(XUAF4ResponseFactory xuaf4ResponseFactory,
			IVistaLinkContext vistaLinkContext) {
		super();
		this.xuaf4ResponseFactory = xuaf4ResponseFactory;
		this.vistaLinkContext = vistaLinkContext;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.
	 * XUAF4STAEndpoint
	 * #STA(gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4STARequest)
	 */
	@Override
	public XUAF4STAResponse sta(XUAF4STARequest request) throws VistaWebServiceFault {
		LOGGER.debug(request);
		try {
			LinkedList<Object> params = new LinkedList<Object>();
			params.add(request.getIen());
	
			XUAF4STAResponse response = xuaf4ResponseFactory.createStaResponse(getVistaLinkContext()
					.makeRPCCall(new RPCIdentifier("XU SOA STA"), params));
			LOGGER.debug(response);
			return response;
		} catch (NullPointerException e) {
			LOGGER.error(e);
			throw new VistaWebServiceFault(e);
		}
	}

	public XUAF4ResponseFactory getXuaf4ResponseFactory() {
		return xuaf4ResponseFactory;
	}

	protected void setXuaf4ResponseFactory(
			XUAF4ResponseFactory xuaf4ResponseFactory) {
		this.xuaf4ResponseFactory = xuaf4ResponseFactory;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	protected void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}

}
