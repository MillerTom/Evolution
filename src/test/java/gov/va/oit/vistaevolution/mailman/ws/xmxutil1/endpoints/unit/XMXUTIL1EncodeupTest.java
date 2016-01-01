package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.unit;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.XMXUTIL1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.XMXUTIL1EncodeupEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1EncodeupEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1EncodeupRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1EncodeupResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;


/**
 * 
 * @author bill.blackmon <bill.blackmon@medshphere.comn>
 *
 */



public class XMXUTIL1EncodeupTest extends VistaLinkContextTestParent {

	private XMXUTIL1EncodeupRequest request;
	private XMXUTIL1EncodeupEndpoint service;

	public XMXUTIL1EncodeupTest() {
		super();
	}

	@Before
	public void setup() {
		service = new XMXUTIL1EncodeupEndpointImpl(getVistaLinkContext(), new XMXUTIL1ResponseFactory());
		request = new XMXUTIL1EncodeupRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * <em> Encode string with an up caret </em>
	 * 
	 * <pre>
	 * Input Data:
	 * >Set U=”^” 
	 * >Set STRING=”String Containing ^ is converted”
	 * 
	 * Procedure Call:
	 * 
	 * >ENCODEUP^XMWSOA06(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DATA
	 * RETURN="String Containing ~U~ is converted"
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testEncodeup() throws VistaWebServiceFault {

		String expectedResponse = "String Containing ~U~ is converted";

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(expectedResponse);

		request.setInput("String Containing ^ is converted");
		XMXUTIL1EncodeupResponse response = service.encodeUp(request);

		assertNotNull(response);
		assertEquals(expectedResponse, response.getResult());

	}
	
	/**
	 * <em> Encode string that does not contain an up caret </em>
	 * 
	 * <pre>
	 * Input Data:
	 * >Set U=”^” 
	 * >Set STRING=”String Containing no up caret”
	 * 
	 * Procedure Call:
	 * 
	 * >ENCODEUP^XMWSOA06(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DATA
	 * RETURN="String Containing no up caret"
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testEncodeupNoCaret() throws VistaWebServiceFault {

		String expectedResponse = "String Containing no up caret";

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(expectedResponse);

		request.setInput("String Containing no up caret");
		XMXUTIL1EncodeupResponse response = service.encodeUp(request);

		assertNotNull(response);
		assertEquals(expectedResponse, response.getResult());

	}
	
	/**
	 * <em> Encode string that is empty </em>
	 * 
	 * <pre>
	 * Input Data:
	 * >Set U=”^” 
	 * >Set STRING=””
	 * 
	 * Procedure Call:
	 * 
	 * >ENCODEUP^XMWSOA06(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DATA
	 * RETURN=""
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testEncodeupEmptyString() throws VistaWebServiceFault {

		String expectedResponse = "";

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(expectedResponse);

		request.setInput("");
		XMXUTIL1EncodeupResponse response = service.encodeUp(request);

		assertNotNull(response);
		assertEquals(expectedResponse, response.getResult());

	}
	
	/**
	 * <em> Encode string that contains an up caret </em>
	 * 
	 * <pre>
	 * Input Data:
	 * >Set U=”^” 
	 * >Set STRING=”^”
	 * 
	 * Procedure Call:
	 * 
	 * >ENCODEUP^XMWSOA06(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DATA
	 * RETURN="~U~”
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testEncodeupOnlyCaret() throws VistaWebServiceFault {

		String expectedResponse = "~U~";

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(expectedResponse);

		request.setInput("^");
		XMXUTIL1EncodeupResponse response = service.encodeUp(request);

		assertNotNull(response);
		assertEquals(expectedResponse, response.getResult());

	}
	
	/**
	 * <em> Encode string that contains multiple fields and up carets </em>
	 * 
	 * <pre>
	 * Input Data:
	 * >Set U=”^” 
	 * >Set STRING="^ONE^two^^^Five^"
	 * 
	 * Procedure Call:
	 * 
	 * >ENCODEUP^XMWSOA06(.RETURN,STRING)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DATA
	 * RETURN="~U~ONE~U~two~U~~U~~U~Five~U~"
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testEncodeupMultipleFieldsAndCarets() throws VistaWebServiceFault {

		String expectedResponse = "~U~ONE~U~two~U~~U~~U~Five~U~";

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(expectedResponse);

		request.setInput("^ONE^two^^^Five");
		XMXUTIL1EncodeupResponse response = service.encodeUp(request);

		assertNotNull(response);
		assertEquals(expectedResponse, response.getResult());

	}
	
}	// end class
