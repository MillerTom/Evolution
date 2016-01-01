/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xma2.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xma2.XMA2ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xma2.endpoints.interfaces.XMA2XmzEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xma2.model.XMA2XmzRequest;
import gov.va.oit.vistaevolution.mailman.ws.xma2.model.XMA2XmzResponse;
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
 * NAME: XMWSOA EN1                        TAG: EN1
 * 
 * This RPC calls the XMZ^XMA2 API to create a message stub.  If this
 * fails, the RPC returns an error message.  If the call was successful,
 * the RPC then calls the API, EN1^XMD to add text and recipients and send
 * the message.
 * 
 * Returns:
 *   0^Successful
 *   -1^Error in required input
 *   -1^Failed to create message stub
 *   -1^DUZ not found
 *   -1^Subject names of this format (1"R"1.N) are RESERVED
 *   -1^SUBJECT must be at least 3 characters long.
 *   -1^Entered SUBJECT too long, <number> characters longer than 65.
 *   -1^Subject cannot contain control characters.
 *   
 *   Input Parameters:
 *   
 *   DUZ	(Required String) Sender's DUZ.
 *   MSG	(Required List) An array containing the text to be added to the message.
 *   XMY    (Required List) Addressee array, XMY(x)="", where x can be:
 *     			User's DUZ or enough of the user's name for a positive ID. For example:
 *     	         XMY(1301)="" OR XMY("lastname,first")=""
 *     		     G.group name (enough for positive ID). For example:
 *         		 XMY("G.group name")=""
 *         		 S.server name (enough for positive ID).
 *         		 D.device name (enough for positive ID).
 *              Prefix the above (except devices and servers) by:
 *              	I: for "Information Only" recipient (cannot reply). For example:
 *                        XMY("I:1301")="" or XMY("I:lastname,first")=""
 *                  C: for "Copy" recipient (not expected to reply). For example:
 *                        XMY("C:1301")="" or XMY("C:lastname,first")=""
 *                  L@datetime: for when (in future) to send to this recipient (datetime
 *                  	can be anything accepted by VA FileMan). For example:
 *                  	    XMY("L@25 DEC@0500:1301")="" or XMY("L@1 JAN:lastname,first")="" or
 *                            XMY("L@2981225.05:1301")=""
 *                            (Can combine IL@datetime: or CL@datetime:)
 *             To delete any recipient (including users, groups, devices, and
 *              	servers, prefix with a hyphen/dash ("-"). For example:
 *                        XMY(-1301)="" or XMY("-lastname,first")=""
 *             To address any recipient (including users, groups, devices, and
 *             		servers) at a remote site, just add the @site name. For example:
 *             			  XMY(recipient@site name)=""
 *  XMSUB	(Required String)Subject of the message.  It should be from 3 to 65 characters 
 *  		in length. If it is less than 3 characters,then three dots ("...") will be appended
 *  		to it.  If it is more than 65 characters, then it will be truncated.
 *  		Subject 'Rnnn' is reserved.
 *  XMSTRIP (Optional String) String containing characters that should be removed from 
 *  		the message text. The default is none.
 *  XMDF    (Optional String)If XMDF is defined, addressing restrictions are waived.
 *  		Addressing restrictions are:
 *  			> Restrict  "domain closed"
 *  			> Restrict  "keys required for domain"
 *  			> Restrict  "may not forward to domain"
 *  			> Restrict  "may not forward priority mail to groups"
 *  			> Restrict  "message length restrictions to remote addresses"
 * 
 */

@Component
@WebService(serviceName = "XMA2XmzService", portName = "XMA2XmzPort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xma2.endpoints.interfaces.XMA2XmzEndpoint")
public class XMA2XmzEndpointImpl extends SpringBeanAutowiringSupport implements XMA2XmzEndpoint {

	@Autowired
	private XMA2ResponseFactory xma2ResponseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	// Log4J setup
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XMA2XmzEndpointImpl.class);
	
	public XMA2XmzEndpointImpl()
	{
		super();
		this.setVistaLinkContext(vistaLinkContext);
		this.setXma2ResponseFactory(xma2ResponseFactory);
	}
	
	public XMA2XmzEndpointImpl(IVistaLinkContext context,
			XMA2ResponseFactory xma2ResponseFactory)
	{
		super();
		this.vistaLinkContext = context;
		this.xma2ResponseFactory = xma2ResponseFactory;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gov.va.oit.vistaevolution.mailman.ws.xma2.endpoints.interfaces.XMA2XmzEndpoint
	 * #status(gov.va.oit.vistaevolution.mailman.ws.xma2.model.XMA2XmzRequest)
	 */
	@Override
	public XMA2XmzResponse xmz(XMA2XmzRequest request)
			throws VistaWebServiceFault {
		
		ArrayList<Object> params = getParameterArray(request);
		return xma2ResponseFactory.createXMA2XmzResponseFromString(
				getVistaLinkContext().makeRPCCall(new RPCIdentifier("XMWSOA EN1"), params));
	}
	
	private ArrayList<Object> getParameterArray(XMA2XmzRequest request) {
		ArrayList<Object> params = new ArrayList <Object>();

		params.add(request.getDuz());
		params.add(request.getMsgs());
		params.add(request.getXmys());
		params.add(request.getXmSub());
		params.add(request.getXmStrip());
		params.add(request.getXmDf());
		
		
		return params;
	}

	public XMA2ResponseFactory getXma2ResponseFactory() {
		return xma2ResponseFactory;
	}
	
	public void setXma2ResponseFactory(XMA2ResponseFactory xma2ResponseFactory) {
		this.xma2ResponseFactory = xma2ResponseFactory;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}
	
}
