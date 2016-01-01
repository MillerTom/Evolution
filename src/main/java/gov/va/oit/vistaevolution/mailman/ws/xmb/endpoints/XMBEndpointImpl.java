/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmb.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmb.XMBResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmb.endpoints.interfaces.XMBEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmb.model.XmbRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmb.model.XmbResponse;
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
@WebService(serviceName = "XmbService", portName = "XMBPort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmb.endpoints.interfaces.XMBEndpoint")
public class XMBEndpointImpl  extends SpringBeanAutowiringSupport implements XMBEndpoint {

	@Autowired
	private XMBResponseFactory xmbResponseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	// Log4J setup
	private static final Logger LOG = Logger
			.getLogger(XMBEndpointImpl.class);
	
	public XMBEndpointImpl()
	{
		super();
	}
	
	public XMBEndpointImpl(XMBResponseFactory xmbResponseFactory, IVistaLinkContext context)
	{
		super();
		this.xmbResponseFactory = xmbResponseFactory;
		this.vistaLinkContext = context;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gov.va.oit.vistaevolution.mailman.ws.xmb.endpoints.interfaces.XMBEndpoint
	 * #status(gov.va.oit.vistaevolution.mailman.ws.xmb.model.XmbRequest)
	 */
	@Override
	public XmbResponse xmb(XmbRequest request)
			throws VistaWebServiceFault {
		
		ArrayList<Object> params = getParameterMap(request);
		

		return xmbResponseFactory.createXmbResponseFromString(
		 vistaLinkContext.makeRPCCall(new RPCIdentifier("XMWSOA XMB"),params));
	}
	
	private ArrayList<Object> getParameterMap(XmbRequest request) {

		ArrayList<Object> parameterMap = new ArrayList<Object>();
//			 * 	xmDuz = 53468
//			 * 	xmys = .XMY
//			 * 	xmBull = "XUSSPKI SAN"
		
		if (request.getXmDuz() != null) {
			parameterMap.add(request.getXmDuz());
		}else{
			LOG.warn("Missing \"XMDUZ\", call to XMB Service will fail for lack of neccessary input.");
		}
		
		if (request.getMsgs() != null && !request.getMsgs().isEmpty()) {
			parameterMap.add(request.getMsgs());
		}else{
			parameterMap.add(new ArrayList<String>());;
		}
		
		if (request.getXmys() != null && !request.getXmys().isEmpty()) {
			parameterMap.add(request.getXmys());
		}else{
			LOG.warn("Missing \"XMYS\", call to XMB Service will fail for lack of neccessary input.");
		}
		
		if (request.getXmBull() != null) {
			parameterMap.add(request.getXmBull());
		}else{
			LOG.warn("Missing \"XMBULL\", call to XMB Service will fail for lack of neccessary input.");
		}

		if (request.getXmbs() != null && request.getXmbs().isEmpty()) {
			parameterMap.add(request.getXmbs());
		}else{
			parameterMap.add(new ArrayList<String>());
		}
		
		if (request.getXmDf() != null) {
			parameterMap.add(request.getXmDf());
		}else{
			parameterMap.add("");
		}
		
		if (request.getXmDt() != null) {
			parameterMap.add(request.getXmDt());
		}else{
			parameterMap.add("");
		}
		
		return parameterMap;
	}

	public XMBResponseFactory getXmbResponseFactory() {
		return xmbResponseFactory;
	}

	public void setXmbResponseFactory(XMBResponseFactory xmbResponseFactory) {
		this.xmbResponseFactory = xmbResponseFactory;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}
	
}
