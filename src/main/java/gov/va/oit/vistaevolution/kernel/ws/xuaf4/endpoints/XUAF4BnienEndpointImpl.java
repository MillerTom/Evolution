/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints;

import gov.va.oit.vistaevolution.kernel.ws.xuaf4.XUAF4ResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4BnienEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4BnienRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4BnienResponse;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.util.XUAF4Constants;
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
@WebService(serviceName = "XUAF4BnienService", portName = "XUAF4BnienServicePort", endpointInterface = "gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4BnienEndpoint")
public class XUAF4BnienEndpointImpl extends SpringBeanAutowiringSupport
		implements XUAF4BnienEndpoint {

	private static Logger LOGGER = Logger
			.getLogger(XUAF4BnienEndpointImpl.class);

	@Autowired
	private XUAF4ResponseFactory xuaf4ResponseFactory;

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	/** raw response from RPC call */
	private String rawResponse;

	/**
	 * No Arguments Constructor
	 * 
	 */
	public XUAF4BnienEndpointImpl() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param xuaf4ResponseFactory
	 * @param vistaLinkContext
	 */
	public XUAF4BnienEndpointImpl(XUAF4ResponseFactory xuaf4ResponseFactory,
			IVistaLinkContext vistaLinkContext) {
		super();
		this.xuaf4ResponseFactory = xuaf4ResponseFactory;
		this.vistaLinkContext = vistaLinkContext;
	}

	@Override
	public XUAF4BnienResponse bnien(XUAF4BnienRequest request)
			throws VistaWebServiceFault {
		try {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(this);
				LOGGER.debug("request= " + request);
			}

			LinkedList<String> params = getParameters(request);

			rawResponse = getVistaLinkContext().makeRPCCall(
					new RPCIdentifier(XUAF4Constants.BNIEN_RPC), params);

			XUAF4BnienResponse response = xuaf4ResponseFactory
					.createXUAF4BnienResponseFromString(rawResponse);

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

	private LinkedList<String> getParameters(XUAF4BnienRequest request) {

		LinkedList<String> parameters = new LinkedList<String>();

		if (request.getXuien() != null) {

			parameters.add(request.getXuien());
		}

		return parameters;
	}

	/**
	 * @return the xuaf4ResponseFactory
	 */
	public XUAF4ResponseFactory getXuaf4ResponseFactory() {
		return xuaf4ResponseFactory;
	}

	/**
	 * @param xuaf4ResponseFactory
	 *            the xuaf4ResponseFactory to set
	 */
	public void setXuaf4ResponseFactory(
			XUAF4ResponseFactory xuaf4ResponseFactory) {
		this.xuaf4ResponseFactory = xuaf4ResponseFactory;
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
		return "XUAF4BnienEndpointImpl [xuaf4ResponseFactory="
				+ xuaf4ResponseFactory + ", vistaLinkContext="
				+ vistaLinkContext + ", rawResponse=" + rawResponse + "]";
	}

}
