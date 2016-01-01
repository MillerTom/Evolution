/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusrb1.endpoints;

import gov.va.oit.vistaevolution.kernel.ws.xusrb1.XUSRB1ResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xusrb1.endpoints.interfaces.XUSRB1DecrypEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xusrb1.model.XUSRB1DecrypRequest;
import gov.va.oit.vistaevolution.kernel.ws.xusrb1.model.XUSRB1DecrypResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Leisa Martella
 * 
 */
@Component
@WebService(serviceName = "XUSRB1DecrypService", portName = "XUSRB1DecrypPort", endpointInterface = "gov.va.oit.vistaevolution.kernel.ws.xusrb1.endpoints.interfaces.XUSRB1DecrypEndpoint")
public class XUSRB1DecrypEndpointImpl implements XUSRB1DecrypEndpoint {

	@Autowired
	private XUSRB1ResponseFactory xusrb1ResponseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	// Log4J setup
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XUSRB1DecrypEndpointImpl.class);
	
	public XUSRB1DecrypEndpointImpl()
	{
		super();
		this.setXusrb1ResponseFactory(xusrb1ResponseFactory);
		this.setVistaLinkContext(vistaLinkContext);
	}
	
	public XUSRB1DecrypEndpointImpl(IVistaLinkContext context, XUSRB1ResponseFactory xusrb1ResponseFactory)
	{
		super();
		this.vistaLinkContext = context;
		this.xusrb1ResponseFactory = xusrb1ResponseFactory;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gov.va.oit.vistaevolution.kernel.ws.xusrb1.endpoints.interfaces.XUSRB1DecrypEndpoint
	 * #status(gov.va.oit.vistaevolution.kernel.ws.xusrb1.model.XUSRB1DecrypRequest)
	 */
	@Override
	public XUSRB1DecrypResponse decryp(XUSRB1DecrypRequest request)
			throws VistaWebServiceFault {
		ArrayList<String> params = getParameterList(request);
		return xusrb1ResponseFactory.createXUSRB1DecrypResponseFromString(
				getVistaLinkContext().makeRPCCall(new RPCIdentifier("XU SOA DECRYP"), params));
	}
	
	private ArrayList<String> getParameterList(XUSRB1DecrypRequest request) {

		ArrayList<String> params = new ArrayList<String>();
		
		if (request.getSt1() != null) {
			params.add(request.getSt1());
		}
		
		return params;
	}

	public XUSRB1ResponseFactory getXusrb1ResponseFactory() {
		return xusrb1ResponseFactory;
	}

	public void setXusrb1ResponseFactory(XUSRB1ResponseFactory xusrb1ResponseFactory) {
		this.xusrb1ResponseFactory = xusrb1ResponseFactory;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}
	
}
