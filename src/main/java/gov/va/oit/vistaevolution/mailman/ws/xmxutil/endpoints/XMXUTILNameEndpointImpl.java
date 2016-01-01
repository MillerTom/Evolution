/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil.XMXUTILResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.XMXUTILNameEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILNameRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILNameResponse;
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
 * XMWSOA USER NAME INFO
 * 
 * This RPC returns the name of the user by looking up XMDUZ in the NEW
 * PERSON file (#200). Optionally, it can also return the user's Title and/or
 * Institution. If XMDUZ is not numeric, it returns XMDUZ.  If there's an
 * error, it returns an error message.
 * 
 * Input Parameters:
 * 		XMDUZ		(Required) User DUZ.
 * 		XMINFO		(Optional) If the user's settings indicate that the user's
 * 					Institution and/or Title are desired, should that information be returned,
 * 					too?
 * 						0 (default)-No
 * 						1-Yes
 * 
 * Response:
 * 		Returns the user's Name, Title, and/or Institution.
 * 
 */

@Component
@WebService(serviceName = "XMXUTILNameService", portName = "XMXUTILNamePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.XMXUTILNameEndpoint")
public class XMXUTILNameEndpointImpl extends SpringBeanAutowiringSupport implements XMXUTILNameEndpoint {

	@Autowired
	private XMXUTILResponseFactory xmxutilResponseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	// Log4J setup
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XMXUTILNameEndpointImpl.class);
	
	public XMXUTILNameEndpointImpl()
	{
		super();
		this.setVistaLinkContext(vistaLinkContext);
		this.setXmxutilResponseFactory(xmxutilResponseFactory);
	}
	
	public XMXUTILNameEndpointImpl(IVistaLinkContext context,
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
	 * gov.va.oit.vistaevolution.mailman.ws.xmutil.endpoints.interfaces.XMXUTILNameEndpoint
	 * #status(gov.va.oit.vistaevolution.mailman.ws.xmutil.model.XMXUTILNameRequest)
	 */
	@Override
	public XMXUTILNameResponse name(XMXUTILNameRequest request)
			throws VistaWebServiceFault {
		
		ArrayList<Object> params = getParameterArray(request);
		return xmxutilResponseFactory.createXMXUTILNameResponseFromString(
				getVistaLinkContext().makeRPCCall(new RPCIdentifier("XMWSOA USER NAME INFO"), params));
	}             
	
	private ArrayList<Object> getParameterArray(XMXUTILNameRequest request) {
		ArrayList<Object> params = new ArrayList <Object>();

		params.add(request.getXmDuz());
		
		
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
