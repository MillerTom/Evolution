/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xustzip.endpoints;

import gov.va.oit.vistaevolution.kernel.ws.xustzip.XUSTZIPResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xustzip.endpoints.interfaces.XUSTZIPLkCheckEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xustzip.model.XUSTZIPLkCheckRequest;
import gov.va.oit.vistaevolution.kernel.ws.xustzip.model.XUSTZIPLkCheckResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * @author Leisa Martella
 * 
 */
@Component
@WebService(serviceName = "XUSTZIPLkCheckService", portName = "XUSTZIPLkCheckPort", endpointInterface = "gov.va.oit.vistaevolution.kernel.ws.xustzip.endpoints.interfaces.XUSTZIPLkCheckEndpoint")
public class XUSTZIPLkCheckEndpointImpl extends SpringBeanAutowiringSupport implements XUSTZIPLkCheckEndpoint {

	@Autowired
	private XUSTZIPResponseFactory xustzipResponseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	// Log4J setup
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XUSTZIPLkCheckEndpointImpl.class);
	
	public XUSTZIPLkCheckEndpointImpl()
	{
		super();
		this.setXustzipResponseFactory(xustzipResponseFactory);
		this.setVistaLinkContext(vistaLinkContext);
	}
	
	public XUSTZIPLkCheckEndpointImpl(IVistaLinkContext context, XUSTZIPResponseFactory xustzipResponseFactory)
	{
		super();
		this.vistaLinkContext = context;
		this.xustzipResponseFactory = xustzipResponseFactory;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gov.va.oit.vistaevolution.kernel.ws.xustzip.endpoints.interfaces.XUSTZIPLkCheckEndpoint
	 * #status(gov.va.oit.vistaevolution.kernel.ws.xustzip.model.XUSTZIPLkCheckRequest)
	 */
	@Override
	public XUSTZIPLkCheckResponse lkCheck(XUSTZIPLkCheckRequest request)
			throws VistaWebServiceFault {
		ArrayList<String> params = getParameterList(request);
		return xustzipResponseFactory.createXUSTZIPLkCheckResponseFromString(
				getVistaLinkContext().makeRPCCall(new RPCIdentifier("XU SOA LKCHECK"), params));
	}
	
	private ArrayList<String> getParameterList(XUSTZIPLkCheckRequest request) {

		ArrayList<String> params = new ArrayList<String>();
		
		if (request.getLcheck1() != null) {
			params.add(request.getLcheck1());
		}
		
		return params;
	}

	public XUSTZIPResponseFactory getXustzipResponseFactory() {
		return xustzipResponseFactory;
	}

	public void setXustzipResponseFactory(XUSTZIPResponseFactory xustzipResponseFactory) {
		this.xustzipResponseFactory = xustzipResponseFactory;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}
	
}
