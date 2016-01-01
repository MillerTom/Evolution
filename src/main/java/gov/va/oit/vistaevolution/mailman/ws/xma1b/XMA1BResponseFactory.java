
package gov.va.oit.vistaevolution.mailman.ws.xma1b;

import gov.va.oit.vistaevolution.mailman.ws.xma1b.model.XMA1BKlResponse;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.model.XMA1BKlqResponse;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.model.XMA1BS2Response;
import gov.va.oit.vistaevolution.util.AbstractResponseFactory;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * 
 * This factory processes response and 
 * creates a response objecs in the XMA1B
 * packages.
 * 
 * @author rcollins
 *
 */
@Component
public class XMA1BResponseFactory extends AbstractResponseFactory {
    
    private static final Logger LOGGER = Logger.getLogger(XMA1BResponseFactory.class);
    
    /**
     * Default Bean Constructor
     */
    public XMA1BResponseFactory() {
        super();
    }
    
    public XMA1BKlResponse createKlResponseFromString(String rawResponse) {
        List<String> rawLines = processLines(rawResponse);
        String response = (!rawLines.isEmpty())?rawLines.get(0):"";
        return new XMA1BKlResponse(response);
    }
    
    public XMA1BS2Response createS2ResponseFromString(String rawResponse) {
        List<String> rawLines = processLines(rawResponse);
        String response = (!rawLines.isEmpty())?rawLines.get(0):"";
        return new XMA1BS2Response(response);
    }
    
    /**
     * This method returns a structured response object based
     * on the raw string response that is passed in.
     *  
     * @param rawResponse
     * @return XMA1BKlqResponse
     */
    public XMA1BKlqResponse createKlqResponseFromString(String rawResponse) {
        
        LOGGER.debug("Returned Data : " + rawResponse);        
        return new XMA1BKlqResponse(rawResponse);        
    }    
}
