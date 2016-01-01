/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxedit.XMXEDITResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITDeliverEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITDeliverRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITDeliverResponse;
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
 * @see gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITDeliverEndpoint
 * @author rcollins
 *
 */
@Component
@WebService(serviceName="XMXEDITDeliverService",
portName="XMXEDITDeliverServicePort",
endpointInterface="gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITDeliverEndpoint")
public class XMXEDITDeliverEndpointImpl extends SpringBeanAutowiringSupport
        implements XMXEDITDeliverEndpoint {
    
    private static final String RPCCALL = "XMWSOA DELIVER BASKET ALL";
    
    private static final Logger LOG = Logger.getLogger(XMXEDITDeliverEndpointImpl.class);
    
    @Autowired
    private XMXEDITResponseFactory responseFactory;
        
    @Autowired
    private IVistaLinkContext vistaLinkContext;
    
    /**
     * Default Bean Constructor
     */
    public XMXEDITDeliverEndpointImpl() {
        super();
    }
    
    /**
     * Constructor intializes the context and
     * factory
     * @param context
     * @param factory
     */
    public XMXEDITDeliverEndpointImpl(IVistaLinkContext context, 
            XMXEDITResponseFactory factory) {
        
        this();
        this.vistaLinkContext = context;
        this.responseFactory = factory;
        
    }
    
    
    /**
     * @see gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITDeliverEndpoint#deliver(gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITDeliverRequest)
     */
    @Override
    public XMXEDITDeliverResponse deliver(XMXEDITDeliverRequest request)
            throws VistaWebServiceFault {        
        
        List<String> params = new ArrayList<String>(2);
        
        params.add(0, request.getXmz());
        params.add(1,request.getXmdbkst());       
        
        try {
            return this.responseFactory
                    .createDeliverFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));
        }
        catch(Exception ex) {
            
            LOG.error("ABNORMAL ERROR OCCURRED in XMXEDITDeliverEndpoint: ", ex);
            throw new VistaWebServiceFault("ABNORMAL ERROR OCCURRED !");
        }
    }
    
}
