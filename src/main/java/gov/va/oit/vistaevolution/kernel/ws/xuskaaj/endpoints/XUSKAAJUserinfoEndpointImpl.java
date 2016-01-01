/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuskaaj.endpoints;

import gov.va.oit.vistaevolution.kernel.ws.xuskaaj.XUSKAAJResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xuskaaj.endpoints.interfaces.XUSKAAJUserinfoEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuskaaj.model.XUSKAAJUserinfoRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuskaaj.model.XUSKAAJUserinfoResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.LinkedList;
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
@WebService(serviceName="XUSKAAJUserinfoService",
portName="XUSKAAJUserinfoServicePort",
endpointInterface="gov.va.oit.vistaevolution.kernel.ws.xuskaaj.endpoints.interfaces.XUSKAAJUserinfoEndpoint")
public class XUSKAAJUserinfoEndpointImpl extends SpringBeanAutowiringSupport
		implements XUSKAAJUserinfoEndpoint {
	
	private static final String RPCCALL = "XUS KAAJEE GET USER INFO";

	private static final Logger LOGGER = Logger.getLogger(XUSKAAJUserinfoEndpointImpl.class);
	
	@Autowired
	private XUSKAAJResponseFactory xuskaajResponseFactory;
	
	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	public XUSKAAJUserinfoEndpointImpl() {
		super();
	}

	public XUSKAAJUserinfoEndpointImpl(IVistaLinkContext vistaLinkContext, XUSKAAJResponseFactory xuskaajResponseFactory) {
		super();
		this.vistaLinkContext = vistaLinkContext;
		this.xuskaajResponseFactory = xuskaajResponseFactory;
	}

	/* (non-Javadoc)
	 * @see gov.va.oit.vistaevolution.kernel.ws.xuskaaj.endpoints.interfaces.XUSKAAJUserinfoEndpoint#userinfo(gov.va.oit.vistaevolution.kernel.ws.xuskaaj.model.XUSKAAJUserinfoRequest)
	 */
	@Override
	public XUSKAAJUserinfoResponse userinfo(XUSKAAJUserinfoRequest request)
			throws VistaWebServiceFault {
		
		List<String> params = new LinkedList<String>();
		params.add(request.getClientip());
		params.add(request.getServernm());

		try {
			return xuskaajResponseFactory.createUserinfoFromString(getVistaLinkContext()
					.makeRPCCall(new RPCIdentifier(RPCCALL), params));
		} catch (Exception ex) {
			LOGGER.error("ABNORMAL ERROR OCCURRED in XUSKAAJUserinfo: ", ex);
			throw new VistaWebServiceFault("ABNORMAL ERROR OCCURRED !");
		}

	}
	
	public XUSKAAJResponseFactory getXuskaajResponseFactory() {
		return xuskaajResponseFactory;
	}

	public void setXuskaajResponseFactory(
			XUSKAAJResponseFactory xuskaajResponseFactory) {
		this.xuskaajResponseFactory = xuskaajResponseFactory;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}
	
}
