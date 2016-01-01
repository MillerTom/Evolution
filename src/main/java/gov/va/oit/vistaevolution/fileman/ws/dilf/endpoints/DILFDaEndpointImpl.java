package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints;

import gov.va.oit.vistaevolution.fileman.ws.dilf.DILFResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.DILFDaEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFDaRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFDaResponse;
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
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@Component
@WebService(serviceName = "DILFDaService", portName = "DILFDaServicePort", endpointInterface = "gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.DILFDaEndpoint")
public class DILFDaEndpointImpl extends SpringBeanAutowiringSupport implements
		DILFDaEndpoint {

	private static final Logger LOGGER = Logger
			.getLogger(DILFDaEndpointImpl.class);

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
	public DILFDaEndpointImpl() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param dilfResponseFactory
	 * @param vistaLinkContext
	 */
	public DILFDaEndpointImpl(DILFResponseFactory dilfResponseFactory,
			IVistaLinkContext vistaLinkContext) {
		super();
		this.dilfResponseFactory = dilfResponseFactory;
		this.vistaLinkContext = vistaLinkContext;
	}

	@Override
	public DILFDaResponse da(DILFDaRequest request) throws VistaWebServiceFault {

		try {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(this);
				LOGGER.debug("request= " + request);
			}

			List<Object> params = getParameterArray(request);

			rawResponse = getVistaLinkContext().makeRPCCall(
					new RPCIdentifier(DILFConstants.DA_RPC), params);

			DILFDaResponse response = dilfResponseFactory
					.createDILFDaResponseFromString(rawResponse);

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

	private List<Object> getParameterArray(DILFDaRequest request) {

		LinkedList<Object> params = new LinkedList<Object>();

		if (request.getIens() != null) {
			params.add(request.getIens());
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
		return "DILFDaEndpointImpl [dilfResponseFactory=" + dilfResponseFactory
				+ ", vistaLinkContext=" + vistaLinkContext + ", rawResponse="
				+ rawResponse + "]";
	}

}
