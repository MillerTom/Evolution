
package gov.va.oit.vistaevolution.kernel.ws.xusclean.enpoints;

import gov.va.oit.vistaevolution.kernel.ws.xusclean.XUSCLEANResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xusclean.enpoints.interfaces.XUSCLEANLoutEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xusclean.model.XUSCLEANLoutRequest;
import gov.va.oit.vistaevolution.kernel.ws.xusclean.model.XUSCLEANLoutResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @see gov.va.oit.vistaevolution.kernel.ws.xusclean.enpoints.interfaces.XUSCLEANLoutEndpoint
 * @author rcollins
 *
 */
@Component
@WebService(serviceName="XUSCLEANLoutService",
portName="XUSCLEANLoutServicePort",
endpointInterface="gov.va.oit.vistaevolution.kernel.ws.xusclean.enpoints.interfaces.XUSCLEANLoutEndpoint")
public class XUSCLEANLoutEndpointImpl implements XUSCLEANLoutEndpoint {
    
    private static final String RPCCALL = "";
    
    private static final Logger LOG = Logger.getLogger(XUSCLEANLoutEndpointImpl.class);
    
    @Autowired
    private XUSCLEANResponseFactory responseFactory;
    
    @Autowired
    private IVistaLinkContext vistaLinkContext;
    
    /**
     * Default Bean Constructor
     */
    public XUSCLEANLoutEndpointImpl() {
        super();
    }
    
    /**
     * Constructor initializes the object
     * @param context
     * @param factory
     */
    public XUSCLEANLoutEndpointImpl(IVistaLinkContext context, 
            XUSCLEANResponseFactory factory) {
        
        this();
        this.vistaLinkContext = context;
        this.responseFactory = factory;
    }
    
    
    /** (non-Javadoc)
     * @see gov.va.oit.vistaevolution.kernel.ws.xusclean.enpoints.interfaces.XUSCLEANLoutEndpoint#lout(gov.va.oit.vistaevolution.kernel.ws.xusclean.model.XUSCLEANLoutRequest)
     */
    @Override
    public XUSCLEANLoutResponse lout(XUSCLEANLoutRequest request)
            throws VistaWebServiceFault {
        
        List<String> params = new ArrayList<String>(1);
        
        params.add(0, request.getDa());
        
        try {
            
            return this.responseFactory
                    .createLoutFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));
        }
        catch (Exception ex){
            
            LOG.error("ABNORMAL ERROR OCCURRED in XUSCLEANLoutEndpoint: ", ex);
            throw new VistaWebServiceFault("ABNORMAL ERROR OCCURRED !");
        }
    }
    
}
