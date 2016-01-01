
package gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints;

import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.XQALBUTLResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints.interfaces.XQALBUTLUserdataEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLUserdataRequest;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLUserdataResponse;
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
 * @see gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints.XQALBUTLUserdataEndpoint
 * @author rcollins
 *
 */
@Component
@WebService(serviceName="XQALBUTLUserdataService",
portName="XQALBUTLUserdataServicePort",
endpointInterface="gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints.interfaces.XQALBUTLUserdataEndpoint")
public class XQALBUTLUserdataEndpointImpl extends SpringBeanAutowiringSupport implements XQALBUTLUserdataEndpoint {

    private static final String RPCCALL = "XU SOA USERDAT";

    @Autowired
    private XQALBUTLResponseFactory responseFactory;

    @Autowired
    private IVistaLinkContext vistaLinkContext;
    
    private static final Logger LOG = Logger
            .getLogger(XQALBUTLUserdataEndpointImpl.class);

    /**
     * Default Bean Constructor
     */
    public XQALBUTLUserdataEndpointImpl() {
        super();
    }

    /**
     * Bean constructor initializes variables
     * @param context
     * @param factory
     */
    public XQALBUTLUserdataEndpointImpl(final IVistaLinkContext context,
            final XQALBUTLResponseFactory factory) {

        this.vistaLinkContext = context;
        this.responseFactory = factory;
    }

    /** (non-Javadoc)
     * @see gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints.interfaces.XQALBUTLUserdataEndpoint#userdata(gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLUserdataRequest)
     */
    @Override
    public XQALBUTLUserdataResponse userdata(final XQALBUTLUserdataRequest request)
            throws VistaWebServiceFault {

        List<String> params = new ArrayList<String>(2);

        params.add(0, request.getXqaid());
        params.add(1, request.getXuien());

        try {
            return this.responseFactory
                    .createUserDataFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));
        }
        catch(Exception ex) {
            
            LOG.error("ABNORMAL ERROR OCCURRED in XQALBUTLUserdataEndpoint: ", ex);
            throw new VistaWebServiceFault("ABNORMAL ERROR OCCURRED !");
        }
    }

}
