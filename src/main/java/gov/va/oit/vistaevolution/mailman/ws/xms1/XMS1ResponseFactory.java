/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xms1;

import gov.va.oit.vistaevolution.mailman.ws.xms1.model.XMS1SrvTimeResponse;
import gov.va.oit.vistaevolution.mailman.ws.xms1.model.XMS1StatusResponse;
import gov.va.oit.vistaevolution.util.AbstractResponseFactory;
import gov.va.oit.vistaevolution.util.VistaConstants;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author Leisa Martella
 * 
 */
@Component
public class XMS1ResponseFactory extends AbstractResponseFactory {

	private static final Logger LOGGER = Logger
			.getLogger(XMS1ResponseFactory.class);

	/**
	 * creating XMS1StatusResponse from RPC Returned String
	 * 
	 * @param rawResponse
	 * 
	 * @return XMS1StatusResponse
	 * 
	 * @throws VistaWebServiceFault
	 */
	public XMS1StatusResponse createXMS1StatusResponseFromString(
			String rawResponse) throws VistaWebServiceFault {
		try {
			XMS1StatusResponse response;
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("rawResponse=" + rawResponse);
			}
			if (rawResponse != null) {
				response = new XMS1StatusResponse(rawResponse);
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
	 * This method returns a structured XMS1SrvTimeResponse object based on the
	 * raw string response that is passed in.
	 * 
	 * @param rawResponse
	 * @return XMS1SrvTimeResponse
	 */
	public XMS1SrvTimeResponse createSrvTimeFromString(final String rawResponse) {

		LOGGER.debug("Returned Data : " + rawResponse);
		String[] lineSplit = rawResponse.split("\\^");

		if (lineSplit.length == 1)
			return new XMS1SrvTimeResponse(lineSplit[0].trim(), rawResponse);
		else
			return new XMS1SrvTimeResponse(lineSplit[0].trim(),
					lineSplit[1].trim(), rawResponse);
	}

}
