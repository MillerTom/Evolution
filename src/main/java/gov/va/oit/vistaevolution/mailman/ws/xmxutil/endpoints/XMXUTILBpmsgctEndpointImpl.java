/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil.XMXUTILResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.XMXUTILBpmsgctEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILBpmsgctRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILBpmsgctResponse;
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
 * @see gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.XMXUTILBpmsgctEndpoint#bpmsgct
 * @author rcollins
 *
 */
@Component
@WebService(serviceName = "XMXUTILBpmsgctService", portName = "XMXUTILBpmsgctPort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.XMXUTILBpmsgctEndpoint")
public class XMXUTILBpmsgctEndpointImpl extends SpringBeanAutowiringSupport implements XMXUTILBpmsgctEndpoint {
    
    private static final String RPCCALL = "XMWSOA NUMB PRIORITY IN BSK";
    
    @Autowired
    private XMXUTILResponseFactory responseFactory;
    
    @Autowired
    private IVistaLinkContext vistaLinkContext;
    
    // Log4J setup
    private static final Logger LOG = Logger.getLogger(XMXUTILBpmsgctEndpointImpl.class);
    
    
    /**
     * Default Bean Constructor
     */
    public XMXUTILBpmsgctEndpointImpl() {
        super();
    }
    
    /**
     * Constructor initializes the object
     * @param context
     * @param factory
     */
    public XMXUTILBpmsgctEndpointImpl(IVistaLinkContext context, 
            XMXUTILResponseFactory factory) {
        
        this();
        this.vistaLinkContext = context;
        this.responseFactory = factory;
    }    
    
    /**
     * @see gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.XMXUTILBpmsgctEndpoint#bpmsgct(gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILBpmsgctRequest)
     */
    @Override
    public XMXUTILBpmsgctResponse bpmsgct(XMXUTILBpmsgctRequest request)
            throws VistaWebServiceFault {
        
        List<String> params = new ArrayList<String>(2);
        
        params.add(0, request.getXmduz());
        params.add(1, request.getXmk());  
        
        try {
            
            return this.responseFactory
                    .createBpmsgctFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));
        }
        catch(Exception ex) {
            
            LOG.error("ABNORMAL ERROR OCCURRED in XMXUTILBpmsgctEndpoint: ", ex);
            throw new VistaWebServiceFault("ABNORMAL ERROR OCCURRED !");        
        }
    }
    
}
