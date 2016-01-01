package gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints;

import gov.va.oit.vistaevolution.fileman.ws.dilfd.DILFDResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.interfaces.DILFDExternalEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDExternalRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDExternalResponse;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.util.DILFDConstants;
import gov.va.oit.vistaevolution.util.VistaConstants;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.HashMap;

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
@WebService(serviceName = "DILFDExternalService", portName = "DILFDExternalServicePort", endpointInterface = "gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.interfaces.DILFDExternalEndpoint")
public class DILFDExternalEndpointImpl extends SpringBeanAutowiringSupport
		implements DILFDExternalEndpoint {

	private static final Logger LOGGER = Logger
			.getLogger(DILFDExternalEndpointImpl.class);

	@Autowired
	DILFDResponseFactory dilfdResponseFactory;

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	/** raw response from RPC call */
	private String rawResponse;

	/**
	 * No Arguments Constructor
	 * 
	 */
	public DILFDExternalEndpointImpl() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param dilfdResponseFactory
	 * @param vistaLinkContext
	 */
	public DILFDExternalEndpointImpl(DILFDResponseFactory dilfdResponseFactory,
			IVistaLinkContext vistaLinkContext) {
		super();
		this.dilfdResponseFactory = dilfdResponseFactory;
		this.vistaLinkContext = vistaLinkContext;
	}

	@Override
	public DILFDExternalResponse external(DILFDExternalRequest request)
			throws VistaWebServiceFault {
		try {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(this);
				LOGGER.debug("request= " + request);
			}

			ArrayList<HashMap<String, String>> params = getParameterMap(request);

			rawResponse = getVistaLinkContext().makeRPCCall(
					new RPCIdentifier(DILFDConstants.EXTERNAL_RPC), params);

			DILFDExternalResponse response = dilfdResponseFactory
					.createDILFDExternalResponseFromString(rawResponse);

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

	private ArrayList<HashMap<String, String>> getParameterMap(
			DILFDExternalRequest request) {

		ArrayList<HashMap<String, String>> parameterMap = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> hashmap = new HashMap<String, String>();

		if (request.getFile() != null) {
			hashmap.put("FILE", request.getFile());
		}

		if (request.getField() != null) {
			hashmap.put("FIELD", request.getField());
		}

		if (request.getFlags() != null && request.getFlags().size() != 0) {
			StringBuilder flags = new StringBuilder();
			for (String flag : request.getFlags()) {
				flags.append(flag);
			}
			hashmap.put("FLAGS", flags.toString());
		} else {
			hashmap.put("FLAGS", "");
		}

		if (request.getInternal() != null) {
			hashmap.put("INTERNAL", request.getInternal());
		}

		parameterMap.add(hashmap);
		return parameterMap;
	}

	/**
	 * @return the dilfdResponseFactory
	 */
	public DILFDResponseFactory getDilfdResponseFactory() {
		return dilfdResponseFactory;
	}

	/**
	 * @param dilfdResponseFactory
	 *            the dilfdResponseFactory to set
	 */
	public void setDilfdResponseFactory(
			DILFDResponseFactory dilfdResponseFactory) {
		this.dilfdResponseFactory = dilfdResponseFactory;
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
		return "DILFDExternalEndpointImpl [dilfdResponseFactory="
				+ dilfdResponseFactory + ", vistaLinkContext="
				+ vistaLinkContext + ", rawResponse=" + rawResponse + "]";
	}

}
