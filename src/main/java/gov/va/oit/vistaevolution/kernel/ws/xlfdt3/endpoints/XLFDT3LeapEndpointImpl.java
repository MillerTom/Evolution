/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xlfdt3.endpoints;

import gov.va.oit.vistaevolution.kernel.ws.xlfdt3.XLFDT3ResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xlfdt3.endpoints.interfaces.XLFDT3LeapEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xlfdt3.model.XLFDT3LeapRequest;
import gov.va.oit.vistaevolution.kernel.ws.xlfdt3.model.XLFDT3LeapResponse;
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
@WebService(serviceName = "XLFDT3LeapService", portName = "XLFDT3LeapPort", endpointInterface = "gov.va.oit.vistaevolution.kernel.ws.xlfdt3.endpoints.interfaces.XLFDT3LeapEndpoint")
public class XLFDT3LeapEndpointImpl extends SpringBeanAutowiringSupport implements XLFDT3LeapEndpoint {

	@Autowired
	private XLFDT3ResponseFactory xlfdt3ResponseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	// Log4J setup
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XLFDT3LeapEndpointImpl.class);
	
	public XLFDT3LeapEndpointImpl()
	{
		super();
		this.setXlfdt3ResponseFactory(xlfdt3ResponseFactory);
		this.setVistaLinkContext(vistaLinkContext);
	}
	
	public XLFDT3LeapEndpointImpl(IVistaLinkContext context, XLFDT3ResponseFactory xlfdt3ResponseFactory)
	{
		super();
		this.vistaLinkContext = context;
		this.xlfdt3ResponseFactory = xlfdt3ResponseFactory;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gov.va.oit.vistaevolution.kernel.ws.xlfdt3.endpoints.interfaces.XLFDT3LeapEndpoint
	 * #status(gov.va.oit.vistaevolution.kernel.ws.xlfdt3.model.XLFDT3LeapRequest)
	 */
	@Override
	public XLFDT3LeapResponse leap(XLFDT3LeapRequest request)
			throws VistaWebServiceFault {
		ArrayList<String> params = getParameterList(request);
		return xlfdt3ResponseFactory.createXLFDT3LeapResponseFromString(
				getVistaLinkContext().makeRPCCall(new RPCIdentifier("XU SOA LEAP"), params));
	}
	
	private ArrayList<String> getParameterList(XLFDT3LeapRequest request) {

		ArrayList<String> params = new ArrayList<String>();
		
		if (request.getYear() != null) {
			params.add(request.getYear());
		}
		
		return params;
	}

	public XLFDT3ResponseFactory getXlfdt3ResponseFactory() {
		return xlfdt3ResponseFactory;
	}

	public void setXlfdt3ResponseFactory(XLFDT3ResponseFactory xlfdt3ResponseFactory) {
		this.xlfdt3ResponseFactory = xlfdt3ResponseFactory;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}
	
}
