package gov.va.oit.vistaevolution.mailman.ws.xma2r.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xma2r.XMA2RResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xma2r.endpoints.XMA2REntEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xma2r.endpoints.interfaces.XMA2REntEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xma2r.model.XMA2REntRequest;
import gov.va.oit.vistaevolution.mailman.ws.xma2r.model.XMA2REntResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Unit Test for ENT method of XMA2R Webservice
 */
public class XMA2REntTest extends VistaLinkContextTestParent {

	/**
	 * <em>Test Case #1  </em>
	 * 
	 * Error message “-1^Error in required input”. Parameter XMZ is set to null.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >K XMTEXT
	 * >S XMZ=""
	 * >S XMSUBJ="ZZ VISTA TEST API ENT-XMA2R"
	 * >S XMTEXT(1)="Test Case for API ENT^--XMA2R."
	 * >S XMSTRIP="-"
	 * >S XMDUZ="53387"
	 * >S XMNET=0
	 * 
	 * Procedure Call:
	 * >D ENT^XMWSOA01(.RETURN,XMZ,XMSUBJ,.XMTEXT,XMSTRIP,XMDUZ,XMNET) 
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^Error in required input"
	 * 
	 * </pre>
	 */
	@Test
	public void testEnt001() throws VistaWebServiceFault {

		String expectedOutput = "-1^Error in required input";

		List<String> xmtext = new ArrayList<String>();
		xmtext.add("Test Case for API ENT^--XMA2R.");
		XMA2REntRequest request = new XMA2REntRequest("", "53387",
				"ZZ VISTA TEST API ENT-XMA2R", xmtext, "", "0", "-");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMA2REntEndpoint service = new XMA2REntEndpointImpl(
				new XMA2RResponseFactory(), getVistaLinkContext());

		XMA2REntResponse response = service.ent(request);

		assertNotNull(response);
		assertEquals("invalid input XMZ - required.  Missing Message IEN,  call to ENT^XMA2R Service will fail for lack of neccessary input.", response.getMsgRoot().get(0));

	}

	/**
	 * <em>Test Case #2  </em>
	 * 
	 * Error message “-1^Error in required input”. Parameter XMSUBJ is set to
	 * null.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >K XMTEXT
	 * >S XMZ="278615"
	 * >S XMSUBJ=""
	 * >S XMTEXT(1)="Test Case for API ENT^--XMA2R."
	 * >S XMSTRIP="-"
	 * >S XMDUZ=DUZ
	 * >S XMNET=0
	 * 
	 * Procedure Call:
	 * >D ENT^XMWSOA01(.RETURN,XMZ,XMSUBJ,.XMTEXT,XMSTRIP,XMDUZ,XMNET) 
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^Error in required input"
	 * 
	 * </pre>
	 */
	@Test
	public void testEnt002() throws VistaWebServiceFault {

		String expectedOutput = "-1^Error in required input";

		List<String> xmtext = new ArrayList<String>();
		xmtext.add("Test Case for API ENT^--XMA2R.");
		XMA2REntRequest request = new XMA2REntRequest("", "DUZ", "", xmtext,
				"278615", "0", "-");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMA2REntEndpoint service = new XMA2REntEndpointImpl(
				new XMA2RResponseFactory(), getVistaLinkContext());

		XMA2REntResponse response = service.ent(request);

		assertNotNull(response);
		assertEquals("invalid input XMSUBJ - required.  Missing Subject of the message,  call to ENT^XMA2R Service will fail for lack of neccessary input.", response.getMsgRoot().get(0));

	}

}
