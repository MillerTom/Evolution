
package gov.va.oit.vistaevolution.kernel.ws.xusclean;

import gov.va.oit.vistaevolution.kernel.ws.xusclean.model.XUSCLEANLoutResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * This factory processes response and 
 * creates a response objecs in the XUSCLEAN
 * packages.
 * @author rcollins
 *
 */
@Component
public class XUSCLEANResponseFactory {
    
    private static final Logger LOG = Logger
            .getLogger(XUSCLEANResponseFactory.class);
    
    /**
     * Default Bean Constructor
     */
    public XUSCLEANResponseFactory() {
        super();
    }
    
    /**
     * This method returns a structured XUSCLEANLoutResponse 
     * object based on the raw string response that is passed in.
     * 
     * @param response
     * @return XUSCLEANLoutResponse
     */
    public XUSCLEANLoutResponse createLoutFromString(String response) {
        
        LOG.debug("Returned Data : " + response);
        return new XUSCLEANLoutResponse(response);
    }
    
}
