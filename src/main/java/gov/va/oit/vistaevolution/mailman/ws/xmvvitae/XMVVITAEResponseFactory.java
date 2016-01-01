/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmvvitae;

import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.model.XMVVITAEInitResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.model.XMVVITAEOtherResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmvvitae.model.XMVVITAESelfResponse;
import gov.va.oit.vistaevolution.util.AbstractResponseFactory;
import gov.va.oit.vistaevolution.util.StrUtils;
import gov.va.oit.vistaevolution.util.VistaConstants;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@Component
public class XMVVITAEResponseFactory extends AbstractResponseFactory {

	private static final Logger LOGGER = Logger
			.getLogger(XMVVITAEResponseFactory.class);

	/**
	 * No Arguments Constructor.
	 */
	public XMVVITAEResponseFactory() {
		super();
	}

	/**
	 * creating XMVVITAEInitResponse from RPC response
	 * 
	 * @param rawResponse
	 * 
	 * @return XMVVITAEInitResponse
	 * 
	 * @throws VistaWebServiceFault
	 */
	public XMVVITAEInitResponse createXMVVITAEInitResponseFromString(
			String rawResponse) throws VistaWebServiceFault {
		try {
			XMVVITAEInitResponse response;
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("rawResponse=" + rawResponse);
			}
			if (rawResponse != null && StrUtils.hasAValue(rawResponse)) {
				if (rawResponse.startsWith("ERROR,")) {
					String[] errorMessages = rawResponse.split("\\^");
					ArrayList<String> errors = new ArrayList<String>();
					for (String entry : errorMessages) {
						errors.add(entry);
					}
					response = new XMVVITAEInitResponse(null, errors);
				} else {
					List<String> rawLines = processXMVVITAELines(rawResponse);
					ArrayList<String> outputDataList = new ArrayList<String>();
					for (String lineOfResponse : rawLines) {
						outputDataList.add(lineOfResponse);
					}
					response = new XMVVITAEInitResponse(outputDataList, null);
				}
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("response=" + response);
				}
				return response;
			} else {
				VistaWebServiceFault fault = new VistaWebServiceFault(
						VistaConstants.ERR_MSG_ABNORMAL
								+ " : [ RPC returned NULL rawResponse ]");
				if (LOGGER.isEnabledFor(Level.ERROR)) {
					LOGGER.error(fault);
				}
				throw fault;
			}
		} catch (Exception e) {
			VistaWebServiceFault fault = new VistaWebServiceFault(
					VistaConstants.ERR_MSG_ABNORMAL + " : [ " + e.getMessage()
							+ " ]");
			if (LOGGER.isEnabledFor(Level.ERROR)) {
				LOGGER.error(fault);
			}
			throw fault;
		}
	}

	/**
	 * creating XMVVITAEOtherResponse from RPC response
	 * 
	 * @param rawResponse
	 * 
	 * @return XMVVITAEOtherResponse
	 * 
	 * @throws VistaWebServiceFault
	 */
	public XMVVITAEOtherResponse createXMVVITAEOtherResponseFromString(
			String rawResponse) throws VistaWebServiceFault {
		try {
			XMVVITAEOtherResponse response;
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("rawResponse=" + rawResponse);
			}
			if (rawResponse != null && StrUtils.hasAValue(rawResponse)) {
				if (rawResponse.startsWith("ERROR,")) {
					String[] errorMessages = rawResponse.split("\\^");
					ArrayList<String> errors = new ArrayList<String>();
					for (String entry : errorMessages) {
						errors.add(entry);
					}
					response = new XMVVITAEOtherResponse(null, errors);
				} else {
					List<String> rawLines = processXMVVITAELines(rawResponse);
					ArrayList<String> outputDataList = new ArrayList<String>();
					for (String lineOfResponse : rawLines) {
						outputDataList.add(lineOfResponse);
					}
					response = new XMVVITAEOtherResponse(outputDataList, null);
				}

				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("response=" + response);
				}
				return response;
			} else {
				VistaWebServiceFault fault = new VistaWebServiceFault(
						VistaConstants.ERR_MSG_ABNORMAL
								+ " : [ RPC returned NULL rawResponse ]");
				if (LOGGER.isEnabledFor(Level.ERROR)) {
					LOGGER.error(fault);
				}
				throw fault;
			}
		} catch (Exception e) {
			VistaWebServiceFault fault = new VistaWebServiceFault(
					VistaConstants.ERR_MSG_ABNORMAL + " : [ " + e.getMessage()
							+ " ]");
			if (LOGGER.isEnabledFor(Level.ERROR)) {
				LOGGER.error(fault);
			}
			throw fault;
		}
	}

	/**
	 * creating XMVVITAESelfResponse from RPC response
	 * 
	 * @param rawResponse
	 * 
	 * @return XMVVITAESelfResponse
	 * 
	 * @throws VistaWebServiceFault
	 */
	public XMVVITAESelfResponse createXMVVITAESelfResponseFromString(
			String rawResponse) throws VistaWebServiceFault {
		try {
			XMVVITAESelfResponse response;
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("rawResponse=" + rawResponse);
			}
			if (rawResponse != null && StrUtils.hasAValue(rawResponse)) {
				List<String> rawLines = processXMVVITAELines(rawResponse);
				ArrayList<String> outputDataList = new ArrayList<String>();
				for (String lineOfResponse : rawLines) {
					outputDataList.add(lineOfResponse);
				}
				response = new XMVVITAESelfResponse(outputDataList);
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("response=" + response);
				}
				return response;
			} else {
				VistaWebServiceFault fault = new VistaWebServiceFault(
						VistaConstants.ERR_MSG_ABNORMAL
								+ " : [ RPC returned NULL rawResponse ]");
				if (LOGGER.isEnabledFor(Level.ERROR)) {
					LOGGER.error(fault);
				}
				throw fault;
			}
		} catch (Exception e) {
			VistaWebServiceFault fault = new VistaWebServiceFault(
					VistaConstants.ERR_MSG_ABNORMAL + " : [ " + e.getMessage()
							+ " ]");
			if (LOGGER.isEnabledFor(Level.ERROR)) {
				LOGGER.error(fault);
			}
			throw fault;
		}
	}

	protected List<String> processXMVVITAELines(String input) {
		String[] data = input.split("\n");
		ArrayList<String> lines = new ArrayList<String>();
		for (String entry : data) {
			lines.add(entry);
		}
		return lines;
	}
}
