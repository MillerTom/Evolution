/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusrb1.endpoints;

import gov.va.oit.vistaevolution.kernel.ws.xusrb1.XUSRB1ResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xusrb1.endpoints.interfaces.XUSRB1EncrypEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xusrb1.model.XUSRB1EncrypRequest;
import gov.va.oit.vistaevolution.kernel.ws.xusrb1.model.XUSRB1EncrypResponse;
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
@WebService(serviceName = "XUSRB1EncrypService", portName = "XUSRB1EncrypPort", endpointInterface = "gov.va.oit.vistaevolution.kernel.ws.xusrb1.endpoints.interfaces.XUSRB1EncrypEndpoint")
public class XUSRB1EncrypEndpointImpl implements XUSRB1EncrypEndpoint {

	@Autowired
	private XUSRB1ResponseFactory xusrb1ResponseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	// Log4J setup
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XUSRB1EncrypEndpointImpl.class);
	
	public XUSRB1EncrypEndpointImpl()
	{
		super();
		this.setXusrb1ResponseFactory(xusrb1ResponseFactory);
		this.setVistaLinkContext(vistaLinkContext);
	}
	
	public XUSRB1EncrypEndpointImpl(IVistaLinkContext context, XUSRB1ResponseFactory xusrb1ResponseFactory)
	{
		super();
		this.vistaLinkContext = context;
		this.xusrb1ResponseFactory = xusrb1ResponseFactory;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gov.va.oit.vistaevolution.kernel.ws.xusrb1.endpoints.interfaces.XUSRB1EncrypEndpoint
	 * #status(gov.va.oit.vistaevolution.kernel.ws.xusrb1.model.XUSRB1EncrypRequest)
	 */
	@Override
	public XUSRB1EncrypResponse encryp(XUSRB1EncrypRequest request)
			throws VistaWebServiceFault {
		ArrayList<String> params = getParameterList(request);
		return xusrb1ResponseFactory.createXUSRB1EncrypResponseFromString(
				getVistaLinkContext().makeRPCCall(new RPCIdentifier("XU SOA ENCRYP"), params));
	}
	
	private ArrayList<String> getParameterList(XUSRB1EncrypRequest request) {

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
