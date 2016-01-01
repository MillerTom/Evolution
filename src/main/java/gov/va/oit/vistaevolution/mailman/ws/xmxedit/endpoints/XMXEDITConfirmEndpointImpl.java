/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxedit.XMXEDITResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITConfirmEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITConfirmRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITConfirmResponse;
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
 * @see gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITConfirmEndpoint
 * @author rcollins
 *
 */
@Component
@WebService(serviceName="XMXEDITConfirmService",
portName="XMXEDITConfirmServicePort",
endpointInterface="gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITConfirmEndpoint")
public class XMXEDITConfirmEndpointImpl extends SpringBeanAutowiringSupport implements XMXEDITConfirmEndpoint {
    
    private static final String RPCCALL = "XMWSOA CONFIRM TOGGLE";
    
    private static final Logger LOG = Logger
            .getLogger(XMXEDITConfirmEndpointImpl.class);
    
    @Autowired
    private XMXEDITResponseFactory responseFactory;
        
    @Autowired
    private IVistaLinkContext vistaLinkContext;

    
    /**
     * Default Bean Constructor
     */
    public XMXEDITConfirmEndpointImpl() {
        super();
    }    

    /**
     * Constructor intializes the context and
     * factory
     * @param context
     * @param factory
     */
    public XMXEDITConfirmEndpointImpl(IVistaLinkContext context, 
            XMXEDITResponseFactory factory) {
        
        this();
        this.vistaLinkContext = context;
        this.responseFactory = factory;
    }

    /**
     * @see gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITConfirmEndpoint#confirm(gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITConfirmRequest)
     */
    @Override
    public XMXEDITConfirmResponse confirm(XMXEDITConfirmRequest request)
            throws VistaWebServiceFault {
        
        List<Object> params = new ArrayList<Object>(2);
        Map<String, String> flags = new HashMap<String, String>(1);
        
        flags.put("FLAGS", request.getXminstr());
        
        params.add(0, request.getXmz());        
        params.add(1, flags);
        
        try {
            return this.responseFactory
                    .createConfirmFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));
        }
        catch(Exception ex) {
            
            LOG.error("ABNORMAL ERROR OCCURRED in XMXEDITConfirmEndpoint: ", ex);
            throw new VistaWebServiceFault("ABNORMAL ERROR OCCURRED !");
        }
    }
    
}
