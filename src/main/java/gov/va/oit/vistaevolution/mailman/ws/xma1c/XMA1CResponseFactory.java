/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xma1c;

import gov.va.oit.vistaevolution.mailman.ws.xma1c.model.XMA1CRemsbmsgResponse;
import gov.va.oit.vistaevolution.mailman.ws.xma1c.model.XMA1CSetsbResponse;
import gov.va.oit.vistaevolution.util.AbstractResponseFactory;
import gov.va.oit.vistaevolution.util.StrUtils;
import gov.va.oit.vistaevolution.util.StrUtilsException;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * This factory processes response and 
 * creates a response objecs in the XMA1C
 * packages.
 * 
 * @author Christopher Schuck
 *
 */
@Component
public class XMA1CResponseFactory extends AbstractResponseFactory {
	
	private static final Logger LOG = Logger
			.getLogger(XMA1CResponseFactory.class);
	
    /**
     * Default Bean Constructor
     */
    public XMA1CResponseFactory() {
        super();
    }

	public XMA1CSetsbResponse createSetsbFromString(String rawResponse) {
		
		LOG.debug("Returned Data : " + rawResponse);
		
		List<String> rawLines = processLines(rawResponse);
		String response = (!rawLines.isEmpty())?rawLines.get(0):"";
		List<String> respLines;
		try {
			respLines = StrUtils.stringtoList(response, "\\^");
			return new XMA1CSetsbResponse(respLines.get(0), respLines.get(1));
		} catch (StrUtilsException e) {
			return new XMA1CSetsbResponse();
		}
	}
	
	/**
     * This method returns a structured XMA1CRemsbmsgResponse 
     * object based on the raw string response that is passed in.
     * 
     * @param rawResponse
     * @return XMA1CRemsbmsgResponse
     */
    public XMA1CRemsbmsgResponse createRemsbmsgFromString(String rawResponse) {
        
        LOG.debug("Returned Data : " + rawResponse);
        return new XMA1CRemsbmsgResponse(rawResponse);
    }
}
