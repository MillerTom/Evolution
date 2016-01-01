
package gov.va.oit.vistaevolution.kernel.ws.xusrb1.endpoints;

import gov.va.oit.vistaevolution.kernel.ws.xusrb1.XUSRB1ResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xusrb1.endpoints.interfaces.XUSRB1SendkeysEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xusrb1.model.XUSRB1SendkeysRequest;
import gov.va.oit.vistaevolution.kernel.ws.xusrb1.model.XUSRB1SendkeysResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *  (non-Javadoc)
 * @see gov.va.oit.vistaevolution.kernel.ws.xusrb1.endpoints.interfaces.XUSRB1SendkeysEndpoint
 * @author rcollins
 *
 */
@Component
@WebService(serviceName="XUSRB1SendkeysEndpointService",
portName="SendkeysXUSRB1ServicePort",
endpointInterface="gov.va.oit.vistaevolution.kernel.ws.xusrb1.endpoints.interfaces.XUSRB1SendkeysEndpoint")
public class XUSRB1SendkeysEndpointImpl implements XUSRB1SendkeysEndpoint {

    private static final String RPCCALL = "XUS SEND KEYS";

    @Autowired
    private XUSRB1ResponseFactory responseFactory;

    @Autowired
    private IVistaLinkContext vistaLinkContext;

    /**
     * Default Constructor
     */
    public XUSRB1SendkeysEndpointImpl() {
        super();
    }

    /**
     * Bean constructor initializes variables
     * @param context
     * @param factory
     */
    public XUSRB1SendkeysEndpointImpl(final IVistaLinkContext context,
            final XUSRB1ResponseFactory factory) {

        super();
        this.vistaLinkContext = context;
        this.responseFactory = factory;
    }

    /** (non-Javadoc)
     * @see gov.va.oit.vistaevolution.kernel.ws.xusrb1.endpoints.interfaces.XUSRB1SendkeysEndpoint#sendkeys(gov.va.oit.vistaevolution.kernel.ws.xusrb1.model.XUSRB1SendkeysRequest)
     */
    @Override
    public XUSRB1SendkeysResponse sendkeys(final XUSRB1SendkeysRequest request)
            throws VistaWebServiceFault {

        List<String> params = new ArrayList<String>(1);

        params.add(request.getRoot());

        return this.responseFactory
                .createSendKeysFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));
    }

}
