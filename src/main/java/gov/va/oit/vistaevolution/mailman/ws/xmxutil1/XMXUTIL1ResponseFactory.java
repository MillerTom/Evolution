package gov.va.oit.vistaevolution.mailman.ws.xmxutil1;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1ConvertResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1CtrlResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1DecodeUpResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1EncodeupResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1GMTDiffResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1MeldResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1MmdtResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1ScrubResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1StripResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1TimeDiffResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1TstampResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1ZonediffResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUtil1INDTResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUtil1MaxBlankResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.utils.XMXUTIL1Constants;
import gov.va.oit.vistaevolution.util.AbstractResponseFactory;
import gov.va.oit.vistaevolution.util.StrUtils;
import gov.va.oit.vistaevolution.util.VistaConstants;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * bill.blackmon <bill.blackmon@medsphere.com>
 * 
 */
@Component
public class XMXUTIL1ResponseFactory extends AbstractResponseFactory {

	// Encodeup variables
	final String CARET = "^";
	final String U = "~U~";

	final CharSequence csCARET = "^";
	final CharSequence csU = "~U~";

	final String TEST_1_OUTPUT = "String Containing ~U~ is converted";
	// end Encodeup variables

	// GMTDiff variables

	// end GMTDiff variables

	private static final Logger LOGGER = Logger
			.getLogger(XMXUTIL1ResponseFactory.class);

	// def constr()
	public XMXUTIL1ResponseFactory() {
	}

	/**
	 * 
	 * @param rawRpcResponse
	 * @return
	 */
	public XMXUtil1INDTResponse getINDTResponse(String rawRpcResponse) {
		XMXUtil1INDTResponse response;
		try {

			if (!rawRpcResponse.startsWith("-1^")) {
				response = new XMXUtil1INDTResponse(rawRpcResponse);

			} else {
				String[] responseArray = rawRpcResponse.split("\\^");
				response = new XMXUtil1INDTResponse(responseArray[0],
						Arrays.asList(responseArray[1]));
			}
			return response;
		} catch (ArrayIndexOutOfBoundsException e) {
			LOGGER.error(e);
			throw new VistaWebServiceFault(
					"There was abormality detected in the response from Vista: "
							+ rawRpcResponse, e);
		}

	}

	/**
	 * 
	 * @param rawResponse
	 * @param input
	 * @return
	 */
	public XMXUTIL1GMTDiffResponse createGMTDiffResponse(String rawResponse) {
		try {

			if (!rawResponse.startsWith("-1")) {
				String[] responseArray = rawResponse.split("\\^");
				XMXUTIL1GMTDiffResponse response;
				if (responseArray.length > 1) {
					response = new XMXUTIL1GMTDiffResponse(responseArray[1]);
				} else {
					response = new XMXUTIL1GMTDiffResponse(rawResponse);
				}
				LOGGER.debug(response);
				return response;
			} else {
				String result = rawResponse.split("\\^")[1];
				String status = rawResponse.split("\\^")[0];
				XMXUTIL1GMTDiffResponse response = new XMXUTIL1GMTDiffResponse( status, 
						Arrays.asList(result));
				LOGGER.error(response);
				return response;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			VistaWebServiceFault fault = new VistaWebServiceFault(
					"There an abnormality detected in the response from the source system.");
			LOGGER.error(fault);
			throw fault;
		}

	}

	/**
	 * 
	 * @param input
	 * @return response
	 */
	public XMXUTIL1EncodeupResponse createEncodeupResponse(String rawResponse) {
		try {

			if (!rawResponse.startsWith("-1")) {
				String[] responseArray = rawResponse.split("\\^");
				XMXUTIL1EncodeupResponse response;
				if (responseArray.length > 1) {
					response = new XMXUTIL1EncodeupResponse(responseArray[1]);
				} else {
					response = new XMXUTIL1EncodeupResponse(rawResponse);
				}
				LOGGER.debug(response);
				return response;
			} else {
				String result = rawResponse.split("\\^")[1];
				XMXUTIL1EncodeupResponse response = new XMXUTIL1EncodeupResponse(
						Arrays.asList(result));
				LOGGER.error(response);
				return response;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			VistaWebServiceFault fault = new VistaWebServiceFault(
					"There an abnormality detected in the response from the source system.");
			LOGGER.error(fault);
			throw fault;
		}

	} // end testCase1()

	public XMXUtil1MaxBlankResponse createMaxBlankResponse(String rawResponse) {
		try {

			if (!rawResponse.startsWith("-1")) {
				String[] responseArray = rawResponse.split("\\^");
				XMXUtil1MaxBlankResponse response;
				if (responseArray.length > 1) {
					response = new XMXUtil1MaxBlankResponse(responseArray[1]);
				} else {
					response = new XMXUtil1MaxBlankResponse(rawResponse);
				}
				LOGGER.debug(response);
				return response;
			} else {
				String status = rawResponse.split("\\^")[0];
				String result = rawResponse.split("\\^")[1];
				XMXUtil1MaxBlankResponse response = new XMXUtil1MaxBlankResponse( status,
						Arrays.asList(result));
				LOGGER.error(response);
				return response;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			VistaWebServiceFault fault = new VistaWebServiceFault(
					"There an abnormality detected in the response from the source system.");
			LOGGER.error(fault);
			throw fault;
		}

	}

	public XMXUTIL1DecodeUpResponse createDecodeUpResponseFromString(
			String rawResponse) {
		String method = this.getClass() + ".createDecodeUpResponseFromString";
		LOGGER.info(method
				+ ": Preparing XMXUTIL1DecodeUpResponse to be Returned!");
		XMXUTIL1DecodeUpResponse response = new XMXUTIL1DecodeUpResponse();

		if (StrUtils.hasAValue(rawResponse)) {
			List<String> rawLines = processLines(rawResponse);

			if (rawLines.size() != 0) {
				response.setDecodedValue(rawLines.get(0));
			} else {
				LOGGER.info(method + ": No Data Found!");
			}
		} else {
			LOGGER.info(method + ": No Data Found!");
		}
		System.out.println(response.toString());

		return response;

	}

	public XMXUTIL1CtrlResponse createCtrlResponseFromString(String rawResponse) {
		String method = this.getClass() + ".createCtrlResponseFromString";
		LOGGER.info(method + ": Preparing XMXUTIL1CtrlResponse to be Returned!");
		XMXUTIL1CtrlResponse response = new XMXUTIL1CtrlResponse();

		if (StrUtils.hasAValue(rawResponse)) {
			List<String> rawLines = processLines(rawResponse);

			if (rawLines.size() != 0) {
				response.setCleanedVal(rawLines.get(0));
			} else {
				LOGGER.info(method + ": No Data Found!");
			}
		} else {
			LOGGER.info(method + ": No Data Found!");
		}
		System.out.println(response.toString());

		return response;
	}

	/*
	 * public XMXUTIL1DecodeUpResponse createDecodeUpResponseFromString(String
	 * rawResponse) { String method = this.getClass() +
	 * ".createDecodeUpResponseFromString"; LOG.info(method +
	 * ": Preparing XMXUTIL1DecodeUpResponse to be Returned!");
	 * XMXUTIL1DecodeUpResponse response = new XMXUTIL1DecodeUpResponse();
	 * 
	 * 
	 * if (StrUtils.hasAValue(rawResponse)) { List<String> rawLines =
	 * processLines(rawResponse);
	 * 
	 * if (rawLines.size() != 0) { response.setDecodedValue(rawLines.get(0)); }
	 * else { LOG.info(method + ": No Data Found!"); } } else { LOG.info(method
	 * + ": No Data Found!"); } System.out.println(response.toString());
	 * 
	 * return response;
	 * 
	 * 
	 * }
	 * 
	 * public XMXUTIL1CtrlResponse createCtrlResponseFromString(String
	 * rawResponse) { String method = this.getClass() +
	 * ".createCtrlResponseFromString"; LOG.info(method +
	 * ": Preparing XMXUTIL1CtrlResponse to be Returned!"); XMXUTIL1CtrlResponse
	 * response = new XMXUTIL1CtrlResponse();
	 * 
	 * 
	 * if (StrUtils.hasAValue(rawResponse)) { List<String> rawLines =
	 * processLines(rawResponse);
	 * 
	 * if (rawLines.size() != 0) { if(rawLines.get(0).startsWith("test")) {
	 * String s = ""; s = rawLines.get(0).replaceAll("\\p{Cntrl}", "");
	 * response.setCleanedVal(s); }else {
	 * response.setCleanedVal(rawLines.get(0)); } } else { LOG.info(method +
	 * ": No Data Found!"); } } else { LOG.info(method + ": No Data Found!"); }
	 * System.out.println(response.toString());
	 * 
	 * return response; }
	 */

	public XMXUTIL1ConvertResponse createConvertResponseFromString(
			String rawResponse) {
		String method = this.getClass() + ".XMXUTIL1ConvertResponse";
		LOGGER.info(method
				+ ": Preparing XMXUTIL1ConvertResponse to be Returned!");
		XMXUTIL1ConvertResponse response = new XMXUTIL1ConvertResponse();

		if (StrUtils.hasAValue(rawResponse)) {
			List<String> rawLines = processLines(rawResponse);

			if (rawLines.size() != 0) {
				response.setFormattedDate(rawLines.get(0));
			} else {
				LOGGER.info(method + ": No Data Found!");
			}
		} else {
			LOGGER.info(method + ": No Data Found!");
		}
		System.out.println(response.toString());

		return response;
	}

	public XMXUTIL1MmdtResponse createXMXUTIL1MmdtResponseFromString(
			String rawResponse) {
		LOGGER.debug("Returned Data : " + rawResponse);
		return new XMXUTIL1MmdtResponse(rawResponse);
	}

	public XMXUTIL1MeldResponse createXMXUTIL1MeldResponseFromString(
			String rawResponse) {
		LOGGER.debug("Returned Data : " + rawResponse);
		return new XMXUTIL1MeldResponse(rawResponse);
	}

	/**
	 * This method returns a structured XMXUTIL1ScrubResponse object based on
	 * the raw string response that is passed in.
	 * 
	 * @param rawResponse
	 * @return XMXUTIL1ScrubResponse
	 */
	public XMXUTIL1ScrubResponse createScrubFromString(final String rawResponse) {
		LOGGER.debug("Returned Data : " + rawResponse);
		return new XMXUTIL1ScrubResponse(rawResponse);
	}

	/**
	 * creating XMXUTIL1TstampResponse from RPC response
	 * 
	 * @param rawResponse
	 * 
	 * @return XMXUTIL1TstampResponse
	 * 
	 * @throws VistaWebServiceFault
	 */
	public XMXUTIL1TstampResponse createTstampResponseFromString(
			String rawResponse) throws VistaWebServiceFault {
		try {
			XMXUTIL1TstampResponse response;
			String method = this.getClass() + ".createTstampResponseFromString";
			LOGGER.info(method
					+ ": Preparing XMXUTIL1TstampResponse to be Returned, RPC RETURNS : "
					+ rawResponse);
			if (rawResponse != null) {
				LOGGER.info(XMXUTIL1Constants.DATA_FOUND);
				response = new XMXUTIL1TstampResponse(rawResponse, null);
			} else {
				LOGGER.error(XMXUTIL1Constants.ERR_MSG_ABNORMAL);
				response = new XMXUTIL1TstampResponse(null, null);
			}
			return response;
		} catch (Exception e) {
			VistaWebServiceFault fault = new VistaWebServiceFault(
					XMXUTIL1Constants.ERR_MSG_ABNORMAL);
			LOGGER.error(fault);
			throw fault;
		}
	}

	public XMXUTIL1StripResponse createStripFromString(String rawResponse) {
		String method = this.getClass() + ".createStripFromString";
		LOGGER.info(method
				+ ": Preparing XMXUTIL1StripResponse to be Returned!");
		XMXUTIL1StripResponse response = new XMXUTIL1StripResponse();

		if (rawResponse != null && StrUtils.hasAValue(rawResponse)) {
			List<String> rawLines = processLines(rawResponse);

			if (rawLines.size() != 0) {
				response.setResponse(rawLines.get(0));
			} else {
				LOGGER.info(method + ": No String Returned!");
			}
		} else {
			LOGGER.info(method + ": No String Returned!");
		}

		return response;
	}

	/**
	 * creating XMXUTIL1ZonediffResponse from RPC response
	 * 
	 * @param rawResponse
	 * 
	 * @return XMXUTIL1ZonediffResponse
	 * 
	 * @throws VistaWebServiceFault
	 */
	public XMXUTIL1ZonediffResponse createXMXUTIL1ZonediffResponseFromString(
			String rawResponse) {
		try {
			XMXUTIL1ZonediffResponse response;
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("rawResponse=" + rawResponse);
			}
			if (rawResponse != null) {
				if (rawResponse.startsWith("-1^")) {
					String[] errorMessages = rawResponse.split("\\^");
					ArrayList<String> errors = new ArrayList<String>();
					for (String entry : errorMessages) {
						errors.add(entry);
					}
					response = new XMXUTIL1ZonediffResponse(null, errors);
				} else {
					List<String> rawLines = processXMXUTIL1Lines(rawResponse);
					ArrayList<String> hmList = new ArrayList<String>();
					for (String lineOfResponse : rawLines) {
						hmList.add(lineOfResponse);
					}
					response = new XMXUTIL1ZonediffResponse(hmList, null);
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
	 * This method returns a structured XMXUTIL1TimeDiffResponse object based on
	 * the raw string response that is passed in.
	 * 
	 * @param rawResponse
	 * @return XMXUTIL1TimeDiffResponse
	 */
	public XMXUTIL1TimeDiffResponse createTimeDiffFromString(String rawResponse) {

		if (LOGGER.isDebugEnabled())
			LOGGER.debug("Returned Data : " + rawResponse);

		return new XMXUTIL1TimeDiffResponse(rawResponse);
	}

	protected List<String> processXMXUTIL1Lines(String input) {
		String[] data = input.split("\n");
		ArrayList<String> lines = new ArrayList<String>();
		for (String entry : data) {
			lines.add(entry);
		}
		return lines;
	}

} // end class
