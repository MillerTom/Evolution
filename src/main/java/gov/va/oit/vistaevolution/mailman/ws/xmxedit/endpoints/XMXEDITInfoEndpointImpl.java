/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxedit.XMXEDITResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITInfoEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITInfoRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITInfoResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * @see gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITInfoEndpoint
 * @author rcollins
 *
 */
@Component
@WebService(serviceName="XMXEDITInfoService",
portName="XMXEDITInfoServicePort",
endpointInterface="gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITInfoEndpoint")
public class XMXEDITInfoEndpointImpl extends SpringBeanAutowiringSupport
        implements XMXEDITInfoEndpoint {
    
    private static final String RPCCALL = "XMWSOA INFO TOGGLE";
    
    private static final Logger LOG = Logger
            .getLogger(XMXEDITInfoEndpointImpl.class);
    
    @Autowired
    private XMXEDITResponseFactory responseFactory;
        
    @Autowired
    private IVistaLinkContext vistaLinkContext;
    
    /**
     * Default Bean Constructor
     */
    public XMXEDITInfoEndpointImpl() {
        super();
    }    

    /**
     * Constructor intializes the context and
     * factory
     *  
     * @param context
     * @param factory
     */
    public XMXEDITInfoEndpointImpl(IVistaLinkContext context, 
            XMXEDITResponseFactory factory) {
        
        this();
        this.vistaLinkContext = context;
        this.responseFactory = factory;
    }
    
    
    /**
     * @see gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITInfoEndpoint#info(gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITInfoRequest)
     */
    @Override
    public XMXEDITInfoResponse info(XMXEDITInfoRequest request)
            throws VistaWebServiceFault {

        List<Object> params = new ArrayList<Object>(2);
        Map<String, String> flags = new HashMap<String, String>(1);
        
        flags.put("FLAGS", request.getXminstr());
        
        params.add(0, request.getXmz());        
        params.add(1, flags);
        
        try {
            return this.responseFactory
                    .createInfoFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));
        }
        catch(Exception ex) {
            
            LOG.error("ABNORMAL ERROR OCCURRED in XMXEDITInfoEndpoint: ", ex);
            throw new VistaWebServiceFault("ABNORMAL ERROR OCCURRED !");
        }
    }    
}
