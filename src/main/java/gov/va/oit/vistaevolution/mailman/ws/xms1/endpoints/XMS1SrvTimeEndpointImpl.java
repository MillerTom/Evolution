
package gov.va.oit.vistaevolution.mailman.ws.xms1.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xms1.XMS1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xms1.endpoints.interfaces.XMS1SrvTimeEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xms1.model.XMS1SrvTimeRequest;
import gov.va.oit.vistaevolution.mailman.ws.xms1.model.XMS1SrvTimeResponse;
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
 * @see gov.va.oit.vistaevolution.mailman.ws.xms1.endpoints.interfaces.XMS1SrvTimeEndpoint
 * @author rcollins
 *
 */
@Component
@WebService(serviceName="XMS1SrvTimeService",
portName="XMS1SrvTimeServicePort",
endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xms1.endpoints.interfaces.XMS1SrvTimeEndpoint")
public class XMS1SrvTimeEndpointImpl extends SpringBeanAutowiringSupport
    implements XMS1SrvTimeEndpoint {
    
    private static final String RPCCALL = "XMWSOA SRVTIME";

    private static final Logger LOG = Logger
            .getLogger(XMS1SrvTimeEndpointImpl.class);

    @Autowired
    private XMS1ResponseFactory responseFactory;

    @Autowired
    private IVistaLinkContext vistaLinkContext;
    
    
    /**
     * Default Bean Constructor 
     */
    public XMS1SrvTimeEndpointImpl() {
        super();
    }
    
    /**
     * Constructor initializes class variables
     * @param context
     * @param factory
     */
    public XMS1SrvTimeEndpointImpl(IVistaLinkContext context, XMS1ResponseFactory factory) {
        
        this();
        this.vistaLinkContext = context;
        this.responseFactory = factory;
    }
    
    
    /**
     * @throws VistaWebServiceFault
     * @see gov.va.oit.vistaevolution.mailman.ws.xms1.endpoints.interfaces.XMS1SrvTimeEndpoint#srvtime(gov.va.oit.vistaevolution.mailman.ws.xms1.model.XMS1SrvTimeRequest)
     */
    @Override
    public XMS1SrvTimeResponse srvtime(XMS1SrvTimeRequest request)
            throws VistaWebServiceFault {
        
        List<String> params = new ArrayList<String>(3);
        
        params.add(0, request.getXmz());
        params.add(1, request.getXmser());
        params.add(2, request.getStatus());
        
        try {
            return this.responseFactory
                    .createSrvTimeFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));
        }
        catch(Exception ex) {

            LOG.error("ABNORMAL ERROR OCCURRED in XMS1SrvTimeEndpoint: ", ex);
            throw new VistaWebServiceFault("ABNORMAL ERROR OCCURRED !");
        }
    }
    
}
