/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xqaldata;

import gov.va.oit.vistaevolution.kernel.ws.xqaldata.model.XQALDATAGetPatResponse;
import gov.va.oit.vistaevolution.kernel.ws.xqaldata.model.XQALDATAGetUser1Response;
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
public class XQALDATAResponseFactory extends AbstractResponseFactory{
	
	// Log4J setup
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XQALDATAResponseFactory.class);
	
	public XQALDATAGetPatResponse createXQALDATAGetPatResponseFromString(String rawResponse) {
		return new XQALDATAGetPatResponse(processXQALDATALines(rawResponse));
	}

	public XQALDATAGetUser1Response createXQALDATAGetUser1ResponseFromString(String rawResponse) {
		return new XQALDATAGetUser1Response(processXQALDATALines(rawResponse));
	}

	/**
	 * Processes raw data strings and removes newlines.
	 * 
	 * @param dataAndErrorStrings
	 */
	protected List<String> processXQALDATALines(String input) {
		String[] data = input.split("\n");
		ArrayList<String> lines = new ArrayList<String>();
		for (String entry : data) {
			lines.add(entry);
		}
		return lines;
	}

}
