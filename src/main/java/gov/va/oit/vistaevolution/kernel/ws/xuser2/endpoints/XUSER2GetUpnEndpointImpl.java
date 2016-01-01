/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuser2.endpoints;

import gov.va.oit.vistaevolution.kernel.ws.xuser2.XUSER2ResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xuser2.endpoints.interfaces.XUSER2GetUpnEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuser2.model.XUSER2GetUpnRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuser2.model.XUSER2GetUpnResponse;
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
@WebService(serviceName = "XUser2GetUpnService", portName = "XUser2GetUpnPrt", endpointInterface = "gov.va.oit.vistaevolution.kernel.ws.xuser2.endpoints.interfaces.XUSER2GetUpnEndpoint")
public class XUSER2GetUpnEndpointImpl  extends SpringBeanAutowiringSupport implements XUSER2GetUpnEndpoint {

	@Autowired
	private XUSER2ResponseFactory xuser2ResponseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	// Log4J setup
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XUSER2GetUpnEndpointImpl.class);
	
	public XUSER2GetUpnEndpointImpl()
	{
		super();
	}
	
	public XUSER2GetUpnEndpointImpl(XUSER2ResponseFactory xuser2ResponseFactory, IVistaLinkContext context)
	{
		super();
		this.xuser2ResponseFactory = xuser2ResponseFactory;
		this.vistaLinkContext = context;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gov.va.oit.vistaevolution.kernel.ws.xuser2.endpoints.interfaces.XUSER2GetUpnEndpoint
	 * #status(gov.va.oit.vistaevolution.kernel.ws.xuser2.model.XUSER2GetUpnRequest)
	 */
	@Override
	public XUSER2GetUpnResponse getUpn(XUSER2GetUpnRequest request)
			throws VistaWebServiceFault {
		
		
		ArrayList<String> params = new ArrayList<String>();
		params.add(request.getDuz());

		return xuser2ResponseFactory.createXUSER2GetUpnResponseFromString(
		 vistaLinkContext.makeRPCCall(new RPCIdentifier("XU SOA GETUPN"),params));
	}

	public XUSER2ResponseFactory getXuser2ResponseFactory() {
		return xuser2ResponseFactory;
	}

	public void setXuser2ResponseFactory(XUSER2ResponseFactory xuser2ResponseFactory) {
		this.xuser2ResponseFactory = xuser2ResponseFactory;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}
	
}
