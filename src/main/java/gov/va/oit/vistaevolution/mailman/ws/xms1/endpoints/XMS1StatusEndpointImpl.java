/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xms1.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xms1.XMS1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xms1.endpoints.interfaces.XMS1StatusEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xms1.model.XMS1StatusRequest;
import gov.va.oit.vistaevolution.mailman.ws.xms1.model.XMS1StatusResponse;
import gov.va.oit.vistaevolution.mailman.ws.xms1.util.XMS1Constants;
import gov.va.oit.vistaevolution.util.VistaConstants;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.LinkedList;
import java.util.List;

import javax.jws.WebService;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * @author Leisa Martella
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@Component
@WebService(serviceName = "XMS1StatusService", portName = "XMS1StatusPort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xms1.endpoints.interfaces.XMS1StatusEndpoint")
public class XMS1StatusEndpointImpl extends SpringBeanAutowiringSupport
		implements XMS1StatusEndpoint {

	private static final Logger LOGGER = Logger
			.getLogger(XMS1StatusEndpointImpl.class);

	@Autowired
	private XMS1ResponseFactory xms1ResponseFactory;

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	/** raw response from RPC call */
	private String rawResponse;

	/**
	 * No Arguments Constructor
	 * 
	 */
	public XMS1StatusEndpointImpl() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param xms1ResponseFactory
	 * @param context
	 */
	public XMS1StatusEndpointImpl(XMS1ResponseFactory xms1ResponseFactory,
			IVistaLinkContext context) {
		super();
		this.xms1ResponseFactory = xms1ResponseFactory;
		this.vistaLinkContext = context;
	}

	@Override
	public XMS1StatusResponse status(XMS1StatusRequest request)
			throws VistaWebServiceFault {
		try {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(this);
				LOGGER.debug("request= " + request);
			}

			List<Object> params = getParameters(request);

			rawResponse = getVistaLinkContext().makeRPCCall(
					new RPCIdentifier(XMS1Constants.STATUS_RPC), params);

			XMS1StatusResponse response = xms1ResponseFactory
					.createXMS1StatusResponseFromString(rawResponse);

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

	private List<Object> getParameters(XMS1StatusRequest request) {

		LinkedList<Object> params = new LinkedList<Object>();

		if (request.getXmz() != null) {
			params.add(request.getXmz());
		}

		if (request.getXmser() != null) {
			params.add(request.getXmser());
		}

		return params;
	}

	/**
	 * @return the xms1ResponseFactory
	 */
	public XMS1ResponseFactory getXms1ResponseFactory() {
		return xms1ResponseFactory;
	}

	/**
	 * @param xms1ResponseFactory
	 *            the xms1ResponseFactory to set
	 */
	public void setXms1ResponseFactory(XMS1ResponseFactory xms1ResponseFactory) {
		this.xms1ResponseFactory = xms1ResponseFactory;
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
	 * returns the raw response from the RPC call
	 * 
	 * @return raw string from successful RPC call
	 */
	public String getRawResponse() {
		return rawResponse;
	}

	@Override
	public String toString() {
		return "XMS1StatusEndpointImpl [xms1ResponseFactory="
				+ xms1ResponseFactory + ", vistaLinkContext="
				+ vistaLinkContext + ", rawResponse=" + rawResponse + "]";
	}

}
