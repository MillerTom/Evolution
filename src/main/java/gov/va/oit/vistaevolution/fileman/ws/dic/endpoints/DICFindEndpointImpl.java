package gov.va.oit.vistaevolution.fileman.ws.dic.endpoints;

import gov.va.oit.vistaevolution.fileman.ws.dic.DICResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.dic.endpoints.interfaces.DICFindEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dic.model.DICFindRequest;
import gov.va.oit.vistaevolution.fileman.ws.dic.model.DICFindResponse;
import gov.va.oit.vistaevolution.fileman.ws.dic.util.DICConstants;
import gov.va.oit.vistaevolution.util.StrUtils;
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
@WebService(serviceName = "DICFindService", portName = "DICFindServicePort", endpointInterface = "gov.va.oit.vistaevolution.fileman.ws.dic.endpoints.interfaces.DICFindEndpoint")
public class DICFindEndpointImpl extends SpringBeanAutowiringSupport implements
		DICFindEndpoint {

	private static final Logger LOGGER = Logger
			.getLogger(DICFindEndpointImpl.class);

	@Autowired
	private DICResponseFactory dicResponseFactory;

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	/** raw response from RPC call */
	private String rawResponse;

	/**
	 * No Arguments Constructor
	 */
	public DICFindEndpointImpl() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param dicResponseFactory
	 * @param vistaLinkContext
	 */
	public DICFindEndpointImpl(DICResponseFactory dicResponseFactory,
			IVistaLinkContext vistaLinkContext) {
		super();
		this.dicResponseFactory = dicResponseFactory;
		this.vistaLinkContext = vistaLinkContext;
	}

	@Override
	public DICFindResponse find(DICFindRequest request)
			throws VistaWebServiceFault {
		try {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(this);
				LOGGER.debug("request= " + request);
			}

			LinkedList<Object> params = getParameters(request);

			rawResponse = getVistaLinkContext().makeRPCCall(
					new RPCIdentifier(DICConstants.FIND_RPC), params);

			DICFindResponse response = dicResponseFactory
					.createDICFindResponseFromString(rawResponse);

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

	private LinkedList<Object> getParameters(DICFindRequest request) {

		LinkedList<Object> parameters = new LinkedList<Object>();
		HashMap<Object, Object> hm = new HashMap<Object, Object>();

		if (request.getFile() != null) {
			hm.put("FILE", request.getFile());
		}

		if (request.getIens() != null) {
			hm.put("IENS", request.getIens());
		} else {
			hm.put("IENS", "");
		}

		if (request.getFields() != null && request.getFields().size() != 0) {
			String fields = StrUtils.join(request.getFields(), ";");
			hm.put("FIELDS", fields);
		} else {
			hm.put("FIELDS", "");
		}

		if (request.getFlags() != null && request.getFlags().size() != 0) {
			StringBuilder flags = new StringBuilder();
			for (String flag : request.getFlags()) {
				flags.append(flag);
			}
			hm.put("FLAGS", flags.toString());
		} else {
			hm.put("FLAGS", "");
		}

		if (request.getValue() != null) {
			if (request.getValue().size() > 1) {
				int index = 1;
				HashMap<String, String> values = new HashMap<String, String>();
				for (String value : request.getValue()) {
					values.put(Integer.toString(index), value);
					index++;
				}
				hm.put("VALUE", values);
			} else if (request.getValue().size() == 1) {
				hm.put("VALUE", request.getValue().get(0));
			}
		}

		if (request.getMax() != null) {
			hm.put("MAX", request.getMax());
		} else {
			hm.put("MAX", "");
		}

		if (request.getXref() != null && request.getXref().size() != 0) {
			String indexes = StrUtils.join(request.getXref(), "^");
			hm.put("XREF", indexes);
		} else {
			hm.put("XREF", "");
		}

		if (request.getScreen() != null) {
			hm.put("SCREEN", request.getScreen());
		} else {
			hm.put("SCREEN", "");
		}

		if (request.getId() != null) {
			hm.put("ID", request.getId());
		} else {
			hm.put("ID", "");
		}

		if (request.getOptions() != null) {
			hm.put("OPTIONS", request.getOptions());
		} else {
			hm.put("OPTIONS", "");
		}

		parameters.add(hm);
		return parameters;
	}

	/**
	 * @return the dicResponseFactory
	 */
	public DICResponseFactory getDicResponseFactory() {
		return dicResponseFactory;
	}

	/**
	 * @param dicResponseFactory
	 *            the dicResponseFactory to set
	 */
	public void setDicResponseFactory(DICResponseFactory dicResponseFactory) {
		this.dicResponseFactory = dicResponseFactory;
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
		return "DICFindEndpointImpl [dicResponseFactory=" + dicResponseFactory
				+ ", vistaLinkContext=" + vistaLinkContext + ", rawResponse="
				+ rawResponse + "]";
	}

}
