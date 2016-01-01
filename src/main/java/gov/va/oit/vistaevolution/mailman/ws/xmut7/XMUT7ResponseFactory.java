/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmut7;

import gov.va.oit.vistaevolution.mailman.ws.xmut7.model.XMUT7EntResponse;
import gov.va.oit.vistaevolution.util.AbstractResponseFactory;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author Leisa Martella
 *
 */
@Component
public class XMUT7ResponseFactory extends AbstractResponseFactory{
	
	// Log4J setup
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XMUT7ResponseFactory.class);
	
	public XMUT7EntResponse createXMUT7EntResponseFromString(
		String rawResponse) throws VistaWebServiceFault {
//		 * Results: TODO: This RPC does not return anything (Leisa)
//			 * 
//			 * Successful—Test message gets sent to the user's forwarding address and 
//			 * the Postmaster.
//			 * 
//			 * Unsuccessful—An error message is sent to the Postmaster.
		return new XMUT7EntResponse(rawResponse);
	}

}
