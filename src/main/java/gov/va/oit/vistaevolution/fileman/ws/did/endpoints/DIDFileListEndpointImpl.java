/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.did.endpoints;

import gov.va.oit.vistaevolution.fileman.ws.did.DIDResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.did.endpoints.interfaces.DIDFileListEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.did.model.DIDFileListResponse;
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
@WebService(serviceName = "DIDFileListService", portName = "FileListDIDServicePort", endpointInterface = "gov.va.oit.vistaevolution.fileman.ws.did.endpoints.interfaces.DIDFileListEndpoint")
public class DIDFileListEndpointImpl implements DIDFileListEndpoint {

	@Autowired
	private DIDResponseFactory didResponseFactory;

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	/**
	 * @param vistaLinkContext
	 * @param didResponseFactory
	 */
	public DIDFileListEndpointImpl(IVistaLinkContext vistaLinkContext,
			DIDResponseFactory didResponseFactory) {
		super();
		this.setVistaLinkContext(vistaLinkContext);
		this.setDidResponseFactory(didResponseFactory);
	}

	/**
	 * Default no arg constructor.
	 */
	public DIDFileListEndpointImpl() {
		super();
		this.setVistaLinkContext(vistaLinkContext);
		this.setDidResponseFactory(didResponseFactory);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see gov.va.oit.vistaevolution.fileman.ws.did.endpoints.interfaces.
	 * FileListDIDEndpoint
	 * #fileList(gov.va.oit.vistaevolution.ws.model.request.VistaRequest)
	 */
	@Override
	public DIDFileListResponse fileList() throws VistaWebServiceFault {
		return didResponseFactory
				.createDIDFileListResponseFromString(getVistaLinkContext()
						.makeRPCCall("DDR SOA FILE LIST RETRIEVER"));
	}

	public DIDResponseFactory getDidResponseFactory() {
		return didResponseFactory;
	}

	protected void setDidResponseFactory(DIDResponseFactory didResponseFactory) {
		this.didResponseFactory = didResponseFactory;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	protected void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}

}
