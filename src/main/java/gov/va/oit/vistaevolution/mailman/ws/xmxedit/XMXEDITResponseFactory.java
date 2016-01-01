
package gov.va.oit.vistaevolution.mailman.ws.xmxedit;

import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITClosedResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITConfidResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITConfirmResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITDeliverResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITInfoResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITPriorityResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITSubjResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITTextResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITVaporResponse;
import gov.va.oit.vistaevolution.util.AbstractResponseFactory;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * 
 * This factory processes response and 
 * creates a response objecs in the XMXEDIT
 * packages.
 * 
 *  @author Christopher Schuck
 *
 */
@Component
public class XMXEDITResponseFactory extends AbstractResponseFactory {
    
    private static final Logger LOGGER = Logger
            .getLogger(XMXEDITResponseFactory.class);
    
    /**
     * Default Constructor
     */
    public XMXEDITResponseFactory() {
        super();
    }
    
    /**
     * This method returns a structured XMXEDITClosedResponse 
     * object based on the raw string response that is passed in.
     * 
     * @param rawResponse
     * @return XMXEDITClosedResponse
     */
    public XMXEDITClosedResponse createClosedFromString(String rawResponse) {     
        
        LOGGER.debug("Returned Data : " + rawResponse);   
        String[] lineSplit = rawResponse.split("\\^", 2);
        String[] finalSplit = lineSplit[1].split("\\'");
        
        if (finalSplit.length == 1)                
            return new XMXEDITClosedResponse(finalSplit[0].trim(), rawResponse);
        else
            return new XMXEDITClosedResponse(finalSplit[1].trim(), finalSplit[2].trim(), rawResponse);
    }
    
    /**
     * This method returns a structured XMXEDITConfirmResponse 
     * object based on the raw string response that is passed in.
     * 
     * @param rawResponse
     * @return XMXEDITConfirmResponse
     */
    public XMXEDITConfirmResponse createConfirmFromString(final String rawResponse) {
        
        if (LOGGER.isDebugEnabled())
         LOGGER.debug("Returned Data : " + rawResponse);
        
        String[] lineSplit = rawResponse.split("\\^", 2);
        String[] finalSplit = lineSplit[1].split("\\'");
        
        if (finalSplit.length == 1)
            return new XMXEDITConfirmResponse(finalSplit[0].trim(), rawResponse);
        else
            return new XMXEDITConfirmResponse(finalSplit[1].trim(), finalSplit[2].trim(), rawResponse);
    }
    
    public XMXEDITConfidResponse createConfidFromString(String rawResponse) {
        String method = this.getClass() + ".createConfidFromString";
        LOGGER.info(method + ": Preparing XMXEDITConfidResponse to be Returned!");
        List<String> lines = processLines(rawResponse);
        if (lines.size() == 2) {
            LOGGER.debug(lines.get(0) + " " + lines.get(1));
            return new XMXEDITConfidResponse(lines.get(0), lines.get(1));
        } else if (lines.size() == 1) {
            XMXEDITConfidResponse response = new XMXEDITConfidResponse();
            response.setXmmsg(lines.get(0));
            return response;
        } else {
            LOGGER.error("NO OUTPUT RETURNED FROM " + method);
            return new XMXEDITConfidResponse();
        }
    }
    
    public XMXEDITTextResponse createTextFromString(String rawResponse) {
        String method = this.getClass() + ".createTextFromString";
        LOGGER.info(method + ": Preparing XMXEDITTextResponse to be Returned!");
        List<String> lines = processLines(rawResponse);
        if (lines != null && lines.size() > 0) {
            LOGGER.debug(lines.get(0));
            return new XMXEDITTextResponse(lines.get(0));
        } else {
            LOGGER.error("NO OUTPUT RETURNED FROM " + method);
            return new XMXEDITTextResponse();
        }
    }

    public XMXEDITSubjResponse createSubjFromString(String rawResponse) {
        String method = this.getClass() + ".createSubjFromString";
        LOGGER.info(method + ": Preparing XMXEDITSubjResponse to be Returned!");
        List<String> rawLines = processLines(rawResponse);
        if (rawLines != null && !rawLines.isEmpty()) {
        	return new XMXEDITSubjResponse(rawLines.get(0));
        } else {
        	LOGGER.error("EMPTY RESPONSE!!!!");
        	return new XMXEDITSubjResponse();
        }
	}
    
    /**
     * This method returns a structured XMXEDITDeliverResponse 
     * object based on the raw string response that is passed in.
     *  
     * @param rawResponse
     * @return XMXEDITDeliverResponse
     */
    public XMXEDITDeliverResponse createDeliverFromString(final String rawResponse) {
        
        if (LOGGER.isDebugEnabled())
            LOGGER.debug("Returned Data : " + rawResponse);
        
        String[] lineSplit = rawResponse.split("\\^");
        
        if (2 == lineSplit.length) {
            return new XMXEDITDeliverResponse(lineSplit[1].trim(),
                    lineSplit[0].trim(), rawResponse);
        }
        
        if (1 == lineSplit.length) {
            return new XMXEDITDeliverResponse(lineSplit[0].trim(), rawResponse);
        }
                    
        return new XMXEDITDeliverResponse();
    }
    
    /**
     * This method returns a structured XMXEDITInfoResponse 
     * object based on the raw string response that is passed in.
     *  
     * @param rawResponse
     * @return XMXEDITInfoResponse
     */
    public XMXEDITInfoResponse createInfoFromString (final String rawResponse) {
        
        if (LOGGER.isDebugEnabled())
            LOGGER.debug("Returned Data : " + rawResponse);
        
        String[] lineSplit = rawResponse.split("\\^", 2);
        
        if (2 == lineSplit.length)
            return new XMXEDITInfoResponse(lineSplit[0].trim(), lineSplit[1].trim(), rawResponse);
        else if (3 == lineSplit.length)
            return new XMXEDITInfoResponse(lineSplit[0].trim(), lineSplit[1].trim(), lineSplit[2].trim(), rawResponse);
        
        return new XMXEDITInfoResponse();
    }
    
    public XMXEDITVaporResponse createVaporFromString(String rawResponse) {
        String method = this.getClass() + ".createVaporFromString";
        LOGGER.info(method + ": Preparing XMXEDITVaporResponse to be Returned!");
        List<String> rawLines = processLines(rawResponse);
        if (rawLines != null && !rawLines.isEmpty()) {
        	return new XMXEDITVaporResponse(rawLines.get(0));
        } else {
        	LOGGER.error("EMPTY RESPONSE!!!!");
        	return new XMXEDITVaporResponse();
        }
	}
    
    public XMXEDITPriorityResponse createPriorityFromString(String rawResponse) {
        String method = this.getClass() + ".createPriorityFromString";
        LOGGER.info(method + ": Preparing XMXEDITPriorityResponse to be Returned!");
        List<String> rawLines = processLines(rawResponse);
        if (rawLines != null && !rawLines.isEmpty()) {
        	return new XMXEDITPriorityResponse(rawLines.get(0));
        } else {
        	LOGGER.error("EMPTY RESPONSE!!!!");
        	return new XMXEDITPriorityResponse();
        }
	}
}
