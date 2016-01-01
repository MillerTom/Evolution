package gov.va.oit.vistaevolution.kernel.ws.xusap;

import gov.va.oit.vistaevolution.util.AbstractResponseFactory;

import gov.va.oit.vistaevolution.kernel.ws.xusap.model.XUSAPActiveResponse;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * This factory processes response and 
 * creates a response objecs in the XUSERB
 * packages.
 * 
 * @author 
 * 
 */
@Component
public class XUSAPResponseFactory extends AbstractResponseFactory {

	private static final Logger LOGGER = Logger
			.getLogger(XUSAPResponseFactory.class);
	
    /**
     * Default Bean Constructor
     */
    public XUSAPResponseFactory() {
        super();
    }   
  
    public XUSAPActiveResponse createSetupFromString(String response) {   
        LOGGER.debug("Returned Data : " + response);
            return new XUSAPActiveResponse(response); 
    }
}
