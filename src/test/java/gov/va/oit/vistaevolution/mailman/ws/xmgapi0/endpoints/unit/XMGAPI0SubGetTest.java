/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmgapi0.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmgapi0.XMGAPI0ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmgapi0.endpoints.XMGAPI0SubGetEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmgapi0.endpoints.interfaces.XMGAPI0SubGetEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmgapi0.model.XMGAPI0SubGetResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmgapi0.model.XMGAPI0SubgetRequest;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
public class XMGAPI0SubGetTest extends VistaLinkContextTestParent {

	/**
	 * Test case returns the subject of the message number passed into the
	 * function.
	 * 
	 * >S U="^" Input >S ZZ=3
	 * 
	 * Function call > D SUBGET^XMWSOA01 (.OUTPUT,ZZ)
	 * 
	 * Output >ZW OUTPUT OUTPUT="0^NEW USER ADDED TO SYSTEM"
	 * 
	 * @throws VistaWebServiceFault
	 * 
	 */
	@Test
	public void testGetMessageSubject() throws VistaWebServiceFault {
		String expectedResult = "NEW USER ADDED TO SYSTEM";

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn("0^" + expectedResult);

		// Setup the endpoint for testing.
		XMGAPI0SubGetEndpoint subGetXMGAPI0Endpoint = new XMGAPI0SubGetEndpointImpl(
				getVistaLinkContext(), new XMGAPI0ResponseFactory());

		// Execute request against mocked object backend.
		XMGAPI0SubGetResponse response = subGetXMGAPI0Endpoint
				.subGet(new XMGAPI0SubgetRequest("3"));

		assertNotNull(response.getSubject());
		assertEquals("0", response.getStatus());
	}

	/**
	 * Pass a non-existent message number to the function.
	 * 
	 * >S U="^" Input: >S ZZ=9 Function call > D SUBGET^XMWSOA01 (.OUTPUT,ZZ)
	 * Output: >ZW OUTPUT OUTPUT="-1^Message not found"
	 * 
	 * @throws VistaWebServiceFault
	 * 
	 */
	@Test
	public void testGetWithBadMessageNumber() throws VistaWebServiceFault {
		String expectedResult = "Message not found";

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn("-1^" + expectedResult);

		// Setup the endpoint for testing.
		XMGAPI0SubGetEndpoint subGetXMGAPI0Endpoint = new XMGAPI0SubGetEndpointImpl(
				getVistaLinkContext(), new XMGAPI0ResponseFactory());

		// Execute request against mocked object backend.
		XMGAPI0SubGetResponse response = subGetXMGAPI0Endpoint
				.subGet(new XMGAPI0SubgetRequest("9"));

		assertNotNull(response.getErrors());
		assertEquals("-1", response.getStatus());

	}

}
