/**
 * 
 */
package gov.va.oit.vistaevolution.vistalink.j2ee.ws.weblogic.endpoints;

import java.util.ArrayList;
import java.util.HashMap;

import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.vistalink.j2ee.ws.weblogic.WLSResponseFactory;
import gov.va.oit.vistaevolution.vistalink.j2ee.ws.weblogic.endpoints.interfaces.WeblogicVLJEndpoint;
import gov.va.oit.vistaevolution.vistalink.j2ee.ws.weblogic.model.WeblogicVLJRequest;
import gov.va.oit.vistaevolution.vistalink.j2ee.ws.weblogic.model.WeblogicVLJResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Stephen Combs (stephen.combs@synaptekcorp.com)
 * 
 */
@Component
@WebService(serviceName = "ProcessRpcService", portName = "ProcessRpcPort", endpointInterface = "gov.va.oit.vistaevolution.vistalink.j2ee.ws.weblogic.endpoints.interfaces.WeblogicVLJEndpoint")
public class WeblogicVLJEndpointImpl implements WeblogicVLJEndpoint {

	@Autowired
	private WLSResponseFactory wlsResponseFactory;
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	// Log4J setup
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(WeblogicVLJEndpointImpl.class);
	
	public WeblogicVLJEndpointImpl()
	{
		super();
	}
	
	public WeblogicVLJEndpointImpl(WLSResponseFactory wlsResponseFactory, IVistaLinkContext context)
	{
		super();
		this.wlsResponseFactory = wlsResponseFactory;
		this.vistaLinkContext = context;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gov.va.oit.vistaevolution.mailman.ws.xm.endpoints.interfaces.XMKillEndpoint
	 * #kill(gov.va.oit.vistaevolution.mailman.ws.xm.model.XMKillRequest)
	 */
	@Override
	public WeblogicVLJResponse processRpc(WeblogicVLJRequest request)
			throws VistaWebServiceFault {
		
		//takes in no parameters
		ArrayList<String> params = new ArrayList<String>();

		if(request.getRpcContext() != null && !request.getRpcContext().isEmpty())
		{
			WeblogicVLJResponse tempResp =  wlsResponseFactory.createWeblogicVLJResponseFromString(vistaLinkContext.makeRPCCall(new RPCIdentifier(request.getRpcContext(),request.getRpcName()),params));
			tempResp.setJndiName("");
			return tempResp;
		}
		else if(request.getRpcName() != null && !request.getRpcName().isEmpty()){
			WeblogicVLJResponse tempResp =  wlsResponseFactory.createWeblogicVLJResponseFromString( vistaLinkContext.makeRPCCall(new RPCIdentifier(request.getRpcName()),params));
			tempResp.setJndiName("");
			return tempResp;
		}
		else{
			throw new VistaWebServiceFault("No RPC Name Provided.");
		}
	}
	
	private HashMap<String, String> getParameterMap(WeblogicVLJRequest request) {

		HashMap<String, String> parameterMap = new HashMap<String, String>();
		
		return parameterMap;
	}

	public WLSResponseFactory getWlsResponseFactory() {
		return wlsResponseFactory;
	}

	public void setWlsResponseFactory(WLSResponseFactory wlsResponseFactory) {
		this.wlsResponseFactory = wlsResponseFactory;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}
	
}
