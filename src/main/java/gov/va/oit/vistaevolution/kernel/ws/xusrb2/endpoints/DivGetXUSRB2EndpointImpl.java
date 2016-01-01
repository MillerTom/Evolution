/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusrb2.endpoints;

import gov.va.oit.vistaevolution.kernel.ws.xusrb2.XUSRB2ResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xusrb2.endpoints.interfaces.DivGetXUSRB2Endpoint;
import gov.va.oit.vistaevolution.kernel.ws.xusrb2.model.DivGetXUSRB2Request;
import gov.va.oit.vistaevolution.kernel.ws.xusrb2.model.DivGetXUSRB2Response;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * This wrapped RPC call will return a list of divisions of a user.
 * @author Stephen Combs <stephen.combs@synaptekcorp.com>
 */
@Component
@WebService(serviceName="DivGetXUSRB2Service",
	portName="DivGetXUSRB2ServicePort",
	endpointInterface="gov.va.oit.vistaevolution.kernel.ws.xusrb2.endpoints.interfaces.DivGetXUSRB2Endpoint")
public class DivGetXUSRB2EndpointImpl implements DivGetXUSRB2Endpoint {
	
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(DivGetXUSRB2EndpointImpl.class);
	
	@Autowired
	private XUSRB2ResponseFactory xusrb2ResponseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;

	
	/**
	 * Creates a DivGet Web Service class where the response and connection are known
	 * @param xusrb2ResponseFactory a class object used to format and create a response
	 * @param vistaLinkContext a vista link connection responsible for executing calls to VistA
	 * */
	public DivGetXUSRB2EndpointImpl(XUSRB2ResponseFactory xusrb2ResponseFactory, IVistaLinkContext vistaLinkContext)
	{
		super();
		this.xusrb2ResponseFactory = xusrb2ResponseFactory;
		this.vistaLinkContext = vistaLinkContext;
	}
	
	
	/**
	 * default, no argument. constructor
	 * */
	public DivGetXUSRB2EndpointImpl()
	{
		super();
	}
	
	
	/* (non-Javadoc)
	 * @see gov.va.oit.vistaevolution.kernel.ws.xusrb2.endpoints.interfaces.UserinfoXUSRB2Endpoint#userinfo(gov.va.oit.vistaevolution.kernel.ws.xusrb2.model.DivGetXUSRB2Request)
	 */
	@Override
	public DivGetXUSRB2Response divget(DivGetXUSRB2Request request)
			throws VistaWebServiceFault {
		
		List<String> parameters = new ArrayList<String>();
		
		if(request.getIEN() != null && !request.getIEN().isEmpty()){
			parameters.add(request.getIEN());
		}
		
		//Establish a connection, run the RPC call, and capture the vista link response string
		String vResStr = this.getVistaLinkContext().makeRPCCall(new RPCIdentifier("XUS DIVISION GET"), parameters);
		
		return xusrb2ResponseFactory.createDivGetXUSRB2ResponseFromString(vResStr);
	}

	public XUSRB2ResponseFactory getXusrb2ResponseFactory() {
		return xusrb2ResponseFactory;
	}

	public void setXusrb2ResponseFactory(XUSRB2ResponseFactory xusrb2ResponseFactory) {
		this.xusrb2ResponseFactory = xusrb2ResponseFactory;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}
	
}
