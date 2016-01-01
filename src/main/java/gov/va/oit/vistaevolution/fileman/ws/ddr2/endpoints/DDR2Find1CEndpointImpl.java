package gov.va.oit.vistaevolution.fileman.ws.ddr2.endpoints;

import gov.va.oit.vistaevolution.fileman.ws.ddr2.DDR2ResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.ddr2.endpoints.interfaces.DDR2Find1CEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.ddr2.model.DDR2Find1CRequest;
import gov.va.oit.vistaevolution.fileman.ws.ddr2.model.DDR2Find1CResponse;
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
@WebService(serviceName = "DDR2Find1CService", portName = "DDR2Find1CServicePort", endpointInterface = "gov.va.oit.vistaevolution.fileman.ws.ddr2.endpoints.interfaces.DDR2Find1CEndpoint")
public class DDR2Find1CEndpointImpl extends SpringBeanAutowiringSupport implements DDR2Find1CEndpoint {
	private static final Logger logger = Logger.getLogger(DDR2Find1CEndpointImpl.class);

	@Autowired
	private DDR2ResponseFactory ddr2ResponseFactory;

	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	/** raw response from RPC call */
	private String rawResponse;

	/**
	 * Default no arg constructor.
	 */
	public DDR2Find1CEndpointImpl() {
	}

	/**
	 * @param vistaLinkContext
	 * @param didResponseFactory
	 */
	public DDR2Find1CEndpointImpl(IVistaLinkContext vistaLinkContext, DDR2ResponseFactory ddr2ResponseFactory) {
		this.vistaLinkContext = vistaLinkContext;
		this.ddr2ResponseFactory = ddr2ResponseFactory;
	}

	/** {@inheritDoc}
	 */
	@Override
	public DDR2Find1CResponse find1C(DDR2Find1CRequest request) throws VistaWebServiceFault {

		DDR2Find1CResponse response = null;
		
		try {
			if (logger.isDebugEnabled()) {
				logger.debug(this);
				logger.debug("request=" + request);
			}
			
			ArrayList<HashMap<String, String>> parameterMap = getParameterMap(request);
			
			rawResponse = getVistaLinkContext().makeRPCCall(new RPCIdentifier("DDR FIND1"), parameterMap);
			
			response = ddr2ResponseFactory.createDDR2Find1CResponseFromString(rawResponse);
			
			return response;
		} catch (VistaWebServiceFault e) {
			logger.error(e);
			throw e;
		} catch (Exception e) {
			logger.error(e);
			throw new VistaWebServiceFault(e);
		}
	}

	/**
	 * This method is used internally to construct the request parameters for
	 * the RPC.
	 * 
	 * @param request
	 * @return
	 */
	private ArrayList<HashMap<String, String>> getParameterMap(DDR2Find1CRequest request) {

		// Setup the parameters to pass to the VistaLink RPC Broker
		ArrayList<HashMap<String, String>> parameterMap = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> hm = new HashMap<String, String>();

		// iens, xref, screen are optional values, so if null, set to empty string or RPC call will fail.
		hm.put("FILE", request.getFile());
		hm.put("IENS", request.getIens() != null ? request.getIens() : "");
		hm.put("VALUE", request.getValue());
		hm.put("XREF", request.getXref() != null ? request.getXref() : "");
		hm.put("SCREEN", request.getScreen() != null ? request.getScreen() : "");

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
	 * @return the ddr2ResponseFactory
	 */
	public DDR2ResponseFactory getDdr2ResponseFactory() {
		return ddr2ResponseFactory;
	}

	/**
	 * @param ddr2ResponseFactory
	 *            the ddr2ResponseFactory to set
	 */
	public void setDdr2ResponseFactory(DDR2ResponseFactory ddr2ResponseFactory) {
		this.ddr2ResponseFactory = ddr2ResponseFactory;
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

	/**
	 * returns the raw response from the RPC call
	 * @return raw string from successful RPC call
	 */
	public String getRawResponse() {
		return rawResponse;
	}

	@Override
	public String toString() {
		return "DDR2Find1CEndpointImpl [ddr2ResponseFactory="
				+ ddr2ResponseFactory + ", vistaLinkContext="
				+ vistaLinkContext + ", rawResponse=" + rawResponse + "]";
	}
	
}
