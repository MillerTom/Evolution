/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmut7.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmut7.XMUT7ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmut7.endpoints.interfaces.XMUT7EntEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmut7.model.XMUT7EntRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmut7.model.XMUT7EntResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.HashMap;
import java.util.LinkedList;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Leisa Martella
 * 
 */
@Component
@WebService(serviceName = "XMUT7EntService", portName = "XMUT7EntPort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmut7.endpoints.interfaces.XMUT7EntEndpoint")
public class XMUT7EntEndpointImpl implements XMUT7EntEndpoint {

	@Autowired
	private XMUT7ResponseFactory xmut7ResponseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	// Log4J setup
	private static final Logger LOG = Logger
			.getLogger(XMUT7EntEndpointImpl.class);
	
	public XMUT7EntEndpointImpl()
	{
		super();
	}
	
	public XMUT7EntEndpointImpl(XMUT7ResponseFactory xmut7ResponseFactory, IVistaLinkContext context)
	{
		super();
		this.xmut7ResponseFactory = xmut7ResponseFactory;
		this.vistaLinkContext = context;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gov.va.oit.vistaevolution.mailman.ws.xmut7.endpoints.interfaces.XMUT7EntEndpoint
	 * #status(gov.va.oit.vistaevolution.mailman.ws.xmut7.model.XMUT7EntRequest)
	 */
	@Override
	public XMUT7EntResponse ent(XMUT7EntRequest request)
			throws VistaWebServiceFault {
		
		
		LinkedList<HashMap<String, String>> params = new LinkedList<HashMap<String, String>>();
		HashMap<String, String> parameterMap = getParameterMap(request);
		params.add(parameterMap);
		
// TODO: Make sure RPC Name is correct when Broker is ready
		return xmut7ResponseFactory.createXMUT7EntResponseFromString(
		 vistaLinkContext.makeRPCCall("XMWSOA XMS",params));
	}
	
	private HashMap<String, String> getParameterMap(XMUT7EntRequest request) {

		HashMap<String, String> parameterMap = new HashMap<String, String>();
		
		if (request.getDuz() != null) {
			parameterMap.put("XMDUZ", request.getDuz());
		}else{
			LOG.warn("Missing \"XMDUZ\", call to XMUT7 Ent Service will fail for lack of neccessary input.");
		}
		
		return parameterMap;
	}

	public XMUT7ResponseFactory getXmut7ResponseFactory() {
		return xmut7ResponseFactory;
	}

	public void setXmut7ResponseFactory(XMUT7ResponseFactory xmut7ResponseFactory) {
		this.xmut7ResponseFactory = xmut7ResponseFactory;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}
	
}
