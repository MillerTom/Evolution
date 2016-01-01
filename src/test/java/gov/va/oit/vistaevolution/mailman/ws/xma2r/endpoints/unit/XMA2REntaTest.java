package gov.va.oit.vistaevolution.mailman.ws.xma2r.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xma2r.XMA2RResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xma2r.endpoints.XMA2REntaEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xma2r.endpoints.interfaces.XMA2REntaEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xma2r.model.XMA2REntaRequest;
import gov.va.oit.vistaevolution.mailman.ws.xma2r.model.XMA2REntaResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Unit Test for ENTA method of XMA2R Webservice
 */
public class XMA2REntaTest extends VistaLinkContextTestParent {

	/**
	 * <em>Test Case #1  </em>
	 * 
	 * Send a response to a message. Use the IEN of the test message and the
	 * name of the user (yourself) that created the test message.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >K XMTEXT
	 * >S XMZ=278219
	 * >S XMSUB="ZZ VISTA API EXPOSURE ENTA-XMWSOA02"
	 * >S XMTEXT(1)="The VISTA EVOLUTION Test Case Scenario"
	 * >S XMTEXT(2)="Test case for API $$ENTA^XMA2R"
	 * >S XMSTRIP=""
	 * >S XMDUZ="CUNNINGHAM,ALLEN"
	 * 
	 * Procedure Call:
	 * >D ENTA^XMWSOA02(.RETURN,XMZ,XMSUB,.XMTEXT,XMSTRIP,XMDUZ)
	 * 
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN=278233
	 * 
	 * </pre>
	 */
	@Test
	public void testEnta001() throws VistaWebServiceFault {
		String expectedOutput = "278233";

		List<String> xmtext = new ArrayList<String>();
		xmtext.add("The VISTA EVOLUTION Test Case Scenario");
		xmtext.add("Test case for API $$ENTA^XMA2R");
		XMA2REntaRequest request = new XMA2REntaRequest("", "CUNNINGHAM,ALLEN",
				"ZZ VISTA API EXPOSURE ENTA-XMWSOA02", xmtext, "278219", "");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMA2REntaEndpoint service = new XMA2REntaEndpointImpl(
				new XMA2RResponseFactory(), getVistaLinkContext());

		XMA2REntaResponse response = service.enta(request);

		assertNotNull(response);
		assertEquals("278233", response.getResult());

	}

	/**
	 * <em>Test Case #2  </em>
	 * 
	 * Error in required input. Use the IEN of the original test message and no
	 * message text.
	 * 
	 * <pre>
	 * Input Data:
	 * >K XMTEXT
	 * >S XMZ=278219
	 * >S XMSUB="ZZ VISTA API EXPOSURE ENTA-XMWSOA02"
	 * >S XMTEXT=""
	 * >S XMSTRIP=""
	 * >S XMDUZ="CUNNINGHAM,ALLEN"
	 *  
	 * Procedure Call:
	 * >D ENTA^XMWSOA02(.RETURN,XMZ,XMSUB,.XMTEXT,XMSTRIP,XMDUZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^Error in required input"
	 * 
	 * </pre>
	 */
	@Test
	public void testEnta002() throws VistaWebServiceFault {

		String expectedOutput = "-1^Error in required input";

		List<String> xmtext = new ArrayList<String>();
		XMA2REntaRequest request = new XMA2REntaRequest("", "CUNNINGHAM,ALLEN",
				"ZZ VISTA API EXPOSURE ENTA-XMWSOA02", xmtext, "278219", "");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMA2REntaEndpoint service = new XMA2REntaEndpointImpl(
				new XMA2RResponseFactory(), getVistaLinkContext());

		XMA2REntaResponse response = service.enta(request);

		assertNotNull(response);
		assertEquals("Error in required input", response.getMsgRoot().get(1));
	}

}
