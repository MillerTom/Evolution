/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints;

import gov.va.med.vistalink.rpc.RpcRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilf.DILFResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.DILFValuesEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFValuesRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFValuesResponse;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.Fda;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.HashMap;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
/**
 * This class provides an implementation to the Ent1XMD service.
 * 
 * @see gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.DILFValuesEndpoint
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com> (Refactored by Leisa Martella)
 * 
 */
@Component
@WebService(serviceName = "DILFValuesService", portName = "DILFValuesServicePort", endpointInterface = "gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.DILFValuesEndpoint")
public class DILFValuesEndpointImpl extends SpringBeanAutowiringSupport implements DILFValuesEndpoint {

	@Autowired
	private DILFResponseFactory dilfResponseFactory;

	@Autowired
	private IVistaLinkContext vistaLinkContext;

	/**
	 * Default no arg constructor.
	 */
	public DILFValuesEndpointImpl() {
		super();
		this.setVistaLinkContext(vistaLinkContext);
		this.setDilfResponseFactory(dilfResponseFactory);
	}
	/**
	 * @param vistaLinkContext
	 * @param didResponseFactory
	 */
	public DILFValuesEndpointImpl(IVistaLinkContext vistaLinkContext,
			DILFResponseFactory dilfResponseFactory) {
		super();
		this.vistaLinkContext = vistaLinkContext;
		this.dilfResponseFactory = dilfResponseFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.DILFValuesEndpoint
	 */
	@Override
	public DILFValuesResponse values(DILFValuesRequest request) throws VistaWebServiceFault {
		ArrayList<HashMap<String, Object>> parameterMap = getParameterMap(request);
		return dilfResponseFactory.createDILFValuesResponseFromString(
				getVistaLinkContext().makeRPCCall(new RPCIdentifier("DDR SOA FDA VALUE RETRIEVER"), parameterMap));
	}

	/**
	 * This method is used internally to construct the request parameters for
	 * the RPC.
	 * 
	 * @param request
	 * @return
	 */
	private ArrayList<HashMap<String, Object>> getParameterMap(DILFValuesRequest request) {

		HashMap<String, Object> valueMap = new HashMap<String, Object>();
		ArrayList<HashMap<String, Object>> valueParams = new ArrayList<HashMap<String, Object>>();

		// Add FILE and FIELD to parameter array if they are not null, otherwise
		// add blank string
		if (request.getFile() != null)
			valueMap.put("FILE", request.getFile());
		else
			valueMap.put("FILE", "");
		if (request.getField() != null)
			valueMap.put("FIELD",request.getField());
		else
			valueMap.put("FIELD","");
		

		// put each entry key and value from the FDA list to a map, then
		// add in parameter map.
		if (request.getFdas() != null && request.getFdas().size() != 0){
//			HashMap<String, String>fdaList = new HashMap<String, String>();
			for (Fda fda : request.getFdas()) {
				String fdaKeyString = "\"FDA\"," + fda.getFile() + ",\"" + fda.getPosition() + "\"," + fda.getField(); 
				String fdaValueString = fda.getValue(); 
//				fdaList.put(RpcRequest.buildMultipleMSubscriptKey(fdaKeyString), fdaValueString);
				valueMap.put(RpcRequest.buildMultipleMSubscriptKey(fdaKeyString), fdaValueString);
			}
			//valueMap.put("FDA", fdaList);
		}
		
		valueParams.add(valueMap);
		return valueParams;
	}
	
	/**
	 * @return the dilfResponseFactory
	 */
	public DILFResponseFactory getDilfResponseFactory() {
		return dilfResponseFactory;
	}

	/**
	 * @param dilfResponseFactory
	 *            the dilfResponseFactory to set
	 */
	public void setDilfResponseFactory(DILFResponseFactory dilfResponseFactory) {
		this.dilfResponseFactory = dilfResponseFactory;
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
