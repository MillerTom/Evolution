
package gov.va.oit.vistaevolution.mailman.ws.xma1c.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xma1c.XMA1CResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xma1c.endpoints.interfaces.XMA1CRemsbmsgEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xma1c.model.XMA1CRemsbmsgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xma1c.model.XMA1CRemsbmsgResponse;
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
 * @see gov.va.oit.vistaevolution.mailman.ws.xma1c.endpoints.interfaces.XMA1CRemsbmsgEndpoint
 * @author Christopher Schuck
 *
 */
@Component
@WebService(serviceName="XMA1CRemsbmsgService",
portName="XMA1CRemsbmsgServicePort",
endpointInterface="gov.va.oit.vistaevolution.mailman.ws.xma1c.endpoints.interfaces.XMA1CRemsbmsgEndpoint")
public class XMA1CRemsbmsgEndpointImpl extends SpringBeanAutowiringSupport 
		implements XMA1CRemsbmsgEndpoint {
	
	private static final Logger LOGGER = Logger.getLogger(XMA1CRemsbmsgEndpointImpl.class);
    
    private static final String RPCCALL = "XMWSOA REMSBMSG";
    
    @Autowired
    private XMA1CResponseFactory responseFactory;
    
    @Autowired
    private IVistaLinkContext vistaLinkContext;  
	
	/**
	 * Default Bean Construtor
	 */
	public XMA1CRemsbmsgEndpointImpl() {
	    super();
	}
	
	/**
	 * Bean constructor initializes variables
	 * @param context
	 * @param factory
	 */
	public XMA1CRemsbmsgEndpointImpl(final IVistaLinkContext context, 
	        final XMA1CResponseFactory factory) {
	    
	    this();
	    this.responseFactory = factory;
	    this.vistaLinkContext = context;	    
	}
	
   
	/** (non-Javadoc)
     * @see gov.va.oit.vistaevolution.mailman.ws.xma1c.endpoints.interfaces.XMA1CRemsbmsgEndpoint#remsb(gov.va.oit.vistaevolution.mailman.ws.xma1c.model.XMA1CRemsbmsgRequest)
     */
	@Override
	public XMA1CRemsbmsgResponse remsbmsg(final XMA1CRemsbmsgRequest request) 
	        throws VistaWebServiceFault {

		try {
			List<String> params = new ArrayList<String>(2);	    

			params.add(0, request.getXmser());
			params.add(1, request.getXmz());

			return this.responseFactory
					.createRemsbmsgFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));
		} catch (VistaWebServiceFault e) {
			LOGGER.error(e);
			throw e;
		} catch (Exception e) {
			LOGGER.error(e);
			throw new VistaWebServiceFault(e);
		}
	}

}
