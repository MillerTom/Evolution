/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xma1c.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xma1c.XMA1CResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xma1c.endpoints.interfaces.XMA1CSetsbEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xma1c.model.XMA1CSetsbRequest;
import gov.va.oit.vistaevolution.mailman.ws.xma1c.model.XMA1CSetsbResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
@WebService(serviceName="XMA1CSetsbService",
portName="XMA1CSetsbServicePort",
endpointInterface="gov.va.oit.vistaevolution.mailman.ws.xma1c.endpoints.interfaces.XMA1CSetsbEndpoint")
public class XMA1CSetsbEndpointImpl extends SpringBeanAutowiringSupport
		implements XMA1CSetsbEndpoint {
	
	private static final String RPCCALL = "XMWSOA SETSB";

	private static final Logger LOGGER = Logger.getLogger(XMA1CSetsbEndpointImpl.class);
	
	@Autowired
	private XMA1CResponseFactory xma1cResponseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	public XMA1CSetsbEndpointImpl() {
		super();
	}
	
	public XMA1CSetsbEndpointImpl(XMA1CResponseFactory xma1cResponseFactory,
			IVistaLinkContext vistaLinkContext) {
		super();
		this.xma1cResponseFactory = xma1cResponseFactory;
		this.vistaLinkContext = vistaLinkContext;
	}
	
	/* (non-Javadoc)
	 * @see gov.va.oit.vistaevolution.mailman.ws.xma1c.endpoints.interfaces.XMA1CSetsbEndpoint#setsb(gov.va.oit.vistaevolution.mailman.ws.xma1c.model.XMA1CSetsbRequest)
	 */
	@Override
	public XMA1CSetsbResponse setsb(XMA1CSetsbRequest request) throws VistaWebServiceFault {
		
		try {
			LinkedList<String> params = new LinkedList<String>();

			params.add(request.getXmxx());
			params.add(request.getXmz());

			return xma1cResponseFactory.createSetsbFromString(getVistaLinkContext()
					.makeRPCCall(new RPCIdentifier(RPCCALL), params));
		} catch (VistaWebServiceFault e) {
			LOGGER.error(e);
			throw e;
		} catch (Exception e) {
			LOGGER.error(e);
			throw new VistaWebServiceFault(e);
		}
	}
	
	public XMA1CResponseFactory getXma1cResponseFactory() {
		return xma1cResponseFactory;
	}

	public void setXma1cResponseFactory(XMA1CResponseFactory xma1cResponseFactory) {
		this.xma1cResponseFactory = xma1cResponseFactory;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}

}
