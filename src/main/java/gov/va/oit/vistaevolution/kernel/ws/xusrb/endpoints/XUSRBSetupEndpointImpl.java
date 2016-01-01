
package gov.va.oit.vistaevolution.kernel.ws.xusrb.endpoints;

import gov.va.oit.vistaevolution.kernel.ws.xusrb.XUSRBResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xusrb.endpoints.interfaces.XUSRBSetupEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xusrb.model.XUSRBSetupResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * (non-Javadoc)
 * @see gov.va.oit.vistaevolution.kernel.ws.xusrb.endpoints.interfaces.XUSRBSetupEndpoint
 * @author rcollins
 *
 */
@Component
@WebService(serviceName="XUSRBSetupService",
portName="XUSRBSetupServicePort",
endpointInterface="gov.va.oit.vistaevolution.kernel.ws.xusrb.endpoints.interfaces.XUSRBSetupEndpoint")
public class XUSRBSetupEndpointImpl  extends SpringBeanAutowiringSupport implements XUSRBSetupEndpoint {

    private static final String RPCCALL = "XUS SIGNON SETUP";
    
    private static final Logger LOG = Logger
            .getLogger(XUSRBSetupEndpointImpl.class);

    @Autowired
    private XUSRBResponseFactory responseFactory;

    @Autowired
    private IVistaLinkContext vistaLinkContext;


    /**
     * Default Bean Constructor
     */
    public XUSRBSetupEndpointImpl() {
        super();
    }


    /**
     * Bean constructor initializes variables
     * @param context
     * @param factory
     */
    public XUSRBSetupEndpointImpl(final IVistaLinkContext context,
            final XUSRBResponseFactory factory) {

        super();
        this.vistaLinkContext = context;
        this.responseFactory = factory;
    }


    /** (non-Javadoc)
     * @see gov.va.oit.vistaevolution.kernel.ws.xusrb.endpoints.interfaces.XUSRBSetupEndpoint#setup()
     */
    @Override
    public XUSRBSetupResponse setup() throws VistaWebServiceFault {

        try {
            return this.responseFactory
                    .createSetupFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), null));
        }
        catch(Exception ex) {
            
            LOG.error("ABNORMAL ERROR OCCURRED in XUSRBSetupEndpoint: ", ex);
            throw new VistaWebServiceFault("ABNORMAL ERROR OCCURRED !");
        }
    }

}
