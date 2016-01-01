/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints;

import gov.va.med.vistalink.rpc.RpcRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilf.DILFResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.DILFFDAEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.AbstractDILFFDARequest;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFFDADARequest;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFFDAIENSRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFFDAResponse;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@Component
@WebService(serviceName = "DILFFDAService", portName = "DILFFDAServicePort", endpointInterface = "gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.DILFFDAEndpoint")
public class DILFFDAEndpointImpl implements DILFFDAEndpoint {

	@Autowired
	private IVistaLinkContext vistaLinkContext;
	
	@Autowired
	private DILFResponseFactory responseFactory;

	/**
	 * @param vistaLinkContext
	 * @param dilfResponseFactory
	 */
	public DILFFDAEndpointImpl(IVistaLinkContext vistaLinkContext,
			DILFResponseFactory dilfResponseFactory) {
		super();
		this.vistaLinkContext = vistaLinkContext;
		this.responseFactory = dilfResponseFactory;
	}

	/**
	 * @param vistaLinkContext
	 * @param dilfResponseFactory
	 */
	public DILFFDAEndpointImpl() {
		this(null, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.
	 * DILFFDAEndpoint
	 * #FDA(gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFFDARequest)
	 */
	@Override
	public DILFFDAResponse FDA(AbstractDILFFDARequest request) throws VistaWebServiceFault {
		ArrayList<HashMap<String, Object>> parameterMap = getParameterMap(request);
		return responseFactory.createDILFFDAResponse(
				getVistaLinkContext().makeRPCCall(new RPCIdentifier("EVOLUTION", "DDR SOA FDA LOADER"), parameterMap));
	}

	/**
	 * This method is used internally to construct the request parameters for
	 * the RPC.
	 * 
	 * @param request
	 * @return
	 */
	private ArrayList<HashMap<String, Object>> getParameterMap(
			AbstractDILFFDARequest request) {

		HashMap<String, Object> valueMap = new HashMap<String, Object>();
		ArrayList<HashMap<String, Object>> valueParams = new ArrayList<HashMap<String, Object>>();

		valueMap.put("FILE", request.getFile());

		valueMap.put("FIELD", request.getField());

//		if (request.getFlags() != null) {
//			valueMap.put("FLAG", request.getFlags());
//		} else
//			valueMap.put("FLAG", "");

//		if (request.getValue() != null & request.getValue().size() != 0) {
//			valueMap.putAll(buildMapEntriesForMultipleSubscriptArray(
//					request.getValue(), "VALUE"));
//
//		} else
//			valueMap.put("VALUE", "");

		if (request instanceof DILFFDAIENSRequest) {

			DILFFDAIENSRequest typedRequest = (DILFFDAIENSRequest) request;
			valueMap.put("IENS", typedRequest.getIens());

		} else if (request instanceof DILFFDADARequest) {

			DILFFDADARequest typedRequest = (DILFFDADARequest) request;
			valueMap.putAll(buildMapEntriesForMultipleSubscriptArray(
					typedRequest.getDa(), "DA"));
		}

		valueParams.add(valueMap);
		return valueParams;
	}

	/**
	 * Creates a {@link Map} from {@link String} to {@link Object} by iterating over a {@link List}
	 * and using the parameter for array name in the form of:
	 *  key = "arrayName" & value = List.get(0) 
	 *  key = "arrayName",1 & value = list.get(1)
	 *  key = "arrayName",n & value = list.get(n)
	 * @param array
	 * @param arrayName
	 * @return
	 */
	private Map<String, Object> buildMapEntriesForMultipleSubscriptArray(
			List<String> array, String arrayName) {
		HashMap<String, Object> valueMap = new HashMap<String, Object>();
		for (int i = 0; i < array.size(); i++) {
			String keyString;
			if (i == 0) {
				keyString = "\"" + arrayName + "\"";
			} else {
				keyString = "\"" + arrayName + "\"" + Integer.toString(i);
			}
			valueMap.put(RpcRequest.buildMultipleMSubscriptKey(keyString),
					array.get(i));
		}
		return valueMap;
	}

	public IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	protected void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}

	public DILFResponseFactory getResponseFactory() {
		return responseFactory;
	}

	protected void setResponseFactory(DILFResponseFactory responseFactory) {
		this.responseFactory = responseFactory;
	}

}
