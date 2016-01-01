package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1GMTDiffEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1GMTDiffRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1GMTDiffResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class XMXUTIL1GMTDiffTestIT extends EvolutionIT<XMXUTIL1GMTDiffEndpoint> {

	XMXUTIL1GMTDiffRequest request;

	@Before
	public void setUp() {
		request = new XMXUTIL1GMTDiffRequest();

	}

	@After
	public void tearDown() {
		request = null;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT#getType()
	 */
	@Override
	protected Class<XMXUTIL1GMTDiffEndpoint> getType() {
		return XMXUTIL1GMTDiffEndpoint.class;
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

		String expectedResponse = "Error in required input";
		String expectedStatus = "-1";

		request.setTZ("");

		XMXUTIL1GMTDiffResponse response = service.gmtDiff(request);

		assertNotNull(response);
		assertEquals(1, response.getErrors().size());
		assertEquals(expectedStatus, response.getStatus());
		assertEquals(expectedResponse, response.getErrors().get(0));
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

		request.setTZ("AAA");
		XMXUTIL1GMTDiffResponse response = service.gmtDiff(request);

		assertNotNull(response);
		assertEquals(expectedResponse, response.getResult());

	}


	

}
