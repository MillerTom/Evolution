package gov.va.oit.vistaevolution.mailman.ws.xmcu1.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.XMCU1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.endpoints.XMCU1DecodeupEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.endpoints.interfaces.XMCU1DecodeupEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.model.XMCU1DecodeupRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.model.XMCU1DecodeupResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Unit Test for Decodeup method of XMCU1 Webservice
 */
public class XMCU1DecodeupTest extends VistaLinkContextTestParent {

	/**
	 * No Arguments Constructor
	 */
	public XMCU1DecodeupTest() {
		super();
	}

	/**
	 * <em>Test Case #1</em>
	 * 
	 * Pass in a string with embedded “~U~”. Return the string with all “~U~”
	 * characters converted to “^”.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING="A~U~B~U~C~U~D~U~"
	 * 
	 * Procedure Call:
	 * >D DECODEUP^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="A^B^C^D^"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testDecodeup001() throws VistaWebServiceFault {

		String expectedOutput = "A^B^C^D^";

		XMCU1DecodeupRequest request = new XMCU1DecodeupRequest();
		request.setInputString("A~U~B~U~C~U~D~U~");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMCU1DecodeupEndpoint service = new XMCU1DecodeupEndpointImpl(
				new XMCU1ResponseFactory(), getVistaLinkContext());

		XMCU1DecodeupResponse response = service.decodeup(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getResult());

	}

	/**
	 * <em>Test Case #2</em>
	 * 
	 * Pass in a null string. Return an error message.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S STRING=""
	 * 
	 * Procedure Call:
	 * >D DECODEUP^XMWSOA01(.RETURN,STRING)
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
	public void testDecodeup002() throws VistaWebServiceFault {

		String expectedOutput = "-1^Error in required input";

		XMCU1DecodeupRequest request = new XMCU1DecodeupRequest();
		request.setInputString("");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMCU1DecodeupEndpoint service = new XMCU1DecodeupEndpointImpl(
				new XMCU1ResponseFactory(), getVistaLinkContext());

		XMCU1DecodeupResponse response = service.decodeup(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getResult());

	}

}
