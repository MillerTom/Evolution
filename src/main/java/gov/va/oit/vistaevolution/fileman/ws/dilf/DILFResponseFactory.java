package gov.va.oit.vistaevolution.fileman.ws.dilf;

import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFCrefResponse;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFDaResponse;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFDtResponse;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFFDAResponse;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFHtmlResponse;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFValue1Response;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFValuesResponse;
import gov.va.oit.vistaevolution.util.AbstractResponseFactory;
import gov.va.oit.vistaevolution.util.VistaConstants;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@Component
public class DILFResponseFactory extends AbstractResponseFactory {

	private static final Logger LOGGER = Logger
			.getLogger(DILFResponseFactory.class);

	/**
	 * No Arguments Constructor
	 */
	public DILFResponseFactory() {
		super();
	}

	/**
	 * creating DILFHtmlResponse from String returned from RPC
	 * 
	 */
	public DILFHtmlResponse createDILFHtmlResponse(String rawResponse) {
		return new DILFHtmlResponse(rawResponse);


	} // end createDILFHtmlResponseFromParamterMap()

	/**
	 * creating DILFCrefResponse from String returned from RPC
	 * 
	 * @param rawResponse
	 * 
	 * @return DILFCrefResponse
	 * 
	 * @throws VistaWebServiceFault
	 */
	public DILFCrefResponse createDILFCrefResponseFromString(String rawResponse)
			throws VistaWebServiceFault {
		try {
			DILFCrefResponse response;
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("rawResponse=" + rawResponse);
			}
			if (rawResponse != null) {
				response = new DILFCrefResponse(rawResponse);
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
	 * creating DILFDaResponse from String returned from RPC
	 * 
	 * @param rawResponse
	 * 
	 * @return DILFDaResponse
	 * 
	 * @throws VistaWebServiceFault
	 */
	public DILFDaResponse createDILFDaResponseFromString(String rawResponse)
			throws VistaWebServiceFault {
		try {
			DILFDaResponse response;
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("rawResponse=" + rawResponse);
			}
			if (rawResponse != null) {
				List<String> rawLines = processDILFLines(rawResponse);
				ArrayList<String> da = new ArrayList<String>(0);
				for (String lineOfResponse : rawLines) {
					da.add(lineOfResponse);
				}
				response = new DILFDaResponse(da);

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
		} catch (ArrayIndexOutOfBoundsException e) {
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
	 * creating DILFDtResponse from String returned from RPC
	 * 
	 * @param rawResponse
	 * 
	 * @return DILFDtResponse
	 * 
	 * @throws VistaWebServiceFault
	 */
	public DILFDtResponse createDILFDtResponseFromString(String rawResponse)
			throws VistaWebServiceFault {
		try {
			DILFDtResponse response;
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("rawResponse=" + rawResponse);
			}
			if (rawResponse != null) {
				List<String> rawLines = processDILFLines(rawResponse);
				ArrayList<String> outputDataList = new ArrayList<String>(0);
				for (String lineOfResponse : rawLines) {
					outputDataList.add(lineOfResponse);
				}
				response = new DILFDtResponse(outputDataList);

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
		} catch (ArrayIndexOutOfBoundsException e) {
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
	 * 
	 * @param rawResponse
	 * @return
	 */
	public DILFValue1Response createDILFValue1ResponseFromString(
			String rawResponse) {
		// This RPC call only returns a string
		return new DILFValue1Response(rawResponse);
	}

	/*
	 * The output from the call is returned in the DDRDATA array. Its structure
	 * is:
	 * 
	 * DDRDATA Number of values found for the specified field. If no node exists
	 * in the FDA for the field, DDRDATA=0.
	 * 
	 * DDRDATA(seq#) Value for a particular instance of the field. Seq# is an
	 * integer starting with 1 that identifies the particular value.
	 * 
	 * DDRDATA(seq#,"IENS") The IENS of the entry or subentry with the value in
	 * DDRDATA(seq#).
	 */public DILFValuesResponse createDILFValuesResponseFromString(String rawResponse) {
		LOGGER.info("Returned Converted DDRDATA array : " + rawResponse);
		List<String> rawLines = processLines(rawResponse);
		List<String> dataArray = new ArrayList<String>();
		if (rawLines.size() != 0) {
			LOGGER.info("Adding OutPut Array Data ");
			for (String lineOfResponse : rawLines) {
				dataArray.add(lineOfResponse);
			}
		}
		return new DILFValuesResponse(dataArray);
	}

	/**
	 * @param makeRPCCall
	 * @return
	 */
	public DILFFDAResponse createDILFFDAResponse(String makeRPCCall) {
		return new DILFFDAResponse(makeRPCCall);
	}

	protected List<String> processDILFLines(String input) {
		String[] data = input.split("\n");
		ArrayList<String> lines = new ArrayList<String>();
		for (String entry : data) {
			lines.add(entry);
		}
		return lines;
	}
}
