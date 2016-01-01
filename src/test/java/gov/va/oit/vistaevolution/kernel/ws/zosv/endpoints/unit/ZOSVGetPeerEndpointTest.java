/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.zosv.endpoints.unit;

import gov.va.oit.vistaevolution.kernel.ws.zosv.ZOSVResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.zosv.endpoints.ZOSVGetPeerEndpointImpl;
import gov.va.oit.vistaevolution.kernel.ws.zosv.model.ZOSVGetPeerRequest;
import gov.va.oit.vistaevolution.kernel.ws.zosv.model.ZOSVGetPeerResponse;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;
import org.junit.Test;

/**
 * @author Stephen Combs <stephen.combs@synaptekcorp.com>
 *
 */
public class ZOSVGetPeerEndpointTest extends VistaLinkContextTestParent {
	
	@Test
	public void testDDR2Find1C() throws VistaWebServiceFault {

		String testResponse = "";
		
		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier("XU SOA GETPEER"),
						null)).thenReturn(testResponse);

		// Setup the endpoint for testing.
		ZOSVGetPeerEndpointImpl service = new ZOSVGetPeerEndpointImpl(new ZOSVResponseFactory() ,
				getVistaLinkContext());

		ZOSVGetPeerRequest request = new ZOSVGetPeerRequest();

		// Execute request against mocked object backend

		ZOSVGetPeerResponse response = service.getPeer(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getRet());
	}

}
