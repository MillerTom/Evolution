package gov.va.oit.vistaevolution.fileman.ws.die.endpoints;

import gov.va.oit.vistaevolution.fileman.ws.die.DIEResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.die.endpoints.interfaces.DIEChkEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.die.model.DIEChkRequest;
import gov.va.oit.vistaevolution.fileman.ws.die.model.DIEChkResponse;
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
@WebService(serviceName = "DIEChkService", portName = "DIEChkServicePort", endpointInterface = "gov.va.oit.vistaevolution.fileman.ws.die.endpoints.interfaces.DIEChkEndpoint")
public class DIEChkEndpointImpl extends SpringBeanAutowiringSupport  implements DIEChkEndpoint {

	@Autowired
	private DIEResponseFactory dieResponseFactory;

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	/**'''''''''''''''''''''
	 * Default no arg constructor.
	 */
public DIEChkEndpointImpl() {
		super();
		this.setVistaLinkContext(vistaLinkContext);
		this.setDieResponseFactory(dieResponseFactory);
	}

	public DIEChkEndpointImpl(IVistaLinkContext vistaLinkContext,
			DIEResponseFactory dieResponseFactory) {
		super();
		this.vistaLinkContext = vistaLinkContext;
		this.dieResponseFactory = dieResponseFactory;
	}

	@Override
	public DIEChkResponse chk(DIEChkRequest request)
			throws VistaWebServiceFault {
		ArrayList<HashMap<String, String>> parameterMap = getParameterMap(request);
		return dieResponseFactory.createDIEChkResponseFromString(
				getVistaLinkContext().makeRPCCall(new RPCIdentifier("DDR SOA DATA CHECKER"), parameterMap));
	}

	private ArrayList<HashMap<String, String>> getParameterMap(DIEChkRequest request) {
		ArrayList<HashMap<String, String>> parameterMap = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> hm = new HashMap<String, String>();

		hm.put("FILE", request.getFile());
		hm.put("FIELD", request.getField());

		if (request.getFlags() != null && request.getFlags().size() != 0) {
			StringBuilder flags = new StringBuilder();
			for (String flag : request.getFlags()) {
				flags.append(flag);
			}
			hm.put("FLAGS", flags.toString());
		}
		hm.put("VALUE", request.getValue());
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
