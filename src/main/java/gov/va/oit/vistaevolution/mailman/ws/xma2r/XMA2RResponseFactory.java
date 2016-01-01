/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xma2r;

import gov.va.oit.vistaevolution.mailman.ws.xma2r.model.XMA2REntResponse;
import gov.va.oit.vistaevolution.mailman.ws.xma2r.model.XMA2REntaResponse;
import gov.va.oit.vistaevolution.mailman.ws.xma2r.util.XMA2RConstants;
import gov.va.oit.vistaevolution.util.AbstractResponseFactory;
import gov.va.oit.vistaevolution.util.StrUtils;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@Component
public class XMA2RResponseFactory extends AbstractResponseFactory {

	private static final Logger LOGGER = Logger
			.getLogger(XMA2RResponseFactory.class);

	/**
	 * creating XMA2REntResponse from String returned from RPC
	 * 
	 * @param rawResponse
	 * 
	 * @return XMA2REntResponse
	 * @throws VistaWebServiceFault
	 * 
	 */
	public XMA2REntResponse createXMA2REntResponseFromString(String rawResponse)
			throws VistaWebServiceFault {

		try {
			XMA2REntResponse response;
			String method = this.getClass()
					+ ".createXMA2REntResponseFromString";
			LOGGER.info(method
					+ ": Preparing XMA2REntResponse to be Returned, RPC RETURNS : "
					+ rawResponse);
			if (rawResponse != null) {
				if (rawResponse.contains("-1^")) {
					LOGGER.warn(XMA2RConstants.ERR_MSG_INPUT);
					String[] errorMessages = rawResponse.split("\\^");
					ArrayList<String> lines = new ArrayList<String>();
					for (String entry : errorMessages) {
						lines.add(entry);
					}
					response = new XMA2REntResponse(null, lines);
					LOGGER.warn(StrUtils.listToString(lines));
				} else {
					LOGGER.info(XMA2RConstants.DATA_FOUND);
					response = new XMA2REntResponse(rawResponse, null);
				}
			} else {
				LOGGER.error(XMA2RConstants.ERR_MSG_ABNORMAL);
				response = new XMA2REntResponse(null, null);
			}
			return response;
		} catch (Exception e) {
			VistaWebServiceFault fault = new VistaWebServiceFault(
					XMA2RConstants.ERR_MSG_ABNORMAL);
			LOGGER.error(fault);
			throw fault;
		}
	}

	/**
	 * creating XMA2REntaResponse from String returned from RPC
	 * 
	 * @param rawResponse
	 * 
	 * @return XMA2REntaResponse
	 * @throws VistaWebServiceFault
	 * 
	 */
	public XMA2REntaResponse createXMA2REntaResponseFromString(
			String rawResponse) throws VistaWebServiceFault {
		try {
			XMA2REntaResponse response;
			String method = this.getClass()
					+ ".createXMA2REntaResponseFromString";
			LOGGER.info(method
					+ ": Preparing XMA2REntaResponse to be Returned, RPC RETURNS : "
					+ rawResponse);
			if (rawResponse != null) {
				if (rawResponse.contains("-1^")) {
					LOGGER.warn(XMA2RConstants.ERR_MSG_INPUT);
					String[] errorMessages = rawResponse.split("\\^");
					ArrayList<String> lines = new ArrayList<String>();
					for (String entry : errorMessages) {
						lines.add(entry);
					}
					response = new XMA2REntaResponse(null, lines);
					LOGGER.warn("msgList var:" + StrUtils.listToString(lines));
				} else {
					LOGGER.info(XMA2RConstants.DATA_FOUND);
					response = new XMA2REntaResponse(rawResponse, null);
				}
			} else {
				LOGGER.error(XMA2RConstants.ERR_MSG_ABNORMAL);
				response = new XMA2REntaResponse(null, null);
			}
			return response;
		} catch (Exception e) {
			VistaWebServiceFault fault = new VistaWebServiceFault(
					XMA2RConstants.ERR_MSG_ABNORMAL);
			LOGGER.error(fault);
			throw fault;
		}
	}

}
