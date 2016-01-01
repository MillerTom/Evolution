/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xqcs.endpoints;

import gov.va.oit.vistaevolution.kernel.ws.xqcs.XQCSResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xqcs.endpoints.interfaces.XQCSOptlkEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xqcs.model.XQCSOptlkRequest;
import gov.va.oit.vistaevolution.kernel.ws.xqcs.model.XQCSOptlkResponse;
import gov.va.oit.vistaevolution.kernel.ws.xqcs.util.XQCSConstants;
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
@WebService(serviceName = "XQCSOptlkService", portName = "XQCSOptlkServicePort", endpointInterface = "gov.va.oit.vistaevolution.kernel.ws.xqcs.endpoints.interfaces.XQCSOptlkEndpoint")
public class XQCSOptlkEndpointImpl extends SpringBeanAutowiringSupport
		implements XQCSOptlkEndpoint {

	private static Logger LOGGER = Logger
			.getLogger(XQCSOptlkEndpointImpl.class);

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
	public XQCSOptlkEndpointImpl() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param xqcsResponseFactory
	 * @param vistaLinkContext
	 */
	public XQCSOptlkEndpointImpl(XQCSResponseFactory xqcsResponseFactory,
			IVistaLinkContext vistaLinkContext) {
		super();
		this.setVistaLinkContext(vistaLinkContext);
		this.setXqcsResponseFactory(xqcsResponseFactory);
	}

	@Override
	public XQCSOptlkResponse optlk(XQCSOptlkRequest request)
			throws VistaWebServiceFault {
		try {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(this);
				LOGGER.debug("request= " + request);
			}

			LinkedList<Object> params = getParameters(request);

			rawResponse = getVistaLinkContext().makeRPCCall(
					new RPCIdentifier(XQCSConstants.OPTLK_RPC), params);

			XQCSOptlkResponse response = xqcsResponseFactory
					.createXQCSOptlkResponseFromString(rawResponse);

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

	private LinkedList<Object> getParameters(XQCSOptlkRequest request) {

		LinkedList<Object> parameters = new LinkedList<Object>();

		if (request.getXuopt() != null) {
			parameters.add(request.getXuopt());
		}

		return parameters;
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
		return "XQCSOptlkEndpointImpl [xqcsResponseFactory="
				+ xqcsResponseFactory + ", vistaLinkContext="
				+ vistaLinkContext + ", rawResponse=" + rawResponse + "]";
	}

}
