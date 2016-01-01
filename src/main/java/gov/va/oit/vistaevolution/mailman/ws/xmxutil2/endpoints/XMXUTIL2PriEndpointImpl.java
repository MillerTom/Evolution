/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.XMXUtil2ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2PriEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2PriRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2PriResponse;
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
 * XMWSOA PRIORITY MSG IND
 * 
 * This RPC returns a value indicating whether the message is priority or
 * not.  If there's an error, it returns an error message.
 * 
 * Input Parameters:
 * 	 XMZ    (Required) Message Internal Entry Number (IEN) in the MESSAGE file
 * 			(#3.9).
 * 
 * Returns:
 *  Is the message marked as priority?
 *   0-No
 *   1-Yes
 *   
 */
@Component
@WebService(serviceName = "XMXUTIL2PriService", portName = "XMXUTIL2PriPort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2PriEndpoint")
public class XMXUTIL2PriEndpointImpl extends SpringBeanAutowiringSupport implements XMXUTIL2PriEndpoint {

	@Autowired
	private XMXUtil2ResponseFactory xmxutil2ResponseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	// Log4J setup
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XMXUTIL2PriEndpointImpl.class);
	
	public XMXUTIL2PriEndpointImpl()
	{
		super();
		this.setVistaLinkContext(vistaLinkContext);
		this.setXmxutil2ResponseFactory(xmxutil2ResponseFactory);
	}
	
	public XMXUTIL2PriEndpointImpl(IVistaLinkContext context, XMXUtil2ResponseFactory xmxutil2ResponseFactory)
	{
		super();
		this.vistaLinkContext = context;
		this.xmxutil2ResponseFactory = xmxutil2ResponseFactory;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2PriEndpoint
	 * #status(gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2PriRequest)
	 */
	@Override
	public XMXUTIL2PriResponse xmxutil2Pri(XMXUTIL2PriRequest request)
			throws VistaWebServiceFault {
		
		
		ArrayList<String> params = getParameterArray(request);
		return xmxutil2ResponseFactory.createXMXUTIL2PriResponseFromString(
				getVistaLinkContext().makeRPCCall(new RPCIdentifier("XMWSOA PRIORITY MSG IND"), params));
	}
	
	private ArrayList<String> getParameterArray(XMXUTIL2PriRequest request) {
		ArrayList<String> params = new ArrayList <String>();

		params.add(request.getXmz());
		
		return params;
	}

	public XMXUtil2ResponseFactory getXmxutil2ResponseFactory() {
		return xmxutil2ResponseFactory;
	}

	public void setXmxutil2ResponseFactory(XMXUtil2ResponseFactory xmxutil2ResponseFactory) {
		this.xmxutil2ResponseFactory = xmxutil2ResponseFactory;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}
	
}
