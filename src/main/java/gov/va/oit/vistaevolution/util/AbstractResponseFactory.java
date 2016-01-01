/**
 * 
 */
package gov.va.oit.vistaevolution.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 *
 */
public abstract class AbstractResponseFactory {

	/**
	 * 
	 */
	public AbstractResponseFactory() {
		super();
	}

	/**
	 * This private function processes a list of "key=val" strings into a map.
	 * 
	 * @param rawData
	 *            Raw list of entries in the form of "key=val"
	 * @return Map of key/vals from raw data.
	 */
	protected Map<String, String> processRawDataListToMap(List<String> rawData) {
		Map<String, String> data = new LinkedHashMap<String, String>();
		for (String entry : rawData) {
			data.put(entry.split("=")[0].trim(), entry.split("=")[1].trim());
		}
		return data;
	}

	/**
	 * Processes raw data strings and removes empty strings caused by newlines.
	 * 
	 * @param dataAndErrorStrings
	 */
	protected List<String> processLines(String input) {
		String[] data = input.split("\n");
		ArrayList<String> lines = new ArrayList<String>();
		for (String entry : data) {
			if (!entry.isEmpty()) {
				lines.add(entry);
			}
		}
		return lines;
	}

	protected List<String> generateErrorsArray(String rawResponse) {
	    String[] responseArray = rawResponse.split("\\^");
	    LinkedList<String> errorsArray = new LinkedList<String>();
	    for (int i = 1; i < responseArray.length; i++) {
	        errorsArray.add(responseArray[i]);
	    }
	    return errorsArray;
	}

}