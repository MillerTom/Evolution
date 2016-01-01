package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints;

import gov.va.oit.vistaevolution.fileman.ws.dilf.DILFResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.DILFDtEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFDtRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFDtResponse;
import gov.va.oit.vistaevolution.fileman.ws.dilf.util.DILFConstants;
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
@WebService(serviceName = "DILFDtService", portName = "DILFDtServicePort", endpointInterface = "gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.DILFDtEndpoint")
public class DILFDtEndpointImpl extends SpringBeanAutowiringSupport implements
		DILFDtEndpoint {

	private static final Logger LOGGER = Logger
			.getLogger(DILFDtEndpointImpl.class);

	@Autowired
	DILFResponseFactory dilfResponseFactory;

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	/** raw response from RPC call */
	private String rawResponse;

	/**
	 * No Arguments Constructor
	 * 
	 */
	public DILFDtEndpointImpl() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param dilfResponseFactory
	 * @param vistaLinkContext
	 */
	public DILFDtEndpointImpl(DILFResponseFactory dilfResponseFactory,
			IVistaLinkContext vistaLinkContext) {
		super();
		this.dilfResponseFactory = dilfResponseFactory;
		this.vistaLinkContext = vistaLinkContext;
	}

	@Override
	public DILFDtResponse dt(DILFDtRequest request) throws VistaWebServiceFault {
		try {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(this);
				LOGGER.debug("request= " + request);
			}

			ArrayList<HashMap<Object, Object>> params = getParameterMap(request);

			rawResponse = getVistaLinkContext().makeRPCCall(
					new RPCIdentifier(DILFConstants.DT_RPC), params);

			DILFDtResponse response = dilfResponseFactory
					.createDILFDtResponseFromString(rawResponse);

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

	private ArrayList<HashMap<Object, Object>> getParameterMap(
			DILFDtRequest request) {

		ArrayList<HashMap<Object, Object>> parameterMap = new ArrayList<HashMap<Object, Object>>();
		HashMap<Object, Object> hashmap = new HashMap<Object, Object>();

		if (request.getFlags() != null && request.getFlags().size() != 0) {
			StringBuilder flags = new StringBuilder();
			for (String flag : request.getFlags()) {
				flags.append(flag);
			}
			hashmap.put("FLAGS", flags.toString());
		} else {
			hashmap.put("FLAGS", "");
		}

		if (request.getInDate() != null) {
			hashmap.put("IN_DATE", request.getInDate());
		}

		if (request.getLimit() != null) {
			hashmap.put("LIMIT", request.getLimit());
		} else {
			hashmap.put("LIMIT", "");
		}

		parameterMap.add(hashmap);
		return parameterMap;
	}

	/**
	 * @return the dilfResponseFactory
	 */
	public DILFResponseFactory getDilfResponseFactory() {
		return dilfResponseFactory;
	}

	/**
	 * @param dilfResponseFactory
	 *            the dilfResponseFactory to set
	 */
	public void setDilfResponseFactory(DILFResponseFactory dilfResponseFactory) {
		this.dilfResponseFactory = dilfResponseFactory;
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
		return "DILFDtEndpointImpl [dilfResponseFactory=" + dilfResponseFactory
				+ ", vistaLinkContext=" + vistaLinkContext + ", rawResponse="
				+ rawResponse + "]";
	}

}
