/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints;

import gov.va.oit.vistaevolution.kernel.ws.xuaf4.XUAF4ResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4ParentEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4ParentRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4ParentResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
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
@WebService(serviceName = "XUAF4ParentService", portName = "XUAF4ParentServicePort", endpointInterface = "gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4ParentEndpoint")
public class XUAF4ParentEndpointImpl implements XUAF4ParentEndpoint {

	@Autowired
	private XUAF4ResponseFactory xuaf4ResponseFactory;

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	/**
	 * @param xuaf4ResponseFactory
	 * @param vistaLinkContext
	 */
	public XUAF4ParentEndpointImpl(XUAF4ResponseFactory xuaf4ResponseFactory,
			IVistaLinkContext vistaLinkContext) {
		this.setVistaLinkContext(vistaLinkContext);
		this.setXuaf4ResponseFactory(xuaf4ResponseFactory);
	}

	/**
	 */
	public XUAF4ParentEndpointImpl() {
		this.setVistaLinkContext(null);
		this.setXuaf4ResponseFactory(null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.
	 * XUAF4ParentEndpoint
	 * #parent(gov.va.oit.vistaevolution.kernel.ws.xuaf4.model
	 * .XUAF4ParentRequest)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public XUAF4ParentResponse parent(XUAF4ParentRequest request)
			throws VistaWebServiceFault {

		LinkedList params = new LinkedList();
		HashMap<String, String> parameterMap = getParameterMap(request);
		params.add(parameterMap);

		IVistaLinkContext makeRPCCall = getVistaLinkContext();
		
		String response = makeRPCCall.makeRPCCall(new RPCIdentifier("XMWSOA PARENT"), params);
		return getXuaf4ResponseFactory().createParentXUAF4Response(response,
				request);
	}

	/**
	 * Converts request object type into RPC parameter map.
	 * 
	 * @param request
	 * @return
	 */
	private HashMap<String, String> getParameterMap(XUAF4ParentRequest request) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("CHILD", request.getIEN());
		map.put("ASSO", request.getASSO());
		return map;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	protected void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}

	public XUAF4ResponseFactory getXuaf4ResponseFactory() {
		return xuaf4ResponseFactory;
	}

	protected void setXuaf4ResponseFactory(
			XUAF4ResponseFactory xuaf4ResponseFactory) {
		this.xuaf4ResponseFactory = xuaf4ResponseFactory;
	}

}
