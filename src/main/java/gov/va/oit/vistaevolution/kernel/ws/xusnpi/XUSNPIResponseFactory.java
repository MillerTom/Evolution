/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusnpi;

import gov.va.oit.vistaevolution.kernel.ws.xusnpi.model.XUSNPIChkDgtResponse;
import gov.va.oit.vistaevolution.kernel.ws.xusnpi.model.XUSNPINpiResponse;
import gov.va.oit.vistaevolution.kernel.ws.xusnpi.model.XUSNPIQiResponse;
import gov.va.oit.vistaevolution.util.AbstractResponseFactory;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author Christopher Schuck
 *
 */
@Component
public class XUSNPIResponseFactory extends AbstractResponseFactory {

	private static final Logger LOGGER = Logger
			.getLogger(XUSNPIResponseFactory.class);
					
	public XUSNPIResponseFactory() {
		super();
	}

	public XUSNPINpiResponse createNpiFromString(String rawResponse) {
		LOGGER.debug("Returned Data : " + rawResponse);
		
		List<String> rawLines = processLines(rawResponse);
		String response = (rawLines != null && !rawLines.isEmpty())?rawLines.get(0):"";
		return new XUSNPINpiResponse(response);
	}

	public XUSNPIQiResponse createQiFromString(String rawResponse) {
		LOGGER.debug("Returned Data : " + rawResponse);
		
		List<String> rawLines = processLines(rawResponse);
		String response = (!rawLines.isEmpty())?rawLines.get(0):"";
		return new XUSNPIQiResponse(response);
	}

	/**
	 * 
	 * @param rawResponse
	 * @return
	 */
	public XUSNPIChkDgtResponse createXUSNPIChkDgtResponseFromString(String rawResponse) {
			return new XUSNPIChkDgtResponse(rawResponse);
	}
}
