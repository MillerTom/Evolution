/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.XMXUtil2ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2InrespsEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2InrespsRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2InrespsResponse;
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
 * @see gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2InrespsEndpoint
 * @author rcollins
 */
@Component
@WebService(serviceName = "XMXUTIL2InrespsService",
portName = "XMXUTIL2InrespsPort",
endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2InrespsEndpoint")
public class XMXUTIL2InrespsEndpointImpl extends SpringBeanAutowiringSupport
        implements XMXUTIL2InrespsEndpoint {
    
    private static final String RPCCALL = "XMWSOA INRESPS";

    @Autowired
    private XMXUtil2ResponseFactory responseFactory;

    @Autowired
    private IVistaLinkContext vistaLinkContext;

    // Log4J setup
    private static final Logger LOGGER = Logger
            .getLogger(XMXUTIL2InrespsEndpointImpl.class);
    
    /**
     * Default Bean Constructor
     */
    public XMXUTIL2InrespsEndpointImpl() {
        super();
    }
    
    /**
     * Constructor initializes the class
     * 
     * @param context
     * @param factory
     */
    public XMXUTIL2InrespsEndpointImpl(final IVistaLinkContext context,
            final XMXUtil2ResponseFactory factory) {

        this();
        this.vistaLinkContext = context;
        this.responseFactory = factory;
    }      
    
    /**
     * @see gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2InrespsEndpoint#inresps(gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2InrespsRequest)
     */
    @Override
    public XMXUTIL2InrespsResponse inresps(XMXUTIL2InrespsRequest request)
            throws VistaWebServiceFault {
        
        List<String> params = new ArrayList<String>(2);
        
        params.add(0, request.getXmduz());
        params.add(1, request.getXmz());
        
        try {

            return this.responseFactory
                    .createInrespsFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));
        }
        catch(Exception ex) {

            LOGGER.error("ABNORMAL ERROR OCCURRED in XMXUTIL2InrespsEndpoint: ", ex);
            throw new VistaWebServiceFault("ABNORMAL ERROR OCCURRED !");
        }      
    }
    
}
