/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusnpi.endpoints;

import java.util.LinkedList;
import java.util.List;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import gov.va.oit.vistaevolution.kernel.ws.xusnpi.XUSNPIResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xusnpi.endpoints.interfaces.XUSNPIQiEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xusnpi.model.XUSNPIQiRequest;
import gov.va.oit.vistaevolution.kernel.ws.xusnpi.model.XUSNPIQiResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

/**
 * @author Christopher Schuck
 *
 */
@Component
@WebService(serviceName="XUSNPIQiService",
portName="XUSNPIQiServicePort",
endpointInterface="gov.va.oit.vistaevolution.kernel.ws.xusnpi.endpoints.interfaces.XUSNPIQiEndpoint")
public class XUSNPIQiEndpointImpl extends SpringBeanAutowiringSupport
		implements XUSNPIQiEndpoint {

	private static final String RPCCALL = "XU SOA QI";
	
	private static final Logger LOGGER = Logger.getLogger(XUSNPIQiEndpointImpl.class);
	
	@Autowired
	private XUSNPIResponseFactory responseFactory;
	
	@Autowired
    private IVistaLinkContext vistaLinkContext;
	
	public XUSNPIQiEndpointImpl() {
		super();
	}

	public XUSNPIQiEndpointImpl(IVistaLinkContext vistaLinkContext, XUSNPIResponseFactory responseFactory) {
		super();
		this.vistaLinkContext = vistaLinkContext;
		this.responseFactory = responseFactory;
	}

	/* (non-Javadoc)
	 * @see gov.va.oit.vistaevolution.kernel.ws.xusnpi.endpoints.interfaces.XUSNPIQiEndpoint#qi(gov.va.oit.vistaevolution.kernel.ws.xusnpi.model.XUSNPIQiRequest)
	 */
	@Override
	public XUSNPIQiResponse qi(XUSNPIQiRequest request)
			throws VistaWebServiceFault {

		try {
			List<String> params = new LinkedList<String>();

			params.add(request.getXusnpi());

			return this.responseFactory
					.createQiFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));
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
