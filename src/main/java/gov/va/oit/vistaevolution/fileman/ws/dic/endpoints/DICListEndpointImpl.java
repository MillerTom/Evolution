package gov.va.oit.vistaevolution.fileman.ws.dic.endpoints;

import gov.va.oit.vistaevolution.fileman.ws.dic.DICResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.dic.endpoints.interfaces.DICListEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dic.model.DICListRequest;
import gov.va.oit.vistaevolution.fileman.ws.dic.model.DICListResponse;
import gov.va.oit.vistaevolution.fileman.ws.dic.util.DICConstants;
import gov.va.oit.vistaevolution.util.StrUtils;
import gov.va.oit.vistaevolution.util.VistaConstants;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.HashMap;
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
@WebService(serviceName = "DICListService", portName = "DICListServicePort", endpointInterface = "gov.va.oit.vistaevolution.fileman.ws.dic.endpoints.interfaces.DICListEndpoint")
public class DICListEndpointImpl extends SpringBeanAutowiringSupport implements
		DICListEndpoint {

	private static final Logger LOGGER = Logger
			.getLogger(DICListEndpointImpl.class);

	@Autowired
	private DICResponseFactory dicResponseFactory;

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	/** raw response from RPC call */
	private String rawResponse;

	/**
	 * No Arguments Constructor
	 * 
	 */
	public DICListEndpointImpl() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param dicResponseFactory
	 * @param vistaLinkContext
	 */
	public DICListEndpointImpl(DICResponseFactory dicResponseFactory,
			IVistaLinkContext vistaLinkContext) {
		super();
		this.dicResponseFactory = dicResponseFactory;
		this.vistaLinkContext = vistaLinkContext;
	}

	public DICListResponse list(DICListRequest request)
			throws VistaWebServiceFault {
		try {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(this);
				LOGGER.debug("request= " + request);
			}

			List<Object> params = getParameterArray(request);

			rawResponse = getVistaLinkContext().makeRPCCall(
					new RPCIdentifier(DICConstants.LIST_RPC), params);

			DICListResponse response = dicResponseFactory
					.createDICListResponseFromString(rawResponse);

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

	private List<Object> getParameterArray(DICListRequest request) {

		LinkedList<Object> params = new LinkedList<Object>();
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

		if (request.getMax() != null) {
			hm.put("MAX", request.getMax());
		} else {
			hm.put("MAX", "");
		}

		if (request.getFrom() != null) {
			if (request.getFrom().size() > 1) {
				int index = 1;
				HashMap<String, String> FROM = new HashMap<String, String>();
				for (String entry : request.getFrom()) {
					FROM.put(Integer.toString(index), entry);
					index++;
				}
				hm.put("FROM", FROM);
			} else if (request.getFrom().size() == 1) {
				hm.put("FROM", request.getFrom().get(0));
			}
		} else {
			hm.put("FROM", "");
		}

		if (request.getPart() != null && !request.getPart().isEmpty()) {
			if (request.getPart().size() > 1) {
				int index = 1;
				HashMap<String, String> PARTS = new HashMap<String, String>();
				for (String part : request.getPart()) {
					PARTS.put(Integer.toString(index), part);
					index++;
				}
				hm.put("PART", PARTS);
			} else {
				hm.put("PART", request.getPart().get(0));
			}
		} else {
			hm.put("PART", "");
		}

		if (request.getXref() != null) {
			hm.put("XREF", request.getXref());
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

		params.add(hm);
		return params;
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
		return "DICListEndpointImpl [dicResponseFactory=" + dicResponseFactory
				+ ", vistaLinkContext=" + vistaLinkContext + ", rawResponse="
				+ rawResponse + "]";
	}

}
