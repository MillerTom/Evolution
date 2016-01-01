/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.XMXUtil2ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2NewEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2NewRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2NewResponse;
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
 * XMWSOA NEW MSG INDICATOR

 * This extrinsic function returns a value indicating whether or not a
 * message is new for this user in this basket.  If there's an error, it
 * returns an error message.
 * 
 * Input Parameters:
 *   XMDUZ	(Required) DUZ of user
 *   XMK	(Required) Internal Entry Number (IEN) of basket.
 * 	 XMZ    (Required) Message Internal Entry Number (IEN) in the MESSAGE file
 * 			(#3.9).
 * 
 * Returns:
 *  0-No
 *  1-Yes
 *   
 */
@Component
@WebService(serviceName = "XMXUTIL2NewService", portName = "XMXUTIL2NewPort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2NewEndpoint")
public class XMXUTIL2NewEndpointImpl extends SpringBeanAutowiringSupport implements XMXUTIL2NewEndpoint {

	@Autowired
	private XMXUtil2ResponseFactory xmxutil2ResponseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	// Log4J setup
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XMXUTIL2NewEndpointImpl.class);
	
	public XMXUTIL2NewEndpointImpl()
	{
		super();
		this.setVistaLinkContext(vistaLinkContext);
		this.setXmxutil2ResponseFactory(xmxutil2ResponseFactory);
	}
	
	public XMXUTIL2NewEndpointImpl(IVistaLinkContext context, XMXUtil2ResponseFactory xmxutil2ResponseFactory)
	{
		super();
		this.vistaLinkContext = context;
		this.xmxutil2ResponseFactory = xmxutil2ResponseFactory;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2NewEndpoint
	 * #status(gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2NewRequest)
	 */
	@Override
	public XMXUTIL2NewResponse xmxutil2New(XMXUTIL2NewRequest request)
			throws VistaWebServiceFault {
		
		
		ArrayList<String> params = getParameterArray(request);
		return xmxutil2ResponseFactory.createXMXUTIL2NewResponseFromString(
				getVistaLinkContext().makeRPCCall(new RPCIdentifier("XMWSOA NEW MSG INDICATOR"), params));
	}
	
	private ArrayList<String> getParameterArray(XMXUTIL2NewRequest request) {
		ArrayList<String> params = new ArrayList <String>();

		params.add(request.getXmDuz());
		params.add(request.getXmk());
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
