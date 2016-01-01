package gov.va.oit.vistaevolution.mailman.ws.xma21.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xma21.XMA21ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xma21.endpoints.interfaces.XMA21InstEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xma21.model.XMA21InstRequest;
import gov.va.oit.vistaevolution.mailman.ws.xma21.model.XMA21InstResponse;
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
 * This class provides an implementation to the InstXMA21
 * service.
 * @see gov.va.oit.vistaevolution.mailman.ws.xma21.endpoints.interfaces.XMA21InstEndpoint
 * @author rcollins
 */
@Component
@WebService(serviceName="XMA21InstService",
portName="XMA21InstServicePort",
endpointInterface="gov.va.oit.vistaevolution.mailman.ws.xma21.endpoints.interfaces.XMA21InstEndpoint")
public class XMA21InstEndpointImpl extends SpringBeanAutowiringSupport implements XMA21InstEndpoint {
    
    private static final String RPCCALL = "XMWSOA INST";
    
    private static final Logger LOG = Logger
            .getLogger(XMA21InstEndpointImpl.class);
    
    @Autowired
    private XMA21ResponseFactory responseFactory;
    
    @Autowired
    private IVistaLinkContext vistaLinkContext;
    
    /**
     * Default Bean Constructor
     */
    public XMA21InstEndpointImpl() {
        super();
    }
    
    /**
     * Bean constructor initializes variables
     * @param factory
     * @param context
     */
    public XMA21InstEndpointImpl(final IVistaLinkContext context,
            final XMA21ResponseFactory factory) {
        
        this.responseFactory = factory;
        this.vistaLinkContext = context;
    }
    
    
    /**
     * @see gov.va.oit.vistaevolution.mailman.ws.xma21.endpoints.interfaces.XMA21InstEndpoint#inst(gov.va.oit.vistaevolution.mailman.ws.xma21.model.XMA21InstRequest)
     */
    @Override
    public XMA21InstResponse inst(final XMA21InstRequest request)
            throws VistaWebServiceFault {
        
        List<String> params = new ArrayList<String>(3);
        
        params.add(0, request.getXmadd());
        params.add(1, request.getXmdf());
        params.add(2, request.getXmduz());
        
        try {
            return this.responseFactory
                    .createInstFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));
        }
        catch(Exception ex) {
            
            LOG.error("ABNORMAL ERROR OCCURRED in XMA21InstEndpoint: ", ex);
            throw new VistaWebServiceFault("ABNORMAL ERROR OCCURRED !");
        }
    }
    
}
