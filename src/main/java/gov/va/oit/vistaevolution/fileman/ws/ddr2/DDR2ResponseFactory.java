package gov.va.oit.vistaevolution.fileman.ws.ddr2;

import gov.va.oit.vistaevolution.fileman.ws.ddr2.model.DDR2Find1CResponse;
import gov.va.oit.vistaevolution.util.AbstractResponseFactory;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author Leisa Martella
 * 
 */
@Component
public class DDR2ResponseFactory extends AbstractResponseFactory {
	private static final Logger logger = Logger.getLogger(DDR2ResponseFactory.class);

	public DDR2Find1CResponse createDDR2Find1CResponseFromString(String rawResponse) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("rawResponse=" + rawResponse);
		}
		
		List<String> rawLines = processDDR2Lines(rawResponse);
		ArrayList<String> dataArray = new ArrayList<String>(0);
		for (String lineOfResponse : rawLines) {
			dataArray.add(lineOfResponse);
		}
		
		DDR2Find1CResponse response = new DDR2Find1CResponse(dataArray);

		if (logger.isDebugEnabled()) {
			logger.debug("response=" + response);
		}

		return response;
	}

	protected List<String> processDDR2Lines(String input) {
		String[] data = input.split("\n");
		ArrayList<String> lines = new ArrayList<String>();
		for (String entry : data) {
			lines.add(entry);
		}
		return lines;
	}
}
