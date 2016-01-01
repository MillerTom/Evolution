/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xlfdt3.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.fileman.ws.die.endpoints.interfaces.DIEHelpEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xlfdt3.endpoints.interfaces.XLFDT3LeapEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xlfdt3.model.XLFDT3LeapRequest;
import gov.va.oit.vistaevolution.kernel.ws.xlfdt3.model.XLFDT3LeapResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Leisa Martella
 *
 */
/**
 * XU SOA LEAP
 * 
 * This RPC function checks to see if the year passed in is a leap year or not. 
 * The function returns a one if the year is a leap year otherwise it returns a zero.
 * 
 * Input Variables	
 * 		Year:	(required) Year being tested to confirm if it is a leap year or not.
 * 
 * Response
 * 		Returns 1 for a leap year, otherwise 0.
 *   
 */

public class XLFDT3LeapIT extends EvolutionIT<XLFDT3LeapEndpoint> {

	private final String EXPECTED_FALSE_RESULT ="0";
	private final String EXPECTED_TRUE_RESULT ="1";

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XLFDT3LeapIT.class);

	@Override
	protected Class<XLFDT3LeapEndpoint> getType() {
		return XLFDT3LeapEndpoint.class;
	}
	

	private XLFDT3LeapRequest request;
	private XLFDT3LeapResponse response;

	@Before
	public void setUp() {
		request = new XLFDT3LeapRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * Test Case #1  
	 * 
	 * In this test case you will set the values for year to 2014.
	 * 
	 * The expected result from RPC Broker is:
	 * 
	 *	0
	 *
	 * @throws VistaWebServiceFault
	 */
@Test
	public void testLeap001() throws VistaWebServiceFault {

		request.setYear("2014");

		// Execute request against mocked object backend.
		response = service.leap(request);

		assertNotNull(response);
		assertEquals(EXPECTED_FALSE_RESULT, response.getResults());
	}
	
	/**
	 * Test Case #2  
	 * 
	 * In this test case you will set the values for year to 2015.
	 * 
	 * The expected result from RPC Broker is:
	 * 
	 *	0
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testLeap002() throws VistaWebServiceFault {

		request.setYear("2015");

		// Execute request against mocked object backend.
		response = service.leap(request);

		assertNotNull(response);
		assertEquals(EXPECTED_FALSE_RESULT, response.getResults());
	}
	
	/**
	 * Test Case #3  
	 * 
	 * In this test case you will set the values for year to 2016.
	 * 
	 * The expected result from RPC Broker is:
	 * 
	 *	1
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testLeap003() throws VistaWebServiceFault {

		request.setYear("2016");

		// Execute request against mocked object backend.
		response = service.leap(request);

		assertNotNull(response);
		assertEquals(EXPECTED_TRUE_RESULT, response.getResults());
	}
	
	/**
	 * Test Case #4  
	 * 
	 * In this test case you will set the values for year to 2000.
	 * 
	 * The expected result from RPC Broker is:
	 * 
	 *	1
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testLeap004() throws VistaWebServiceFault {

		request.setYear("2000");

		// Execute request against mocked object backend.
		response = service.leap(request);

		assertNotNull(response);
		assertEquals(EXPECTED_TRUE_RESULT, response.getResults());
	}
	
	/**
	 * Test Case #5  
	 * 
	 * In this test case you will set the values for year to 1900.
	 * 
	 * The expected result from RPC Broker is:
	 * 
	 *	0
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testLeap005() throws VistaWebServiceFault {

		request.setYear("1900");

		// Execute request against mocked object backend.
		response = service.leap(request);

		assertNotNull(response);
		assertEquals(EXPECTED_FALSE_RESULT, response.getResults());
	}
	
	/** TODO: Find out how to set up this test case and results
	 * $$LEAP^XLFDT3()
	 * 
	 *  S:%<1700 %=%+1700
	 *  ^
	 *  <UNDEFINED>LEAP+1^XLFDT3 *%
	 *  
	 * Test Case #6  
	 * 
	 * In this test case you will set the values for year to 2004.
	 * 
	 * The expected result from RPC Broker is:
	 * 
	 *	1
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testLeap006() throws VistaWebServiceFault {

		request.setYear("2004");

		// Execute request against mocked object backend.
		response = service.leap(request);

		assertNotNull(response);
		assertEquals(EXPECTED_TRUE_RESULT, response.getResults());
	}
	
	/**
	 * Test Case #7  
	 * 
	 * In this test case you will set the values for year to NINTEEN HUNDRED.
	 * 
	 * The expected result from RPC Broker is:
	 * 
	 *	0
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testLeap007() throws VistaWebServiceFault {

		request.setYear("NINTEEN HUNDRED");

		// Execute request against mocked object backend.
		response = service.leap(request);

		assertNotNull(response);
		assertEquals(EXPECTED_FALSE_RESULT, response.getResults());
	}

}
