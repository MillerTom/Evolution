/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmrent.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmrent.XMRENTResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmrent.endpoints.interfaces.XMRENTNetEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmrent.model.XMRENTNetRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmrent.model.XMRENTNetResponse;
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
 * XMWSOA NET
 * 
 * This RPC  returns an ^-delimited string of information about a message. If
 * message does not exist, returns null.
 * 
 * Input Parameters:
 *		XMZ		(Required) Message Internal Entry Number (IEN) in the MESSAGE file (#3.9).
 *
 * Response:
 * 		Piece 1: Message date, in the following format: MAY 25, 1999@08:16:00, if
 * 				 local, or as sent, if remote.
 * 		Piece 2: Scramble hint, if any; otherwise null.
 * 		Piece 3: Message from (external).
 * 		Piece 4: Message ID at originating site (XMZ@sitename, if local).
 * 		Piece 5: Message sender, usually surrogate (external).
 * 		Piece 6: Message subject (external).
 * 		Piece 7: Message ID of original message, if this is a reply
 * 				 (XMZ@sitename, if local).
 * 		Piece 8: Message type (Piece 7 of the message's zero node).
 *  	-1^[error text]
 *   
 */
@Component
@WebService(serviceName = "XMRENTNetService", portName = "XMRENTNetPort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmrent.endpoints.interfaces.XMRENTNetEndpoint")
public class XMRENTNetEndpointImpl extends SpringBeanAutowiringSupport implements XMRENTNetEndpoint {

	@Autowired
	private XMRENTResponseFactory xmrentResponseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	// Log4J setup
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XMRENTNetEndpointImpl.class);
	
	public XMRENTNetEndpointImpl()
	{
		super();
		this.setVistaLinkContext(vistaLinkContext);
		this.setXmrentResponseFactory(xmrentResponseFactory);
	}
	
	public XMRENTNetEndpointImpl(IVistaLinkContext context, XMRENTResponseFactory xmrentResponseFactory)
	{
		super();
		this.vistaLinkContext = context;
		this.xmrentResponseFactory = xmrentResponseFactory;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gov.va.oit.vistaevolution.mailman.ws.xmrent.endpoints.interfaces.XMRENTNetEndpoint
	 * #status(gov.va.oit.vistaevolution.mailman.ws.xmrent.model.XMRENTNetRequest)
	 */
	@Override
	public XMRENTNetResponse xmrentNet(XMRENTNetRequest request)
			throws VistaWebServiceFault {
		
		
		ArrayList<String> params = getParameterArray(request);
		return xmrentResponseFactory.createXMRENTNetResponseFromString(
				getVistaLinkContext().makeRPCCall(new RPCIdentifier("XMWSOA NET"), params));
	}
	
	private ArrayList<String> getParameterArray(XMRENTNetRequest request) {
		ArrayList<String> params = new ArrayList <String>();

		params.add(request.getXmz());
		
		return params;
	}

	public XMRENTResponseFactory getXmxsecResponseFactory() {
		return xmrentResponseFactory;
	}

	public void setXmrentResponseFactory(XMRENTResponseFactory xmrentResponseFactory) {
		this.xmrentResponseFactory = xmrentResponseFactory;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}
	
}
