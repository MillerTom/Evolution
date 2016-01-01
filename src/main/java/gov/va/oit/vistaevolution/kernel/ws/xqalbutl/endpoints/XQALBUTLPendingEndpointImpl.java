/**
 *
 */
package gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints;

import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.XQALBUTLResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints.interfaces.XQALBUTLPendingEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLPendingRequest;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLPendingResponse;
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
 * @see gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints.interfaces.XQALBUTLPendingEndpoint
 * @author rcollins
 *
 */
@Component
@WebService(serviceName="XQALBUTLPendingService",
portName="XQALBUTLPendingServicePort",
endpointInterface="gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints.interfaces.XQALBUTLPendingEndpoint")
public class XQALBUTLPendingEndpointImpl extends SpringBeanAutowiringSupport implements XQALBUTLPendingEndpoint{

    private static final String RPCCALL = "XU SOA PENDING";

    @Autowired
    private XQALBUTLResponseFactory responseFactory;

    @Autowired
    private IVistaLinkContext vistaLinkContext;
    
    private static final Logger LOG = Logger
            .getLogger(XQALBUTLPendingEndpointImpl.class);

    /**
     * Default Bean Constructor
     */
    public XQALBUTLPendingEndpointImpl() {
        super();
    }

    /**
     * Bean constructor initializes variables
     * @param context
     * @param factory
     */
    public XQALBUTLPendingEndpointImpl(final IVistaLinkContext context,
            final XQALBUTLResponseFactory factory) {

        this.vistaLinkContext = context;
        this.responseFactory = factory;
    }


    /*
     * @{inheritDoc}
     */
    @Override
    public XQALBUTLPendingResponse pending(final XQALBUTLPendingRequest request)
            throws VistaWebServiceFault {

        List<String> params = new ArrayList<String>();

        params.add(0, request.getXuien());
        params.add(1, request.getXuaid());

        try {
            
            return this.responseFactory
                    .createPendingAlertUserFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));
        }
        catch (Exception ex) {            

            LOG.error("ABNORMAL ERROR OCCURRED in XQALBUTLPendingEndpoint: ", ex);
            throw new VistaWebServiceFault("ABNORMAL ERROR OCCURRED !");
            
        }
    }

}
