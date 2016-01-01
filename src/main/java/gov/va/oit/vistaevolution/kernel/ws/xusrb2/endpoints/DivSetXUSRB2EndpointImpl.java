/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusrb2.endpoints;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gov.va.oit.vistaevolution.kernel.ws.xusrb2.XUSRB2ResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xusrb2.endpoints.interfaces.DivSetXUSRB2Endpoint;
import gov.va.oit.vistaevolution.kernel.ws.xusrb2.model.DivSetXUSRB2Request;
import gov.va.oit.vistaevolution.kernel.ws.xusrb2.model.DivSetXUSRB2Response;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

/**
 * This wrapped RPC call will set a division for the current user.
 * @author Stephen Combs <stephen.combs@synaptekcorp.com>
 *
 */
@Component
@WebService(serviceName="DivSetXUSRB2Service",
portName="DivSetXUSRB2ServicePort",
endpointInterface="gov.va.oit.vistaevolution.kernel.ws.xusrb2.endpoints.interfaces.DivSetXUSRB2Endpoint")
public class DivSetXUSRB2EndpointImpl implements DivSetXUSRB2Endpoint {
	
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(DivSetXUSRB2EndpointImpl.class);
	
	@Autowired
	private XUSRB2ResponseFactory xusrb2ResponseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;

	
	/**
	 * Default non-arg constructor for div set object
	 */
	public DivSetXUSRB2EndpointImpl(){
		super();		
	}
	
	/**
	 * Creates a DivSet Web Service class where the response and connection are known
	 * @param xusrb2ResponseFactory a class object used to format and create a response
	 * @param vistaLinkContext a vista link connection responsible for executing calls to VistA
	 * */
	public DivSetXUSRB2EndpointImpl(XUSRB2ResponseFactory xusrb2ResponseFactory, IVistaLinkContext vistaLinkContext){
		super();
		this.xusrb2ResponseFactory = xusrb2ResponseFactory;
		this.vistaLinkContext = vistaLinkContext;
	}

	/* (non-Javadoc)
	 * @see gov.va.oit.vistaevolution.kernel.ws.xusrb2.endpoints.interfaces.DivSetXUSRB2Endpoint#divset(gov.va.oit.vistaevolution.kernel.ws.xusrb2.model.DivSetXUSRB2Request)
	 */
	@Override
	public DivSetXUSRB2Response divset(DivSetXUSRB2Request request)
			throws VistaWebServiceFault {
		List<String> parameters = new ArrayList<String>();
		
		parameters.add(request.getDiv());
		
		//Establish a connection, run the RPC call, and capture the vista link response string
		String vResStr = this.getVistaLinkContext().makeRPCCall(new RPCIdentifier("XUS DIVISION SET"), parameters);
		
		return xusrb2ResponseFactory.createDivSetXUSRB2ResponseFromString(vResStr);

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
