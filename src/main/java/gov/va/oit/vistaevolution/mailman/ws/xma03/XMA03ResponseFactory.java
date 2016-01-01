/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xma03;

import gov.va.oit.vistaevolution.mailman.ws.xma03.model.XMA03RenResponse;
import gov.va.oit.vistaevolution.util.AbstractResponseFactory;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author Leisa Martella
 *
 */
@Component
public class XMA03ResponseFactory extends AbstractResponseFactory{
	
	// Log4J setup
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XMA03ResponseFactory.class);
	
	public XMA03RenResponse createXMA03RenResponseFromString(
		String rawResponse) throws VistaWebServiceFault {
				return new XMA03RenResponse(rawResponse);
	}

}
