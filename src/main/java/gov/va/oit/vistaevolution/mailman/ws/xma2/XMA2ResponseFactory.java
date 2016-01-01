/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xma2;

import gov.va.oit.vistaevolution.mailman.ws.xma2.model.XMA2XmzResponse;
import gov.va.oit.vistaevolution.util.AbstractResponseFactory;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author Leisa Martella
 *
 */
@Component
public class XMA2ResponseFactory extends AbstractResponseFactory{
	
	// Log4J setup
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XMA2ResponseFactory.class);
	
	public XMA2XmzResponse createXMA2XmzResponseFromString(
		String rawResponse) throws VistaWebServiceFault {
		//This method returns a single string
		return new XMA2XmzResponse(rawResponse);
	}

}
