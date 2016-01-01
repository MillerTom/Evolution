/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints;

import java.util.ArrayList;
import java.util.List;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.XMXUtil2ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2BsktEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2BsktRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2BsktResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

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
@WebService(serviceName = "XMXUTIL2BsktService", portName = "XMXUTIL2BsktPort", endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2BsktEndpoint")
public class XMXUTIL2BsktEndpointImpl extends SpringBeanAutowiringSupport
		implements XMXUTIL2BsktEndpoint {
	
	private static final String RPCCALL = "XMWSOA MSG BSK INFO";

	@Autowired
	private XMXUtil2ResponseFactory responseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	// Log4J setup
	private static final Logger LOGGER = Logger
			.getLogger(XMXUTIL2BsktEndpointImpl.class);
	
	public XMXUTIL2BsktEndpointImpl() {
		super();
	}
	
	public XMXUTIL2BsktEndpointImpl(IVistaLinkContext vistaLinkContext, XMXUtil2ResponseFactory XMXUtil2ResponseFactory) {
		super();
		this.responseFactory = XMXUtil2ResponseFactory;
		this.vistaLinkContext = vistaLinkContext;
	}

	/* (non-Javadoc)
	 * @see gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2BsktEndpoint#bskt(gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2BsktRequest)
	 */
	@Override
	public XMXUTIL2BsktResponse bskt(XMXUTIL2BsktRequest request)
			throws VistaWebServiceFault {
        
        try {
            
            List<String> params = new ArrayList<String>();
            
            params.add(request.getXmduz());
            params.add(request.getXmz());        
            params.add(request.getXmname());

            return this.responseFactory
                    .createBsktFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));
        } catch (VistaWebServiceFault e) {
			LOGGER.error(e);
			throw e;
		} catch (Exception e) {
			LOGGER.error(e);
			throw new VistaWebServiceFault(e);
		}
	}

	public XMXUtil2ResponseFactory getXMXUtil2ResponseFactory() {
		return responseFactory;
	}

	public void setXMXUtil2ResponseFactory(
			XMXUtil2ResponseFactory responseFactory) {
		this.responseFactory = responseFactory;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}

}
