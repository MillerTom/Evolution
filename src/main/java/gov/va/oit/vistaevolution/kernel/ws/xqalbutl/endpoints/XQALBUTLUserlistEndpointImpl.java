/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints;

import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.XQALBUTLResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints.interfaces.XQALBUTLUserlistEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLUserlistRequest;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLUserlistResponse;
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
 * @see gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints.interfaces.XQALBUTLUserlistEndpoint
 * @author Christopher Schuck
 *
 */
@Component
@WebService(serviceName="XQALBUTLUserlistService",
portName="XQALBUTLUserlistServicePort",
endpointInterface="gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints.interfaces.XQALBUTLUserlistEndpoint")
public class XQALBUTLUserlistEndpointImpl extends SpringBeanAutowiringSupport 
		implements XQALBUTLUserlistEndpoint {
    
    private static final String RPCCALL = "XU SOA USERLST";
	
	private static final Logger LOGGER = Logger.getLogger(XQALBUTLUserlistEndpointImpl.class);
	
	@Autowired
	private XQALBUTLResponseFactory responseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	/**
	 * Default Constructor
	 */
	public XQALBUTLUserlistEndpointImpl() {
	    super();
	}
	
	/**
	 * Constructor initializes object
	 * @param context
	 * @param factory
	 */
	public XQALBUTLUserlistEndpointImpl(final IVistaLinkContext context, 
	        final XQALBUTLResponseFactory factory) {
	    
        this();
        this.vistaLinkContext = context;
        this.responseFactory = factory;
    }
	

	/** (non-Javadoc)
	 * @see gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints.interfaces.XQALBUTLUserlistEndpoint#userlist(gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLUserlist)
	 */
	@Override
	public XQALBUTLUserlistResponse userlist(XQALBUTLUserlistRequest request) 
	        throws VistaWebServiceFault {
	    
		try {

			List<String> params = new ArrayList<String>(1);

			params.add(0, request.getXqaid());

			return this.responseFactory
					.createUserlistXQALBUTLResponseFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));
		} catch (VistaWebServiceFault e) {
			LOGGER.error(e);
			throw e;
		} catch (Exception e) {
			LOGGER.error(e);
			throw new VistaWebServiceFault(e);
		}
	}

	public XQALBUTLResponseFactory getXqabutlResponseFactory() {
		return responseFactory;
	}

	public void setXqabutlResponseFactory(
			XQALBUTLResponseFactory xqabutlResponseFactory) {
		this.responseFactory = xqabutlResponseFactory;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}
	
}
