/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmd.XMDResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.XMDEN1EndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.interfaces.XMDEN1Endpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMDEN1Request;
import gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMDResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMYEntry;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;

import org.junit.Test;

/**
 * 
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
public class XMDEN1Test extends VistaLinkContextTestParent {

	/**
	 * <em>This is an example sending a message to one user from the user passed in the “DUZ” variable:</em>
	 * 
	 * <pre>
	 * >S U=”^”,DUZ=53467,XMY(“53392”),XMSUB=”This is a test message”
	 * >S MSG(1)=”Hello Dr. House”
	 * >S MSG(2)=””
	 * >S MSG(3)=”This is a test to check if your e-mail is working.”
	 * >S MSG(4)=”Good bye.”
	 * 
	 * >D EN1^XMWSOA02(.DATA,DUZ,MSG,XMY,XMSUB,XMDF,XMSTRIP)
	 * >ZW DATA
	 * DATA="0^Successful"
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testSuccessfulSend() throws VistaWebServiceFault {
		String testResponse = "0^Successful";

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(testResponse);

		ArrayList<XMYEntry> XMY = new ArrayList<XMYEntry>();
		XMY.add(new XMYEntry("53392", ""));

		ArrayList<String> message = new ArrayList<String>();
		message.add("Hello Dr. House");
		message.add("");
		message.add("This is a test to check if your e-mail is working.");
		message.add("Good bye.");

		XMDEN1Request request = new XMDEN1Request("53392", message, XMY,
				"This is a test message");

		// Setup the endpoint for testing.
		XMDEN1Endpoint service = new XMDEN1EndpointImpl(getVistaLinkContext(),
				new XMDResponseFactory());

		// Execute request against mocked object backend.
		XMDResponse response = service.en1(request);

		assertEquals("Successful", response.getResponse());

	}

	/**
	 * <em>This is an example sending a message to one user from the user passed in the “DUZ” variable:</em>
	 * 
	 * <pre>
	 * >S U=”^”,DUZ=1,XMY(“983”),XMSUB=”Ab”
	 * >S MSG(1)=”Hello Dr. House”
	 * >S MSG(2)=””
	 * >S MSG(3)=”This is a test to check if your e-mail is working.”
	 * >S MSG(4)=”Good bye.”
	 * 
	 * >D EN1^XMWSOA02(.DATA,DUZ,MSG,XMY,XMSUB,XMDF,XMSTRIP)
	 * >ZW DATA
	 * DATA="-1^SUBJECT must be at least 3 characters long.^Ab"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testShortSubjectSend() throws VistaWebServiceFault {
		String testResponse = "-1^SUBJECT must be at least 3 characters long.";

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(testResponse);

		ArrayList<XMYEntry> XMY = new ArrayList<XMYEntry>();
		XMY.add(new XMYEntry("983", ""));

		ArrayList<String> message = new ArrayList<String>();
		message.add("Hello Dr. House");
		message.add("");
		message.add("This is a test to check if your e-mail is working.");
		message.add("Good bye.");

		XMDEN1Request request = new XMDEN1Request("1", message, XMY, "Ab");

		// Setup the endpoint for testing.
		XMDEN1Endpoint service = new XMDEN1EndpointImpl(getVistaLinkContext(),
				new XMDResponseFactory());
		// Execute request against mocked object backend.
		XMDResponse response = service.en1(request);

		assertEquals("SUBJECT must be at least 3 characters long.", response.getErrors().get(0));

	}

}
