
package gov.va.oit.vistaevolution.kernel.ws.xusrb1;

import gov.va.oit.vistaevolution.kernel.ws.xusrb1.model.XUSRB1DecrypResponse;
import gov.va.oit.vistaevolution.kernel.ws.xusrb1.model.XUSRB1EncrypResponse;
import gov.va.oit.vistaevolution.kernel.ws.xusrb1.model.XUSRB1SendkeysResponse;
import gov.va.oit.vistaevolution.util.AbstractResponseFactory;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * This factory processes response and 
 * creates a response objecs in the XUSERB1
 * packages.
 * 
 * @author rcollins
 *
 */
@Component
public class XUSRB1ResponseFactory extends AbstractResponseFactory {
    
    private static final Logger LOGGER = Logger.getLogger(XUSRB1ResponseFactory.class);
    
    /**
     * Default Bean Constructor
     */
    public XUSRB1ResponseFactory() {
        super();
    }
    
    /**
     * This method returns a structured XUSRB1SendkeysResponse 
     * object based on the string response that is passed in.
     * 
     * @param response
     * @return XUSRB1SendkeysResponse
     */    
    public XUSRB1SendkeysResponse createSendKeysFromString(String response) {
        
        LOGGER.debug("Returned Data : " + response);
        
        List<String> rawLines = processLines(response);
        List<String> dataArray = new ArrayList<String>();
        
        for (String lineOfResponse : rawLines) {
            dataArray.add(lineOfResponse);
        }
        
        if (dataArray.size() > 0)
            return new XUSRB1SendkeysResponse(dataArray);
        else
            return null;        
    }
    
	public XUSRB1EncrypResponse createXUSRB1EncrypResponseFromString(String rawResponse) {
		return new XUSRB1EncrypResponse(rawResponse);
	}

	public XUSRB1DecrypResponse createXUSRB1DecrypResponseFromString(String rawResponse) {
		return new XUSRB1DecrypResponse(rawResponse);
	}
}
