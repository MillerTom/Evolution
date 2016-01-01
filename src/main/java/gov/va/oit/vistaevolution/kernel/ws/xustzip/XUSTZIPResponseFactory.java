/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xustzip;

import gov.va.oit.vistaevolution.kernel.ws.xustzip.model.XUSTZIPLkCheckResponse;
import gov.va.oit.vistaevolution.util.AbstractResponseFactory;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author Leisa Martella
 *
 */
@Component
public class XUSTZIPResponseFactory extends AbstractResponseFactory{
	
	// Log4J setup
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XUSTZIPResponseFactory.class);
	
	public XUSTZIPLkCheckResponse createXUSTZIPLkCheckResponseFromString(
		String rawResponse) throws VistaWebServiceFault {
		return new XUSTZIPLkCheckResponse(rawResponse);
	}

}
