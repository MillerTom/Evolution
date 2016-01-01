
package gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints;

import gov.va.oit.vistaevolution.fileman.ws.dilfd.DILFDResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.interfaces.DILFDVfieldEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDVfieldRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDVfieldResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * @see gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.interfaces.DILFDVfieldEndpoint
 * @author Christopher Schuck
 *
 */
@Component
@WebService(serviceName="DILFDVfieldService",
portName="DILFDVfieldServicePort",
endpointInterface="gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.interfaces.DILFDVfieldEndpoint")
public class DILFDVfieldEndpointImpl extends SpringBeanAutowiringSupport
		implements DILFDVfieldEndpoint {
    
    private static final String RPCCALL = "DDR SOA FIELD VERIFIER";

    @Autowired
    private DILFDResponseFactory responseFactory;

    @Autowired
    private IVistaLinkContext vistaLinkContext;
    
    /**
     * Default bean constructor
     */
    public DILFDVfieldEndpointImpl() {
        super();
    }
    
    /**
     * Constructor initializes bean
     * @param context
     * @param factory
     */
    public DILFDVfieldEndpointImpl(IVistaLinkContext context, 
            DILFDResponseFactory factory) {
        
        this();
        this.vistaLinkContext = context;
        this.responseFactory = factory;
    }
    

	/** 
	 * @throws VistaWebServiceFault 
	 * @see gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.interfaces.DILFDVfieldEndpoint#root(gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDVfieldRequest)
	 */
	@Override
	public DILFDVfieldResponse vfield(DILFDVfieldRequest request) throws VistaWebServiceFault {
		
	    List<Object> params = new ArrayList<Object>();
	    
	    Map<String, Object> parameterMap = new HashMap<String, Object>(2);
	    
	    parameterMap.put("FILE", request.getFile());
	    parameterMap.put("FIELD", request.getField());
	    
	    params.add(parameterMap);
	    
	    return this.responseFactory
	            .createVfieldResponseFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));
	}

}
