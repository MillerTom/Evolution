package gov.va.oit.vistaevolution.mailman.ws.xmcu1.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.XMCU1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.endpoints.XMCU1RtranEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.endpoints.interfaces.XMCU1RtranEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.model.XMCU1RtranRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.model.XMCU1RtranResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Unit Test for Rtran function of XMCU1 Webservice
 */
public class XMCU1RtranTest extends VistaLinkContextTestParent {

	/**
	 * No Arguments Constructor
	 */
	public XMCU1RtranTest() {
		super();
	}

	/**
	 * <em>Test Case #1</em>
	 * 
	 * Pass in “~” concatenated with the printable control character and return
	 * the ASCII control character (Start of Header).
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=”~A”
	 * 
	 * Procedure Call:
	 * >S STRING=$$RTRAN^XMCU1(STRING)
	 * 
	 * Expected Output:
	 * >W $A(STRING)
	 * 1
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRtran001() throws VistaWebServiceFault {

		String expectedOutput = "1";

		XMCU1RtranRequest request = new XMCU1RtranRequest();
		request.setInputString("~A");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMCU1RtranEndpoint service = new XMCU1RtranEndpointImpl(
				new XMCU1ResponseFactory(), getVistaLinkContext());

		XMCU1RtranResponse response = service.rtran(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getResult());

	}

	/**
	 * <em>Test Case #2</em>
	 * 
	 * Pass in a null string and return an error message.
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING=""
	 * 
	 * Procedure Call:
	 * >D RTRAN^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^Error in required input"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRtran002() throws VistaWebServiceFault {

		String expectedOutput = "-1^Error in required input";

		XMCU1RtranRequest request = new XMCU1RtranRequest();
		request.setInputString("~B");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMCU1RtranEndpoint service = new XMCU1RtranEndpointImpl(
				new XMCU1ResponseFactory(), getVistaLinkContext());

		XMCU1RtranResponse response = service.rtran(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getResult());

	}
}
