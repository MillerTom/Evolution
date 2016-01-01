/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xma21;

import gov.va.oit.vistaevolution.mailman.ws.xma21.model.XMA21ChkResponse;
import gov.va.oit.vistaevolution.mailman.ws.xma21.model.XMA21InstResponse;
import gov.va.oit.vistaevolution.mailman.ws.xma21.model.XMA21WhoResponse;
import gov.va.oit.vistaevolution.util.AbstractResponseFactory;
import gov.va.oit.vistaevolution.util.StrUtils;
import gov.va.oit.vistaevolution.util.StrUtilsException;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * This factory processes response and 
 * creates a response objecs in the XMA21
 * packages.
 * 
 * @author Christopher Schuck
 *
 */
@Component
public class XMA21ResponseFactory extends AbstractResponseFactory {

	private static final Logger LOG = Logger
			.getLogger(XMA21ResponseFactory.class);
					
	/**
	 * Default Bean Constructor
	 */
	public XMA21ResponseFactory() {
		super();
	}
	
	/**
	 * This method returns a structured XMA21ChkResponse 
     * object based on the raw string response that is passed in. 
	 * @param rawResponse
	 * @return XMA21ChkResponse
	 */
	public XMA21ChkResponse createChkXMA21ResponseFromString(String rawResponse) {
	    LOG.debug("Returned Data : " + rawResponse);
	    List<String> rawLines = processLines(rawResponse);
	    if (rawLines != null && !rawLines.isEmpty()) {
	    	try {
				List<String> returnCodes = StrUtils.stringtoList(rawLines.get(0), "\\^");
				return new XMA21ChkResponse(returnCodes.get(0), returnCodes.get(1));
			} catch (StrUtilsException e) {
				LOG.debug(e);
				return new XMA21ChkResponse();
			}
	    } else {
	    	return new XMA21ChkResponse();
	    }
	}
	
    /**
     * This method returns a structured XMA21InstResponse 
     * object based on the raw string response that is passed in.
     * 
     * @param rawResponse
     * @return XMA21InstResponse
     */
    public XMA21InstResponse createInstFromString(String rawResponse) {
        
        if (LOG.isDebugEnabled())
            LOG.debug("Returned Data : " + rawResponse);
        
        String address = null;
        String duz = null;
        String username = null;
        String domain = null;
        String message = null;
        String ien = null;
        
        List<String> rawLines = processLines(rawResponse);
        
        for (String s : rawLines) {
            
            String[] rawSplit = s.split("\\^");
            
            //  For Local or Remote Response
            if (s.startsWith("ADDRESS")) {
                   
                if (rawLines.size() == 3)
                    address = rawSplit[1].trim();
                else if (rawLines.size() == 2)
                    duz = rawSplit[1].trim();
            }
            
            //  For Remote Response
            if (s.startsWith("REMOTE")) {                
                
                if (rawSplit.length == 3) {
                    ien = rawSplit[1].trim();
                    domain = rawSplit[2].trim();
                }
            }
            
            //  For Local Response
            if (s.startsWith("LOCAL")) {
                username = rawSplit[2].trim();
            }
            
            //  For Message Response
            if (s.startsWith("-1")) {                
                message = rawSplit[1].trim();
            }
            
            //  For ERROR Response
            if (s.startsWith("ERROR")) {                
                message = rawSplit[1].trim();
            }
            
        }
        
        if (3 == rawLines.size() ) {
            return new XMA21InstResponse(address, ien, domain, rawResponse);
        }
        if (2 == rawLines.size()) {
            return new XMA21InstResponse(username, duz, rawResponse);
        }
        if (1 == rawLines.size()) {
            return new XMA21InstResponse(message, rawResponse);
        }
        
        return null; 
        
    }

    public XMA21WhoResponse createWhoFromString(String rawResponse) {
        
        LOG.debug("Returned Data : " + rawResponse);
        
        List<String> rawLines = processLines(rawResponse);
        /*
        List<String> dataArray = new ArrayList<String>(3);
        
        for (String lineOfResponse : rawLines) {
            dataArray.add(lineOfResponse);
        }
        
        if (dataArray.size() > 0)
            return new XMA21WhoResponse(dataArray); 
        else
            return null;
         */
        if (rawLines != null && !rawLines.isEmpty()) {
        	try {
				List<String> respLines = StrUtils.stringtoList(rawLines.get(0), "\\^");
				return new XMA21WhoResponse(respLines);
			} catch (StrUtilsException e) {
				LOG.debug(e);
				return new XMA21WhoResponse();
			}
        } else {
        	return new XMA21WhoResponse();
        }
    }
}
