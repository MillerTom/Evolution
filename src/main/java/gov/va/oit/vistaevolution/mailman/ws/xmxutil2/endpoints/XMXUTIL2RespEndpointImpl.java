
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.XMXUtil2ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2RespEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2RespRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2RespResponse;
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
 * @see gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2RespEndpoint
 * @author rcollins
  */
@Component
@WebService(serviceName = "XMXUTIL2RespService",
portName = "XMXUTIL2RespPort",
endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2RespEndpoint")
public class XMXUTIL2RespEndpointImpl extends SpringBeanAutowiringSupport
    implements XMXUTIL2RespEndpoint {

    private static final String RPCCALL = "XMWSOA NO OF RESPONSES";

    @Autowired
    private XMXUtil2ResponseFactory responseFactory;

    @Autowired
    private IVistaLinkContext vistaLinkContext;

    // Log4J setup
    private static final Logger LOGGER = Logger
            .getLogger(XMXUTIL2RespEndpointImpl.class);

    /**
     * Default Constructor
     */
    public XMXUTIL2RespEndpointImpl() {
        super();
    }

    /**
     * Constructor initializes the class
     * @param context
     * @param factory
     */
    public XMXUTIL2RespEndpointImpl(final IVistaLinkContext context,
            final XMXUtil2ResponseFactory factory) {

        this();
        this.vistaLinkContext = context;
        this.responseFactory = factory;
    }


    /**
     * @see gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2RespEndpoint#resp(gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2RespRequest)
     */
    @Override
    public XMXUTIL2RespResponse resp(final XMXUTIL2RespRequest request)
            throws VistaWebServiceFault {

        List<String> params = new ArrayList<String>(1);

        params.add(0, request.getXmz());

        try {

            return this.responseFactory
                    .createRespFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));
        }
        catch(Exception ex) {

            LOGGER.error("ABNORMAL ERROR OCCURRED in XMXUTIL2RespEndpoint: ", ex);
            throw new VistaWebServiceFault("ABNORMAL ERROR OCCURRED !");
        }
    }

}
