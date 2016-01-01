package gov.va.oit.vistaevolution.fileman.ws.die.endpoints;

import gov.va.oit.vistaevolution.fileman.ws.die.DIEResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.die.endpoints.interfaces.DIEKeyValEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.die.model.DIEKeyValRequest;
import gov.va.oit.vistaevolution.fileman.ws.die.model.DIEKeyValResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@Component
@WebService(serviceName = "DIEKeyValService", portName = "DIEKeyValServicePort", endpointInterface = "gov.va.oit.vistaevolution.fileman.ws.die.endpoints.interfaces.DIEKeyValEndpoint")
public class DIEKeyValEndpointImpl extends SpringBeanAutowiringSupport implements DIEKeyValEndpoint {

	private static Logger LOGGER = Logger.getLogger(DIEKeyValEndpointImpl.class);

	@Autowired
	private DIEResponseFactory dieResponseFactory;

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	/**
	 * Default no arg constructor.
	 */
	public DIEKeyValEndpointImpl() {
		super();
	}

	/**
	 * @param vistaLinkContext
	 * @param didResponseFactory
	 */
	public DIEKeyValEndpointImpl(DIEResponseFactory dieResponseFactory,
			IVistaLinkContext vistaLinkContext) {
		super();
		this.dieResponseFactory = dieResponseFactory;
		this.vistaLinkContext = vistaLinkContext;
	}

	@Override
	public DIEKeyValResponse keyVal(DIEKeyValRequest request)
			throws VistaWebServiceFault {

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(this.toString() + " called with request of:\n"
					+ request.toString());
		}

		ArrayList<ArrayList<String>> params = getParameterList(request);

		String rawRpcResponse = getVistaLinkContext().makeRPCCall(
				new RPCIdentifier("DDR KEY VALIDATOR"), params);
		
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("RPC Call in" + this.toString() + " responded with:\n"
					+ rawRpcResponse);
		}

		DIEKeyValResponse response = dieResponseFactory
				.createDIEKeyValResponseFromString(rawRpcResponse);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(this.toString() + " responded with:\n"
					+ response.toString());
		}
		return response;
	}

	private ArrayList<ArrayList<String>> getParameterList(DIEKeyValRequest request) {

		ArrayList<ArrayList<String>> parameterList = new ArrayList<ArrayList<String>>();
		ArrayList<String> params = new ArrayList<String>();

		if (request.getValues() != null && request.getValues().size() != 0) {
			for (String value : request.getValues()) {
				params.add(value);
			}
			parameterList.add(params);
		}
		return parameterList;
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
