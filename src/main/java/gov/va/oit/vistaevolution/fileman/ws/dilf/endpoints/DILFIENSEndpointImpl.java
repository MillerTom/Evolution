/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints;

import gov.va.oit.vistaevolution.fileman.ws.dilf.DILFResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.DILFIENSEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFIENSRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFIENSResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;

import javax.jws.WebService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@Component
@WebService(serviceName = "DILFIENSService", portName = "DILFIENSServicePort", endpointInterface = "gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.DILFIENSEndpoint")
public class DILFIENSEndpointImpl implements DILFIENSEndpoint {

	@Autowired
	private IVistaLinkContext vistaLinkContext;
	@Autowired
	private DILFResponseFactory responseFactory;

	/**
	 * @param vistaLinkContext
	 * @param dilfResponseFactory
	 */
	public DILFIENSEndpointImpl(IVistaLinkContext vistaLinkContext,
			DILFResponseFactory responseFactory) {
		super();
		this.setVistaLinkContext(vistaLinkContext);
		this.setResponseFactory(responseFactory);
	}

	/**
	 */

	public DILFIENSEndpointImpl() {
		super();
		this.setVistaLinkContext(null);
		this.setResponseFactory(null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.
	 * DILFIENSEndpoint
	 * #createIENS(gov.va.oit.vistaevolution.fileman.ws.dilf.model
	 * .DILFIENSRequest)
	 */
	@Override
	public DILFIENSResponse createIENS(DILFIENSRequest request) {
		return new DILFIENSResponse(StringUtils.join(request.getDdr(), ','));
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	protected void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}

	public DILFResponseFactory getResponseFactory() {
		return responseFactory;
	}

	protected void setResponseFactory(DILFResponseFactory responseFactory) {
		this.responseFactory = responseFactory;
	}

}
