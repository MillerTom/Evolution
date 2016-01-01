/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuser;

import gov.va.oit.vistaevolution.kernel.ws.xuser.model.XUSERDiv4Response;
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
public class XUSERResponseFactory extends AbstractResponseFactory {

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XUSERResponseFactory.class);
	
	public XUSERDiv4Response createXUSERDiv4ResponseFromString(String rawResponse) {
		return new XUSERDiv4Response(processResponseLines(rawResponse));
	}
	/**
	 * Processes raw data strings and removes newlines.
	 * 
	 * @param dataAndErrorStrings
	 */
	protected List<String> processResponseLines(String input) {
		String[] data = input.split("\n");
		ArrayList<String> lines = new ArrayList<String>();
		for (String entry : data) {
			lines.add(entry);
		}
		return lines;
	}
	
}
