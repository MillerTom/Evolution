/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xm.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xm.XMResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xm.endpoints.interfaces.XMNewEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xm.model.XMNewRequest;
import gov.va.oit.vistaevolution.mailman.ws.xm.model.XMNewResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;

import javax.jws.WebParam;
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
@WebService(serviceName = "XMNewService", portName = "XMNewPort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xm.endpoints.interfaces.XMNewEndpoint")
public class XMNewEndpointImpl extends SpringBeanAutowiringSupport implements XMNewEndpoint {

	@Autowired
	private XMResponseFactory xmResponseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	// Log4J setup
	private static final Logger LOG = Logger
			.getLogger(XMNewEndpointImpl.class);
	
	public XMNewEndpointImpl()
	{
		super();
	}
	
	public XMNewEndpointImpl(XMResponseFactory xmResponseFactory, IVistaLinkContext context)
	{
		super();
		this.xmResponseFactory = xmResponseFactory;
		this.vistaLinkContext = context;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gov.va.oit.vistaevolution.mailman.ws.xm.endpoints.interfaces.XMNewEndpoint
	 * #xmnew(gov.va.oit.vistaevolution.mailman.ws.xm.model.XMNewRequest)
	 */
	public XMNewResponse xmnew( XMNewRequest request)
			throws VistaWebServiceFault {

		ArrayList<String> params = getParameterMap(request);		

		return xmResponseFactory.createXMNewResponseFromString(
		 vistaLinkContext.makeRPCCall(new RPCIdentifier("XMWSOA NEW"),params));
	}
	
	
	
	private ArrayList<String> getParameterMap(XMNewRequest request) {

		ArrayList<String> parameterMap = new ArrayList<String>();
		
		if (request.getXmz() != null) {
			parameterMap.add(request.getXmz());
		}if (request.getXmDuz() != null) {
				parameterMap.add(request.getXmDuz());
		}else{
			LOG.warn("Missing \"XMDUZ\", call to XM New Service will fail for lack of neccessary input.");
		}

		return parameterMap;
	}

	public XMResponseFactory getXmResponseFactory() {
		return xmResponseFactory;
	}

	public void setXmResponseFactory(XMResponseFactory xmResponseFactory) {
		this.xmResponseFactory = xmResponseFactory;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}

	public String toString() {
		return "XMNewEndpointImpl [toString()=" + super.toString() + "]";
	}
	
}
