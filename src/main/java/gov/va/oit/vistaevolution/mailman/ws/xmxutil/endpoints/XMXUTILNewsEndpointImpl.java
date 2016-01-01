/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil.XMXUTILResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.XMXUTILNewsEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILNewsRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILNewsResponse;
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
/*
 * XMWSOA NEW MSG INFO
 * 
 * This RPC returns information on new messages in a user's mailbox.  If
 * there's an error, it returns an error message.
 * 
 * Input parameters:
 * 		XMDUZ		(Required) User DUZ.
 * 
 * 		XMTEST      (Optional) Is this a test?
 * 						1 (default)-Yes
 * 						0-No
 * 
 * If this is not a test, then the LAST NEW MSG NOTIFY DATE/TIME field
 * (#1.12) in the MAILBOX file (#3.7) can be updated for this user.
 * 
 * Response:
 * 		-1-If XMDUZ is not a valid user
 * 		 0-If the user has no new messages
 * 
 * Otherwise, it returns the following ^-delimited string:
 * 		Piece 1: Number of new messages in the mailbox.
 * 		Piece 2: Does the user have new priority mail?
 * 				 0-No
 * 				 1-Yes
 * 		Piece 3: Number of new messages in the "IN" basket.
 * 		Piece 4: Date/time (in VA FileMan format) that the last message was
 * 				 received.
 * 		Piece 5: Have there been any new messages since the last time this routine
 * 				 was called?
 * 				 0-No
 * 				 1-Yes
 */

@Component
@WebService(serviceName = "XMXUTILNewsService", portName = "XMXUTILNewsPort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.XMXUTILNewsEndpoint")
public class XMXUTILNewsEndpointImpl extends SpringBeanAutowiringSupport implements XMXUTILNewsEndpoint {

	@Autowired
	private XMXUTILResponseFactory xmxutilResponseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	// Log4J setup
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XMXUTILNewsEndpointImpl.class);
	
	public XMXUTILNewsEndpointImpl()
	{
		super();
		this.setVistaLinkContext(vistaLinkContext);
		this.setXmxutilResponseFactory(xmxutilResponseFactory);
	}
	
	public XMXUTILNewsEndpointImpl(IVistaLinkContext context,
			XMXUTILResponseFactory xmxutilResponseFactory)
	{
		super();
		this.vistaLinkContext = context;
		this.xmxutilResponseFactory = xmxutilResponseFactory;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gov.va.oit.vistaevolution.mailman.ws.xmutil.endpoints.interfaces.XMXUTILNewsEndpoint
	 * #status(gov.va.oit.vistaevolution.mailman.ws.xmutil.model.XMXUTILNewsRequest)
	 */
	@Override
	public XMXUTILNewsResponse news(XMXUTILNewsRequest request)
			throws VistaWebServiceFault {
		
		ArrayList<Object> params = getParameterArray(request);
		return xmxutilResponseFactory.createXMXUTILNewsResponseFromString(
				getVistaLinkContext().makeRPCCall(new RPCIdentifier("XMWSOA NEW MSG INFO"), params));
	}
	
	private ArrayList<Object> getParameterArray(XMXUTILNewsRequest request) {
		ArrayList<Object> params = new ArrayList <Object>();

		params.add(request.getXmDuz());
		params.add(request.getXmTest());
		
		
		return params;
	}

	public XMXUTILResponseFactory getXmxutilResponseFactory() {
		return xmxutilResponseFactory;
	}
	
	public void setXmxutilResponseFactory(XMXUTILResponseFactory xmxutilResponseFactory) {
		this.xmxutilResponseFactory = xmxutilResponseFactory;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}
	
}
