/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xus1a.endpoints;

import java.util.LinkedList;
import java.util.List;

import gov.va.oit.vistaevolution.kernel.ws.xus1a.XUS1AResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xus1a.endpoints.interfaces.XUS1AProhibitEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xus1a.model.XUS1AProhibitRequest;
import gov.va.oit.vistaevolution.kernel.ws.xus1a.model.XUS1AProhibitResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * @author Christopher Schuck
 *
 */
@Component
@WebService(serviceName="XUS1AProhibitService",
portName="XUS1AProhibitServicePort",
endpointInterface="gov.va.oit.vistaevolution.kernel.ws.xus1a.endpoints.interfaces.XUS1AProhibitEndpoint")
public class XUS1AProhibitEndpointImpl extends SpringBeanAutowiringSupport
		implements XUS1AProhibitEndpoint {

	private static final String RPCCALL = "XU SOA PROHIBIT";
	
	private static final Logger LOGGER = Logger
			.getLogger(XUS1AProhibitEndpointImpl.class);
	
	@Autowired
	private XUS1AResponseFactory responseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	public XUS1AProhibitEndpointImpl() {
		super();
	}

	public XUS1AProhibitEndpointImpl(IVistaLinkContext vistaLinkContext, XUS1AResponseFactory responseFactory) {
		super();
		this.vistaLinkContext = vistaLinkContext;
		this.responseFactory = responseFactory;
	}

	@Override
	public XUS1AProhibitResponse prohibit(XUS1AProhibitRequest request)
			throws VistaWebServiceFault {

		try {
			List<String> params = new LinkedList<String>();

			params.add(request.getT());
			params.add(request.getR());

			return this.responseFactory
					.createProhibitFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));
		} catch (VistaWebServiceFault e) {
			LOGGER.error(e);
			throw e;
		} catch (Exception e) {
			LOGGER.error(e);
			throw new VistaWebServiceFault(e);
		}
	}

	public XUS1AResponseFactory getResponseFactory() {
		return responseFactory;
	}

	public void setResponseFactory(XUS1AResponseFactory responseFactory) {
		this.responseFactory = responseFactory;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}

}
