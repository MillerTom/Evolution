
package gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints;

import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.XQALBUTLResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints.interfaces.XQALBUTLPkgPendEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLPkgPendRequest;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLPkgPendResponse;
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
 * (non-Javadoc)
 * @see gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints.interfaces.XQALBUTLPkgPendEndpoint
 * @author rcollins
 *
 */
@Component
@WebService(serviceName="XQALBUTLPkgPendService",
portName="XQALBUTLPkgPendServicePort",
endpointInterface="gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints.interfaces.XQALBUTLPkgPendEndpoint")
public class XQALBUTLPkgPendEndpointImpl extends SpringBeanAutowiringSupport implements XQALBUTLPkgPendEndpoint {

    private static final String RPCCALL = "XU SOA PKGPEND";

    @Autowired
    private XQALBUTLResponseFactory responseFactory;

    @Autowired
    private IVistaLinkContext vistaLinkContext;
    
    private static final Logger LOG = Logger
            .getLogger(XQALBUTLPkgPendEndpointImpl.class);

    /**
     * Default Bean Constructor
     */
    public XQALBUTLPkgPendEndpointImpl() {
        super();
    }

    /**
     * Bean constructor initializes variables
     * @param context
     * @param factory
     */
    public XQALBUTLPkgPendEndpointImpl(final IVistaLinkContext context,
            final XQALBUTLResponseFactory factory) {

        this.vistaLinkContext = context;
        this.responseFactory = factory;
    }

    /** (non-Javadoc)
     * @see gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints.interfaces.XQALBUTLPkgPendEndpoint#pkgpend(gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLPkgPendRequest)
     */
    @Override
    public XQALBUTLPkgPendResponse pkgpend(final XQALBUTLPkgPendRequest request)
            throws VistaWebServiceFault {

        List<String> params = new ArrayList<String>();

        params.add(0, request.getXuien());
        params.add(1, request.getXupkg());

        try {
            return this.responseFactory
                    .createPendingAlertSoftwareFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));        
        }
        catch (Exception ex) {            
    
           LOG.error("ABNORMAL ERROR OCCURRED in XQALBUTLPkgPendEndpoint: ", ex);
           throw new VistaWebServiceFault("ABNORMAL ERROR OCCURRED !");
               
        }
    }
}
