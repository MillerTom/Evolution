/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmvvitae.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.XMVVITAEResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.endpoints.interfaces.XMVVITAEInitEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.model.XMVVITAEInitRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.model.XMVVITAEInitResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.util.XMVVITAEConstants;
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
@WebService(serviceName = "XMVVITAEInitService", portName = "XMVVITAEInitServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmvvitae.endpoints.interfaces.XMVVITAEInitEndpoint")
public class XMVVITAEInitEndpointImpl extends SpringBeanAutowiringSupport
		implements XMVVITAEInitEndpoint {

	private static final Logger LOGGER = Logger
			.getLogger(XMVVITAEInitEndpointImpl.class);

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	@Autowired
	private XMVVITAEResponseFactory xmvvitaeResponseFactory;

	/** raw response from RPC call */
	private String rawResponse;

	/**
	 * No Arguments Constructor
	 */
	public XMVVITAEInitEndpointImpl() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param vistaLinkContext
	 * @param xmvvitaeResponseFactory
	 */
	public XMVVITAEInitEndpointImpl(IVistaLinkContext vistaLinkContext,
			XMVVITAEResponseFactory xmvvitaeResponseFactory) {
		super();
		this.vistaLinkContext = vistaLinkContext;
		this.xmvvitaeResponseFactory = xmvvitaeResponseFactory;
	}

	@Override
	public XMVVITAEInitResponse init(XMVVITAEInitRequest request)
			throws VistaWebServiceFault {
		try {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(this);
				LOGGER.debug("request= " + request);
			}

			LinkedList<Object> params = getParameters(request);

			rawResponse = getVistaLinkContext().makeRPCCall(
					new RPCIdentifier(XMVVITAEConstants.INIT_RPC), params);

			XMVVITAEInitResponse response = xmvvitaeResponseFactory
					.createXMVVITAEInitResponseFromString(rawResponse);

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

	private LinkedList<Object> getParameters(XMVVITAEInitRequest request) {

		LinkedList<Object> parameters = new LinkedList<Object>();

		if (request.getDuz() != null) {
			parameters.add(request.getDuz());
		}

		if (request.getXmduz() != null) {
			parameters.add(request.getXmduz());
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
	 * @return the xmvvitaeResponseFactory
	 */
	public XMVVITAEResponseFactory getXmvvitaeResponseFactory() {
		return xmvvitaeResponseFactory;
	}

	/**
	 * @param xmvvitaeResponseFactory
	 *            the xmvvitaeResponseFactory to set
	 */
	public void setXmvvitaeResponseFactory(
			XMVVITAEResponseFactory xmvvitaeResponseFactory) {
		this.xmvvitaeResponseFactory = xmvvitaeResponseFactory;
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
		return "XMVVITAEInitEndpointImpl [xmvvitaeResponseFactory="
				+ xmvvitaeResponseFactory + ", vistaLinkContext="
				+ vistaLinkContext + ", rawResponse=" + rawResponse + "]";
	}
}
