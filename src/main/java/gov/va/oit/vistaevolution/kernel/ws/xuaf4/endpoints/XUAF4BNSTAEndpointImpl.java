package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints;

import gov.va.oit.vistaevolution.kernel.ws.xuaf4.XUAF4ResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4BNSTAEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4BNSTARequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4BNSTAResponse;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.util.XUAF4Constants;
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

@Component
@WebService(serviceName = "XUAF4BNSTAService", portName = "XUAF4BNSTAServicePort", endpointInterface = "gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4BNSTAEndpoint")
public class XUAF4BNSTAEndpointImpl extends SpringBeanAutowiringSupport
		implements XUAF4BNSTAEndpoint {

	private static final Logger LOGGER = Logger
			.getLogger(XUAF4BNSTAEndpointImpl.class);

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	@Autowired
	private XUAF4ResponseFactory xuaf4ResponseFactory;

	/** raw response from RPC call */
	private String rawResponse;

	/**
	 * No Arguments Constructor
	 */
	public XUAF4BNSTAEndpointImpl() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param xuaf4ResponseFactory
	 * @param vistaLinkContext
	 */
	public XUAF4BNSTAEndpointImpl(XUAF4ResponseFactory xuaf4ResponseFactory,
			IVistaLinkContext vistaLinkContext) {
		super();
		this.xuaf4ResponseFactory = xuaf4ResponseFactory;
		this.vistaLinkContext = vistaLinkContext;
	}

	@Override
	public XUAF4BNSTAResponse BNSTA(XUAF4BNSTARequest request)
			throws VistaWebServiceFault {
		try {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(this);
				LOGGER.debug("request= " + request);
			}

			List<Object> paramsLst = addParameters(request);

			rawResponse = getVistaLinkContext().makeRPCCall(
					new RPCIdentifier(XUAF4Constants.BNSTA_RPC), paramsLst);

			XUAF4BNSTAResponse response = xuaf4ResponseFactory
					.createBNSTAResponseFromString(rawResponse);

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

	private List<Object> addParameters(XUAF4BNSTARequest request) {

		LinkedList<Object> parameters = new LinkedList<Object>();

		if (request.getSta() != null) {

			parameters.add(request.getSta());
		}
		return parameters;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}

	public XUAF4ResponseFactory getXuaf4ResponseFactory() {
		return xuaf4ResponseFactory;
	}

	public void setXuaf4ResponseFactory(
			XUAF4ResponseFactory xuaf4ResponseFactory) {
		this.xuaf4ResponseFactory = xuaf4ResponseFactory;
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
		return "XUAF4BNSTAEndpointImpl [xuaf4ResponseFactory="
				+ xuaf4ResponseFactory + ", vistaLinkContext="
				+ vistaLinkContext + ", rawResponse=" + rawResponse + "]";
	}

}
