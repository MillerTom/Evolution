package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints;

import gov.va.oit.vistaevolution.fileman.ws.dilf.DILFResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.DILFHtmlEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFHtmlRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFHtmlResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.HashMap;
import java.util.LinkedList;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * 
 * @author bill.blackmon <bill.blackmon@medsphere.com>
 * 
 * 
 */

@Component
@WebService(serviceName = "DILFHtmlService", portName = "DILFHtmlServicePort", endpointInterface = "gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.DILFHtmlEndpoint")
public class DILFHtmlEndpointImpl implements DILFHtmlEndpoint {

	private static final Logger LOG = Logger.getLogger(DILFHtmlRequest.class);

	@Autowired
	private DILFResponseFactory responseFactory;

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	/**
	 * default no-arg constructor
	 */
	public DILFHtmlEndpointImpl() {
		this.setVistaLinkContext(null);
		this.setResponseFactory(null);
	}

	/**
	 * @param dilfResponseFactory
	 * @param vistaLinkContext
	 */
	public DILFHtmlEndpointImpl(DILFResponseFactory responseFactory, IVistaLinkContext vistaLinkContext) {
		super();
		this.vistaLinkContext = vistaLinkContext;
		this.responseFactory = responseFactory;
	}

	/**
	 * 
	 */
	@Override
	public DILFHtmlResponse html(DILFHtmlRequest request) throws VistaWebServiceFault {
		LOG.debug(request);

		try {

			LinkedList<HashMap<Object, Object>> params = new LinkedList<HashMap<Object, Object>>();
			HashMap<Object, Object> parameterMap = new HashMap<Object, Object>();
			params.add(parameterMap);

			parameterMap.put("STRING", request.getString());
			parameterMap.put("ACTION", request.getAction());
			DILFHtmlResponse response = responseFactory.createDILFHtmlResponse(vistaLinkContext.makeRPCCall(
					new RPCIdentifier("DDR SOA HTML ENCODER/DECODER"), params));

			return response;
		} catch (NullPointerException e) {
			LOG.error(e);
			throw new VistaWebServiceFault(e);
		}

	}


	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	protected void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}

	public DILFResponseFactory getResponseFactory() {
		return responseFactory;
	}

	protected void setResponseFactory(DILFResponseFactory responseFactory) {
		this.responseFactory = responseFactory;
	}

} // end class
