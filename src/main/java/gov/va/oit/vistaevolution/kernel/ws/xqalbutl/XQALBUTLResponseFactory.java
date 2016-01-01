
package gov.va.oit.vistaevolution.kernel.ws.xqalbutl;



import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLAhistoryResponse;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLAlertDatResponse;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLPendingResponse;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLPkgPendResponse;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLUserdataResponse;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLUserlistResponse;
import gov.va.oit.vistaevolution.util.AbstractResponseFactory;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * This factory processes response and 
 * creates a response objecs in the XQALBULT
 * packages.
 * 
 * @author Christopher Schuck
 *
 */
@Component
public class XQALBUTLResponseFactory extends AbstractResponseFactory {

	private static final Logger LOG = Logger
			.getLogger(XQALBUTLResponseFactory.class);
	
	/**
	 * Default bean Constructor
	 */
	public XQALBUTLResponseFactory() {
	    super();
	}
	
	public XQALBUTLUserlistResponse createUserlistXQALBUTLResponseFromString(String rawResponse) {
		List<String> rawLines = processLines(rawResponse);
		return new XQALBUTLUserlistResponse(rawLines);
	}
	
	/**
     * This method returns a structured XQALBUTLPendingResponse 
     * object based on the raw string response that is passed in.
     * 
     * @param response
     * @return XQALBUTLPendingResponse
     */
    public XQALBUTLPendingResponse createPendingAlertUserFromString(String response) {
        
        if (LOG.isDebugEnabled())
            LOG.debug("Returned Data : " + response);
        
        return new XQALBUTLPendingResponse(response);
    }    
    
    /**
     * This method returns a structured XQALBUTLPkgPendResponse 
     * object based on the raw string response that is passed in.
     * 
     * @param response
     * @return XQALBUTLPkgPendResponse
     */
    public XQALBUTLPkgPendResponse createPendingAlertSoftwareFromString(String response) {
        
        if (LOG.isDebugEnabled())
            LOG.debug("Returned Data : " + response);
        
        return new XQALBUTLPkgPendResponse(response);
    }
    
    /**
     * This method returns a structured XQALBUTLUserdataResponse
     * object based on the raw string response that is passed in. 
     * @param response
     * @return XQALBUTLUserdataResponse
     */
    public XQALBUTLUserdataResponse createUserDataFromString(String response) {
        
        LOG.debug("Returned Data : " + response);
        
        List<String> rawLines = processLines(response);
        List<String> dataArray = new ArrayList<String>();
        
        for (String lineOfResponse : rawLines) {
            dataArray.add(lineOfResponse);
        }
        
        if (dataArray.size() > 0)
            return new XQALBUTLUserdataResponse(dataArray, response); 
        else
            return null;        
    }
	/**
	 * 
	 * @param rawResponse
	 * @return
	 */
	public XQALBUTLAhistoryResponse createXQALBUTLAhistoryResponseFromString(String rawResponse) {
			return new XQALBUTLAhistoryResponse(processResponseLines(rawResponse));
	}
	/**
	 * 
	 * @param rawResponse
	 * @return
	 */
	public XQALBUTLAlertDatResponse createXQALBUTLAlertDatResponseFromString(String rawResponse) {
			return new XQALBUTLAlertDatResponse(processResponseLines(rawResponse));
	}
	/**
	 * Processes raw data strings and removes newlines.
	 * 
	 * @param input
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
