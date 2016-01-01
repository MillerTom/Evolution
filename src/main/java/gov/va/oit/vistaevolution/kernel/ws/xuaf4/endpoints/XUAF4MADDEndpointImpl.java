package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints;

import gov.va.oit.vistaevolution.kernel.ws.xuaf4.XUAF4ResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4MADDEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4MADDRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4MADDResponse;
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
@WebService(serviceName = "XUAF4MADDService", portName = "XUAF4MADDServicePort", endpointInterface = "gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4MADDEndpoint")
public class XUAF4MADDEndpointImpl extends SpringBeanAutowiringSupport
		implements XUAF4MADDEndpoint {

	private static final Logger LOGGER = Logger
			.getLogger(XUAF4MADDEndpointImpl.class);

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	@Autowired
	private XUAF4ResponseFactory xuaf4ResponseFactory;

	/** raw response from RPC call */
	private String rawResponse;

	public XUAF4MADDEndpointImpl() {
		super();
	}

	public XUAF4MADDEndpointImpl(XUAF4ResponseFactory xuaf4ResponseFactory,
			IVistaLinkContext vistaLinkContext) {
		super();
		this.xuaf4ResponseFactory = xuaf4ResponseFactory;
		this.vistaLinkContext = vistaLinkContext;
	}

	@Override
	public XUAF4MADDResponse MADD(XUAF4MADDRequest request)
			throws VistaWebServiceFault {
		try {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(this);
				LOGGER.debug("request= " + request);
			}

			LinkedList<Object> params = getParameters(request);

			rawResponse = getVistaLinkContext().makeRPCCall(
					new RPCIdentifier(XUAF4Constants.MADD_RPC), params);

			XUAF4MADDResponse response = xuaf4ResponseFactory
					.createMADDResponseFromString(rawResponse);

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

	private LinkedList<Object> getParameters(XUAF4MADDRequest request) {

		LinkedList<Object> parameters = new LinkedList<Object>();

		if (request.getIen() != null) {
			parameters.add(request.getIen());
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
		return "XUAF4MADDEndpointImpl [xuaf4ResponseFactory="
				+ xuaf4ResponseFactory + ", vistaLinkContext="
				+ vistaLinkContext + ", rawResponse=" + rawResponse + "]";
	}

}
