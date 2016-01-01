/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Test;

import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.interfaces.XMXSEC1SsPrivEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1SsPrivResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;

/**
 * @author Christopher Schuck
 *
 */
public class XMXSEC1SsPrivIT extends EvolutionIT<XMXSEC1SsPrivEndpoint> {
	
	private static Logger LOGGER = Logger.getLogger(XMXSEC1SsPrivIT.class);

	/**
	 * Test method for {@link gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.XMXSEC1SsPrivEndpointImpl#sspriv(gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1SsPrivRequest)}.
	 */
	@Test
	public void testSspriv() {

		XMXSEC1SsPrivResponse response = service.sspriv(null);
		
		assertNotNull(response);
		
		LOGGER.debug("ss priv response: " + response.getFlag());
	}

	@Override
	protected Class<XMXSEC1SsPrivEndpoint> getType() {
		return XMXSEC1SsPrivEndpoint.class;
	}

}
