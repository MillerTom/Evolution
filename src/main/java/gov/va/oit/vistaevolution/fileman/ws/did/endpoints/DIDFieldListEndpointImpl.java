/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.did.endpoints;

import gov.va.oit.vistaevolution.fileman.ws.did.DIDResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.did.endpoints.interfaces.DIDFieldListEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.did.model.DIDFieldListResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@Component
@WebService(serviceName = "DIDFieldListService", portName = "DIDFieldListServicePort", endpointInterface = "gov.va.oit.vistaevolution.fileman.ws.did.endpoints.interfaces.DIDFieldListEndpoint")
public class DIDFieldListEndpointImpl implements DIDFieldListEndpoint {

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	@Autowired
	private DIDResponseFactory didResponseFactory;

	/**
	 * @param vistaLinkContext
	 * @param didResponseFactory
	 */
	public DIDFieldListEndpointImpl(IVistaLinkContext vistaLinkContext,
			DIDResponseFactory didResponseFactory) {
		this.setDidResponseFactory(didResponseFactory);
		this.setVistaLinkContext(vistaLinkContext);
	}
	
	/**
	 */
	public DIDFieldListEndpointImpl() {
		this.setDidResponseFactory(null);
		this.setVistaLinkContext(null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see gov.va.oit.vistaevolution.fileman.ws.did.endpoints.interfaces.
	 * DIDFieldListEndpoint
	 * #fieldList(gov.va.oit.vistaevolution.ws.model.request.VistaRequest)
	 */
	@Override
	public DIDFieldListResponse fieldList() throws VistaWebServiceFault {

		return getDidResponseFactory().createDIDFieldListResponseFromString(
				getVistaLinkContext().makeRPCCall(
						"DDR SOA FIELD LIST RETRIEVER"));
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}

	public DIDResponseFactory getDidResponseFactory() {
		return didResponseFactory;
	}

	public void setDidResponseFactory(DIDResponseFactory didResponseFactory) {
		this.didResponseFactory = didResponseFactory;
	}

}
