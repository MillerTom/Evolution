package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxapi.XMXAPIResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIVSubjEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIVSubjRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIVSubjResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.LinkedList;
import java.util.List;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@Component
@WebService(serviceName = "XMXAPIVSubjService", portName = "XMXAPIVSubjServicePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIVSubjEndpoint")
public class XMXAPIVSubjEndpointImpl extends SpringBeanAutowiringSupport implements XMXAPIVSubjEndpoint {

	private static final Logger LOGGER = Logger.getLogger(XMXAPIVSubjEndpointImpl.class);

	@Autowired
	private XMXAPIResponseFactory responseFactory;

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	public XMXAPIVSubjEndpointImpl(XMXAPIResponseFactory responseFactory, IVistaLinkContext vistaLinkContext) {
		this.responseFactory = responseFactory;
		this.vistaLinkContext = vistaLinkContext;
	}

	public XMXAPIVSubjEndpointImpl() {
		super();
	}

	@Override
	public XMXAPIVSubjResponse vsubj(XMXAPIVSubjRequest request) {
		LOGGER.debug(request);
		try {
			List<Object> params = new LinkedList<Object>();
			params.add(request.getSubject());

			RPCIdentifier rpcIdentifier = new RPCIdentifier("XMWSOA VSUBJ");

			XMXAPIVSubjResponse response = responseFactory.createXMXAPIVSubjResponse(vistaLinkContext.makeRPCCall(rpcIdentifier,
					params));
			LOGGER.debug(response);
			return response;
		} catch (NullPointerException e) {
			LOGGER.error(e);
			throw new VistaWebServiceFault(e);
		}
	}

}
