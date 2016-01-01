/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.zosv.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.apache.log4j.Logger;
import org.junit.Test;

import gov.va.oit.vistaevolution.kernel.ws.zosv.endpoints.interfaces.ZOSVGetPeerEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.zosv.model.ZOSVGetPeerRequest;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

/**
 * @author 0G4976SEC
 *
 */
public class ZOSVGetPeerIT extends EvolutionIT<ZOSVGetPeerEndpoint> {
	
	private static final Logger LOG = Logger
			.getLogger(ZOSVGetPeerIT.class);
	
	
	protected Class<ZOSVGetPeerEndpoint> getType()
	{
		return ZOSVGetPeerEndpoint.class;
	}
	
	@Test
	public void testZOSVGetPeer001() throws VistaWebServiceFault
	{
		String expected = "";//empty response is expected.
		String actual = "";
		
		ZOSVGetPeerRequest zosvGetPeerRequest = new ZOSVGetPeerRequest();
		
		try {
				LOG.debug("request object = " + zosvGetPeerRequest.toString());
			actual = service.getPeer(zosvGetPeerRequest).getRet();
				LOG.debug("response object = " + actual.toString());
			
			assertNotNull(actual);
			assertEquals(expected, actual);
		} catch (VistaWebServiceFault e) {

			fail("Failed due to internal error in running the GetPeer Service.");
				LOG.error("Error encountered while running unit test,testZOSVGetPeer001.",e);
		}
		finally
		{
			zosvGetPeerRequest = null;
			actual = "";
		}
	}

}
