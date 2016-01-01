/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xma1b.endpoints;

import gov.va.oit.vistaevolution.mailman.ws.xma1b.XMA1BResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.endpoints.interfaces.XMA1BKlEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.model.XMA1BKlRequest;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.model.XMA1BKlResponse;
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
@WebService(serviceName="XMA1BKlService",
portName="XMA1BKlServicePort",
endpointInterface="gov.va.oit.vistaevolution.mailman.ws.xma1b.endpoints.interfaces.XMA1BKlEndpoint")
public class XMA1BKlEndpointImpl extends SpringBeanAutowiringSupport
		implements XMA1BKlEndpoint {
	
	private static final String RPCCALL = "XMWSOA KL";

	private static final Logger LOGGER = Logger.getLogger(XMA1BKlEndpointImpl.class);
			
	@Autowired
	private XMA1BResponseFactory xma1bResponseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	public XMA1BKlEndpointImpl() {
		super();
	}

	public XMA1BKlEndpointImpl(XMA1BResponseFactory xma1bResponseFactory, IVistaLinkContext vistaLinkContext) {
		super();
		this.xma1bResponseFactory = xma1bResponseFactory;
		this.vistaLinkContext = vistaLinkContext;
	}

	@Override
	public XMA1BKlResponse kl(XMA1BKlRequest request) throws VistaWebServiceFault {
		try {
			List<String> params = new ArrayList<String>(3);

			params.add(0, request.getXmduz());
			params.add(1, request.getXmk());
			params.add(2, request.getXmz());

			return this.xma1bResponseFactory
					.createKlResponseFromString(this.vistaLinkContext.makeRPCCall(new RPCIdentifier(RPCCALL) , params));
		} catch (VistaWebServiceFault e) {
			LOGGER.error(e);
			throw e;
		} catch (Exception e) {
			LOGGER.error(e);
			throw new VistaWebServiceFault(e);
		}
	}

	/*
	private Map<String, String> getParameterMap(XMA1BKlRequest request) {
		Map<String, String> parameterMap = new HashMap<String, String>();
		
		parameterMap.put("XMDUZ", request.getXmduz());
		parameterMap.put("XMK", request.getXmk());
		parameterMap.put("XMZ", request.getXmz());
		
		return parameterMap;
	}
	*/

	public XMA1BResponseFactory getXma1bResponseFactory() {
		return xma1bResponseFactory;
	}

	public void setXma1bResponseFactory(XMA1BResponseFactory xma1bResponseFactory) {
		this.xma1bResponseFactory = xma1bResponseFactory;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}
	
}
