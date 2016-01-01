package gov.va.oit.vistaevolution.mailman.ws.xmcu1.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.XMCU1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.endpoints.XMCU1StranEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.endpoints.interfaces.XMCU1StranEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.model.XMCU1StranRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.model.XMCU1StranResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Unit Test for Stran method of XMCU1 Webservice
 */
public class XMCU1StranTest extends VistaLinkContextTestParent {

	/**
	 * No Arguments Constructor
	 */
	public XMCU1StranTest() {
		super();
	}

	/**
	 * <em>Test Case #1</em>
	 * 
	 * Pass in the ASCII control character (Start of Header) and return “~”
	 * concatenated with the printable control character.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=$C(1)
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="~A"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStran001() throws VistaWebServiceFault {

		String expectedOutput = "~A";

		XMCU1StranRequest request = new XMCU1StranRequest();

		char ctrlChar = 1;
		String controlStr = Character.toString(ctrlChar);

		request.setInputString(controlStr);

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMCU1StranEndpoint service = new XMCU1StranEndpointImpl(
				new XMCU1ResponseFactory(), getVistaLinkContext());

		XMCU1StranResponse response = service.stran(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getResult());

	}

	/**
	 * <em>Test Case #2</em>
	 * 
	 * Pass in the non-control character null (“”) and an Error Message is
	 * returned..
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=""
	 * 
	 * Procedure Call:
	 * >D STRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^Error in required input"
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStran002() throws VistaWebServiceFault {

		String expectedOutput = "-1^Error in required input";

		XMCU1StranRequest request = new XMCU1StranRequest();
		request.setInputString("");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMCU1StranEndpoint service = new XMCU1StranEndpointImpl(
				new XMCU1ResponseFactory(), getVistaLinkContext());

		XMCU1StranResponse response = service.stran(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getResult());

	}

}
