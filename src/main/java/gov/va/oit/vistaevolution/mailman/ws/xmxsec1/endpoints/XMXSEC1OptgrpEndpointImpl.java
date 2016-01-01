/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.XMXSEC1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.interfaces.XMXSEC1OptgrpEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1OptgrpRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1OptgrpResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.utils.XMXSEC1Constants;
import gov.va.oit.vistaevolution.util.VistaConstants;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.LinkedList;

import javax.jws.WebService;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@Component
@WebService(serviceName = "XMXSEC1OptgrpService", portName = "XMXSEC1OptgrpServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.interfaces.XMXSEC1OptgrpEndpoint")
public class XMXSEC1OptgrpEndpointImpl extends SpringBeanAutowiringSupport
		implements XMXSEC1OptgrpEndpoint {

	private static final Logger LOGGER = Logger
			.getLogger(XMXSEC1OptgrpEndpointImpl.class);

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	@Autowired
	private XMXSEC1ResponseFactory xmxsec1ResponseFactory;

	/** raw response from RPC call */
	private String rawResponse;

	/**
	 * No Arguments Constructor
	 */
	public XMXSEC1OptgrpEndpointImpl() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param vistaLinkContext
	 * @param xmxsec1ResponseFactory
	 */
	public XMXSEC1OptgrpEndpointImpl(IVistaLinkContext vistaLinkContext,
			XMXSEC1ResponseFactory xmxsec1ResponseFactory) {
		super();
		this.vistaLinkContext = vistaLinkContext;
		this.xmxsec1ResponseFactory = xmxsec1ResponseFactory;
	}

	@Override
	public XMXSEC1OptgrpResponse optgrp(XMXSEC1OptgrpRequest request)
			throws VistaWebServiceFault {
		try {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(this);
				LOGGER.debug("request= " + request);
			}

			LinkedList<Object> params = getParameters(request);

			rawResponse = getVistaLinkContext().makeRPCCall(
					new RPCIdentifier(XMXSEC1Constants.OPTGRP_RPC), params);

			XMXSEC1OptgrpResponse response = xmxsec1ResponseFactory
					.createXMXSEC1OptgrpResponseFromString(rawResponse);

			return response;
		} catch (Exception e) {
			VistaWebServiceFault fault = new VistaWebServiceFault(
					VistaConstants.ERR_MSG_ABNORMAL + " : [ " + e.getMessage()
							+ " ]");
			if (LOGGER.isEnabledFor(Level.ERROR)) {
				LOGGER.error(fault);
			}
			throw new VistaWebServiceFault(e);
		}
	}

	private LinkedList<Object> getParameters(XMXSEC1OptgrpRequest request) {

		LinkedList<Object> parameters = new LinkedList<Object>();

		if (request.getXmduz() != null) {
			parameters.add(request.getXmduz());
		}

		if (request.getXmk() != null) {
			parameters.add(request.getXmk());
		}

		return parameters;
	}

	/**
	 * @return the vistaLinkContext
	 */
	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	/**
	 * @param vistaLinkContext
	 *            the vistaLinkContext to set
	 */
	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}

	/**
	 * @return the xmxsec1ResponseFactory
	 */
	public XMXSEC1ResponseFactory getXmxsec1ResponseFactory() {
		return xmxsec1ResponseFactory;
	}

	/**
	 * @param xmxsec1ResponseFactory
	 *            the xmxsec1ResponseFactory to set
	 */
	public void setXmxsec1ResponseFactory(
			XMXSEC1ResponseFactory xmxsec1ResponseFactory) {
		this.xmxsec1ResponseFactory = xmxsec1ResponseFactory;
	}

	/**
	 * returns the raw response from the RPC call
	 * 
	 * @return raw string from successful RPC call
	 */
	public String getRawResponse() {
		return rawResponse;
	}

	@Override
	public String toString() {
		return "XMXSEC1OptgrpEndpointImpl [xmxsec1ResponseFactory="
				+ xmxsec1ResponseFactory + ", vistaLinkContext="
				+ vistaLinkContext + ", rawResponse=" + rawResponse + "]";
	}

}
