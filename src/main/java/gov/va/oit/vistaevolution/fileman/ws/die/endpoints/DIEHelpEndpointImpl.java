package gov.va.oit.vistaevolution.fileman.ws.die.endpoints;

import gov.va.oit.vistaevolution.fileman.ws.die.DIEResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.die.endpoints.interfaces.DIEHelpEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.die.model.DIEHelpRequest;
import gov.va.oit.vistaevolution.fileman.ws.die.model.DIEHelpResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.HashMap;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@Component
@WebService(serviceName = "DIEHelpService", portName = "DIEHelpServicePort", endpointInterface = "gov.va.oit.vistaevolution.fileman.ws.die.endpoints.interfaces.DIEHelpEndpoint")
public class DIEHelpEndpointImpl extends SpringBeanAutowiringSupport implements DIEHelpEndpoint {

	@Autowired
	private DIEResponseFactory dieResponseFactory;

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	/**
	 * Default no arg constructor.
	 */
	public DIEHelpEndpointImpl() {
		super();
		this.setVistaLinkContext(vistaLinkContext);
		this.setDieResponseFactory(dieResponseFactory);
	}

	/**
	 * @param vistaLinkContext
	 * @param didResponseFactory
	 */
	public DIEHelpEndpointImpl(	IVistaLinkContext vistaLinkContext,
			DIEResponseFactory dieResponseFactory) {
		super();
		this.vistaLinkContext = vistaLinkContext;
		this.dieResponseFactory = dieResponseFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see gov.va.oit.vistaevolution.fileman.ws.die.endpoints.interfaces.
	 * DIEHelpEndpoint
	 */
	@Override
	public DIEHelpResponse help(DIEHelpRequest request) throws VistaWebServiceFault {
		ArrayList<HashMap<String, String>> parameterMap = getParameterMap(request);
		return dieResponseFactory.createDIEHelpResponseFromString(
				getVistaLinkContext().makeRPCCall(new RPCIdentifier("DDR GET DD HELP"), parameterMap));
	}

	/**
	 * This method is used internally to construct the request parameters for
	 * the RPC.
	 * 
	 * @param request
	 * @return
	 */
	private ArrayList<HashMap<String, String>> getParameterMap(DIEHelpRequest request) {

		// Setup the parameters to pass to the VistaLink RPC Broker
		ArrayList<HashMap<String, String>> parameterMap = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> hm = new HashMap<String, String>();

		hm.put("FILE", request.getFile());
		hm.put("FIELD", request.getField());
		hm.put("IENS", request.getIens());

		if (request.getFlags() != null && request.getFlags().size() != 0) {
			StringBuilder flags = new StringBuilder();
			for (String flag : request.getFlags()) {
				flags.append(flag);

			}
			hm.put("FLAGS", flags.toString());
		}
		
		parameterMap.add(hm);

		return parameterMap;
	}
	
	/**
	 * @return the dieResponseFactory
	 */
	public DIEResponseFactory getDieResponseFactory() {
		return dieResponseFactory;
	}

	/**
	 * @param dieResponseFactory
	 *            the dieResponseFactory to set
	 */
	public void setDieResponseFactory(DIEResponseFactory dieResponseFactory) {
		this.dieResponseFactory = dieResponseFactory;
	}

	/**
	 * @return the vistaLinkContext
	 */
	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	/**
	 * @param vistaLinkContext
	 *            the vistaLinkContext to set
	 */
	public void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}

}
