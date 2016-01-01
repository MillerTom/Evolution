/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.XMXUTIL1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.XMXUtil1MaxBlankEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUtil1MaxBlankEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUtil1MaxBlankRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUtil1MaxBlankResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
public class XMLUTIL1MaxBlankTest extends VistaLinkContextTestParent {

	private XMXUtil1MaxBlankRequest request;
	private XMXUtil1MaxBlankEndpoint service;

	public XMLUTIL1MaxBlankTest() {
		super();
	}

	@Before
	public void setup() {
		service = new XMXUtil1MaxBlankEndpointImpl(getVistaLinkContext(), new XMXUTIL1ResponseFactory());
		request = new XMXUtil1MaxBlankRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * <em> Remove consecutive spaces from an input string </em>
	 * 
	 * <pre>
	 * Input Data:
	 * >Set INSTRING=”Multiple spaces    in middle of string”
	 * 
	 * Procedure Call:
	 * 
	 * > D MAXBLANK^XMWSOA07(.DATA,INSTRING)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DATA
	 * DATA="Multiple spaces  in middle of string"
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRemoveConsecutiveSpaces() throws VistaWebServiceFault {
		String expectedResult = "Multiple spaces  in middle of string";

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(expectedResult);

		request.setInput("Multiple spaces    in middle of string");
		XMXUtil1MaxBlankResponse response = service.maxBlank(request);

		assertNotNull(response);
		assertEquals(expectedResult, response.getCorrectedResult());
	}

	/**
	 * <em>Empty string passed into the function returns an error </em>
	 * 
	 * <pre>
	 * Input Data:
	 * >Set INSTRING=””
	 * 
	 * Procedure Call:
	 * 
	 * > D MAXBLANK^XMWSOA07(.DATA,INSTRING)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DATA
	 * DATA="-1^Error in required input"
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testEmptyString() throws VistaWebServiceFault {
		String expectedResult = "-1^Error in required input";

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(expectedResult);

		request.setInput("");

		XMXUtil1MaxBlankResponse response = service.maxBlank(request);

		assertNotNull(response);
		assertNull(response.getCorrectedResult());
		assertNotNull(response.getErrors());
		assertEquals(expectedResult.split("\\^")[0], response.getStatus());
		assertEquals(expectedResult.split("\\^")[1], response.getErrors().get(0));

	}

	/**
	 * <em>Leading 3 spaces passed into the function </em>
	 * 
	 * <pre>
	 * Input Data:
	 * >Set INSTRING=”   Leading spaces”
	 * 
	 * Procedure Call:
	 * 
	 * > D MAXBLANK^XMWSOA07(.DATA,INSTRING)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DATA
	 * DATA="  Leading spaces"
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRemoveLeadingSpaces() throws VistaWebServiceFault {
		String expectedResult = "  Leading spaces";

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(expectedResult);

		request.setInput("   Leading spaces");
		XMXUtil1MaxBlankResponse response = service.maxBlank(request);

		assertNotNull(response);
		assertEquals(expectedResult, response.getCorrectedResult());
	}

	/**
	 * <em>Trailing Spaces string passed into the function </em>
	 * 
	 * <pre>
	 * Input Data:
	 * >Set INSTRING=”Trailing spaces   ”
	 * 
	 * Procedure Call:
	 * 
	 * > D MAXBLANK^XMWSOA07(.DATA,INSTRING)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DATA
	 * DATA="Trailing spaces  "
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRemoveTrailingSpaces() throws VistaWebServiceFault {
		String expectedResult = "Trailing spaces  ";

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(expectedResult);

		request.setInput("Trailing spaces   ");
		XMXUtil1MaxBlankResponse response = service.maxBlank(request);

		assertNotNull(response);
		assertEquals(expectedResult, response.getCorrectedResult());
	}

	/**
	 * <em>String only containing 3 spaces passed into the function </em>
	 * 
	 * <pre>
	 * Input Data:
	 * >Set INSTRING=”   ”
	 * 
	 * Procedure Call:
	 * 
	 * > D MAXBLANK^XMWSOA07(.DATA,INSTRING)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DATA
	 * DATA="  "
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRemoveOnlySpaces() throws VistaWebServiceFault {
		String expectedResult = "  ";

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(expectedResult);

		request.setInput("   ");
		XMXUtil1MaxBlankResponse response = service.maxBlank(request);

		assertNotNull(response);
		assertEquals(expectedResult, response.getCorrectedResult());
	}

	/**
	 * <em>String leading, middle and trailing spaces passed into the function </em>
	 * 
	 * <pre>
	 * Input Data:
	 * >Set INSTRING=”   Leading   Middle   Trailing   ”
	 * 
	 * Procedure Call:
	 * 
	 * > D MAXBLANK^XMWSOA07(.DATA,INSTRING)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DATA
	 * DATA="  Leading  Middle  Trailing  "
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRemoveLeadingMiddleTrailing() throws VistaWebServiceFault {
		String expectedResult = "  ";

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(expectedResult);

		request.setInput("   ");
		XMXUtil1MaxBlankResponse response = service.maxBlank(request);

		assertNotNull(response);
		assertEquals(expectedResult, response.getCorrectedResult());
	}
}
