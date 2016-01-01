/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xma03.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xma03.XMA03ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xma03.endpoints.XMA03RenEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xma03.model.XMA03RenRequest;
import gov.va.oit.vistaevolution.mailman.ws.xma03.model.XMA03RenResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Test for Ren function of XMA03 Webservice
 * 
 * @author Leisa Martella <Leisa.Martella@vangent.com>
 * 
 */
public class XMA03RenTest extends VistaLinkContextTestParent {

	/**
	 * XMWSOA REN
	 * 
	 * REN^XMWSOA01
	 * 
	 * This RPC performs an integrity check on a user's basket,
	 * resequences messages in a user's basket, and returns a string,
	 * "Resequenced from 1 to n", where n is the number of messages in the
	 * basket. This message is only returned if the user has a mailbox with the
	 * selected basket and the basket has messages in it.
	 * if the user has a mailbox and the selected basket and has messages
	 * 
	 * 
	 * Input Parameters:
	 *   XMDUZ	DUZ of user
	 *   XMK	Internal Entry Number (IEN) of basket in sub-file 3.701.
	 * 
	 * Returns:
	 *  -1^Error in required input
	 *   0^Resequenced from 1 to n
	 *   0^No Action Taken
	 *   
	 */
	
	/**
	 * Test Case #7  Success
	 * 
	 * In this test case you will set the values for xmk to 1 and xmDuz to 53468
	 * 
	 * The expected result from the routine is:
	 *
	 *	Resequenced from 1 to 19.
	 *  
	 *  The expected result from RPC Broker is:
	 *  
	 *  "0^Resequenced from 1 to 27."
	 *	
	 * @throws VistaWebServiceFault
	 */
	@Test
	@Ignore //TODO: remove when data is correct or test case is updated
	public void testResequenceBasket() throws VistaWebServiceFault {
		String testResponse = "0^Resequenced from 1 to 27";

		// Set up the request object
		XMA03RenRequest request = new XMA03RenRequest("1", "53468");

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(
				testResponse);

		// Setup the endpoint for testing.
		XMA03RenEndpointImpl xma03RenEndpoint = new XMA03RenEndpointImpl(
				getVistaLinkContext(), new XMA03ResponseFactory());

		// Execute request against mocked object backend.
		XMA03RenResponse response = xma03RenEndpoint.ren(request);

		assertEquals(testResponse, response.getResults());
	}

	/**
	 * Test Case #1  No Action Taken
	 * 
	 * In this test case you will set the values for xmk to 3 and xmDuz to 53468.
	 * 
	 * The expected result from routine is:
	 * 
	 *	^TMP("XMERR",11051,1)=39415
	 *	^TMP("XMERR",11051,1,"PARAM","ID")="XMK" "VALUE")=3
	 *	^TMP("XMERR",11051,1,"TEXT",1)="Basket '3' not found."
	 *	^TMP("XMERR",11051,"E",39415,1)=""
	 *	 * 
	 *
	 * The expected result from RPC Broker is:
	 * 
	 *	RESULT="0^No Action Taken"
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testNoActionTakenResponse() throws VistaWebServiceFault {
		// Set up the request object
		XMA03RenRequest request = new XMA03RenRequest("3", "53468");
		String testResponse = "0^No Action Taken";
		
		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(
				testResponse);

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(
				testResponse);

		// Setup the endpoint for testing.
		XMA03RenEndpointImpl xma03RenEndpoint = new XMA03RenEndpointImpl(
				getVistaLinkContext(), new XMA03ResponseFactory());

		// Execute request against mocked object backend.
		XMA03RenResponse response = xma03RenEndpoint.ren(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getResults());
	}
}
