package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxapi.XMXAPIResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIPutServEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIPutServRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIPutServResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@Component
@WebService(serviceName = "XMXAPIPutServService", portName = "XMXAPIPutServServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIPutServEndpoint")
public class XMXAPIPutServEndpointImpl extends SpringBeanAutowiringSupport implements XMXAPIPutServEndpoint {

	private static final Logger LOGGER = Logger.getLogger(XMXAPIPutServEndpointImpl.class);

	@Autowired
	private XMXAPIResponseFactory responseFactory;

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	public XMXAPIPutServEndpointImpl(XMXAPIResponseFactory responseFactory, IVistaLinkContext vistaLinkContext) {
		this.responseFactory = responseFactory;
		this.vistaLinkContext = vistaLinkContext;
	}

	public XMXAPIPutServEndpointImpl() {
		super();
	}

	@Override
	public XMXAPIPutServResponse putMsg(XMXAPIPutServRequest request) {
		LOGGER.debug(request);
		try {
			ArrayList<String> parameterMap = new ArrayList<String>();
			parameterMap.add(request.getMkn());
			parameterMap.add(request.getMz());
			
			RPCIdentifier rpcIdentifier = new RPCIdentifier("XMWSOA PUTSERV");

			XMXAPIPutServResponse response = responseFactory.createXMXAPIPutServResponse(vistaLinkContext.makeRPCCall(rpcIdentifier,
					parameterMap));
			LOGGER.debug(response);
			return response;
		} catch (NullPointerException e) {
			LOGGER.error(e);
			throw new VistaWebServiceFault(e);
		}
	}

}
