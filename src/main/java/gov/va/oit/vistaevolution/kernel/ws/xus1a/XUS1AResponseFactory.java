/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xus1a;

import java.util.List;

import gov.va.oit.vistaevolution.kernel.ws.xus1a.model.XUS1AProhibitResponse;
import gov.va.oit.vistaevolution.util.AbstractResponseFactory;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author Christopher Schuck
 *
 */
@Component
public class XUS1AResponseFactory extends AbstractResponseFactory {
	
	private static final Logger LOGGER = Logger
			.getLogger(XUS1AResponseFactory.class);

	public XUS1AResponseFactory() {
		super();
	}
	
	public XUS1AProhibitResponse createProhibitFromString(String rawResponse) {
		LOGGER.debug("Returned Data : " + rawResponse);
		
		List<String> rawLines = processLines(rawResponse);
		String response = (!rawLines.isEmpty())?rawLines.get(0):"";

		return new XUS1AProhibitResponse(response);
	}

}
