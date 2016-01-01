/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.XMXSEC1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.interfaces.XMXSEC1PakmanEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1PakmanRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1PakmanResponse;
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
/**
 * XMWSOA IS MSG PAKMAN
 * 
 * This RPC returns a value indicating whether a message is a PackMan message
 * or not (0 = No; 1 = Yes).  If there's an error, it returns an error
 * message.
 * 
 * Input Parameters:
 * 	 XMZ    (Required) Message Internal Entry Number (IEN) in the MESSAGE file
 * 			(#3.9).
 * 
 * Returns:
 *   0-No, the message is not a PackMan message.
 *   1-Yes, the message is a PackMan message.
 *   
 */
@Component
@WebService(serviceName = "XMXSEC1PakmanService", portName = "XMXSEC1PakmanPort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.interfaces.XMXSEC1PakmanEndpoint")
public class XMXSEC1PakmanEndpointImpl extends SpringBeanAutowiringSupport implements XMXSEC1PakmanEndpoint {

	@Autowired
	private XMXSEC1ResponseFactory xmxsec1ResponseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	// Log4J setup
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XMXSEC1PakmanEndpointImpl.class);
	
	public XMXSEC1PakmanEndpointImpl()
	{
		super();
		this.setVistaLinkContext(vistaLinkContext);
		this.setXmxsec1ResponseFactory(xmxsec1ResponseFactory);
	}
	
	public XMXSEC1PakmanEndpointImpl(IVistaLinkContext context, XMXSEC1ResponseFactory xmxsec1ResponseFactory)
	{
		super();
		this.vistaLinkContext = context;
		this.xmxsec1ResponseFactory = xmxsec1ResponseFactory;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.interfaces.XMXSEC1PakmanEndpoint
	 * #status(gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1PakmanRequest)
	 */
	@Override
	public XMXSEC1PakmanResponse xmxsec1Pakman(XMXSEC1PakmanRequest request)
			throws VistaWebServiceFault {
		
		
		ArrayList<String> params = getParameterArray(request);
		return xmxsec1ResponseFactory.createXMXSEC1PakmanResponseFromString(
				getVistaLinkContext().makeRPCCall(new RPCIdentifier("XMWSOA IS MSG PAKMAN"), params));
	}
	
	private ArrayList<String> getParameterArray(XMXSEC1PakmanRequest request) {
		ArrayList<String> params = new ArrayList <String>();

		params.add(request.getXmz());
		
		return params;
	}

	public XMXSEC1ResponseFactory getXmxsecResponseFactory() {
		return xmxsec1ResponseFactory;
	}

	public void setXmxsec1ResponseFactory(XMXSEC1ResponseFactory xmxsec1ResponseFactory) {
		this.xmxsec1ResponseFactory = xmxsec1ResponseFactory;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}
	
}
