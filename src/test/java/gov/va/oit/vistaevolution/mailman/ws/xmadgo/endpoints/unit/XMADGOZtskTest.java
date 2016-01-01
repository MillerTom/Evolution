/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmadgo.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmadgo.XMADGOResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmadgo.endpoints.XMADGOZtskEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmadgo.model.XMADGOZtskRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmadgo.model.XMADGOZtskResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * 
 * @author Leisa Martella <Leisa.Martella@vangent.com>
 * 
 */
/**
 * 
 * XMWSOA ZTSK
 * 
 * This RPC starts tasks to deliver messages in local delivery queues. It
 * has no effect if the background filer has been stopped or if the local
 * delivery queues are already active.
 * 
 * Returns:
 *    0^Tasks started to deliver messages in local delivery queues
 *    -1^Background filer set to stop"
 *   
 */
public class XMADGOZtskTest extends VistaLinkContextTestParent {
	/**
	 *
	 * @throws VistaWebServiceFault
	 */

	@Test
	public void testZtsk() throws VistaWebServiceFault {
		String testResponse = "0";

		// Set up the request object
		XMADGOZtskRequest request = new XMADGOZtskRequest();

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(
		testResponse);

		// Setup the endpoint for testing.
		XMADGOZtskEndpointImpl service = new XMADGOZtskEndpointImpl(
				getVistaLinkContext(), new XMADGOResponseFactory());

		// Execute request against mocked object backend
		XMADGOZtskResponse response = service.ztsk(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getResults());
	}
}
