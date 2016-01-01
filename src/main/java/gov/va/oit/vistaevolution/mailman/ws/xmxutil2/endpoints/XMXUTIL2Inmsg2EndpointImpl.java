/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.XMXUtil2ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2Inmsg2Endpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2Inmsg2Request;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2Inmsg2Response;
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
 * @see gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2Inmsg2Endpoint
 * @author rcollins
 *
 */
@Component
@WebService(serviceName = "XMXUTIL2Inmsg2Service",
portName = "XMXUTIL2Inmsg2Port",
endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2Inmsg2Endpoint")
public class XMXUTIL2Inmsg2EndpointImpl extends SpringBeanAutowiringSupport
        implements XMXUTIL2Inmsg2Endpoint {
    
    
    private static final String RPCCALL = "XMWSOA INMSG2";

    @Autowired
    private XMXUtil2ResponseFactory responseFactory;

    @Autowired
    private IVistaLinkContext vistaLinkContext;

    // Log4J setup
    private static final Logger LOGGER = Logger
            .getLogger(XMXUTIL2Inmsg2EndpointImpl.class);

    
    /**
     * Default Bean constructor
     */
    public XMXUTIL2Inmsg2EndpointImpl() {
        super();
    }
    
    /**
     * Constructor initializes the class
     * 
     * @param context
     * @param factory
     */
    public XMXUTIL2Inmsg2EndpointImpl(final IVistaLinkContext context,
            final XMXUtil2ResponseFactory factory) {

        this();
        this.vistaLinkContext = context;
        this.responseFactory = factory;
    }    
    
    
    /**
     * @see gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2Inmsg2Endpoint#inmsg2(gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2Inmsg2Request)
     */
    @Override
    public XMXUTIL2Inmsg2Response inmsg2(XMXUTIL2Inmsg2Request request)
            throws VistaWebServiceFault {        
        
        List<String> params = new ArrayList<String>(3);
        
        params.add(0, request.getXmduz());
        params.add(1, request.getXmz());
        
        if (!(null == request.getXmzrec()) && !(request.getXmzrec().isEmpty()))
            params.add(2, request.getXmzrec()); 
        else
            params.add(2, "");
        
        try {

            return this.responseFactory
                    .createInmsg2FromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));
        }
        catch(Exception ex) {

            LOGGER.error("ABNORMAL ERROR OCCURRED in XMXUTIL2Inmsg2Endpoint: ", ex);
            throw new VistaWebServiceFault("ABNORMAL ERROR OCCURRED !");
        }        
    }
    
}
