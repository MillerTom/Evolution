/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints;

import gov.va.med.vistalink.rpc.RpcRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmd.XMDResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.interfaces.XMDEN1Endpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMDEN1Request;
import gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMDResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMYEntry;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@Component
@WebService(serviceName = "XMDEN1Service", portName = "XMDEN1ServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.interfaces.XMDEN1Endpoint")
public class XMDEN1EndpointImpl extends SpringBeanAutowiringSupport implements
		XMDEN1Endpoint {

	public static final Logger LOGGER = Logger
			.getLogger(XMDEN1EndpointImpl.class);

	@Autowired
	private XMDResponseFactory xmdResponseFactory;

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	/**
	 * Default no-arg constructor
	 */
	public XMDEN1EndpointImpl() {
		super();
	}

	/**
	 * @param vistaLinkContext
	 * @param xmdResponseFactory
	 */
	public XMDEN1EndpointImpl(IVistaLinkContext vistaLinkContext,
			XMDResponseFactory xmdResponseFactory) {
		this.setVistaLinkContext(vistaLinkContext);
		this.setXmdResponseFactory(xmdResponseFactory);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.interfaces.XMDEnt1Endpoint
	 * #ent1(gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMDEnt1Request)
	 */
	@Override
	public XMDResponse en1(XMDEN1Request request) throws VistaWebServiceFault {
		LOGGER.debug(request);
		try {
			List<Object> params = getParameterArray(request);

			String rawResponse = getVistaLinkContext().makeRPCCall(
					new RPCIdentifier("XMWSOA EN1"), params);

			XMDResponse response = xmdResponseFactory
					.createXMDResponse(rawResponse);
			LOGGER.debug(response);
			return response;
		} catch (NullPointerException e) {
			LOGGER.error(e);
			throw new VistaWebServiceFault(e);
		}
	}

	/**
	 * @param request
	 *            request to be broken down into a {@link RpcRequest} parameter
	 *            array
	 * @return
	 * @throws VistaWebServiceFault
	 */
	private List<Object> getParameterArray(XMDEN1Request request)
			throws VistaWebServiceFault {
		LinkedList<Object> params = new LinkedList<Object>();

		// Add Duz
		params.add(request.getDUZ());

		// Build hashmap with keys of line numbers for each line of the message.
		int index = 1;
		HashMap<String, String> MSG = new HashMap<String, String>();
		for (String line : request.getMessage()) {
			MSG.put(Integer.toString(index), line);
			index++;
		}
		params.add(MSG);

		// put each entry key and value from the XMY Entry list to a map, then
		// add in parameter array.
		HashMap<String, String> xmy = new HashMap<String, String>();
		for (XMYEntry entry : request.getXMY()) {
			xmy.put(entry.getKey(), entry.getValue());
		}
		params.add(xmy);

		// add subject or error.
		if (request.getXMSub() != null) {
			params.add(request.getXMSub());
		} else {
			params.add("");
		}

		// Check for null XMStrip and add if not.
		if (request.getXMStrip() != null) {
			params.add(request.getXMStrip());
		}

		// Check for null XMDF and add if not.
		if (request.getXMDF() != null) {
			params.add(request.getXMDF());
		}

		return params;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	protected void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}

	public XMDResponseFactory getXmdResponseFactory() {
		return xmdResponseFactory;
	}

	protected void setXmdResponseFactory(XMDResponseFactory xmdResponseFactory) {
		this.xmdResponseFactory = xmdResponseFactory;
	}

}
