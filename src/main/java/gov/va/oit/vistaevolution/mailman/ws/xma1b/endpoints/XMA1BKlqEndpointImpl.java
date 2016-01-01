
package gov.va.oit.vistaevolution.mailman.ws.xma1b.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xma1b.XMA1BResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.endpoints.interfaces.XMA1BKlqEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.model.XMA1BKlqRequest;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.model.XMA1BKlqResponse;
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
 * @author Christopher Schuck
 *
 */
@Component
@WebService(serviceName="XMA1BKlqService",
portName="XMA1BKlqServicePort",
endpointInterface="gov.va.oit.vistaevolution.mailman.ws.xma1b.endpoints.interfaces.XMA1BKlqEndpoint")
public class XMA1BKlqEndpointImpl extends SpringBeanAutowiringSupport
		implements XMA1BKlqEndpoint {
    
    private static final String RPCCALL = "XMWSOA KLQ";
    
    @Autowired
    private XMA1BResponseFactory responseFactory;

    @Autowired
    private IVistaLinkContext vistaLinkContext;
    
	private static final Logger LOGGER = Logger.getLogger(XMA1BKlqEndpointImpl.class);
	
	/**
	 * Default Bean Constructor
	 */
	public XMA1BKlqEndpointImpl() {
	    super();
	}
	
	/**
	 * Bean constructor initializes variables
	 * @param context
	 * @param factory
	 */
	public XMA1BKlqEndpointImpl(final IVistaLinkContext context, 
	        final XMA1BResponseFactory factory) {
	        
	    super();
	    this.vistaLinkContext = context;
	    this.responseFactory = factory;
	}


    /* 
     * @{inheritDoc}
     */
	@Override
	public XMA1BKlqResponse klq(final XMA1BKlqRequest request) 
	        throws VistaWebServiceFault {
		
		try {
			List<String> params = new ArrayList<String>(3);

			params.add(0, request.getXmduz());
			params.add(1, request.getXmk());
			params.add(2, request.getXmz());

			return this.responseFactory
					.createKlqResponseFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL) , params));
		} catch (VistaWebServiceFault e) {
			LOGGER.error(e);
			throw e;
		} catch (Exception e) {
			LOGGER.error(e);
			throw new VistaWebServiceFault(e);
		}
	}

}
