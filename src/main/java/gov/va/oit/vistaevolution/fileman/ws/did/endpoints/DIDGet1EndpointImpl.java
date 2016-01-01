/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.did.endpoints;

import gov.va.oit.vistaevolution.fileman.ws.did.DIDResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.did.endpoints.interfaces.DIDGet1Endpoint;
import gov.va.oit.vistaevolution.fileman.ws.did.model.DIDGet1Request;
import gov.va.oit.vistaevolution.fileman.ws.did.model.DIDGet1Response;
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
@WebService(serviceName = "DIDGet1Service", portName = "DIDGet1ServicePort", endpointInterface = "gov.va.oit.vistaevolution.fileman.ws.did.endpoints.interfaces.DIDGet1Endpoint")
public class DIDGet1EndpointImpl implements DIDGet1Endpoint {

	@Autowired
	private DIDResponseFactory didResponseFactory;

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	/**
	 * {@inheritDoc}
	 * 
	 * @throws VistaWebServiceFault
	 * 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public DIDGet1Response get1(DIDGet1Request request)
			throws VistaWebServiceFault {
		// TODO: Where are we gathering the division from?
		LinkedList params = new LinkedList();
		HashMap<String, String> parameterMap = getParameterMap(request);
		params.add(parameterMap);

		return didResponseFactory
				.createGet1ResponseFromString(getVistaLinkContext()
						.makeRPCCall("DDR SOA ATTRIBUTE RETRIEVER", params));

	}

	/**
	 * @param request
	 * @return
	 */
	private HashMap<String, String> getParameterMap(DIDGet1Request request) {
		// TODO Auto-generated method stub
		return null;
	}

	public DIDResponseFactory getDidResponseFactory() {
		return didResponseFactory;
	}

	public void setDidResponseFactory(DIDResponseFactory didResponseFactory) {
		this.didResponseFactory = didResponseFactory;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}

}
