/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.XMXUTIL1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1ScrubEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1ScrubRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1ScrubResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * @see gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1ScrubEndpoint
 * @author rcollins
 *
 */
@Component
@WebService(serviceName = "XMXUTIL1ScrubService", 
portName = "XMXUTIL1ScrubPort", 
endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1ScrubEndpoint")
public class XMXUTIL1ScrubEndpointImpl extends SpringBeanAutowiringSupport
        implements XMXUTIL1ScrubEndpoint {
        
    private static final String RPCCALL = "XMWSOA SCRUB STRING";
    
    private static final Logger LOG = Logger.getLogger(XMXUTIL1ScrubEndpointImpl.class);
    
    @Autowired
    private XMXUTIL1ResponseFactory responseFactory;
    
    @Autowired
    private IVistaLinkContext vistaLinkContext;    
    
    /**
     * Default Bean Constructor
     */
    public XMXUTIL1ScrubEndpointImpl() {
        super();
    }
    
    /**
     * Constructor initializes the class
     * @param context
     * @param factory
     */
    public XMXUTIL1ScrubEndpointImpl(IVistaLinkContext context, 
            XMXUTIL1ResponseFactory factory) {
        
        this();
        this.vistaLinkContext = context;
        this.responseFactory = factory;        
    }    
    
    /**
     * @see gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1ScrubEndpoint#scrub(gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1ScrubRequest)
     */
    @Override
    public XMXUTIL1ScrubResponse scrub(XMXUTIL1ScrubRequest request)
            throws VistaWebServiceFault {
        
        List<String> params = new ArrayList<String>(1);
        
        params.add(request.getXmxstring());        
        
        try {
            return this.responseFactory
                    .createScrubFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));
        }
        catch (Exception ex) {
          
            LOG.error("ABNORMAL ERROR OCCURRED in XMXUTILBsktnameEndpoint: ", ex);
            throw new VistaWebServiceFault("ABNORMAL ERROR OCCURRED !");
        }        
    }
    
}
