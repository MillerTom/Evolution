
package gov.va.oit.vistaevolution.kernel.ws.xusap.endpoints;

import gov.va.oit.vistaevolution.kernel.ws.xusap.XUSAPResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xusap.endpoints.interfaces.XUSAPActiveEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xusap.model.XUSAPActiveRequest;
import gov.va.oit.vistaevolution.kernel.ws.xusap.model.XUSAPActiveResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.LinkedList;

import javax.jws.WebService;

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
endpointInterface="gov.va.oit.vistaevolution.kernel.ws.xusap.endpoints.interfaces.XUSAPActiveEndpoint")
public class XUSAPActiveEndpointImpl extends SpringBeanAutowiringSupport implements XUSAPActiveEndpoint {

    private static final String RPCCALL = "XU SOA ACTIVE";

    @Autowired
    private XUSAPResponseFactory responseFactory;

    @Autowired
    private IVistaLinkContext vistaLinkContext;


    /**
     * Default Bean Constructor
     */
    public XUSAPActiveEndpointImpl() {
        super();
    }


    /**
     * Bean constructor initializes variables
     * @param context
     * @param factory
     */
    public XUSAPActiveEndpointImpl(final IVistaLinkContext context,
            final XUSAPResponseFactory factory) {

        super();
        this.vistaLinkContext = context;
        this.responseFactory = factory;
    }


    /** (non-Javadoc)
     * @see gov.va.oit.vistaevolution.kernel.ws.xusrb.endpoints.interfaces.XUSRBSetupEndpoint#setup(gov.va.oit.vistaevolution.kernel.ws.xusrb.model.XUSRBSetupRequest)
     */
    @Override
    public XUSAPActiveResponse active(XUSAPActiveRequest request)
            throws VistaWebServiceFault {

        LinkedList<String> params = new LinkedList<String>();
        params.add(request.getDuz());

        return this.responseFactory
                .createSetupFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));
    }

}
