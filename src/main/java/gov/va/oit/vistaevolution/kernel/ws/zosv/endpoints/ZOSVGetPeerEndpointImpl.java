/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.zosv.endpoints;

import java.util.ArrayList;

import gov.va.oit.vistaevolution.kernel.ws.zosv.ZOSVResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.zosv.endpoints.interfaces.ZOSVGetPeerEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.zosv.model.ZOSVGetPeerRequest;
import gov.va.oit.vistaevolution.kernel.ws.zosv.model.ZOSVGetPeerResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * This wrapped RPC call will get the ip of the peer
 * @author Stephen Combs <stephen.combs@synaptekcorp.com>
 */
@Component
@WebService(serviceName="ZosvGetPeerService",
	portName="ZosvGetPeerServicePort",
	endpointInterface="gov.va.oit.vistaevolution.kernel.ws.zosv.endpoints.interfaces.ZOSVGetPeerEndpoint")
public class ZOSVGetPeerEndpointImpl  extends SpringBeanAutowiringSupport implements ZOSVGetPeerEndpoint {
	
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(ZOSVGetPeerEndpointImpl.class);
	
	@Autowired
	private ZOSVResponseFactory zosvGetPeerResponseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;

	
	/**
	 * 
	 * @param zosvGetPeerResponseFactory a class object used to format and create a response
	 * @param vistaLinkContext a vista link connection responsible for executing calls to VistA
	 * */
	public ZOSVGetPeerEndpointImpl(ZOSVResponseFactory zosvGetPeerResponseFactory, IVistaLinkContext vistaLinkContext)
	{
		super();
		this.zosvGetPeerResponseFactory = zosvGetPeerResponseFactory;
		this.vistaLinkContext = vistaLinkContext;
	}
	
	/**
	 * default, no argument. constructor
	 * */
	public ZOSVGetPeerEndpointImpl()
	{
		super();
	}
	

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}


	@Override
	public ZOSVGetPeerResponse getPeer( ZOSVGetPeerRequest request)
			throws VistaWebServiceFault {
		ArrayList<String> params = null;

		return zosvGetPeerResponseFactory.createZOSVGetPeerResponseFromString(
		 vistaLinkContext.makeRPCCall(new RPCIdentifier("XU SOA GETPEER"),params));
	}
	
}
