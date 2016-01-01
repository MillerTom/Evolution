/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xma21.endpoints;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import gov.va.oit.vistaevolution.mailman.ws.xma21.XMA21ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xma21.endpoints.interfaces.XMA21WhoEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xma21.model.XMA21WhoRequest;
import gov.va.oit.vistaevolution.mailman.ws.xma21.model.XMA21WhoResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

/**
 * @author Christopher Schuck
 *
 */
@Component
@WebService(serviceName="XMA21WhoService",
portName="XMA21WhoServicePort",
endpointInterface="gov.va.oit.vistaevolution.mailman.ws.xma21.endpoints.interfaces.XMA21WhoEndpoint")
public class XMA21WhoEndpointImpl extends SpringBeanAutowiringSupport 
		implements XMA21WhoEndpoint {
	
	private static final String RPCCALL = "XMWSOA WHO";

	private static final Logger LOGGER = Logger.getLogger(XMA21WhoEndpointImpl.class);
			
    @Autowired
    private XMA21ResponseFactory responseFactory;
        
    @Autowired
    private IVistaLinkContext vistaLinkContext;
    
    public XMA21WhoEndpointImpl() {
		super();
	}
    
    public XMA21WhoEndpointImpl(XMA21ResponseFactory responseFactory, IVistaLinkContext vistaLinkContext) {
		super();
		this.responseFactory = responseFactory;
		this.vistaLinkContext = vistaLinkContext;
	}

    /* (non-Javadoc)
	 * @see gov.va.oit.vistaevolution.mailman.ws.xma21.endpoints.interfaces.XMA21WhoEndpoint#who(gov.va.oit.vistaevolution.mailman.ws.xma21.model.XMA21WhoRequest)
	 */
	@Override
	public XMA21WhoResponse who(XMA21WhoRequest request) throws VistaWebServiceFault {
		try {
			List<String> params = new ArrayList<String>(4);

			params.add(0, request.getX());
			params.add(1, request.getXmdf());
			params.add(2, request.getXmduz());
			// params.add(3, request.getXmloc());

			return this.responseFactory
					.createWhoFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));
		} catch (VistaWebServiceFault e) {
			LOGGER.error(e);
			throw e;
		} catch (Exception e) {
			LOGGER.error(e);
			e.printStackTrace();
			throw new VistaWebServiceFault(e);
		}
	}

	public XMA21ResponseFactory getResponseFactory() {
		return responseFactory;
	}

	public void setResponseFactory(XMA21ResponseFactory responseFactory) {
		this.responseFactory = responseFactory;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}

}
