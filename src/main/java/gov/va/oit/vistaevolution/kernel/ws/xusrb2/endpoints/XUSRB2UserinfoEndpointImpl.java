/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusrb2.endpoints;

import gov.va.oit.vistaevolution.kernel.ws.xusrb2.XUSRB2ResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xusrb2.endpoints.interfaces.XUSRB2UserinfoEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xusrb2.model.XUSRB2UserinfoRequest;
import gov.va.oit.vistaevolution.kernel.ws.xusrb2.model.XUSRB2UserinfoResponse;
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
@WebService(serviceName="XUSRB2UserinfoService",
portName="XUSRB2UserinfoServicePort",
endpointInterface="gov.va.oit.vistaevolution.kernel.ws.xusrb2.endpoints.interfaces.XUSRB2UserinfoEndpoint")
public class XUSRB2UserinfoEndpointImpl extends SpringBeanAutowiringSupport
		implements XUSRB2UserinfoEndpoint {
	
	private static final String RPCCALL = "XUS GET USER INFO";
	
	private static final Logger LOGGER = Logger.getLogger(XUSRB2UserinfoEndpointImpl.class);
	
	@Autowired
	private XUSRB2ResponseFactory responseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	public XUSRB2UserinfoEndpointImpl() {
		super();
	}

	public XUSRB2UserinfoEndpointImpl(IVistaLinkContext vistaLinkContext, XUSRB2ResponseFactory xusrb2ResponseFactory) {
		super();
		this.vistaLinkContext = vistaLinkContext;
		this.responseFactory = xusrb2ResponseFactory;
	}

	/* (non-Javadoc)
	 * @see gov.va.oit.vistaevolution.kernel.ws.xusrb2.endpoints.interfaces.XUSRB2UserinfoEndpoint#userinfo(gov.va.oit.vistaevolution.kernel.ws.xusrb2.model.XUSRB2UserinfoRequest)
	 */
	@Override
	public XUSRB2UserinfoResponse userinfo(XUSRB2UserinfoRequest request)
			throws VistaWebServiceFault {

		try {
			return responseFactory
					.createUserinfoFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL)));
		} catch (VistaWebServiceFault e) {
			LOGGER.error(e);
			throw e;
		} catch (Exception e) {
			LOGGER.error(e);
			throw new VistaWebServiceFault(e);
		}
	}

}
