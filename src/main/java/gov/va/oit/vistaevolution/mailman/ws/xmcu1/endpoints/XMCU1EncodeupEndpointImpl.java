package gov.va.oit.vistaevolution.mailman.ws.xmcu1.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmcu1.XMCU1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.endpoints.interfaces.XMCU1EncodeupEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.model.XMCU1EncodeupRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.model.XMCU1EncodeupResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.util.XMCU1Constants;
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
@WebService(serviceName = "XMCU1EncodeupService", portName = "XMCU1EncodeupServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmcu1.endpoints.interfaces.XMCU1EncodeupEndpoint")
public class XMCU1EncodeupEndpointImpl extends SpringBeanAutowiringSupport
		implements XMCU1EncodeupEndpoint {

	private static Logger LOGGER = Logger
			.getLogger(XMCU1EncodeupEndpointImpl.class);

	@Autowired
	private XMCU1ResponseFactory xmcu1ResponseFactory;

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	/** raw response from RPC call */
	private String rawResponse;

	/**
	 * No Arguments Constructor
	 * 
	 */
	public XMCU1EncodeupEndpointImpl() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param xmcu1ResponseFactory
	 * @param vistaLinkContext
	 */
	public XMCU1EncodeupEndpointImpl(XMCU1ResponseFactory xmcu1ResponseFactory,
			IVistaLinkContext vistaLinkContext) {
		super();
		this.xmcu1ResponseFactory = xmcu1ResponseFactory;
		this.vistaLinkContext = vistaLinkContext;
	}

	@Override
	public XMCU1EncodeupResponse encodeup(XMCU1EncodeupRequest request)
			throws VistaWebServiceFault {
		try {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(this);
				LOGGER.debug("request= " + request);
			}

			List<Object> params = getParameterArray(request);

			rawResponse = getVistaLinkContext().makeRPCCall(
					new RPCIdentifier(XMCU1Constants.ENCODEUP_RPC), params);

			XMCU1EncodeupResponse response = xmcu1ResponseFactory
					.createXMCU1EncodeupResponseFromString(rawResponse);

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

	private List<Object> getParameterArray(XMCU1EncodeupRequest request) {

		LinkedList<Object> params = new LinkedList<Object>();

		if (request.getInputString() != null) {
			params.add(request.getInputString());
		}

		return params;
	}

	/**
	 * @return the xmcu1ResponseFactory
	 */
	public XMCU1ResponseFactory getXmcu1ResponseFactory() {
		return xmcu1ResponseFactory;
	}

	/**
	 * @param xmcu1ResponseFactory
	 *            the xmcu1ResponseFactory to set
	 */
	public void setXmcu1ResponseFactory(
			XMCU1ResponseFactory xmcu1ResponseFactory) {
		this.xmcu1ResponseFactory = xmcu1ResponseFactory;
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
		return "XMCU1EncodeupEndpointImpl [xmcu1ResponseFactory="
				+ xmcu1ResponseFactory + ", vistaLinkContext="
				+ vistaLinkContext + ", rawResponse=" + rawResponse + "]";
	}

}
