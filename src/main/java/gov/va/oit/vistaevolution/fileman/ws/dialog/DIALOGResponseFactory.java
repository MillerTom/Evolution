
package gov.va.oit.vistaevolution.fileman.ws.dialog;

import gov.va.oit.vistaevolution.fileman.ws.dialog.model.DIALOGBldResponse;
import gov.va.oit.vistaevolution.fileman.ws.dialog.model.DIALOGEzBldResponse;
import gov.va.oit.vistaevolution.fileman.ws.dialog.model.DIALOGMsgResponse;
import gov.va.oit.vistaevolution.util.AbstractResponseFactory;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * This factory processes response and 
 * creates a response objecs in the DIALOG
 * packages.
 * 
 * @author rcollins
 */
@Component
public class DIALOGResponseFactory extends AbstractResponseFactory {

    private static final Logger LOGGER = Logger
            .getLogger(DIALOGResponseFactory.class);
    
    /**
     * Default Bean Constructor
     */
    public DIALOGResponseFactory() {
        super();
    }
    
    /**
     * This method returns a structured DIALOGBldResponse 
     * object based on the raw string response that is passed in.
     * @param response
     * @return DIALOGBldResponse
     */
    public DIALOGBldResponse createBldFromString(String response) {
        
        LOGGER.debug("Returned Data : " + response);
        
        // TODO: need to redo logic once we have an opportunity to look at what data is returned.        
        List<String> rawLines = processLines(response);
        
        for (int i = 0; i < rawLines.size(); i++) {
        	LOGGER.debug("rawLines[" + i + "]: " + rawLines.get(i));
        }
        
        if (rawLines.size() > 0) {
            return new DIALOGBldResponse(null, rawLines); //TODO: need to populate this in proper Lists
        } else {
            return new DIALOGBldResponse();
        }
    }
    
    /**
     * This method returns a structured DIALOGEzBldResponse 
     * object based on the raw string response that is passed in. 
     * @param response
     * @return DIALOGEzBldResponse
     */
    public DIALOGEzBldResponse createEzBldFromString(String response) {
        
        LOGGER.debug("Returned Data : " + response);

        List<String> rawLines = processLines(response);
 
        if (rawLines != null && rawLines.size() > 0) {        
        	return new DIALOGEzBldResponse(rawLines.get(0));
        } else {
        	return new DIALOGEzBldResponse();
        }
    }
    
    /**
     * This method returns a structured DIALOGMsgResponse 
     * object based on the raw string response that is passed in.
     * @param response
     * @return DIALOGMsgResponse
     */
    public DIALOGMsgResponse createMsgFromString(String response) {
               
        LOGGER.debug("Returned Data : " + response);
        
        // TODO: need to redo logic once we have an opportunity to look at what data is returned.        
        List<String> rawLines = processLines(response);
        List<String> dataArray = new ArrayList<String>();
        
        for (String lineOfResponse : rawLines) {
            dataArray.add(lineOfResponse);
        }
        
        if (dataArray.size() > 0)
            return new DIALOGMsgResponse(dataArray); //TODO: need to populate this is proper Lists
        else
            return null;
    }
    
}
