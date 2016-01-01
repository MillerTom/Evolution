/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xma1b.endpoints;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gov.va.oit.vistaevolution.mailman.ws.xma1b.XMA1BResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.endpoints.interfaces.XMA1BS2Endpoint;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.model.XMA1BS2Request;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.model.XMA1BS2Response;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

/**
 * @author Christopher Schuck
 *
 */
@Component
@WebService(serviceName="XMA1BS2Service",
portName="XMA1BS2ServicePort",
endpointInterface="gov.va.oit.vistaevolution.mailman.ws.xma1b.endpoints.interfaces.XMA1BS2Endpoint")
public class XMA1BS2EndpointImpl implements XMA1BS2Endpoint {
	
	private static final String RPCCALL = "XMWSOA S2";

	private static final Logger LOGGER = Logger.getLogger(XMA1BS2EndpointImpl.class);
	
	@Autowired
	private XMA1BResponseFactory xma1bResponseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	public XMA1BS2EndpointImpl() {
		super();
	}
	
	public XMA1BS2EndpointImpl(XMA1BResponseFactory xma1bResponseFactory, IVistaLinkContext vistaLinkContext) {
		super();
		this.xma1bResponseFactory = xma1bResponseFactory;
		this.vistaLinkContext = vistaLinkContext;
	}
	
	/* (non-Javadoc)
	 * @see gov.va.oit.vistaevolution.mailman.ws.xma1b.endpoints.interfaces.XMA1BS2Endpoint#s2(gov.va.oit.vistaevolution.mailman.ws.xma1b.model.XMA1BS2Request)
	 */
	@Override
	public XMA1BS2Response s2(XMA1BS2Request request) throws VistaWebServiceFault {
	    List<String> params = new ArrayList<String>(3);
	    
	    params.add(0, request.getXmduz());
	    params.add(1, request.getXmkm());
	    params.add(2, request.getXmz());
	    	    
	    try {
    		return this.xma1bResponseFactory
    		        .createS2ResponseFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL) , params));
	    }
	    catch(Exception ex) {
	        
	        LOGGER.error("ABNORMAL ERROR OCCURRED in XMA1BS2: ", ex);
	        throw new VistaWebServiceFault("ABNORMAL ERROR OCCURRED !");
	    }
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}

	public XMA1BResponseFactory getXma1bResponseFactory() {
		return xma1bResponseFactory;
	}

	public void setXma1bResponseFactory(XMA1BResponseFactory xma1bResponseFactory) {
		this.xma1bResponseFactory = xma1bResponseFactory;
	}

}
