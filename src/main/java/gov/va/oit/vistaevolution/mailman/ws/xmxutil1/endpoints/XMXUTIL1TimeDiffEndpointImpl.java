
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.XMXUTIL1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1TimeDiffEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1TimeDiffRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1TimeDiffResponse;
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
 * @see gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1TimeDiffEndpoint
 * @author rcollins
 *
 */
@Component
@WebService(serviceName = "XMXUTIL1TimeDiffService",
portName = "XMXUTIL1TimeDiffPort",
endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1TimeDiffEndpoint")
public class XMXUTIL1TimeDiffEndpointImpl extends SpringBeanAutowiringSupport
implements XMXUTIL1TimeDiffEndpoint {
    
    private static final String RPCCALL = "XMWSOA REFOREMAT TIME DIFF";
    
    private static final Logger LOG = Logger.getLogger(XMXUTIL1TimeDiffEndpointImpl.class);
    
    @Autowired
    private XMXUTIL1ResponseFactory responseFactory;
    
    @Autowired
    private IVistaLinkContext vistaLinkContext;
    
    /**
     * Default Bean Constructor
     */
    public XMXUTIL1TimeDiffEndpointImpl() {
        super();
    }
    
    /**
     * Constructor initializes the class
     * @param context
     * @param factory
     */
    public XMXUTIL1TimeDiffEndpointImpl(final IVistaLinkContext context,
            final XMXUTIL1ResponseFactory factory) {
        
        this();
        this.vistaLinkContext = context;
        this.responseFactory = factory;
    }
    
    /**
     * @see gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1TimeDiffEndpoint#timediff(gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1TimeDiffRequest)
     */
    @Override
    public XMXUTIL1TimeDiffResponse timediff(final XMXUTIL1TimeDiffRequest request)
            throws VistaWebServiceFault {
        
        List<String> params = new ArrayList<String>(1);
        
        params.add(request.getXmdiff());
        
        try {
            
            return this.responseFactory
                    .createTimeDiffFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));
        }
        catch (Exception ex) {
            
            LOG.error("ABNORMAL ERROR OCCURRED in XMXUTIL1TimeDiffEndpoint: ", ex);
            throw new VistaWebServiceFault("ABNORMAL ERROR OCCURRED !");
        }
    }
    
}
