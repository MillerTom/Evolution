/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xma21.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xma21.XMA21ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xma21.endpoints.interfaces.XMA21ChkEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xma21.model.XMA21ChkRequest;
import gov.va.oit.vistaevolution.mailman.ws.xma21.model.XMA21ChkResponse;
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
 * @see gov.va.oit.vistaevolution.mailman.ws.xma21.endpoints.interfaces.XMA21ChkEndpoint
 * @author Christopher Schuck
 *
 */
@Component
@WebService(serviceName="XMA21ChkService",
portName="XMA21ChkServicePort",
endpointInterface="gov.va.oit.vistaevolution.mailman.ws.xma21.endpoints.interfaces.XMA21ChkEndpoint")
public class XMA21ChkEndpointImpl extends SpringBeanAutowiringSupport 
		implements XMA21ChkEndpoint {

    private static final String RPCCALL = "XMWSOA CHK";
	
	private static final Logger LOGGER = Logger.getLogger(XMA21ChkEndpointImpl.class);
			
	@Autowired
	private XMA21ResponseFactory responseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	/**
	 * Default Constructor
	 */
	public XMA21ChkEndpointImpl() {
		super();
	}	

	/**
	 * Constructor initializes class variables
	 * @param vistaLinkContext
	 * @param responseFactory
	 */
	public XMA21ChkEndpointImpl(IVistaLinkContext vistaLinkContext, 
	        XMA21ResponseFactory responseFactory) {
		
	    this();
		this.responseFactory = responseFactory;
		this.vistaLinkContext = vistaLinkContext;
	}

	/** (non-Javadoc)
	 * @see gov.va.oit.vistaevolution.mailman.ws.xma21.endpoints.interfaces.XMA21ChkEndpoint#chk(gov.va.oit.vistaevolution.mailman.ws.xma21.model.XMA21ChkRequest)
	 */
	@Override
	public XMA21ChkResponse chk(XMA21ChkRequest request) 
	        throws VistaWebServiceFault {
		
		try {
			List<String> params = new ArrayList<String>(2);

			params.add(0, request.getXmduz());
			params.add(1, request.getIen());

			return this.responseFactory
					.createChkXMA21ResponseFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL), params));
		} catch (VistaWebServiceFault e) {
			LOGGER.error(e);
			throw e;
		} catch (Exception e) {
			LOGGER.error(e);
			e.printStackTrace();
			throw new VistaWebServiceFault(e);
		}
	}


	public XMA21ResponseFactory getXma21ResponseFactory() {
		return this.responseFactory;
	}

	public void setXma21ResponseFactory(XMA21ResponseFactory responseFactory) {
		this.responseFactory = responseFactory;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}
	
}
