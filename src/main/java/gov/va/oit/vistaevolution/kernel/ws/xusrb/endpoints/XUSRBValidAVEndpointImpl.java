package gov.va.oit.vistaevolution.kernel.ws.xusrb.endpoints;

import gov.va.oit.vistaevolution.kernel.ws.xusrb.XUSRBResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xusrb.endpoints.interfaces.XUSRBValidAVEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xusrb.model.XUSRBValidAVRequest;
import gov.va.oit.vistaevolution.kernel.ws.xusrb.model.XUSRBValidAVResponse;
import gov.va.oit.vistaevolution.kernel.ws.xusrb.util.XUSRBConstants;
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
@WebService(serviceName = "XUSRBValidAVService", portName = "XUSRBValidAVServicePort", endpointInterface = "gov.va.oit.vistaevolution.kernel.ws.xusrb.endpoints.interfaces.XUSRBValidAVEndpoint")
public class XUSRBValidAVEndpointImpl extends SpringBeanAutowiringSupport
		implements XUSRBValidAVEndpoint {

	private static Logger LOGGER = Logger
			.getLogger(XUSRBValidAVEndpointImpl.class);

	@Autowired
	private XUSRBResponseFactory xusrbResponseFactory;

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	/** raw response from RPC call */
	private String rawResponse;

	public XUSRBValidAVEndpointImpl() {
		super();
	}

	public XUSRBValidAVEndpointImpl(XUSRBResponseFactory xusrbResponseFactory,
			IVistaLinkContext vistaLinkContext) {
		super();
		this.xusrbResponseFactory = xusrbResponseFactory;
		this.vistaLinkContext = vistaLinkContext;
	}

	@Override
	public XUSRBValidAVResponse validAV(XUSRBValidAVRequest request)
			throws VistaWebServiceFault {

		try {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(this);
				LOGGER.debug("request= " + request);
			}

			LinkedList<HashMap<Object, Object>> params = new LinkedList<HashMap<Object, Object>>();
			HashMap<Object, Object> parameterMap = getParameterMap(request);
			params.add(parameterMap);

			rawResponse = getVistaLinkContext().makeRPCCall(
					new RPCIdentifier(XUSRBConstants.VALIDAV_RPC), params);

			XUSRBValidAVResponse response = xusrbResponseFactory
					.createXUSRBValidAVResponseFromString(rawResponse);

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

	private HashMap<Object, Object> getParameterMap(XUSRBValidAVRequest request) {

		HashMap<Object, Object> parameterMap = new HashMap<Object, Object>();

		if (request.getAvcode() != null) {
			parameterMap.put("AVCODE", request.getAvcode());
		}

		return parameterMap;
	}

	/**
	 * @return the xusrbResponseFactory
	 */
	public XUSRBResponseFactory getXusrbResponseFactory() {
		return xusrbResponseFactory;
	}

	/**
	 * @param xusrbResponseFactory
	 *            the xusrbResponseFactory to set
	 */
	public void setXusrbResponseFactory(
			XUSRBResponseFactory xusrbResponseFactory) {
		this.xusrbResponseFactory = xusrbResponseFactory;
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
		return "XUSRBValidAVEndpointImpl [xusrbResponseFactory="
				+ xusrbResponseFactory + ", vistaLinkContext="
				+ vistaLinkContext + ", rawResponse=" + rawResponse + "]";
	}

}
