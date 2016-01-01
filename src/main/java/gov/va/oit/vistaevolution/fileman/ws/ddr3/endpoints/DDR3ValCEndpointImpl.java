package gov.va.oit.vistaevolution.fileman.ws.ddr3.endpoints;

import gov.va.oit.vistaevolution.fileman.ws.ddr3.DDR3ResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.ddr3.endpoints.interfaces.DDR3ValCEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.ddr3.model.DDR3ValCRequest;
import gov.va.oit.vistaevolution.fileman.ws.ddr3.model.DDR3ValCResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.HashMap;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@Component
@WebService(serviceName="DDR3ValCService",
portName="DDR3ValCServicePort",
endpointInterface="gov.va.oit.vistaevolution.fileman.ws.ddr3.endpoints.interfaces.DDR3ValCEndpoint")
public class DDR3ValCEndpointImpl extends SpringBeanAutowiringSupport implements DDR3ValCEndpoint {
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(DDR3ValCEndpointImpl.class);
	
	@Autowired
	private DDR3ResponseFactory ddr3ResponseFactory;

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	/**
	 * Default no arg constructor.
	 */
	public DDR3ValCEndpointImpl() {
		super();
		this.setVistaLinkContext(vistaLinkContext);
		this.setDdr3ResponseFactory(ddr3ResponseFactory);
	}

	/**
	 * @param vistaLinkContext
	 * @param didResponseFactory
	 */
	public DDR3ValCEndpointImpl(	IVistaLinkContext vistaLinkContext,
			DDR3ResponseFactory ddr3ResponseFactory) {
		super();
		this.vistaLinkContext = vistaLinkContext;
		this.ddr3ResponseFactory = ddr3ResponseFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see gov.va.oit.vistaevolution.fileman.ws.ddr3.endpoints.interfaces.
	 * DDR3ValCEndpoint
	 */
	@Override
	public DDR3ValCResponse valC(DDR3ValCRequest request) throws VistaWebServiceFault {
		ArrayList<HashMap<String, String>> parameterMap = getParameterMap(request);
		return ddr3ResponseFactory.createDDR3ValCResponseFromString(
				getVistaLinkContext().makeRPCCall(new RPCIdentifier("DDR VALIDATOR"), parameterMap));
	}

	/**
	 * This method is used internally to construct the request parameters for
	 * the RPC.
	 * 
	 * @param request
	 * @return
	 */
	private ArrayList<HashMap<String, String>> getParameterMap(DDR3ValCRequest request) {

		// Setup the parameters to pass to the VistaLink RPC Broker
		ArrayList<HashMap<String, String>> parameterMap = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> hm = new HashMap<String, String>();

		hm.put("FILE", request.getFile());
		hm.put("FIELD", request.getField());
		hm.put("IENS", request.getIens());
		hm.put("VALUE", request.getValue());

		parameterMap.add(hm);

		return parameterMap;
	}
	
	/**
	 * @return the ddr3ResponseFactory
	 */
	public DDR3ResponseFactory getDdr3ResponseFactory() {
		return ddr3ResponseFactory;
	}

	/**
	 * @param ddr3ResponseFactory
	 *            the ddr3ResponseFactory to set
	 */
	public void setDdr3ResponseFactory(DDR3ResponseFactory ddr3ResponseFactory) {
		this.ddr3ResponseFactory = ddr3ResponseFactory;
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
