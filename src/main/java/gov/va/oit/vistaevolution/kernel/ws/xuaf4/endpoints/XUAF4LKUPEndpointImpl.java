package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints;

import gov.va.oit.vistaevolution.kernel.ws.xuaf4.XUAF4ResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4LKUPEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4LKUPRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4LKUPResponse;
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

@Component
@WebService(serviceName = "XUAF4LKUPService", portName = "XUAF4LKUPServicePort", endpointInterface = "gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4LKUPEndpoint")
public class XUAF4LKUPEndpointImpl extends SpringBeanAutowiringSupport
		implements XUAF4LKUPEndpoint {

	private static final Logger LOGGER = Logger
			.getLogger(XUAF4LKUPEndpointImpl.class);

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	@Autowired
	private XUAF4ResponseFactory xuaf4ResponseFactory;

	/** raw response from RPC call */
	private String rawResponse;

	public XUAF4LKUPEndpointImpl() {
		super();
	}

	public XUAF4LKUPEndpointImpl(XUAF4ResponseFactory xuaf4ResponseFactory,
			IVistaLinkContext vistaLinkContext) {
		super();
		this.xuaf4ResponseFactory = xuaf4ResponseFactory;
		this.vistaLinkContext = vistaLinkContext;

	}

	@Override
	public XUAF4LKUPResponse LKUP(XUAF4LKUPRequest request)
			throws VistaWebServiceFault {
		try {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(this);
				LOGGER.debug("request= " + request);
			}

			LinkedList<Object> params = getParameters(request);

			rawResponse = getVistaLinkContext().makeRPCCall(
					new RPCIdentifier(XUAF4Constants.LKUP_RPC), params);

			XUAF4LKUPResponse response = xuaf4ResponseFactory
					.createLKUPResponseFromString(rawResponse);

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

	private LinkedList<Object> getParameters(XUAF4LKUPRequest request) {

		LinkedList<Object> parameters = new LinkedList<Object>();

		if (request.getInst() != null) {
			parameters.add(request.getInst());
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
		return "XUAF4LKUPEndpointImpl [xuaf4ResponseFactory="
				+ xuaf4ResponseFactory + ", vistaLinkContext="
				+ vistaLinkContext + ", rawResponse=" + rawResponse + "]";
	}

}
