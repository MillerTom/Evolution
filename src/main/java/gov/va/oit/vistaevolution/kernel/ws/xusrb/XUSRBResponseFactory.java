package gov.va.oit.vistaevolution.kernel.ws.xusrb;

import gov.va.oit.vistaevolution.kernel.ws.xusrb.model.XUSRBCheckAVResponse;
import gov.va.oit.vistaevolution.kernel.ws.xusrb.model.XUSRBSetupResponse;
import gov.va.oit.vistaevolution.kernel.ws.xusrb.model.XUSRBValidAVResponse;
import gov.va.oit.vistaevolution.util.AbstractResponseFactory;
import gov.va.oit.vistaevolution.util.VistaConstants;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * This factory processes response and creates a response objecs in the XUSERB
 * packages.
 * 
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@Component
public class XUSRBResponseFactory extends AbstractResponseFactory {

	private static final Logger LOGGER = Logger
			.getLogger(XUSRBResponseFactory.class);

	/**
	 * Default Bean Constructor
	 */
	public XUSRBResponseFactory() {
		super();
	}

	/**
	 * creating XUSRBValidAVResponse from String returned from RPC
	 * 
	 * @param rawResponse
	 * 
	 * @return XUSRBValidAVResponse
	 * 
	 */
	public XUSRBValidAVResponse createXUSRBValidAVResponseFromString(
			String rawResponse) {

		try {
			XUSRBValidAVResponse response;
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("rawResponse=" + rawResponse);
			}
			if (rawResponse != null) {
				List<String> rawLines = processXUSRBLines(rawResponse);
				ArrayList<String> outputDataList = new ArrayList<String>();
				for (String lineOfResponse : rawLines) {
					outputDataList.add(lineOfResponse);
				}
				response = new XUSRBValidAVResponse(outputDataList);
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
	 * creating XUSRBCheckAVResponse from String returned from RPC
	 * 
	 * @param rawResponse
	 * 
	 * @return XUSRBCheckAVResponse
	 * 
	 */
	public XUSRBCheckAVResponse createXUSRBCheckAVResponseFromString(
			String rawResponse) {

		LOGGER.debug("Preparing XUSRBCheckAVResponse to be Returned!");

		return new XUSRBCheckAVResponse(rawResponse);

	}

	/**
	 * This method returns a structured XUSRBSetupResponse object based on the
	 * string response that is passed in.
	 * 
	 * @param response
	 * @return XUSRBSetupResponse
	 */
	public XUSRBSetupResponse createSetupFromString(String response) {

		LOGGER.debug("Returned Data : " + response);

		List<String> rawLines = processLines(response);
		List<String> dataArray = new ArrayList<String>();

		for (String lineOfResponse : rawLines) {
			dataArray.add(lineOfResponse);
		}

		if (dataArray.size() > 0) {
			return new XUSRBSetupResponse(dataArray.get(0), dataArray.get(1),
					dataArray.get(2), dataArray.get(3), dataArray.get(4),
					dataArray.get(5), dataArray.get(6), dataArray.get(7),
					response);
		} else {
			return null;
		}
	}

	protected List<String> processXUSRBLines(String input) {
		String[] data = input.split("\n");
		ArrayList<String> lines = new ArrayList<String>();
		for (String entry : data) {
			lines.add(entry);
		}
		return lines;
	}
}
