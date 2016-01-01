/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.XMXSEC1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.interfaces.XMXSEC1SsPrivEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1SsPrivRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1SsPrivResponse;
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
@WebService(serviceName = "XMXSEC1SsPrivService", 
portName = "XMXSEC1SsPrivPort", 
endpointInterface = "gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.interfaces.XMXSEC1SsPrivEndpoint")
public class XMXSEC1SsPrivEndpointImpl extends SpringBeanAutowiringSupport
		implements XMXSEC1SsPrivEndpoint {

	private static final String RPCCALL = "XMWSOA SS PRIV";
	
	@Autowired
	private XMXSEC1ResponseFactory responseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	// Log4J setup
	private static final Logger LOGGER = Logger
				.getLogger(XMXSEC1SsPrivEndpointImpl.class);
	
	public XMXSEC1SsPrivEndpointImpl() {
		super();
	}

	public XMXSEC1SsPrivEndpointImpl(IVistaLinkContext vistaLinkContext, XMXSEC1ResponseFactory responseFactory) {
		super();
		this.vistaLinkContext = vistaLinkContext;
		this.responseFactory = responseFactory;
	}

	/* (non-Javadoc)
	 * @see gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.interfaces.XMXSEC1SsPrivEndpoint#sspriv(gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1SsPrivRequest)
	 */
	@Override
	public XMXSEC1SsPrivResponse sspriv(XMXSEC1SsPrivRequest request)
			throws VistaWebServiceFault {
		
		try {
			return this.responseFactory.createSsPrivFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL)));
		} catch (Exception ex) {
            LOGGER.error("ABNORMAL ERROR OCCURRED in XMXSEC1SsPrivEndpoint: ", ex);
            throw new VistaWebServiceFault("ABNORMAL ERROR OCCURRED !");
        }
	}

}
