/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1StripEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1StripRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1StripResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @author Christopher Schuck
 *
 */
public class XMXUTIL1StripIT extends EvolutionIT<XMXUTIL1StripEndpoint> {
	
	private static final Logger LOGGER 
		= Logger.getLogger(XMXUTIL1StripIT.class);

	/**
	 * Test method for {@link gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.XMXUTIL1StripEndpointImpl#strip(gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1StripRequest)}.
	 */
	@Test
	public void testStrip() {
		XMXUTIL1StripRequest request = new XMXUTIL1StripRequest(" ABC XYZ ");
		
		XMXUTIL1StripResponse response = service.strip(request);
		
		LOGGER.debug("stripped string: " + response.getResponse());
		
		assertNotNull(response);
        assertEquals("ABC XYZ", response.getResponse());
	}

	@Override
	protected Class<XMXUTIL1StripEndpoint> getType() {
		return XMXUTIL1StripEndpoint.class;
	}

}
