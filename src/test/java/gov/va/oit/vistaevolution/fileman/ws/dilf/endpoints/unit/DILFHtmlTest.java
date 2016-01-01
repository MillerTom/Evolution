package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.fileman.ws.dilf.DILFResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.DILFHtmlEndpointImpl;
import gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.DILFHtmlEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFHtmlRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFHtmlResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author Bill Blackmon <Bill.blackmon@medsphere.com>
 * 
 * 
 
 */
public class DILFHtmlTest extends VistaLinkContextTestParent {
	DILFHtmlRequest request;
	DILFHtmlEndpoint service;

	@Before
	public void setUp() {
		request = new DILFHtmlRequest();
		service = new DILFHtmlEndpointImpl(new DILFResponseFactory(), getVistaLinkContext());

	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * <em>Encoding a string that contains a “^” character</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >SET DDR(“STRING”)="NAME^JANE DOE"
	 * >SET DDR(“ACTION”)=1
	 * 
	 * Procedure Call:
	 * 
	 * >D HTMLR^DDR5(.DDRDATA,.DDR)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DDRDATA
	 * DDRDATA=”NAME&#94;JANE DOE”
	 * </pre>
	 * 
	 */
	@Test
	public void testEncodeCaret() throws VistaWebServiceFault {
		String testResponse = "NAME&#94;JANE DOE";

		request.setAaction("1");
		request.setString("NAME^JANE DOE");

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(testResponse);

		DILFHtmlResponse response = service.html(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getData());

	}			
	
	/**
	 * <em>Decoding a string that contains a “^” character</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >SET DDR(“STRING”)="NAME&#94;JANE DOE"
	 * >SET DDR(“ACTION”)=-1
	 * 
	 * Procedure Call:
	 * 
	 * >D HTMLR^DDR5(.DDRDATA,.DDR)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DDRDATA
	 * DDRDATA=”NAME^JANE DOE”
	 * </pre>
	 * 
	 */
	@Test
	public void testDecodeCaret() throws VistaWebServiceFault {
		String testResponse = "NAME^JANE DOE";

		request.setAaction("-1");
		request.setString("NAME&#94;JANE DOE");

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(testResponse);

		DILFHtmlResponse response = service.html(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getData());

	}			
	
	
	/**
	 * <em>Attempting to decode an decoded string</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >SET DDR(“STRING”)="NAME^JANE DOE"
	 * >SET DDR(“ACTION”)=-1
	 * 
	 * Procedure Call:
	 * 
	 * >D HTMLR^DDR5(.DDRDATA,.DDR)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DDRDATA
	 * DDRDATA=”NAME^JANE DOE”
	 * </pre>
	 * 
	 */
	@Test
	public void testDecodeDecoded() throws VistaWebServiceFault {
		String testResponse = "NAME^JANE DOE";

		request.setAaction("-1");
		request.setString("NAME^JANE DOE");

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(testResponse);

		DILFHtmlResponse response = service.html(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getData());

	}			
	
	/**
	 * <em>- Attempting to encode an already encoded string</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >SET DDR(“STRING”)="NAME&#94;JANE DOE"
	 * >SET DDR(“ACTION”)=1
	 * 
	 * Procedure Call:
	 * 
	 * >D HTMLR^DDR5(.DDRDATA,.DDR)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DDRDATA
	 * DDRDATA=”NAME&amp;#94;JANE DOE”
	 * </pre>
	 * 
	 */
	@Test
	public void testEncodeEncoded() throws VistaWebServiceFault {
		String testResponse = "NAME&amp;#94;JANE DOE";

		request.setAaction("1");
		request.setString("NAME&#94;JANE DOE");

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(testResponse);

		DILFHtmlResponse response = service.html(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getData());

	}			
	
	/**
	 * <em>Attempting to encode a string > 255 characters</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >SET DDR(“STRING”)="P($G(^ICD9(12443,1)),"^")_"^"_$P($G(^ICD9(12443,68,3,1)),"^")"
	 * >SET DDR(“ACTION”)=1
	 * 
	 * Procedure Call:
	 * 
	 * >D HTMLR^DDR5(.DDRDATA,.DDR)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DDRDATA
	 * DDRDATA=””
	 * </pre>
	 * 
	 */
	@Test
	public void testEncode255() throws VistaWebServiceFault {
		String testResponse = "P($G(^ICD9(12443,1)),\"^\")_\"^\"_$P($G(^ICD9(12443,68,3,1)),\"^\")";

		request.setAaction("1");
		request.setString("");

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(testResponse);

		DILFHtmlResponse response = service.html(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getData());

	}			
	
	/**
	 * <em>Attempting to encode a NULL string</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >SET DDR(“STRING”)=""
	 * >SET DDR(“ACTION”)=1
	 * 
	 * Procedure Call:
	 * 
	 * >D HTMLR^DDR5(.DDRDATA,.DDR)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DDRDATA
	 * DDRDATA=””
	 * </pre>
	 * 
	 */
	@Test
	public void testEncodeNullString() throws VistaWebServiceFault {
		String testResponse = "";

		request.setAaction("1");
		request.setString("");

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(testResponse);

		DILFHtmlResponse response = service.html(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getData());

	}			
	
	/**
	 * <em>Attempting to decode a NULL string</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >SET DDR(“STRING”)=""
	 * >SET DDR(“ACTION”)=-1
	 * 
	 * Procedure Call:
	 * 
	 * >D HTMLR^DDR5(.DDRDATA,.DDR)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DDRDATA
	 * DDRDATA=””
	 * </pre>
	 * 
	 */
	@Test
	public void testDecodeNullString() throws VistaWebServiceFault {
		String testResponse = "";

		request.setAaction("-1");
		request.setString("");

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(testResponse);

		DILFHtmlResponse response = service.html(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getData());

	}		
	
	/**
	 * <em>Attempting to encode a string > 255 characters</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >SET DDR(“STRING”)="P($G(^ICD9(12443,1)),"^")_"^"_$P($G(^ICD9(12443,68,3,1)),"^")"
	 * >SET DDR(“ACTION”)=1
	 * 
	 * Procedure Call:
	 * 
	 * >D HTMLR^DDR5(.DDRDATA,.DDR)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DDRDATA
	 * DDRDATA=””
	 * </pre>
	 * 
	 */
	@Test
	public void testDecode255() throws VistaWebServiceFault {
		String testResponse = "P($G(^ICD9(12443,1)),\"^\")_\"^\"_$P($G(^ICD9(12443,68,3,1)),\"^\")";

		request.setAaction("-1");
		request.setString("");

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(testResponse);

		DILFHtmlResponse response = service.html(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getData());

	}			
	
	
}	// end class
