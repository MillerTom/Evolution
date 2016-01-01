/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xqcs.endpoints;

import gov.va.oit.vistaevolution.kernel.ws.xqcs.XQCSResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xqcs.endpoints.interfaces.XQCSChkEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xqcs.model.XQCSChkRequest;
import gov.va.oit.vistaevolution.kernel.ws.xqcs.model.XQCSChkResponse;
import gov.va.oit.vistaevolution.kernel.ws.xqcs.util.XQCSConstants;
import gov.va.oit.vistaevolution.util.VistaConstants;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
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
@WebService(serviceName = "XQCSChkService", portName = "XQCSChkServicePort", endpointInterface = "gov.va.oit.vistaevolution.kernel.ws.xqcs.endpoints.interfaces.XQCSChkEndpoint")
public class XQCSChkEndpointImpl extends SpringBeanAutowiringSupport implements
		XQCSChkEndpoint {

	private static Logger LOGGER = Logger.getLogger(XQCSChkEndpointImpl.class);

	@Autowired
	private XQCSResponseFactory xqcsResponseFactory;

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	/** raw response from RPC call */
	private String rawResponse;

	/**
	 * No Arguments Constructor
	 * 
	 */
	public XQCSChkEndpointImpl() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param xqcsResponseFactory
	 * @param vistaLinkContext
	 */
	public XQCSChkEndpointImpl(XQCSResponseFactory xqcsResponseFactory,
			IVistaLinkContext vistaLinkContext) {
		super();
		this.setVistaLinkContext(vistaLinkContext);
		this.setXqcsResponseFactory(xqcsResponseFactory);
	}

	@Override
	public XQCSChkResponse chk(XQCSChkRequest request)
			throws VistaWebServiceFault {
		try {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(this);
				LOGGER.debug("request= " + request);
			}

			List<Object> params = getParameterArray(request);

			rawResponse = getVistaLinkContext().makeRPCCall(
					new RPCIdentifier(XQCSConstants.CHK_RPC), params);

			XQCSChkResponse response = xqcsResponseFactory
					.createXQCSChkResponseFromString(rawResponse);

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

	private List<Object> getParameterArray(XQCSChkRequest request) {

		ArrayList<Object> params = new ArrayList<Object>();

		if (request.getXuien() != null) {
			params.add(request.getXuien());
		}

		if (request.getXuopt() != null) {
			params.add(request.getXuopt());
		}

		if (request.getXurpc() != null) {
			params.add(request.getXurpc());
		} else {

			params.add("");
		}

		return params;
	}

	/**
	 * @return the xqcsResponseFactory
	 */
	public XQCSResponseFactory getXqcsResponseFactory() {
		return xqcsResponseFactory;
	}

	/**
	 * @param xqcsResponseFactory
	 *            the xqcsResponseFactory to set
	 */
	public void setXqcsResponseFactory(XQCSResponseFactory xqcsResponseFactory) {
		this.xqcsResponseFactory = xqcsResponseFactory;
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
		return "XQCSChkEndpointImpl [xqcsResponseFactory="
				+ xqcsResponseFactory + ", vistaLinkContext="
				+ vistaLinkContext + ", rawResponse=" + rawResponse + "]";
	}

}
