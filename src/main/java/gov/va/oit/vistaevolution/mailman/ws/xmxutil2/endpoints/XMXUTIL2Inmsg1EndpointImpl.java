
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.XMXUtil2ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2Inmsg1Endpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2Inmsg1Request;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2Inmsg1Response;
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
 * @see gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2Inmsg1Endpoint
 * @author rcollins
 *
 */
@Component
@WebService(serviceName = "XMXUTIL2Inmsg1Service",
portName = "XMXUTIL2Inmsg1Port",
endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2Inmsg1Endpoint")
public class XMXUTIL2Inmsg1EndpointImpl extends SpringBeanAutowiringSupport
        implements XMXUTIL2Inmsg1Endpoint {
    
    private static final String RPCCALL = "XMWSOA INMSG1";

    @Autowired
    private XMXUtil2ResponseFactory responseFactory;

    @Autowired
    private IVistaLinkContext vistaLinkContext;

    // Log4J setup
    private static final Logger LOGGER = Logger
            .getLogger(XMXUTIL2Inmsg1EndpointImpl.class);

    
    /**
     * Default Bean Constructor
     */
    public XMXUTIL2Inmsg1EndpointImpl() {
        super();
    }
    
    /**
     * Constructor initializes the class
     * 
     * @param context
     * @param factory
     */
    public XMXUTIL2Inmsg1EndpointImpl(final IVistaLinkContext context,
            final XMXUtil2ResponseFactory factory) {

        this();
        this.vistaLinkContext = context;
        this.responseFactory = factory;
    }    
    
    /**
     * @see gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2Inmsg1Endpoint#inmsg1(gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2Inmsg1Request)
     */
    @Override
    public XMXUTIL2Inmsg1Response inmsg1(XMXUTIL2Inmsg1Request request)
            throws VistaWebServiceFault {
        
        List<String> params = new ArrayList<String>(4);
        
        params.add(0, request.getXmduz());
        params.add(1, request.getXmz());
        
        if (!(null == request.getXmzrec()) && !(request.getXmzrec().isEmpty()))
            params.add(2, request.getXmzrec());
        else
            params.add(2, "");
        
        if (!(null == request.getXmflags()) && !(request.getXmflags().isEmpty()))
            params.add(3, request.getXmflags());
        else
            params.add(3, "");
        
        
        try {

            return this.responseFactory
                    .createInmsg1FromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));
        }
        catch(Exception ex) {

            LOGGER.error("ABNORMAL ERROR OCCURRED in XMXUTIL2Inmsg1Endpoint: ", ex);
            throw new VistaWebServiceFault("ABNORMAL ERROR OCCURRED !");
        }

    }
    
}
