/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmut7.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmut7.XMUT7ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmut7.endpoints.XMUT7EntEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmut7.model.XMUT7EntRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmut7.model.XMUT7EntResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

/**
 * Test for Ent function of XMUT7 Webservice
 * 
 * @author Leisa Martella <Leisa.Martella@vangent.com>
 * 
 */
public class XMUT7EntTest extends VistaLinkContextTestParent {

	/**
	 * @author Leisa Martella
	 *
	 */
	/**
	 * TODO: Correct RPC name once broker is completed
	 * XMWSOA ENT
	 * 
	 * ENT^XMUT7(): Send a Test Message to a User's Forwarding Address
	 * 
	 * Reference Type	Supported
	 * Category	Utilities—General Development (Classic MailMan)
	 * IA #	1132
	 * 
	 * Description	This API sends a test message to a user's forwarding address.
	 * The message is also sent to the Postmaster. If the forwarding address is 
	 * no good, the Postmaster receives an error message.
	 * 
	 * Format	ENT^XMUT7(duz)
	 * 
	 * Input Parameters	
	 * 
	 * duz:	(required) DUZ of user, whose forwarding address you want to test.
	 * 
	 * Output	returns:	
	 * 
	 * Results:
	 * 
	 * Successful—Test message gets sent to the user's forwarding address and 
	 * the Postmaster.
	 * 
	 * Unsuccessful—An error message is sent to the Postmaster.
	 * 
	 *   
	 */

	/**
	 * Test Case #1  Success
	 *
	 * D ENT^XMUT7(53469)
	 * 
	 * Note: this test was run on a VA development system, because it had 
	 * everything set up to communicate to the world.
	 * 
	 * Receive an email
	 * From: POSTMASTER@CARVDD.FO-ALBANY.MED.VA.GOV
	 * [mailto:POSTMASTER@CARVDD.FO-ALBANY.MED.VA.GOV] 
	 * 
	 * Sent: Friday, December 13, 2013 10:47 AM
	 * 
	 * To: User; POSTMASTER@CARVDD.FO-ALBANY.MED.VA.GOV
	 * Subject: Test new forwarding address for TEST,USER
	 * 
	 * This is a test to confirm that the forwarding address
	 * 
	 * TEST.USER@VA.GOV belonging to USER,TEST does not generate an error.
	 * 
	 * Please ignore this message.
	 *
	 * @throws VistaWebServiceFault
	 */

	public void testCreateMessageStub() throws VistaWebServiceFault {
		String testResponse = "0^Success";

		// Set up the request object
		XMUT7EntRequest request = new XMUT7EntRequest("53469");

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(
		testResponse);

		// Setup the endpoint for testing.
		XMUT7EntEndpointImpl xmut7EntEndpoint = new XMUT7EntEndpointImpl(
				new XMUT7ResponseFactory(), getVistaLinkContext());

		// Execute request against mocked object backend.
		XMUT7EntResponse response = xmut7EntEndpoint.ent(request);

		assertEquals(testResponse, response.getResults());
	}

}
