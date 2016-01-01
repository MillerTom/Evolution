/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xm.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;

import gov.va.oit.vistaevolution.mailman.ws.xm.XMResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xm.endpoints.XMN1EndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xm.model.XMN1Request;
import gov.va.oit.vistaevolution.mailman.ws.xm.model.XMN1Response;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

/**
 * Test for N1 function of XM Webservice
 * 
 * @author Leisa Martella <Leisa.Martella@vangent.com>
 * 
 */
/**
 * 
 * 	 This RPC creates a mailbox for a user.
 * 
 * Inputs:
 *     xmDuz	(Required) User's DUZ.
 *     
 *     xmz 		(Optional) If you wish to prevent the user from seeing messages created
 *     before a certain date, then set XMZ to a message number in the MESSAGE
 *     file (#3.9). The user will not be able to access any messages created
 *     earlier than this one, unless the message is already in the user's mailbox
 *     or is forwarded to the user. This really only applies to users who left
 *     the organization and then returned, or if (heaven forbid) you are re-using
 *     a DUZ. This prevents the user from accessing old messages that may have
 *     been addressed to the user.
 * 
 * Returns:
 *    0^Successful
 *    -1^Error in required input
 *    -1^Mailbox already exists
 *    -1^Failed to create mailbox
 *    -1^XMDUZ <XMDUZ> does not exist
 *  
 */
public class XMN1Test extends VistaLinkContextTestParent {

	/**
	 * Test Case #1  Success
	 * 
	 * In this test case you will set the values for xmz to empty string and xmDuz to 50.
	 * 
	 * The expected result is "0^Successful"
	 * 
	 * NOTE: IF YOU TRY TO CREATE A MAILBOX THAT HAS ALREADY BEEN CREATED THE TEST WILL FAIL
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testCreateMailbox() throws VistaWebServiceFault {
		String testResponse = "0^Successful";

		// Set up the request object
		XMN1Request request = new XMN1Request("", "50");

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(
				testResponse);

		// Setup the endpoint for testing.
		XMN1EndpointImpl xmN1Endpoint = new XMN1EndpointImpl(
				new XMResponseFactory(), getVistaLinkContext());

		// Execute request against mocked object backend.
		XMN1Response response = xmN1Endpoint.n1(request);

		assertEquals(testResponse, response.getResults());
	}

}
