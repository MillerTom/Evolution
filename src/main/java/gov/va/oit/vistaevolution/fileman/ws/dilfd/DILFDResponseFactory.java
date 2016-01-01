/**
 *
 */
package gov.va.oit.vistaevolution.fileman.ws.dilfd;

import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDExternalResponse;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDFldnumResponse;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDRootResponse;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDVfieldResponse;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDVfileResponse;
import gov.va.oit.vistaevolution.util.AbstractResponseFactory;
import gov.va.oit.vistaevolution.util.VistaConstants;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * This factory processes response and creates a response objecs in the DILFD
 * packages.
 */
@Component
public class DILFDResponseFactory extends AbstractResponseFactory {

	private static final Logger LOGGER = Logger
			.getLogger(DILFDResponseFactory.class);

	/**
	 * No Arguments Constructor.
	 */
	public DILFDResponseFactory() {
		super();
	}

	/**
	 * creating DILFDExternalResponse from String returned from RPC
	 * 
	 * @param rawResponse
	 * 
	 * @returnDILFDExternalResponse
	 * 
	 * @throws VistaWebServiceFault
	 */
	public DILFDExternalResponse createDILFDExternalResponseFromString(
			final String rawResponse) throws VistaWebServiceFault {
		try {
			DILFDExternalResponse response;
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("rawResponse=" + rawResponse);
			}
			if (rawResponse != null) {
				List<String> rawLines = processDILFDLines(rawResponse);
				ArrayList<String> outputData = new ArrayList<String>();
				for (String lineOfResponse : rawLines) {
					outputData.add(lineOfResponse);
				}
				response = new DILFDExternalResponse(outputData);
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
	 * This method returns a structured DILFDFldnumResponse object based on the
	 * raw string response that is passed in.
	 * 
	 * @param response
	 * @return DILFDFldnumResponse
	 */
	public DILFDFldnumResponse createFldnumResponseFromString(
			final String response) {

		LOGGER.debug("Returned Data : " + response);
		List<String> rawLines = processLines(response);

		if (rawLines != null && rawLines.size() > 0) {
			return new DILFDFldnumResponse(rawLines.get(0));
		} else {
			return new DILFDFldnumResponse();
		}

	}

	/**
	 * This method returns a structured DILFDRootResponse object based on the
	 * raw string response that is passed in.
	 * 
	 * @param response
	 * @return DILFDRootResponse
	 */
	public DILFDRootResponse createRootResponseFromString(final String response) {

		LOGGER.debug("Returned Data : " + response);
		return new DILFDRootResponse(response);

	}

	/**
	 * This method returns a structured DILFDVfieldResponse object based on the
	 * raw string response that is passed in.
	 * 
	 * @param response
	 * @return DILFDVfieldResponse
	 */
	public DILFDVfieldResponse createVfieldResponseFromString(
			final String response) {

		LOGGER.debug("Returned Data : " + response);
		return new DILFDVfieldResponse(response);

	}

	/**
	 * This method returns a structured DILFDVfileResponse object based on the
	 * raw string response that is passed in.
	 * 
	 * @param response
	 * @return DILFDVfileResponse
	 */
	public DILFDVfileResponse createVfileResponseFromString(
			final String response) {

		LOGGER.debug("Returned Data : " + response);
		return new DILFDVfileResponse(response);

	}

	protected List<String> processDILFDLines(String input) {
		String[] data = input.split("\n");
		ArrayList<String> lines = new ArrayList<String>();
		for (String entry : data) {
			lines.add(entry);
		}
		return lines;
	}

}
