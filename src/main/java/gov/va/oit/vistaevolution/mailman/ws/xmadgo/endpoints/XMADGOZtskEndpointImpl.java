/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmadgo.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmadgo.XMADGOResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmadgo.endpoints.interfaces.XMADGOZtskEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmadgo.model.XMADGOZtskRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmadgo.model.XMADGOZtskResponse;
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
@Component
@WebService(serviceName = "XMADGOZtskService", portName = "XMADGOZtskPort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmadgo.endpoints.interfaces.XMADGOZtskEndpoint")
public class XMADGOZtskEndpointImpl extends SpringBeanAutowiringSupport implements XMADGOZtskEndpoint {

	@Autowired
	private XMADGOResponseFactory xmadgoResponseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	// Log4J setup
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XMADGOZtskEndpointImpl.class);
	
	public XMADGOZtskEndpointImpl()
	{
		super();
		this.setXmadgoResponseFactory(xmadgoResponseFactory);
		this.setVistaLinkContext(vistaLinkContext);
	}
	
	public XMADGOZtskEndpointImpl(IVistaLinkContext context, XMADGOResponseFactory xmadgoResponseFactory)
	{
		super();
		this.vistaLinkContext = context;
		this.xmadgoResponseFactory = xmadgoResponseFactory;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gov.va.oit.vistaevolution.kernel.ws.xmadgo.endpoints.interfaces.XMADGOZtskEndpoint
	 * #status(gov.va.oit.vistaevolution.kernel.ws.xmadgo.model.XMADGOZtskRequest)
	 */
	@Override
	public XMADGOZtskResponse ztsk(XMADGOZtskRequest request)
			throws VistaWebServiceFault {
		//takes in no parameters
		ArrayList<String> params = null;
		return xmadgoResponseFactory.createXMADGOZtskResponseFromString(
				getVistaLinkContext().makeRPCCall(new RPCIdentifier("XMWSOA ZTSK"), params));
	}
	
	public XMADGOResponseFactory getXmadgoResponseFactory() {
		return xmadgoResponseFactory;
	}

	public void setXmadgoResponseFactory(XMADGOResponseFactory xmadgoResponseFactory) {
		this.xmadgoResponseFactory = xmadgoResponseFactory;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}
	
}
