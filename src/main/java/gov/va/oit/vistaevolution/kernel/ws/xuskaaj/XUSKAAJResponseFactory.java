/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuskaaj;

import gov.va.oit.vistaevolution.kernel.ws.xuskaaj.model.XUSKAAJSignoffResponse;
import gov.va.oit.vistaevolution.kernel.ws.xuskaaj.model.XUSKAAJUserinfoResponse;
import gov.va.oit.vistaevolution.util.AbstractResponseFactory;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * This factory processes response and 
 * creates a response objecs in the XUSKAAJ
 * packages.
 * 
 * @author Christopher Schuck
 *
 */
@Component
public class XUSKAAJResponseFactory extends AbstractResponseFactory {

	private static final Logger LOG = Logger
			.getLogger(XUSKAAJResponseFactory.class);
	
	public XUSKAAJUserinfoResponse createUserinfoFromString(String rawResponse) {
	    LOG.debug("Returned Data : " + rawResponse);
		List<String> rawLines = processLines(rawResponse);
		return new XUSKAAJUserinfoResponse(rawLines);
	}
	
	/**
	 * This method returns a structured XUSKAAJSignoffResponse
     * object based on the raw string response that is passed in.
	 * @param rawResponse
	 * @return XUSKAAJSignoffResponse
	 */
	public XUSKAAJSignoffResponse createSignoffXUSKAAJResponseFromString(String rawResponse) {		
	    
	    if (LOG.isDebugEnabled())
	        LOG.debug("Returned Data : " + rawResponse);
	    
		return new XUSKAAJSignoffResponse(rawResponse);
	}
}
