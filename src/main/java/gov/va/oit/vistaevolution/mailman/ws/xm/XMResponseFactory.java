/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xm;

import gov.va.oit.vistaevolution.mailman.ws.xm.model.XMKillResponse;
import gov.va.oit.vistaevolution.mailman.ws.xm.model.XMN1Response;
import gov.va.oit.vistaevolution.mailman.ws.xm.model.XMNewResponse;
import gov.va.oit.vistaevolution.util.AbstractResponseFactory;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author Stephen Combs <stephen.combs@synaptekcorp.com>
 *Response Factory for XM tagged routines
 */
@Component
public class XMResponseFactory extends AbstractResponseFactory{
	
	
	// Log4J setup
	private static final Logger LOG = Logger
			.getLogger(XMResponseFactory.class);
	

	public XMKillResponse createXMKillResponseFromString(
		String rawResponse) throws VistaWebServiceFault {
		
				return new XMKillResponse(rawResponse);
	}

	public XMNewResponse createXMNewResponseFromString(
			String rawResponse) throws VistaWebServiceFault {

					return new XMNewResponse(rawResponse);
	}

	public XMN1Response createXMN1ResponseFromString(
		String rawResponse) throws VistaWebServiceFault {

			return new XMN1Response(rawResponse);
	}
	
	
	
}
