package gov.va.oit.vistaevolution.mailman.ws.xmxsec1;

import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1CopyAmtResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1CopyLimsResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1CopyRecpResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1OptgrpResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1PakmanResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1SsPrivResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1ZssPrivResponse;
import gov.va.oit.vistaevolution.util.AbstractResponseFactory;
import gov.va.oit.vistaevolution.util.StrUtils;
import gov.va.oit.vistaevolution.util.VistaConstants;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class XMXSEC1ResponseFactory extends AbstractResponseFactory {

	private static final Logger LOGGER = Logger
			.getLogger(XMXSEC1ResponseFactory.class);

	public XMXSEC1ResponseFactory() {
		super();
	}

	public XMXSEC1CopyAmtResponse createCopyAmtResponseFromString(
			String rawResponse) {
		String method = this.getClass() + ".createCopyAmtResponseFromString";
		LOGGER.info(method
				+ ": Preparing XMXSEC1CopyAmtResponse to be Returned!");
		XMXSEC1CopyAmtResponse response = new XMXSEC1CopyAmtResponse();

		if (rawResponse != null && StrUtils.hasAValue(rawResponse)) {
			List<String> rawLines = processLines(rawResponse);

			if (rawLines.size() != 0) {
				if (rawLines.get(0).startsWith("-1")) {
					response.getMsgRoot().add(0, rawLines.get(0));
				} else {
					response.setCopyAmountOK(rawLines.get(0));
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

	public XMXSEC1CopyLimsResponse createCopyLimsResponseFromString(
			String rawResponse) {
		String method = this.getClass() + ".createCopyLimsResponseFromString";
		LOGGER.info(method
				+ ": Preparing XMXSEC1CopyLimsResponse to be Returned!");
		XMXSEC1CopyLimsResponse response = new XMXSEC1CopyLimsResponse();

		if (rawResponse != null && StrUtils.hasAValue(rawResponse)) {
			List<String> rawLines = processLines(rawResponse);

			if (rawLines.size() != 0) {
				String[] lineParts = rawLines.get(0).split("\\^");
				if (lineParts.length == 3) {
					response.setNumRecipeints(lineParts[0]);
					response.setNumResponses(lineParts[1]);
					response.setNumLines(lineParts[2]);
				} else {
					// ?? what to do ??
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

	public XMXSEC1CopyRecpResponse createCopyRecpResponseFromString(
			String rawResponse) {
		String method = this.getClass() + ".createCopyRecpResponseFromString";
		LOGGER.info(method
				+ ": Preparing XMXSEC1CopyRecpResponse to be Returned!");
		XMXSEC1CopyRecpResponse response = new XMXSEC1CopyRecpResponse();

		if (rawResponse != null && StrUtils.hasAValue(rawResponse)) {
			List<String> rawLines = processLines(rawResponse);

			if (rawLines.size() != 0) {
				if (rawLines.get(0).startsWith("-1")) {
					response.getMsgRoot().add(0, rawLines.get(0));
				} else {
					response.setMsgOK(rawLines.get(0));
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

	public XMXSEC1SsPrivResponse createSsPrivFromString(String rawResponse) {
		String method = this.getClass() + ".createSsPrivFromString";
		LOGGER.info(method
				+ ": Preparing XMXSEC1SsPrivResponse to be Returned!");
		XMXSEC1SsPrivResponse response = new XMXSEC1SsPrivResponse();

		if (rawResponse != null && StrUtils.hasAValue(rawResponse)) {
			List<String> rawLines = processLines(rawResponse);

			if (rawLines.size() != 0) {
				response.setFlag(rawLines.get(0));
			} else {
				LOGGER.error(method + ": No Data Found!");
			}
		} else {
			LOGGER.error(method + ": No Data Found!");
		}
		return response;
	}

	/**
	 * creating XMXSEC1OptgrpResponse from RPC response
	 * 
	 * @param rawResponse
	 * 
	 * @return XMXSEC1OptgrpResponse
	 * 
	 * @throws VistaWebServiceFault
	 */
	public XMXSEC1OptgrpResponse createXMXSEC1OptgrpResponseFromString(
			String rawResponse) {
		try {
			XMXSEC1OptgrpResponse response;
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("rawResponse=" + rawResponse);
			}
			if (rawResponse != null && StrUtils.hasAValue(rawResponse)) {
				if (rawResponse.startsWith("-1^")) {
					String[] errorMessages = rawResponse.split("\\^");
					ArrayList<String> errors = new ArrayList<String>();
					for (String entry : errorMessages) {
						errors.add(entry);
					}
					response = new XMXSEC1OptgrpResponse(null, errors);
				} else {
					List<String> rawLines = processXMXSEC1Lines(rawResponse);
					ArrayList<String> optionsDataList = new ArrayList<String>();
					for (String lineOfResponse : rawLines) {
						optionsDataList.add(lineOfResponse);
					}
					response = new XMXSEC1OptgrpResponse(optionsDataList, null);
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

	protected List<String> processXMXSEC1Lines(String input) {
		String[] data = input.split("\n");
		ArrayList<String> lines = new ArrayList<String>();
		for (String entry : data) {
			lines.add(entry);
		}
		return lines;
	}

	public XMXSEC1PakmanResponse createXMXSEC1PakmanResponseFromString(
			String rawResponse) {
		LOGGER.debug("Returned Data : " + rawResponse);
		return new XMXSEC1PakmanResponse(rawResponse);
	}

	public XMXSEC1ZssPrivResponse createZssPrivResponseFromString(String rawResponse) { 
			String method = this.getClass() + ".createZssPrivResponseFromString: ";
			LOGGER.info(method+ "Preparing XMXSEC1ZssPrivResponse to be Returned!");
			XMXSEC1ZssPrivResponse response = new XMXSEC1ZssPrivResponse();

			if (rawResponse != null && StrUtils.hasAValue(rawResponse)) {
				List<String> rawLines = processLines(rawResponse);

				if (rawLines.size() != 0) {
					if (rawLines.get(0).startsWith("-1")) {
						response.getErrors().add(0, rawLines.get(0));
					} else {
						response.setUserCanDoSuperSearch(rawLines.get(0));
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

}
