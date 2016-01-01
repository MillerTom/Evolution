/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil.XMXUTILResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.XMXUTILMakenewEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILMakenewRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILMakenewResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.util.XMXUTILConstants;
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
@WebService(serviceName = "XMXUTILMakenewService", portName = "XMXUTILMakenewServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.XMXUTILMakenewEndpoint")
public class XMXUTILMakenewEndpointImpl extends SpringBeanAutowiringSupport
		implements XMXUTILMakenewEndpoint {

	private static final Logger LOGGER = Logger
			.getLogger(XMXUTILMakenewEndpointImpl.class);

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	@Autowired
	private XMXUTILResponseFactory xmxutilResponseFactory;

	/** raw response from RPC call */
	private String rawResponse;

	/**
	 * No Arguments Constructor
	 */
	public XMXUTILMakenewEndpointImpl() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param vistaLinkContext
	 * @param xmxutilResponseFactory
	 */
	public XMXUTILMakenewEndpointImpl(IVistaLinkContext vistaLinkContext,
			XMXUTILResponseFactory xmxutilResponseFactory) {
		super();
		this.vistaLinkContext = vistaLinkContext;
		this.xmxutilResponseFactory = xmxutilResponseFactory;
	}

	@Override
	public XMXUTILMakenewResponse makenew(XMXUTILMakenewRequest request)
			throws VistaWebServiceFault {
		try {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(this);
				LOGGER.debug("request= " + request);
			}

			LinkedList<Object> params = getParameters(request);

			rawResponse = getVistaLinkContext().makeRPCCall(
					new RPCIdentifier(XMXUTILConstants.MAKENEW_RPC), params);

			XMXUTILMakenewResponse response = xmxutilResponseFactory
					.createXMXUTILMakenewResponseFromString(rawResponse);

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

	private LinkedList<Object> getParameters(XMXUTILMakenewRequest request) {

		LinkedList<Object> parameters = new LinkedList<Object>();

		if (request.getXmduz() != null) {
			parameters.add(request.getXmduz());
		}

		if (request.getXmk() != null) {
			parameters.add(request.getXmk());
		}

		if (request.getXmz() != null) {
			parameters.add(request.getXmz());
		}

		if (request.getXmlockit() != null) {
			parameters.add(request.getXmlockit());
		} else {
			parameters.add("0");
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
	 * @return the xmxutilResponseFactory
	 */
	public XMXUTILResponseFactory getXmxutilResponseFactory() {
		return xmxutilResponseFactory;
	}

	/**
	 * @param xmxutilResponseFactory
	 *            the xmxutilResponseFactory to set
	 */
	public void setXmxutilResponseFactory(
			XMXUTILResponseFactory xmxutilResponseFactory) {
		this.xmxutilResponseFactory = xmxutilResponseFactory;
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
		return "XMXUTILMakenewEndpointImpl [xmxutilResponseFactory="
				+ xmxutilResponseFactory + ", vistaLinkContext="
				+ vistaLinkContext + ", rawResponse=" + rawResponse + "]";
	}
}
