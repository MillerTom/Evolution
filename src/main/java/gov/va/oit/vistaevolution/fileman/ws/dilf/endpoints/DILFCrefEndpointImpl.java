package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints;

import gov.va.oit.vistaevolution.fileman.ws.dilf.DILFResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.DILFCrefEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFCrefRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFCrefResponse;
import gov.va.oit.vistaevolution.fileman.ws.dilf.util.DILFConstants;
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

/**
 * 
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@Component
@WebService(serviceName = "DILFCrefService", portName = "DILFCrefServicePort", endpointInterface = "gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.DILFCrefEndpoint")
public class DILFCrefEndpointImpl extends SpringBeanAutowiringSupport implements
		DILFCrefEndpoint {

	private static final Logger LOGGER = Logger
			.getLogger(DILFCrefEndpointImpl.class);

	@Autowired
	public DILFResponseFactory dilfResponseFactory;

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	/** raw response from RPC call */
	private String rawResponse;

	/**
	 * No Arguments Constructor
	 */
	public DILFCrefEndpointImpl() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param vistaLinkContext
	 * @param dilfResponseFactory
	 */
	public DILFCrefEndpointImpl(DILFResponseFactory dilfResponseFactory,
			IVistaLinkContext vistaLinkContext) {
		super();
		this.dilfResponseFactory = dilfResponseFactory;
		this.vistaLinkContext = vistaLinkContext;
	}

	@Override
	public DILFCrefResponse cref(DILFCrefRequest request)
			throws VistaWebServiceFault {

		try {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(this);
				LOGGER.debug("request= " + request);
			}

			List<Object> params = getParameterArray(request);

			rawResponse = getVistaLinkContext().makeRPCCall(
					new RPCIdentifier(DILFConstants.CREF_RPC), params);

			DILFCrefResponse response = dilfResponseFactory
					.createDILFCrefResponseFromString(rawResponse);

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

	private List<Object> getParameterArray(DILFCrefRequest request) {

		LinkedList<Object> params = new LinkedList<Object>();

		if (request.getOpenRoot() != null) {
			params.add(request.getOpenRoot());
		}

		return params;
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
		return "DILFCrefEndpointImpl [dilfResponseFactory="
				+ dilfResponseFactory + ", vistaLinkContext="
				+ vistaLinkContext + ", rawResponse=" + rawResponse + "]";
	}

}
