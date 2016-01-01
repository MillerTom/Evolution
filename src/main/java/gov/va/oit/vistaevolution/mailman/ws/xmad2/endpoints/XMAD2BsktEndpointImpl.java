package gov.va.oit.vistaevolution.mailman.ws.xmad2.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmad2.XMAD2ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmad2.endpoints.interfaces.XMAD2BsktEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmad2.model.XMAD2BsktRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmad2.model.XMAD2BsktResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmad2.util.XMAD2Constants;
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
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@Component
@WebService(serviceName = "XMAD2BsktService", portName = "XMAD2BsktServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmad2.endpoints.interfaces.XMAD2BsktEndpoint")
public class XMAD2BsktEndpointImpl extends SpringBeanAutowiringSupport
		implements XMAD2BsktEndpoint {

	private static Logger LOGGER = Logger
			.getLogger(XMAD2BsktEndpointImpl.class);

	@Autowired
	private XMAD2ResponseFactory xmad2ResponseFactory;

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	/** raw response from RPC call */
	private String rawResponse;

	/**
	 * No Arguments Constructor
	 * 
	 */
	public XMAD2BsktEndpointImpl() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param xmad2ResponseFactory
	 * @param vistaLinkContext
	 */
	public XMAD2BsktEndpointImpl(XMAD2ResponseFactory xmad2ResponseFactory,
			IVistaLinkContext vistaLinkContext) {
		super();
		this.xmad2ResponseFactory = xmad2ResponseFactory;
		this.vistaLinkContext = vistaLinkContext;
	}

	@Override
	public XMAD2BsktResponse bskt(XMAD2BsktRequest request)
			throws VistaWebServiceFault {
		try {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(this);
				LOGGER.debug("request= " + request);
			}

			List<Object> params = getParameters(request);

			rawResponse = getVistaLinkContext().makeRPCCall(
					new RPCIdentifier(XMAD2Constants.BSKT_RPC), params);

			XMAD2BsktResponse response = xmad2ResponseFactory
					.createXMAD2BsktResponseFromString(rawResponse);

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

	private List<Object> getParameters(XMAD2BsktRequest request) {

		LinkedList<Object> params = new LinkedList<Object>();

		if (request.getXmduz() != null) {
			params.add(request.getXmduz());
		}

		if (request.getXmkn() != null) {
			params.add(request.getXmkn());
		}

		return params;
	}

	/**
	 * @return the xmad2ResponseFactory
	 */
	public XMAD2ResponseFactory getXmad2ResponseFactory() {
		return xmad2ResponseFactory;
	}

	/**
	 * @param xmad2ResponseFactory
	 *            the xmad2ResponseFactory to set
	 */
	public void setXmad2ResponseFactory(
			XMAD2ResponseFactory xmad2ResponseFactory) {
		this.xmad2ResponseFactory = xmad2ResponseFactory;
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
		return "XMAD2BsktEndpointImpl [xmad2ResponseFactory="
				+ xmad2ResponseFactory + ", vistaLinkContext="
				+ vistaLinkContext + ", rawResponse=" + rawResponse + "]";
	}

}
