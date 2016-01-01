package gov.va.oit.vistaevolution.kernel.ws.xuaf4;

import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4BNSTAResponse;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4BnienResponse;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4ChildrenResponse;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4F4Response;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4IenResponse;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4LKUPResponse;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4MADDResponse;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4NNTResponse;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4NameResponse;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4PADDResponse;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4PRNTResponse;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4ParentRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4ParentResponse;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4STAResponse;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4TFResponse;
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

@Component
public class XUAF4ResponseFactory extends AbstractResponseFactory {

	private static final Logger LOGGER = Logger
			.getLogger(XUAF4ResponseFactory.class);

	/**
	 * No Arguments Constructor.
	 */
	public XUAF4ResponseFactory() {
		super();
	}

	/**
	 * 
	 * @param rawResponse
	 * @return
	 */
	public XUAF4PRNTResponse createPRNTResponseFromString(String rawResponse) {
		try {

			if (!rawResponse.startsWith("0^")) {
				String[] responseArray = rawResponse.split("\\^");
				XUAF4PRNTResponse response;
				if (responseArray.length > 1) {
					response = new XUAF4PRNTResponse(responseArray[1]);
				} else {
					response = new XUAF4PRNTResponse(rawResponse);
				}
				LOGGER.debug(response);
				return response;
			} else {
				String status = rawResponse.split("\\^")[0];
				String result = rawResponse.split("\\^")[1];
				XUAF4PRNTResponse response = new XUAF4PRNTResponse(status,
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
	 * creating XUAF4F4Response from RPC response
	 * 
	 * @param rawResponse
	 * 
	 * @return XUAF4F4Response
	 * 
	 * @throws VistaWebServiceFault
	 */
	public XUAF4F4Response createF4ResponseFromString(String rawResponse)
			throws VistaWebServiceFault {
		try {
			XUAF4F4Response response;
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("rawResponse=" + rawResponse);
			}
			if (rawResponse != null) {
				List<String> rawLines = processXUAF4Lines(rawResponse);
				ArrayList<String> outputDataList = new ArrayList<String>();
				for (String lineOfResponse : rawLines) {
					outputDataList.add(lineOfResponse);
				}
				response = new XUAF4F4Response(outputDataList);
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

	private ArrayList<String> createDataArray(List<String> rawLines) {
		ArrayList<String> dataArray = new ArrayList<String>();
		for (String lineOfResponse : rawLines) {
			LOGGER.info("Preparing Output Array of (Data or Errors)");
			dataArray.add(lineOfResponse);
		}
		return dataArray;
	}

	/**
	 * @param makeRPCCall
	 * @return
	 * @throws VistaWebServiceFault
	 */
	public XUAF4NNTResponse createNNTXUAF4Response(String rawResponse)
			throws VistaWebServiceFault {

		String[] responseArray = rawResponse.split("\\^");

		if (rawResponse.startsWith("^")) {
			XUAF4NNTResponse response = new XUAF4NNTResponse("", "", "");
			return response;
		} else if (rawResponse.startsWith("^")
				|| StrUtils.hasNoValue(rawResponse)) {
			XUAF4NNTResponse response = new XUAF4NNTResponse();
			return response;
		} else if (responseArray.length < 3) {
			VistaWebServiceFault error = new VistaWebServiceFault(
					"The reponse format from the source system was not recognized: "
							+ rawResponse);
			LOGGER.error(error);
			throw error;
		} else {
			LOGGER.debug(responseArray[0]);
			return new XUAF4NNTResponse(responseArray[0], responseArray[1],
					responseArray[2]);
		}
	}

	/**
	 * @param makeRPCCall
	 * @return
	 * @throws VistaWebServiceFault
	 */
	public XUAF4PADDResponse createPADDXUAF4Response(String rawResponse)
			throws VistaWebServiceFault {
		String[] responseArray = rawResponse.split("\\^");
		XUAF4PADDResponse response = new XUAF4PADDResponse();

		// Check for Street Address
		if (responseArray.length > 0 && !StrUtils.hasNoValue(responseArray[0]))
			response.setStreetAddress(responseArray[0]);
		else
			response.setStreetAddress("");

		// Check for City
		if (responseArray.length > 1 && !StrUtils.hasNoValue(responseArray[1]))
			response.setCity(responseArray[1]);
		else
			response.setCity("");

		// Check for State
		if (responseArray.length > 2 && !StrUtils.hasNoValue(responseArray[2]))
			response.setState(responseArray[2]);
		else
			response.setState("");

		// Check for Zip Code
		if (responseArray.length > 3 && !StrUtils.hasNoValue(responseArray[3]))
			response.setZipCode(responseArray[3]);
		else
			response.setZipCode("");

		return response;

	}

	/**
	 * @param rawResponse
	 * @return
	 */
	public XUAF4NameResponse createNameXUAF4Response(String rawResponse) {

		return new XUAF4NameResponse(rawResponse);

	}

	/**
	 * creating XUAF4ChildrenResponse from String returned from RPC
	 * 
	 * @param rawResponse
	 * 
	 * @return XUAF4ChildrenResponse
	 * 
	 * @throws VistaWebServiceFault
	 * 
	 */
	public XUAF4ChildrenResponse createXUAF4ChildrenResponseFromString(
			String rawResponse) throws VistaWebServiceFault {
		try {
			XUAF4ChildrenResponse response;
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("rawResponse=" + rawResponse);
			}
			if (rawResponse != null) {
				List<String> rawLines = processXUAF4Lines(rawResponse);
				ArrayList<String> outputDataList = new ArrayList<String>();
				for (String lineOfResponse : rawLines) {
					outputDataList.add(lineOfResponse);
				}
				response = new XUAF4ChildrenResponse(outputDataList);
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
	 * creating XUAF4BNSTAResponse from String returned from RPC
	 * 
	 * @param rawResponse
	 * 
	 * @return XUAF4BNSTAResponse
	 * 
	 * @throws VistaWebServiceFault
	 */
	public XUAF4BNSTAResponse createBNSTAResponseFromString(String rawResponse)
			throws VistaWebServiceFault {
		try {
			XUAF4BNSTAResponse response;
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("rawResponse=" + rawResponse);
			}
			if (rawResponse != null) {
				response = new XUAF4BNSTAResponse(rawResponse);
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

	public XUAF4LKUPResponse createLKUPResponseFromString(String rawResponse)
			throws VistaWebServiceFault {
		try {
			XUAF4LKUPResponse response;
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("rawResponse=" + rawResponse);
			}
			if (rawResponse != null) {
				response = new XUAF4LKUPResponse(rawResponse);
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

	public XUAF4MADDResponse createMADDResponseFromString(String rawResponse)
			throws VistaWebServiceFault {
		try {
			XUAF4MADDResponse response;
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("rawResponse=" + rawResponse);
			}
			if (rawResponse != null) {
				response = new XUAF4MADDResponse(rawResponse);
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
	 * creating XUAF4BnienResponse from String returned from RPC
	 * 
	 * @param rawResponse
	 * 
	 * @return XUAF4BnienResponse
	 * 
	 * @throws VistaWebServiceFault
	 * 
	 */
	public XUAF4BnienResponse createXUAF4BnienResponseFromString(
			String rawResponse) throws VistaWebServiceFault {
		try {
			XUAF4BnienResponse response;
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("rawResponse=" + rawResponse);
			}
			if (rawResponse != null) {
				response = new XUAF4BnienResponse(rawResponse);
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
	 * @param makeRPCCall
	 * @return
	 */
	public XUAF4ParentResponse createParentXUAF4Response(String makeRPCCall,
			XUAF4ParentRequest request) {
		String[] list = makeRPCCall.split("\\^");
		return new XUAF4ParentResponse(request.getASSO(), list[0]);
	}

	/**
	 * creating XUAF4IenResponse from String returned from RPC
	 * 
	 * @param rawResponse
	 * 
	 * @return XUAF4IenResponse
	 * 
	 * @throws VistaWebServiceFault
	 * 
	 */
	public XUAF4IenResponse createXUAF4IenResponseFromString(String rawResponse)
			throws VistaWebServiceFault {
		try {
			XUAF4IenResponse response;
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("rawResponse=" + rawResponse);
			}
			if (rawResponse != null) {
				response = new XUAF4IenResponse(rawResponse);
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
	 * @param response
	 * @return
	 */
	public XUAF4TFResponse createTFXUAF4Response(String response) {
		return new XUAF4TFResponse(response);
	}

	public XUAF4STAResponse createStaResponse(String response) {
		return new XUAF4STAResponse(response);
	}

	protected List<String> processXUAF4Lines(String input) {
		String[] data = input.split("\n");
		ArrayList<String> lines = new ArrayList<String>();
		for (String entry : data) {
			lines.add(entry);
		}
		return lines;
	}

}
