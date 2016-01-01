package gov.va.oit.vistaevolution.fileman.ws.dic;

import gov.va.oit.vistaevolution.fileman.ws.dic.model.DICFindResponse;
import gov.va.oit.vistaevolution.fileman.ws.dic.model.DICListResponse;
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
public class DICResponseFactory extends AbstractResponseFactory {

	private static final Logger LOGGER = Logger
			.getLogger(DICResponseFactory.class);

	/**
	 * creating DICFindResponse from String returned from RPC
	 * 
	 * @param rawResponse
	 * 
	 * @return DICFindResponse
	 * 
	 * @throws VistaWebServiceFault
	 * 
	 */
	public DICFindResponse createDICFindResponseFromString(String rawResponse)
			throws VistaWebServiceFault {
		try {
			DICFindResponse response;
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("rawResponse=" + rawResponse);
			}
			if (rawResponse != null && StrUtils.hasAValue(rawResponse)) {
				List<String> rawLines = processDICLines(rawResponse);
				ArrayList<String> outputDataList = new ArrayList<String>(0);
				for (String lineOfResponse : rawLines) {
					outputDataList.add(lineOfResponse);
				}
				response = new DICFindResponse(outputDataList);
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
	 * creating DICListResponse from String returned from RPC
	 * 
	 * @param rawResponse
	 * 
	 * @return DICListResponse
	 * 
	 * @throws VistaWebServiceFault
	 * 
	 */
	public DICListResponse createDICListResponseFromString(String rawResponse)
			throws VistaWebServiceFault {
		try {
			DICListResponse response;
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("rawResponse=" + rawResponse);
			}
			if (rawResponse != null && StrUtils.hasAValue(rawResponse)) {
				List<String> rawLines = processDICLines(rawResponse);
				ArrayList<String> outputDataList = new ArrayList<String>(0);
				for (String lineOfResponse : rawLines) {
					outputDataList.add(lineOfResponse);
				}
				response = new DICListResponse(outputDataList);
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

	protected List<String> processDICLines(String input) {
		String[] data = input.split("\n");
		ArrayList<String> lines = new ArrayList<String>();
		for (String entry : data) {
			lines.add(entry);
		}
		return lines;
	}

}
