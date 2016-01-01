/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.ddr3;

import java.util.ArrayList;
import java.util.List;

import gov.va.oit.vistaevolution.fileman.ws.ddr3.model.DDR3ValCResponse;
import gov.va.oit.vistaevolution.util.AbstractResponseFactory;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author Leisa Martella
 * 
 */
@Component
public class DDR3ResponseFactory extends AbstractResponseFactory {

	// VistaLinkContextITParentLog4J setup
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(AbstractResponseFactory.class);

	public DDR3ValCResponse createDDR3ValCResponseFromString(String rawResponse) {

		return new DDR3ValCResponse(processDDR3Lines(rawResponse));
	}
	protected List<String> processDDR3Lines(String input) {
		String[] data = input.split("\n", -1);
		ArrayList<String> lines = new ArrayList<String>();
		for (String entry : data) {
			lines.add(entry);
		}
		return lines;
	}

}
