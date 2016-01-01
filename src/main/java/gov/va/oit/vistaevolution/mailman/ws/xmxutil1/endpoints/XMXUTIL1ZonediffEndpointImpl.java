/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.XMXUTIL1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1ZonediffEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1ZonediffRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1ZonediffResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.utils.XMXUTIL1Constants;
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
@WebService(serviceName = "XMXUTIL1ZonediffService", portName = "XMXUTIL1ZonediffServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1ZonediffEndpoint")
public class XMXUTIL1ZonediffEndpointImpl extends SpringBeanAutowiringSupport
		implements XMXUTIL1ZonediffEndpoint {

	private static final Logger LOGGER = Logger
			.getLogger(XMXUTIL1ZonediffEndpointImpl.class);

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	@Autowired
	private XMXUTIL1ResponseFactory xmxutil1ResponseFactory;

	/** raw response from RPC call */
	private String rawResponse;

	/**
	 * No Arguments Constructor
	 */
	public XMXUTIL1ZonediffEndpointImpl() {
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param vistaLinkContext
	 * @param xmxutil1ResponseFactory
	 */
	public XMXUTIL1ZonediffEndpointImpl(IVistaLinkContext vistaLinkContext,
			XMXUTIL1ResponseFactory xmxutil1ResponseFactory) {
		this.vistaLinkContext = vistaLinkContext;
		this.xmxutil1ResponseFactory = xmxutil1ResponseFactory;
	}

	@Override
	public XMXUTIL1ZonediffResponse zonediff(XMXUTIL1ZonediffRequest request)
			throws VistaWebServiceFault {
		try {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(this);
				LOGGER.debug("request= " + request);
			}

			LinkedList<Object> params = getParameters(request);

			rawResponse = getVistaLinkContext().makeRPCCall(
					new RPCIdentifier(XMXUTIL1Constants.ZONEDIFF_RPC), params);

			XMXUTIL1ZonediffResponse response = xmxutil1ResponseFactory
					.createXMXUTIL1ZonediffResponseFromString(rawResponse);

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

	private LinkedList<Object> getParameters(XMXUTIL1ZonediffRequest request) {

		LinkedList<Object> parameters = new LinkedList<Object>();

		if (request.getXmyt() != null) {
			parameters.add(request.getXmyt());
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
	 * @return the xmxutil1ResponseFactory
	 */
	public XMXUTIL1ResponseFactory getXmxutil1ResponseFactory() {
		return xmxutil1ResponseFactory;
	}

	/**
	 * @param xmxutil1ResponseFactory
	 *            the xmxutil1ResponseFactory to set
	 */
	public void setXmxutil1ResponseFactory(
			XMXUTIL1ResponseFactory xmxutil1ResponseFactory) {
		this.xmxutil1ResponseFactory = xmxutil1ResponseFactory;
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
		return "XMXUTIL1ZonediffEndpointImpl [xmxutil1ResponseFactory="
				+ xmxutil1ResponseFactory + ", vistaLinkContext="
				+ vistaLinkContext + ", rawResponse=" + rawResponse + "]";
	}

}
