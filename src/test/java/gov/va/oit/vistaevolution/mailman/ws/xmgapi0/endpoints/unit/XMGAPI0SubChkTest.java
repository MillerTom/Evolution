/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmgapi0.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmgapi0.XMGAPI0ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmgapi0.endpoints.XMGAPI0SubChkEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmgapi0.endpoints.interfaces.XMGAPI0SubChkEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmgapi0.model.XMGAPI0SubChkRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmgapi0.model.XMGAPI0SubChkResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
public class XMGAPI0SubChkTest extends VistaLinkContextTestParent {

	/**
	 * 
	 * Test case with a successful return.
	 * 
	 * >S U="^" Input >S MSG="This is my subject of message!!"
	 * 
	 * Function call >D SUBCHK^XMWSOA01(.OUTPUT,MSG)
	 * 
	 * Output >ZW OUTPUT OUTPUT="0^Successful"
	 * 
	 * @throws VistaWebServiceFault
	 * 
	 */
	@Test
	public void testChkMessageSubject() throws VistaWebServiceFault {
		String testResponse = "Successful";

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn("0^" + testResponse);

		// Setup the endpoint for testing.
		XMGAPI0SubChkEndpoint subChkXMGAPI0Endpoint = new XMGAPI0SubChkEndpointImpl(
				getVistaLinkContext(), new XMGAPI0ResponseFactory());

		// Execute request against mocked object backend.
		XMGAPI0SubChkResponse response = subChkXMGAPI0Endpoint
				.subChk(new XMGAPI0SubChkRequest(
						"This is my subject of message!!"));

		assertNotNull(response.getResults());
		assertEquals("0", response.getStatus());
	}

	/**
	 * 
	 * Test case, the subject of message MSG contains exactly 66 characters.
	 * 
	 * >S U="^" Input >S $P(MSG,”A”,66)=”B”
	 * 
	 * Function call >D SUBCHK^XMWSOA01(.OUTPUT,MSG)
	 * 
	 * Output >ZW OUTPUT
	 * OUTPUT="-1^Entered SUBJECT too long, 1 characters longer than 65."
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testChkBadMessageSubject() throws VistaWebServiceFault {
		String testResponse = "Entered SUBJECT too long, 1 characters longer than 65.";

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn("-1^" + testResponse);

		// Setup the endpoint for testing.
		XMGAPI0SubChkEndpoint subChkXMGAPI0Endpoint = new XMGAPI0SubChkEndpointImpl(
				getVistaLinkContext(), new XMGAPI0ResponseFactory());
		XMGAPI0SubChkResponse response = subChkXMGAPI0Endpoint
				.subChk(new XMGAPI0SubChkRequest(
						"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"));
		assertNotNull(response.getErrors());
		assertEquals("-1", response.getStatus());

	}

}
