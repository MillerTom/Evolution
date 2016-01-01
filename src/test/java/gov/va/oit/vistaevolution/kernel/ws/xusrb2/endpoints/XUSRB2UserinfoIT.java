/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusrb2.endpoints;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import gov.va.oit.vistaevolution.kernel.ws.xusrb2.endpoints.interfaces.XUSRB2UserinfoEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xusrb2.model.XUSRB2UserinfoResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @author Christopher Schuck
 *
 */
public class XUSRB2UserinfoIT extends EvolutionIT<XUSRB2UserinfoEndpoint> {
	
	private static final Logger LOGGER = Logger.getLogger(XUSRB2UserinfoIT.class);

	/**
	 * <em>Use Case #1</em>
	 * 
	 * <pre>
	 * Get Demographic info for current user in return array
	 * </pre>
	 */
	@Test
	public void testUserinfo001() throws VistaWebServiceFault {
		XUSRB2UserinfoResponse response = service.userinfo(null);
		
		assertNotNull(response);
		
		if (response.getRet() != null && !response.getRet().isEmpty()) {
			for (int i = 0; i < response.getRet().size(); i++) {
				LOGGER.info("ret[" + i + "]: " + response.getRet().get(i));
			}
			assertTrue(response.getRet().get(0).equals("1"));
		} else {
			fail("no response received");
		}
	}

	@Override
	protected Class<XUSRB2UserinfoEndpoint> getType() {
		return XUSRB2UserinfoEndpoint.class;
	}

}
