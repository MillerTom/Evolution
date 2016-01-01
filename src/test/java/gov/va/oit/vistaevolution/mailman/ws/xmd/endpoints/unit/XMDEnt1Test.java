package gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmd.XMDResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.XMDEnt1EndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.interfaces.XMDEnt1Endpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMDEnt1Request;
import gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMDResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMYEntry;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;

import org.junit.Test;

public class XMDEnt1Test extends VistaLinkContextTestParent {

	/**
	 * <em>Test case forward a message to a user, successful return code. </em>
	 * 
	 * <pre>
	 * >S U="^"
	 * Input  
	 * >S DUZ=53467,XMDUZ=52,XMY(53392)=””,XMZ=3
	 *  
	 * Function call 
	 * > D ENT1^XMWSOA02(.OUTPUT,DUZ,XMDUZ,.XMY,XMZ)
	 *  
	 * Output 
	 * >ZW OUTPUT
	 * OUTPUT="0^Successful"
	 * </pre>
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
		XMDEnt1Request request = new XMDEnt1Request("53467", "52", XMY, "3");

		// Setup the endpoint for testing.
		XMDEnt1Endpoint service = new XMDEnt1EndpointImpl(
				getVistaLinkContext(), new XMDResponseFactory());

		// Execute request against mocked object backend.
		XMDResponse response = service.ent1(request);

		assertEquals("Successful", response.getResponse());

	}

	/**
	 * <em>Test case no DUZ defined, returns error</em>
	 * 
	 * <pre>
	 * >S U="^"
	 * Input  
	 * >S DUZ=””,XMDUZ=52,XMY(53392)=””,XMZ=3
	 *  
	 * Function call 
	 * > D ENT1^XMWSOA02(.OUTPUT,DUZ,XMDUZ,.XMY,XMZ)
	 *  
	 * Output 
	 * >ZW OUTPUT
	 * OUTPUT="-1^Error in required input"
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testNoDUZError() throws VistaWebServiceFault {
		String testResponse = "1^Error in required input";

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(testResponse);

		ArrayList<XMYEntry> XMY = new ArrayList<XMYEntry>();
		XMY.add(new XMYEntry("53467", ""));
		XMDEnt1Request request = new XMDEnt1Request("", "52", XMY, "3");

		// Setup the endpoint for testing.
		XMDEnt1Endpoint service = new XMDEnt1EndpointImpl(
				getVistaLinkContext(), new XMDResponseFactory());

		// Execute request against mocked object backend.
		XMDResponse response = service.ent1(request);

	    assertEquals("Error in required input", response.getErrors().get(0));
		

	}
}
