/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.did.endpoints;

import gov.va.oit.vistaevolution.fileman.ws.did.DIDResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.did.endpoints.interfaces.DIDFieldEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.did.model.DIDFieldRequest;
import gov.va.oit.vistaevolution.fileman.ws.did.model.DIDFieldResponse;
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
@WebService(serviceName = "DIDFieldService", portName = "DIDFieldServicePort", endpointInterface = "gov.va.oit.vistaevolution.fileman.ws.did.endpoints.interfaces.DIDFieldEndpoint")
public class DIDFieldEndpointImpl implements DIDFieldEndpoint {

	@Autowired
	private DIDResponseFactory didResponseFactory;

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	/**
	 * @param vistaLinkContext
	 * @param didResponseFactory
	 */
	public DIDFieldEndpointImpl(IVistaLinkContext vistaLinkContext,
			DIDResponseFactory didResponseFactory) {
		this.setVistaLinkContext(vistaLinkContext);
		this.setDiqResponseFactory(didResponseFactory);
	}

	/**
	 * @param vistaLinkContext
	 * @param didResponseFactory
	 */
	public DIDFieldEndpointImpl() {
		this.setDiqResponseFactory(null);
		this.setDiqResponseFactory(null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see gov.va.oit.vistaevolution.fileman.ws.did.endpoints.interfaces.
	 * DIDFieldEndpoint
	 * #field(gov.va.oit.vistaevolution.ws.model.request.VistaRequest)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public DIDFieldResponse field(DIDFieldRequest request)
			throws VistaWebServiceFault {
		LinkedList params = new LinkedList();
		HashMap<String, String> parameterMap = getParameterMap(request);
		params.add(parameterMap);

		return didResponseFactory.createDIDFieldResponseFromString(
				request,
				getVistaLinkContext().makeRPCCall("DDR SOA FIELD RETRIEVER",
						params));
	}

	/**
	 * This method is used internally to construct the request parameters for
	 * the RPC.
	 * 
	 * @param request
	 * @return
	 */
	private HashMap<String, String> getParameterMap(DIDFieldRequest request) {
		//TODO Most of this is duplicated in FileDIDEndpointImpl
		HashMap<String, String> parameterMap = new HashMap<String, String>();

		parameterMap.put("FILE", request.getFile());
		parameterMap.put("FIELD", request.getField());

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

	public void setDiqResponseFactory(DIDResponseFactory diqResponseFactory) {
		this.didResponseFactory = diqResponseFactory;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}

}
