/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.did.endpoints;

import gov.va.oit.vistaevolution.fileman.ws.did.DIDResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.did.endpoints.interfaces.DIDFileEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.did.model.DIDFileRequest;
import gov.va.oit.vistaevolution.fileman.ws.did.model.DIDFileResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.HashMap;
import java.util.LinkedList;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@Component
@WebService(serviceName = "DIDFileService", portName = "DIDFileServicePort", endpointInterface = "gov.va.oit.vistaevolution.fileman.ws.did.endpoints.interfaces.DIDFileEndpoint")
public class DIDFileEndpointImpl implements DIDFileEndpoint {

	@Autowired
	private DIDResponseFactory didResponseFactory;

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	/**
	 * @param vistaLinkContext
	 * @param didResponseFactory
	 */
	public DIDFileEndpointImpl(IVistaLinkContext vistaLinkContext,
			DIDResponseFactory didResponseFactory) {
		super();
		this.setVistaLinkContext(vistaLinkContext);
		this.setDiqResponseFactory(didResponseFactory);
	}
	
	/**
	 * @param vistaLinkContext
	 * @param didResponseFactory
	 */
	public DIDFileEndpointImpl() {
		super();
		this.setVistaLinkContext(null);
		this.setDiqResponseFactory(null);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws VistaWebServiceFault
	 * 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public DIDFileResponse file(DIDFileRequest request)
			throws VistaWebServiceFault {
		LinkedList params = new LinkedList();
		HashMap<String, String> parameterMap = getParameterMap(request);
		params.add(parameterMap);

		return didResponseFactory
				.createDIDFileResponseFromString(getVistaLinkContext()
						.makeRPCCall("DDR SOA FILE RETRIEVER", params));
	}

	/**
	 * @param request
	 * @return
	 */
	private HashMap<String, String> getParameterMap(DIDFileRequest request) {
		// TODO most of this is duplicated from FieldDIDEndpointImpl
		HashMap<String, String> parameterMap = new HashMap<String, String>();

		parameterMap.put("FILE", request.getFile());

		if (request.getFlags() != null && request.getFlags().size() != 0) {
			StringBuilder flags = new StringBuilder();
			for (String flag : request.getFlags()) {
				flags.append(flag);

			}
			parameterMap.put("FLAGS", flags.toString());
		}
		StringBuilder attributes = new StringBuilder();
		for (String attribute : request.getAttributes()) {
			attributes.append(attribute);
			attributes.append(";");
		}
		parameterMap.put("ATTRIBUTES",
				attributes.substring(0, attributes.length() - 2)); // cuts off
																	// final ';'

		return parameterMap;
	}

	public DIDResponseFactory getDiqResponseFactory() {
		return didResponseFactory;
	}

	protected void setDiqResponseFactory(DIDResponseFactory diqResponseFactory) {
		this.didResponseFactory = diqResponseFactory;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	protected void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}

}