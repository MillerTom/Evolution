/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmb;

import gov.va.oit.vistaevolution.mailman.ws.xmb.model.XmbResponse;
import gov.va.oit.vistaevolution.util.AbstractResponseFactory;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author Leisa Martella
 *
 */
@Component
public class XMBResponseFactory extends AbstractResponseFactory{
	
	// Log4J setup
	private static final Logger LOG = Logger
			.getLogger(XMBResponseFactory.class);
	
	public XmbResponse createXmbResponseFromString(
		String rawResponse) throws VistaWebServiceFault {
			LOG.debug(rawResponse);
				return new XmbResponse(rawResponse);

	}

}
