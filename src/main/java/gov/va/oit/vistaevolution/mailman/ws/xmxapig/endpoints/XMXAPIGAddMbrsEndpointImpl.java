/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxapig.endpoints;

import gov.va.med.vistalink.rpc.RpcRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapig.XMXAPIGResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapig.endpoints.interfaces.XMXAPIGAddMbrsEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapig.model.XMXAPIGAddMbrsRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapig.model.XMXAPIGAddMbrsResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapig.model.XMXAPIGListEntry;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
@WebService(serviceName = "XMXAPIGAddMbrsService", portName = "XMXAPIGAddMbrsServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxapig.endpoints.interfaces.XMXAPIGAddMbrsEndpoint")
public class XMXAPIGAddMbrsEndpointImpl extends SpringBeanAutowiringSupport implements XMXAPIGAddMbrsEndpoint {

	private static final Logger LOGGER = Logger.getLogger(XMXAPIGAddMbrsEndpointImpl.class);

	@Autowired
	private XMXAPIGResponseFactory responseFactory;

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	/**
	 * Default no-arg constructor.
	 */
	public XMXAPIGAddMbrsEndpointImpl() {

	}

	/**
	 * @param vistaLinkContext
	 * @param xmxapigResponseFactory
	 */
	public XMXAPIGAddMbrsEndpointImpl(IVistaLinkContext vistaLinkContext, XMXAPIGResponseFactory xmxapigResponseFactory) {
		this.vistaLinkContext = vistaLinkContext;
		this.responseFactory = xmxapigResponseFactory;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see gov.va.oit.vistaevolution.mailman.ws.xmxapig.endpoints.interfaces.
	 * XMXAPIGAddMbrsEndpoint
	 * #addMbrs(gov.va.oit.vistaevolution.mailman.ws.xmxapig
	 * .model.XMXAPIGAddMbrsRequest)
	 */
	@Override
	public XMXAPIGAddMbrsResponse addMbrs(XMXAPIGAddMbrsRequest request) throws VistaWebServiceFault {

		LOGGER.debug(request);
		try {
			List<Object> params = getParameterArray(request);

			RPCIdentifier rpcIdentifier = new RPCIdentifier("EVOLUTION", "XMWSOA ADDMBRS");

			XMXAPIGAddMbrsResponse response = responseFactory.createXMXAPIGAddMbrsResponse(vistaLinkContext.makeRPCCall(
					rpcIdentifier, params));
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
	private List<Object> getParameterArray(XMXAPIGAddMbrsRequest request) throws VistaWebServiceFault {
		LinkedList<Object> params = new LinkedList<Object>();

		// Add Duz
		params.add(request.getDuz());

		// Add XMDUZ
		params.add(request.getXmDuz());

		// Add xmGrp
		params.add(processList(request.getXmGrp()));

		// add xmMbr
		params.add(processList(request.getXmMbr()));

		// add xmInstr (if populated)
		if (request.getXmInstr() != null && request.getXmInstr().size() > 0) {
			params.add(processList(request.getXmInstr()));
		}

		return params;
	}

	/**
	 * 
	 * @param list
	 * @return
	 */
	private Map<String, String> processList(List<XMXAPIGListEntry> list) {
		HashMap<String, String> map = new HashMap<String, String>();
		String value;
		for (XMXAPIGListEntry entry : list) {
			if (entry.getValue() == null)
				value = "";
			else
				value = entry.getValue();
			map.put(entry.getType(), value);
		}
		return map;
	}

}
