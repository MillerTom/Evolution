package gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints;

import gov.va.med.vistalink.rpc.RpcRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmd.XMDResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.interfaces.XMDEnt1Endpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMDEnt1Request;
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

/**
 * This class provides an implementation to the Ent1XMD service.
 * 
 * @see gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.interfaces.XMDEnt1Endpoint
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@Component
@WebService(serviceName = "XMDEnt1Service", portName = "XMDEnt1ServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.interfaces.XMDEnt1Endpoint")
public class XMDEnt1EndpointImpl implements XMDEnt1Endpoint {

	private static final Logger LOGGER = Logger
			.getLogger(XMDEnt1EndpointImpl.class);

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	@Autowired
	private XMDResponseFactory xmdResponseFactory;

	/**
	 * Default Constructor
	 */
	public XMDEnt1EndpointImpl() {
		this.setVistaLinkContext(vistaLinkContext);
		this.setXmdResponseFactory(xmdResponseFactory);
	}

	public XMDEnt1EndpointImpl(IVistaLinkContext vistaLinkContext,
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
	public XMDResponse ent1(XMDEnt1Request request) throws VistaWebServiceFault {
		try {
			LOGGER.debug(request);
			List<Object> params = getParameterArray(request);
			String rawResponse = getVistaLinkContext().makeRPCCall(
					new RPCIdentifier("XMWSOA ENT1"), params);
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
	 */
	private List<Object> getParameterArray(XMDEnt1Request request) {
		LinkedList<Object> params = new LinkedList<Object>();

		// Add DUZ and XMDUZ to parameter array if they are not null, otherwise
		// add blank string
		if (request.getDUZ() != null)
			params.add(request.getDUZ());
		else
			params.add("");
		if (request.getXMDUZ() != null)
			params.add(request.getXMDUZ());
		else
			params.add("");

		// put each entry key and value from the XMY Entry list to a map, then
		// add in parameter array.
		HashMap<String, String> xmy = new HashMap<String, String>();
		for (XMYEntry entry : request.getXMY()) {
			xmy.put(entry.getKey(), entry.getValue());
		}
		params.add(xmy);

		// add XMZ, cannot be null by rules of XSD
		params.add(request.getXMZ());
		return params;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	private void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}

	public XMDResponseFactory getXmdResponseFactory() {
		return xmdResponseFactory;
	}

	private void setXmdResponseFactory(XMDResponseFactory xmdResponseFactory) {
		this.xmdResponseFactory = xmdResponseFactory;
	}

}
