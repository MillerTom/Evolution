/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusnpi.endpoints;

import gov.va.oit.vistaevolution.kernel.ws.xusnpi.XUSNPIResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xusnpi.endpoints.interfaces.XUSNPINpiEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xusnpi.model.XUSNPINpiRequest;
import gov.va.oit.vistaevolution.kernel.ws.xusnpi.model.XUSNPINpiResponse;
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

/**
 * @author Christopher Schuck
 *
 */
@Component
@WebService(serviceName="XUSNPINpiService",
portName="XUSNPINpiServicePort",
endpointInterface="gov.va.oit.vistaevolution.kernel.ws.xusnpi.endpoints.interfaces.XUSNPINpiEndpoint")
public class XUSNPINpiEndpointImpl extends SpringBeanAutowiringSupport
		implements XUSNPINpiEndpoint {
	
	private static final String RPCCALL = "XU SOA NPI";
	
	private static final Logger LOGGER = Logger.getLogger(XUSNPINpiEndpointImpl.class);
	
	@Autowired
	private XUSNPIResponseFactory responseFactory;
	
	@Autowired
    private IVistaLinkContext vistaLinkContext;

	public XUSNPINpiEndpointImpl() {
		super();
	}
	
	public XUSNPINpiEndpointImpl(IVistaLinkContext vistaLinkContext, XUSNPIResponseFactory responseFactory) {
		super();
		this.vistaLinkContext = vistaLinkContext;
		this.responseFactory = responseFactory;
	}

	@Override
	public XUSNPINpiResponse npi(XUSNPINpiRequest request)
			throws VistaWebServiceFault {

		try {
			List<String> params = new LinkedList<String>();

			params.add(request.getXusqi());
			params.add(request.getXusien());
			params.add(request.getXusdate());

			return this.responseFactory
					.createNpiFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));
		} catch (VistaWebServiceFault e) {
			LOGGER.error(e);
			throw e;
		} catch (Exception e) {
			LOGGER.error(e);
			throw new VistaWebServiceFault(e);
		}
	}

	public XUSNPIResponseFactory getResponseFactory() {
		return responseFactory;
	}

	public void setResponseFactory(XUSNPIResponseFactory responseFactory) {
		this.responseFactory = responseFactory;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}

}
