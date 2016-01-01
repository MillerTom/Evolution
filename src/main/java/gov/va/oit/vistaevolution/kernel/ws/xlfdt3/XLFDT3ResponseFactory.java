/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xlfdt3;

import gov.va.oit.vistaevolution.kernel.ws.xlfdt3.model.XLFDT3LeapResponse;
import gov.va.oit.vistaevolution.util.AbstractResponseFactory;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author Leisa Martella
 *
 */
@Component
public class XLFDT3ResponseFactory extends AbstractResponseFactory{
	
	// Log4J setup
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XLFDT3ResponseFactory.class);
	
	public XLFDT3LeapResponse createXLFDT3LeapResponseFromString(
		String rawResponse) throws VistaWebServiceFault {
//		 * Results: This RPC returns a 0 or 1 
		return new XLFDT3LeapResponse(rawResponse);
	}

}
