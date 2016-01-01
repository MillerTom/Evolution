/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxapi.XMXAPIResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIMovemsgsEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIArrayEntry;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIMovemsgsRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIMovemsgsResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.utils.XMXAPIConstants;
import gov.va.oit.vistaevolution.util.VistaConstants;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.HashMap;
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
@WebService(serviceName = "XMXAPIMovemsgsService", portName = "XMXAPIMovemsgsServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIMovemsgsEndpoint")
public class XMXAPIMovemsgsEndpointImpl extends SpringBeanAutowiringSupport
		implements XMXAPIMovemsgsEndpoint {

	private static final Logger LOGGER = Logger
			.getLogger(XMXAPIMovemsgsEndpointImpl.class);

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	@Autowired
	private XMXAPIResponseFactory xmxapiResponseFactory;

	/** raw response from RPC call */
	private String rawResponse;

	/**
	 * No Arguments Constructor
	 */
	public XMXAPIMovemsgsEndpointImpl() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param vistaLinkContext
	 * @param xmxapiResponseFactory
	 */
	public XMXAPIMovemsgsEndpointImpl(IVistaLinkContext vistaLinkContext,
			XMXAPIResponseFactory xmxapiResponseFactory) {
		super();
		this.vistaLinkContext = vistaLinkContext;
		this.xmxapiResponseFactory = xmxapiResponseFactory;
	}

	@Override
	public XMXAPIMovemsgsResponse movemsgs(XMXAPIMovemsgsRequest request)
			throws VistaWebServiceFault {
		try {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(this);
				LOGGER.debug("request= " + request);
			}

			LinkedList<Object> params = getParameters(request);

			rawResponse = getVistaLinkContext().makeRPCCall(
					new RPCIdentifier(XMXAPIConstants.MOVEMSGS_RPC), params);

			XMXAPIMovemsgsResponse response = xmxapiResponseFactory
					.createXMXAPIMovemsgsResponseFromString(rawResponse);

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

	private LinkedList<Object> getParameters(XMXAPIMovemsgsRequest request) {

		LinkedList<Object> parameters = new LinkedList<Object>();

		if (request.getDuz() != null) {
			parameters.add(request.getDuz());
		}

		if (request.getXmDuz() != null) {
			parameters.add(request.getXmDuz());
		}

		if (request.getXmk() != null) {
			parameters.add(request.getXmk());
		}

		if (request.getXmkza() != null) {
			HashMap<String, String> xmkza = new HashMap<String, String>();
			for (XMXAPIArrayEntry entry : request.getXmkza()) {
				xmkza.put(entry.getIndex(), entry.getValue());
			}
			parameters.add(xmkza);
		}

		if (request.getXmkto() != null) {
			parameters.add(request.getXmkto());
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
	 * @return the xmxapiResponseFactory
	 */
	public XMXAPIResponseFactory getXmxapiResponseFactory() {
		return xmxapiResponseFactory;
	}

	/**
	 * @param xmxapiResponseFactory
	 *            the xmxapiResponseFactory to set
	 */
	public void setXmxapiResponseFactory(
			XMXAPIResponseFactory xmxapiResponseFactory) {
		this.xmxapiResponseFactory = xmxapiResponseFactory;
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
		return "XMXAPIMovemsgsEndpointImpl [xmxapiResponseFactory="
				+ xmxapiResponseFactory + ", vistaLinkContext="
				+ vistaLinkContext + ", rawResponse=" + rawResponse + "]";
	}

}
