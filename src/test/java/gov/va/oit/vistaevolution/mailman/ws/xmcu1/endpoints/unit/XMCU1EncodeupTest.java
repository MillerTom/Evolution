package gov.va.oit.vistaevolution.mailman.ws.xmcu1.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.XMCU1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.endpoints.XMCU1EncodeupEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.endpoints.interfaces.XMCU1EncodeupEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.model.XMCU1EncodeupRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmcu1.model.XMCU1EncodeupResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Unit Test for Encodeup method of XMCU1 Webservice
 */
public class XMCU1EncodeupTest extends VistaLinkContextTestParent {

	/**
	 * No Arguments Constructor
	 */
	public XMCU1EncodeupTest() {
		super();
	}

	/**
	 * <em>Test Case #1</em>
	 * 
	 * Pass in a string with embedded “^”. Return the string with any “^”
	 * characters converted to “~U~”.
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >S STRING="A^B^C^D^"
	 * 
	 * Procedure Call:
	 * >D ENCODEUP^XMWSOA01(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="A~U~B~U~C~U~D~U~"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testEncodeup001() throws VistaWebServiceFault {

		String expectedOutput = "A~U~B~U~C~U~D~U~";

		XMCU1EncodeupRequest request = new XMCU1EncodeupRequest();
		request.setInputString("A^B^C^D^");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMCU1EncodeupEndpoint service = new XMCU1EncodeupEndpointImpl(
				new XMCU1ResponseFactory(), getVistaLinkContext());

		XMCU1EncodeupResponse response = service.encodeup(request);

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
	 * >D ENCODEUP^XMWSOA01(.RETURN,STRING)
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
	public void testEncodeup002() throws VistaWebServiceFault {

		String expectedOutput = "-1^Error in required input";

		XMCU1EncodeupRequest request = new XMCU1EncodeupRequest();
		request.setInputString("");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMCU1EncodeupEndpoint service = new XMCU1EncodeupEndpointImpl(
				new XMCU1ResponseFactory(), getVistaLinkContext());

		XMCU1EncodeupResponse response = service.encodeup(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getResult());

	}

}
