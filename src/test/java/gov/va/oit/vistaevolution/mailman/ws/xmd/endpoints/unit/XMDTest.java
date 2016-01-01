/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmd.XMDResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.XMDEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.interfaces.XMDEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMDRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMDResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMYEntry;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
public class XMDTest extends VistaLinkContextTestParent {

	private ArrayList<String> message;
	private ArrayList<XMYEntry> XMY;
	private XMDRequest request;

	@Before
	public void setUp() {
		XMY = new ArrayList<XMYEntry>();
		XMY.add(new XMYEntry(".6", ""));

		message = new ArrayList<String>();
		message.add("THIS IS A 2 LINE TEST MESSAGE");
		message.add("THIS IS THE SECOND LINE ~&% with some text to be stripped.");
		
		request = new XMDRequest();
	}

	/**
	 * <em>Send a standard Message to a single recipient</em>
	 * 
	 * <pre>
	 *  Input Data:
	 *  >S DUZ=.5
	 *  >S XMDUZ=.5
	 *  >S XMSUB="Test subject",
	 *  >S MSG(1,0)="THIS IS A 2 LINE TEST MESSAGE"
	 *  >S MSG(1,1)="THIS IS THE SECOND LINE ~&% with some text to be stripped."
	 *  >S XMY(.6)=""
	 *  >S U=^
	 *  >S RETURN=””
	 *  
	 *  Procedure Call:
	 *  >D XMD^XMWSOA02(.RETURN,DUZ,XMDUZ,XMSUB,.MSG,.XMY)
	 *  
	 *  Expected Output:
	 *  >ZW RETURN
	 *  RETURN=55763
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testSendStandardMessageToSingleRecipient() throws VistaWebServiceFault {
		String expectedResult = "55763";

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedResult);

		request.setDuz(".5");
		request.setXmDuz(".5");
		request.setXmSub("Test Subject");
		request.setMessage(message);
		request.setxMY(XMY);

		// Setup the endpoint for testing.
		XMDEndpoint service = new XMDEndpointImpl(getVistaLinkContext(),
				new XMDResponseFactory());

		// Execute request against mocked object backend.
		XMDResponse response = service.xmd(request);

		assertEquals(expectedResult, response.getResponse());

	}
	


}
