/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuser2;

import gov.va.oit.vistaevolution.kernel.ws.xuser2.model.XUSER2GetUpnResponse;
import gov.va.oit.vistaevolution.mailman.ws.xm.XMResponseFactory;
import gov.va.oit.vistaevolution.util.AbstractResponseFactory;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author Christopher Schuck
 *
 */
@Component
public class XUSER2ResponseFactory extends AbstractResponseFactory {

	// Log4J setup
	private static final Logger LOG = Logger
			.getLogger(XUSER2ResponseFactory.class);
	
	public XUSER2GetUpnResponse createXUSER2GetUpnResponseFromString(String rawResponse) {
		LOG.debug("Processing \"" + rawResponse + "\" for createXUSER2GetUpnResponseFromString.");
		return new XUSER2GetUpnResponse(rawResponse);
	}
}
