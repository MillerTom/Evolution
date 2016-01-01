package gov.va.oit.vistaevolution.mailman.ws.xmxsec;

import gov.va.oit.vistaevolution.mailman.ws.xmxsec.model.XMXSECBcastResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.model.XMXSECClosedResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.model.XMXSECConfidResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.model.XMXSECInfoResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.model.XMXSECPriorityResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.util.XMXSECConstants;
import gov.va.oit.vistaevolution.util.AbstractResponseFactory;
import gov.va.oit.vistaevolution.util.StrUtils;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@Component
public class XMXSECResponseFactory extends AbstractResponseFactory {

	private static final Logger LOGGER = Logger
			.getLogger(XMXSECResponseFactory.class);

	/**
	 * Default Empty Constructor
	 */
	public XMXSECResponseFactory() {
		super();
	}

	public XMXSECBcastResponse createBcastResponseFromString(String rawResponse) {
		String method = this.getClass() + ".createBcastResponseFromString";
		LOGGER.info(method + ": Preparing XMXSECBcastResponse to be Returned!");
		XMXSECBcastResponse response = new XMXSECBcastResponse();

		if (rawResponse != null && StrUtils.hasAValue(rawResponse)) {
			List<String> rawLines = processLines(rawResponse);

			if (rawLines.size() != 0) {
				if(rawLines.get(0).startsWith("-1^")) { 
					response.getMsgRoot().add(rawLines.get(0));
				}else {
					response.setMsgWasBroadCast(rawLines.get(0));
				}
			} else {
				LOGGER.info(method + ": No Data Found!");
			}
		} else {
			LOGGER.info(method + ": No Data Found!");
		}
		System.out.println(response.toString());
		return response;
	}

	/**
	 * creating XMXSECClosedResponse from RPC response
	 * 
	 * @param rawResponse
	 * 
	 * @return XMXSECClosedResponse
	 * 
	 * @throws VistaWebServiceFault
	 */
	public XMXSECClosedResponse createClosedResponseFromString(
			String rawResponse) throws VistaWebServiceFault {
		try {
			XMXSECClosedResponse response = new XMXSECClosedResponse();
			String method = this.getClass() + ".createClosedResponseFromString";
			LOGGER.info(method
					+ ": Preparing XMXSECClosedResponse to be Returned, RPC RETURNS : "
					+ rawResponse);
			if (rawResponse != null) {
				if (rawResponse.contains("-1")) {
					LOGGER.warn(XMXSECConstants.ERR_MSG_INPUT);
					String[] errorMessages = rawResponse.split("\\^");
					ArrayList<String> lines = new ArrayList<String>();
					for (String entry : errorMessages) {
						lines.add(entry);
					}
					response = new XMXSECClosedResponse(null, lines);
				} else if (rawResponse.equalsIgnoreCase("0")) {
					LOGGER.info(XMXSECConstants.NOT_CLOSED_MSG);
					response = new XMXSECClosedResponse(rawResponse, null);
				} else if (rawResponse.equalsIgnoreCase("1")) {
					LOGGER.info(XMXSECConstants.CLOSED_MSG);
					response = new XMXSECClosedResponse(rawResponse, null);
				} else {
					LOGGER.info(XMXSECConstants.NO_DATA_FOUND);
					response = new XMXSECClosedResponse("", null);
				}
			} else {
				LOGGER.error(XMXSECConstants.ERR_MSG_ABNORMAL);
				response = new XMXSECClosedResponse(null, null);
			}
			return response;
		} catch (Exception e) {
			VistaWebServiceFault fault = new VistaWebServiceFault(
					XMXSECConstants.ERR_MSG_ABNORMAL);
			LOGGER.error(fault);
			throw fault;
		}
	}

	/**
	 * creating XMXSECConfidResponse from RPC response
	 * 
	 * @param rawResponse
	 * 
	 * @return XMXSECConfidResponse
	 * 
	 * @throws VistaWebServiceFault
	 */
	public XMXSECConfidResponse createConfidResponseFromString(
			String rawResponse) throws VistaWebServiceFault {
		try {
			XMXSECConfidResponse response = new XMXSECConfidResponse();
			String method = this.getClass() + ".createConfidResponseFromString";
			LOGGER.info(method
					+ ": Preparing XMXSECConfidResponse to be Returned, RPC RETURNS : "
					+ rawResponse);
			if (rawResponse != null) {
				if (rawResponse.contains("-1")) {
					LOGGER.warn(XMXSECConstants.ERR_MSG_INPUT);
					String[] errorMessages = rawResponse.split("\\^");
					ArrayList<String> lines = new ArrayList<String>();
					for (String entry : errorMessages) {
						lines.add(entry);
					}
					response = new XMXSECConfidResponse(null, lines);
				} else if (rawResponse.equalsIgnoreCase("0")) {
					LOGGER.info(XMXSECConstants.NOT_CONFID_MSG);
					response = new XMXSECConfidResponse(rawResponse, null);
				} else if (rawResponse.equalsIgnoreCase("1")) {
					LOGGER.info(XMXSECConstants.CONFID_MSG);
					response = new XMXSECConfidResponse(rawResponse, null);
				} else {
					LOGGER.info(XMXSECConstants.NO_DATA_FOUND);
					response = new XMXSECConfidResponse("", null);
				}
			} else {
				LOGGER.error(XMXSECConstants.ERR_MSG_ABNORMAL);
				response = new XMXSECConfidResponse(null, null);
			}
			return response;
		} catch (Exception e) {
			VistaWebServiceFault fault = new VistaWebServiceFault(
					XMXSECConstants.ERR_MSG_ABNORMAL);
			LOGGER.error(fault);
			throw fault;
		}
	}

	/**
	 * creating XMXSECInfoResponse from RPC response
	 * 
	 * @param rawResponse
	 * 
	 * @return XMXSECInfoResponse
	 * 
	 * @throws VistaWebServiceFault
	 */
	public XMXSECInfoResponse createInfoResponseFromString(String rawResponse)
			throws VistaWebServiceFault {
		try {
			XMXSECInfoResponse response = new XMXSECInfoResponse();
			String method = this.getClass() + ".createInfoResponseFromString";
			LOGGER.info(method
					+ ": Preparing XMXSECInfoResponse to be Returned, RPC RETURNS : "
					+ rawResponse);
			if (rawResponse != null) {
				if (rawResponse.startsWith("-1")) {
					LOGGER.warn(XMXSECConstants.ERR_MSG_INPUT);
					String[] errorMessages = rawResponse.split("\\^");
					ArrayList<String> lines = new ArrayList<String>();
					for (String entry : errorMessages) {
						lines.add(entry);
					}
					response = new XMXSECInfoResponse(null, lines);
				} else if (rawResponse.equalsIgnoreCase("0")) {
					LOGGER.info(XMXSECConstants.NOT_INFO_ONLY);
					response = new XMXSECInfoResponse(rawResponse, null);
				} else if (rawResponse.equalsIgnoreCase("1")) {
					LOGGER.info(XMXSECConstants.INFO_ONLY);
					response = new XMXSECInfoResponse(rawResponse, null);
				} else {
					LOGGER.info(XMXSECConstants.NO_DATA_FOUND);
					response = new XMXSECInfoResponse("", null);
				}
			} else {
				LOGGER.error(XMXSECConstants.ERR_MSG_ABNORMAL);
				response = new XMXSECInfoResponse(null, null);
			}
			return response;
		} catch (Exception e) {
			VistaWebServiceFault fault = new VistaWebServiceFault(
					XMXSECConstants.ERR_MSG_ABNORMAL);
			LOGGER.error(fault);
			throw fault;
		}
	}
	
	/**
	 * creating XMXSECPriorityResponse from RPC response
	 * 
	 * @param rawResponse
	 * 
	 * @return XMXSECPriorityResponse
	 * 
	 * @throws VistaWebServiceFault
	 */
	public XMXSECPriorityResponse createPriorityResponseFromString(
			String rawResponse) throws VistaWebServiceFault {
		try {
			XMXSECPriorityResponse response = new XMXSECPriorityResponse();
			String method = this.getClass()
					+ ".createPriorityResponseFromString";
			LOGGER.info(method
					+ ": Preparing XMXSECPriorityResponse to be Returned, RPC RETURNS : "
					+ rawResponse);
			if (rawResponse != null) {
				if (rawResponse.startsWith("-1")) {
					LOGGER.warn(XMXSECConstants.ERR_MSG_INPUT);
					String[] errorMessages = rawResponse.split("\\^");
					ArrayList<String> lines = new ArrayList<String>();
					for (String entry : errorMessages) {
						lines.add(entry);
					}
					response = new XMXSECPriorityResponse(null, lines);
				} else if (rawResponse.equalsIgnoreCase("0")) {
					LOGGER.info(XMXSECConstants.NOT_PRIORITY_MSG);
					response = new XMXSECPriorityResponse(rawResponse, null);
				} else if (rawResponse.equalsIgnoreCase("1")) {
					LOGGER.info(XMXSECConstants.PRIORITY_MSG);
					response = new XMXSECPriorityResponse(rawResponse, null);
				} else {
					LOGGER.info(XMXSECConstants.NO_DATA_FOUND);
					response = new XMXSECPriorityResponse("", null);
				}
			} else {
				LOGGER.error(XMXSECConstants.ERR_MSG_ABNORMAL);
				response = new XMXSECPriorityResponse(null, null);
			}
			return response;
		} catch (Exception e) {
			VistaWebServiceFault fault = new VistaWebServiceFault(
					XMXSECConstants.ERR_MSG_ABNORMAL);
			LOGGER.error(fault);
			throw fault;
		}
	}

}
