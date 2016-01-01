/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmadgo;

import gov.va.oit.vistaevolution.mailman.ws.xmadgo.model.XMADGOZtskResponse;
import gov.va.oit.vistaevolution.util.AbstractResponseFactory;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author Leisa Martella
 *
 */
@Component
public class XMADGOResponseFactory extends AbstractResponseFactory{
	
	// Log4J setup
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XMADGOResponseFactory.class);
	
	public XMADGOZtskResponse createXMADGOZtskResponseFromString(
		String rawResponse) throws VistaWebServiceFault {
		return new XMADGOZtskResponse(rawResponse);
	}

}
