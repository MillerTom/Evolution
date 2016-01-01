package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.XMXUTIL1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.XMXUTIL1GMTDiffEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1GMTDiffEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1GMTDiffRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1GMTDiffResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.After;
import org.junit.Before;
// import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * 
 * @author bill.blackmon <bill.blackmon@medshphere.com>
 * 
 *         Taken from document 1.1.1 $$GMTDIFF^XMXUTIL1(): Retrieve GMT offset
 **/

public class XMXUTIL1GMTDiffTest extends VistaLinkContextTestParent {

	private XMXUTIL1GMTDiffRequest request;
	private XMXUTIL1GMTDiffEndpoint service;

	public XMXUTIL1GMTDiffTest() {
		super();
	}

	@Before
	public void setup() {
		service = new XMXUTIL1GMTDiffEndpointImpl(getVistaLinkContext(), new XMXUTIL1ResponseFactory());
		request = new XMXUTIL1GMTDiffRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * <em> Retrieve GMT offset for Eastern Standard Time </em>
	 * 
	 * <pre>
	 * Input Data:
	 * >Set U=”^” 
	 * >Set TZ=”EST”
	 * 
	 * Procedure Call:
	 * 
	 * >D GMTDIFF^XMWSOA06(.RETURN, TZ)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DATA
	 * RETURN="-0500"
	 * </pre>
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGMTDiffEST() throws VistaWebServiceFault {

		String expectedResponse = "-0500";

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(expectedResponse);

		request.setTZ("EST");
		XMXUTIL1GMTDiffResponse response = service.gmtDiff(request);

		assertNotNull(response);
		assertEquals(expectedResponse, response.getResult());

	}

	/**
	 * <em> Retrieve GMT offset for Eastern Daylight Time </em>
	 * 
	 * <pre>
	 * Input Data:
	 * >Set U=”^” 
	 * >Set TZ=”EDT”
	 * 
	 * Procedure Call:
	 * 
	 * >D GMTDIFF^XMWSOA06(.RETURN, TZ)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DATA
	 * RETURN="-0400"
	 * </pre>
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGMTDiffEDT() throws VistaWebServiceFault {

		String expectedResponse = "-0400";

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(expectedResponse);

		request.setTZ("EDT");
		XMXUTIL1GMTDiffResponse response = service.gmtDiff(request);

		assertNotNull(response);
		assertEquals(expectedResponse, response.getResult());

	}

	/**
	 * <em> Retrieve GMT offset for an empty string timezone. </em>
	 * 
	 * <pre>
	 * Input Data:
	 * >Set U=”^” 
	 * >Set TZ=””
	 * 
	 * Procedure Call:
	 * 
	 * >D GMTDIFF^XMWSOA06(.RETURN, TZ)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DATA
	 * RETURN="-1^Error in required input"
	 * </pre>
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGMTDiffEmptyTimezone() throws VistaWebServiceFault {

		String expectedResponse = "-1^Error in required input";


		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(expectedResponse);

		request.setTZ("");

		XMXUTIL1GMTDiffResponse response = service.gmtDiff(request);

		assertNotNull(response);
		assertEquals(1, response.getErrors().size());
		assertEquals(expectedResponse.split("\\^")[1], response.getErrors().get(0));
		assertEquals(expectedResponse.split("\\^")[0], response.getStatus());
		assertEquals(null, response.getResult());
	}

	/**
	 * <em> Retrieve GMT offset for a non-existent timezone. </em>
	 * 
	 * <pre>
	 * Input Data:
	 * >Set U=”^” 
	 * >Set TZ=””
	 * 
	 * Procedure Call:
	 * 
	 * >D GMTDIFF^XMWSOA06(.RETURN, TZ)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DATA
	 * RETURN="-1^Error in required input"
	 * </pre>
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGMTDiffInvalidTimezone() throws VistaWebServiceFault {

		String expectedResponse = "";

		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(expectedResponse);

		request.setTZ("AAA");
		XMXUTIL1GMTDiffResponse response = service.gmtDiff(request);

		assertNotNull(response);
		assertEquals(expectedResponse, response.getResult());

	}

}
