/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xm.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;

import gov.va.oit.vistaevolution.mailman.ws.xm.XMResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xm.endpoints.XMNewEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xm.model.XMNewRequest;
import gov.va.oit.vistaevolution.mailman.ws.xm.model.XMNewResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

/**
 * Test for New function of XM Webservice
 * 
 * @author Leisa Martella <Leisa.Martella@vangent.com>
 * 
 */
public class XMNewTest extends VistaLinkContextTestParent {

	/**
	 * XMWSOA NEW
	 * 
	 * This RPC creates a mailbox for a user.
	 * 
	 * Input Parameters
	 * 	xmz:	(optional)  If you wish to prevent the user from seeing messages
	 *  created before a certain date, then set XMZ to a message number
	 *  in the MESSAGE file (#3.9). The user will not be able to access
	 *  any messages created earlier than this one, unless the message is
	 *  already in the user's mailbox or is forwarded to the user. This
	 *  really only applies to users who left the organization and then
	 *  returned, or if (heaven forbid) you are re-using a DUZ. This
	 *  prevents the user from accessing old messages that may have
	 *  been addressed to the user.
	 *   
	 * 	xmDuz:	(required) The User's DUZ
	 * 
	 *  Returns: 
	 *    0^Successful
	 *   -1^Error in required input
	 *   -1^Mailbox already exists
	 *   -1^Failed to create mailbox
	 *  
	 */
	@Test
	public void testResequenceBasket() throws VistaWebServiceFault {
		String testResponse = "0^Successful";

		// Set up the request object
		XMNewRequest request = new XMNewRequest("53871","S.XTPM PATCH SERVER" );

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(
				testResponse);

		// Setup the endpoint for testing.
		XMNewEndpointImpl xmNewEndpoint = new XMNewEndpointImpl(
				new XMResponseFactory(), getVistaLinkContext());

		// Execute request against mocked object backend.
		XMNewResponse response = xmNewEndpoint.xmnew(request);

		assertEquals(testResponse, response.getResults());
	}

}
