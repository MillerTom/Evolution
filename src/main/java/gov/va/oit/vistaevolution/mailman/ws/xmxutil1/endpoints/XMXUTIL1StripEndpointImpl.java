/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.XMXUTIL1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1StripEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1StripRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1StripResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

/**
 * @author Christopher Schuck
 *
 */
@Component
@WebService(serviceName = "XMXUTIL1StripService", 
portName = "XMXUTIL1StripPort", 
endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1StripEndpoint")
public class XMXUTIL1StripEndpointImpl extends SpringBeanAutowiringSupport
		implements XMXUTIL1StripEndpoint {

	private static final String RPCCALL = "XMWSOA STRIP STRING";
	
	private static final Logger LOGGER 
		= Logger.getLogger(XMXUTIL1StripEndpointImpl.class);
    
    @Autowired
    private XMXUTIL1ResponseFactory responseFactory;
    
    @Autowired
    private IVistaLinkContext vistaLinkContext;    
	
	public XMXUTIL1StripEndpointImpl() {
		super();
	}

	public XMXUTIL1StripEndpointImpl(IVistaLinkContext context, 
            XMXUTIL1ResponseFactory factory) {
		super();
		this.vistaLinkContext = context;
	    this.responseFactory = factory;
	}

	/* (non-Javadoc)
	 * @see gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1StripEndpoint#strip(gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1StripRequest)
	 */
	@Override
	public XMXUTIL1StripResponse strip(XMXUTIL1StripRequest request)
			throws VistaWebServiceFault {
        List<String> params = new ArrayList<String>(1);
        
        params.add(0, request.getXmstring());        
        
        try {
        	
            return this.responseFactory
                    .createStripFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));
        }
        catch (Exception ex) {
          
            LOGGER.error("ABNORMAL ERROR OCCURRED in XMXUTIL1StripEndpoint: ", ex);
            throw new VistaWebServiceFault("ABNORMAL ERROR OCCURRED !", ex);
        }        
	}

}
