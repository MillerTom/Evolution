/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil.XMXUTILResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.XMXUTILNetNameEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILNetNameRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILNetNameResponse;
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
 * 
 * XMWSOA GET NET NAME
 * 
 * This RPC returns network name of user, including @site name.  If there's
 * an error, it returns an error message.
 * 
 * Input Parameters:
 * 
 * 		XMDUZ		(Required) User DUZ or any string.
 * 
 * Response:
 * 		Returns the user's Network Name and Domain name (i.e., @site name).
 * 
	 */

@Component
@WebService(serviceName = "XMXUTILNetNameService", portName = "XMXUTILNetNamePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.XMXUTILNetNameEndpoint")
public class XMXUTILNetNameEndpointImpl extends SpringBeanAutowiringSupport implements XMXUTILNetNameEndpoint {

	@Autowired
	private XMXUTILResponseFactory xmxutilResponseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	// Log4J setup
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XMXUTILNetNameEndpointImpl.class);
	
	public XMXUTILNetNameEndpointImpl()
	{
		super();
		this.setVistaLinkContext(vistaLinkContext);
		this.setXmxunitResponseFactory(xmxutilResponseFactory);
	}
	
	public XMXUTILNetNameEndpointImpl(IVistaLinkContext context,
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
	 * gov.va.oit.vistaevolution.mailman.ws.xmutil.endpoints.interfaces.XMXUTILNetNameEndpoint
	 * #status(gov.va.oit.vistaevolution.mailman.ws.xmutil.model.XMXUTILNetNameRequest)
	 */
	@Override
	public XMXUTILNetNameResponse netName(XMXUTILNetNameRequest request)
			throws VistaWebServiceFault {
		
		ArrayList<Object> params = getParameterArray(request);
		return xmxutilResponseFactory.createXMXUTILNetNameResponseFromString(
				getVistaLinkContext().makeRPCCall(new RPCIdentifier("XMWSOA GET NET NAME"), params));
	}
	
	private ArrayList<Object> getParameterArray(XMXUTILNetNameRequest request) {
		ArrayList<Object> params = new ArrayList <Object>();

		params.add(request.getXmDuz());
		
		
		return params;
	}

	public XMXUTILResponseFactory getXmxutilResponseFactory() {
		return xmxutilResponseFactory;
	}
	
	public void setXmxunitResponseFactory(XMXUTILResponseFactory xmxutilResponseFactory) {
		this.xmxutilResponseFactory = xmxutilResponseFactory;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}
	
}
