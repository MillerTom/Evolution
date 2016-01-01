/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil.XMXUTILResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.XMXUTILBsktnameEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILBsktnameRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILBsktnameResponse;
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
 * @see gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.XMXUTILBsktnameEndpoint
 * @author rcollins
 *
 */
@Component
@WebService(serviceName = "XMXUTILBsktnameService", portName = "XMXUTILBsktnamePort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.XMXUTILBsktnameEndpoint")
public class XMXUTILBsktnameEndpointImpl extends SpringBeanAutowiringSupport implements XMXUTILBsktnameEndpoint {
    
    private static final String RPCCALL = "XMWSOA MSG BSK INFO";
    
    @Autowired
    private XMXUTILResponseFactory responseFactory;
    
    @Autowired
    private IVistaLinkContext vistaLinkContext;
    
    // Log4J setup
    private static final Logger LOG = Logger.getLogger(XMXUTILBsktnameEndpointImpl.class);
    
    /**
     * Default Constructor
     */
    public XMXUTILBsktnameEndpointImpl() {
        super();
    }
    

    /**
     * Constructor initializes object
     * @param context
     * @param factory
     */
    public XMXUTILBsktnameEndpointImpl(IVistaLinkContext context, 
            XMXUTILResponseFactory factory) {
        
        this();
        this.vistaLinkContext = context;
        this.responseFactory = factory;                
    }
    
    
    /** (non-Javadoc)
     * @see gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.XMXUTILBsktnameEndpoint#bsktname(gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILBsktnameRequest)
     */
    @Override
    public XMXUTILBsktnameResponse bsktname(XMXUTILBsktnameRequest request)
            throws VistaWebServiceFault {

        List<String> params = new ArrayList<String>(2);
        
        params.add(0, request.getXmduz());
        params.add(1, request.getXmz());        
        params.add(2, request.getXmname());
        
        try {
            
            return this.responseFactory
                    .createBsktnameFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));
        }
        catch(Exception ex) {
            
            LOG.error("ABNORMAL ERROR OCCURRED in XMXUTILBsktnameEndpoint: ", ex);
            throw new VistaWebServiceFault("ABNORMAL ERROR OCCURRED !");        
        }
    }
    
}
