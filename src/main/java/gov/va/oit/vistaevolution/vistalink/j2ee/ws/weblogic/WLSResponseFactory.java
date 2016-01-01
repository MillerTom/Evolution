/**
 * 
 */
package gov.va.oit.vistaevolution.vistalink.j2ee.ws.weblogic;

import gov.va.oit.vistaevolution.util.AbstractResponseFactory;
import gov.va.oit.vistaevolution.vistalink.j2ee.ws.weblogic.model.WeblogicVLJResponse;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class WLSResponseFactory extends AbstractResponseFactory{
	
	
	// Log4J setup
	private static final Logger LOG = Logger
			.getLogger(WLSResponseFactory.class);
	

	public WeblogicVLJResponse createWeblogicVLJResponseFromString(
		String rawResponse) throws VistaWebServiceFault {
		
				return new WeblogicVLJResponse(rawResponse);
	}

	
}
