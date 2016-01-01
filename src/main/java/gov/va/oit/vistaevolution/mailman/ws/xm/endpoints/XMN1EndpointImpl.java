/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xm.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xm.XMResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xm.endpoints.interfaces.XMN1Endpoint;
import gov.va.oit.vistaevolution.mailman.ws.xm.model.XMN1Request;
import gov.va.oit.vistaevolution.mailman.ws.xm.model.XMN1Response;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

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
@WebService(serviceName = "XMN1Service", portName = "XMN1Port", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xm.endpoints.interfaces.XMN1Endpoint")
public class XMN1EndpointImpl extends SpringBeanAutowiringSupport implements XMN1Endpoint {

	@Autowired
	private XMResponseFactory xmResponseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	// Log4J setup
	private static final Logger LOG = Logger
			.getLogger(XMN1EndpointImpl.class);
	
	public XMN1EndpointImpl()
	{
		super();
	}
	
	public XMN1EndpointImpl(XMResponseFactory xmResponseFactory, IVistaLinkContext context)
	{
		super();
		this.xmResponseFactory = xmResponseFactory;
		this.vistaLinkContext = context;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gov.va.oit.vistaevolution.mailman.ws.xm.endpoints.interfaces.XMN1Endpoint
	 * #n1(gov.va.oit.vistaevolution.mailman.ws.xm.model.XMN1Request)
	 */
	@Override
	public XMN1Response n1(XMN1Request request)
			throws VistaWebServiceFault {
				
		ArrayList<String> params = getParameterMap(request);

		return xmResponseFactory.createXMN1ResponseFromString(
		 vistaLinkContext.makeRPCCall(new RPCIdentifier("XMWSOA N1"),params));
	}
	
	private ArrayList<String> getParameterMap(XMN1Request request) {

		ArrayList<String> parameterMap = new ArrayList<String>();
		
		if (request.getXmDuz() != null) {
			parameterMap.add(request.getXmDuz());
		}
		if (request.getXmz() != null) {
			parameterMap.add(request.getXmz());
		}else{
			LOG.warn("Missing \"XMDUZ\", call to XM N1 Service will fail for lack of neccessary input.");
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
	
}
