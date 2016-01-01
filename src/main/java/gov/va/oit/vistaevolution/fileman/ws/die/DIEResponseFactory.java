/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.die;

import gov.va.oit.vistaevolution.fileman.ws.die.model.DIEChkResponse;
import gov.va.oit.vistaevolution.fileman.ws.die.model.DIEHelpResponse;
import gov.va.oit.vistaevolution.fileman.ws.die.model.DIEKeyValResponse;
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
public class DIEResponseFactory extends AbstractResponseFactory {

	// VistaLinkContextITParentLog4J setup
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(AbstractResponseFactory.class);

	public DIEChkResponse createDIEChkResponseFromString(String rawResponse) {

		return new DIEChkResponse(processDIELines(rawResponse));
	}

	public DIEKeyValResponse createDIEKeyValResponseFromString(String rawResponse) {

		return new DIEKeyValResponse(processDIELines(rawResponse));
	}

	/**
	 * 
	 * @param rawResponse
	 * @return
	 */
	public DIEHelpResponse createDIEHelpResponseFromString(String rawResponse) {
		return new DIEHelpResponse(processDIELines(rawResponse));
	}

	/**
	 * Processes raw data strings and removes newlines.
	 * 
	 * @param dataAndErrorStrings
	 */
	protected List<String> processDIELines(String input) {
		String[] data = input.split("\n");
		ArrayList<String> lines = new ArrayList<String>();
		for (String entry : data) {
			lines.add(entry);
		}
		return lines;
	}
	
}
