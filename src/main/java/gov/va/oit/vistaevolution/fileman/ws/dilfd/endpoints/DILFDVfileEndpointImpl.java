
package gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints;

import gov.va.oit.vistaevolution.fileman.ws.dilfd.DILFDResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.interfaces.DILFDVfileEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDVfileRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDVfileResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * @see gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.interfaces.DILFDVfileEndpoint
 * @author Christopher Schuck
 *
 */
@Component
@WebService(serviceName="DILFDVfileService",
portName="DILFDVfileServicePort",
endpointInterface="gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.interfaces.DILFDVfileEndpoint")
public class DILFDVfileEndpointImpl extends SpringBeanAutowiringSupport
		implements DILFDVfileEndpoint {
	
	private static final Logger LOGGER = Logger.getLogger(DILFDVfileEndpointImpl.class);
    
    private static final String RPCCALL = "DDR SOA FILE VERIFIER";

    @Autowired
    private DILFDResponseFactory responseFactory;

    @Autowired
    private IVistaLinkContext vistaLinkContext;
    
    /**
     * Default Bean Constructor
     */
    public DILFDVfileEndpointImpl() {
        super();
    }
    
    /**
     * Constructor initializes object
     * @param context
     * @param factory
     */
    public DILFDVfileEndpointImpl(IVistaLinkContext context, 
            DILFDResponseFactory factory) {
        
        this();
        this.vistaLinkContext = context;
        this.responseFactory = factory;
    }

	/**(non-Javadoc)
	 * @throws VistaWebServiceFault 
	 * @see gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.interfaces.DILFDVfileEndpoint#vfile(gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDVfileRequest)
	 */
	@Override
	public DILFDVfileResponse vfile(DILFDVfileRequest request) throws VistaWebServiceFault {
		
		try {
			
			List<String> params = new ArrayList<String>();

			params.add(request.getFile());        

			return this.responseFactory
					.createVfileResponseFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));
			
		} catch (VistaWebServiceFault e) {
			LOGGER.error(e);
			throw e;
		} catch (Exception e) {
			LOGGER.error(e);
			throw new VistaWebServiceFault(e);
		}
	}
}
