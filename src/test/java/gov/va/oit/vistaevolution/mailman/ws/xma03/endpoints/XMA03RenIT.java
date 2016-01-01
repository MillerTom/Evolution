/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xma03.endpoints;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import gov.va.oit.vistaevolution.mailman.ws.xma03.endpoints.interfaces.XMA03RenEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xma03.model.XMA03RenRequest;
import gov.va.oit.vistaevolution.mailman.ws.xma03.model.XMA03RenResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Leisa Martella
 *
 */
//	-1^Error in required input
//	 0^Resequenced from 1 to n
//	 0^No Action Taken
public class XMA03RenIT extends EvolutionIT<XMA03RenEndpoint> {

	private final String EXPECTED_SUCCESS_MESSAGE = "0^Resequenced from 1 to";
	private final String EXPECTED_NO_ACTION_MESSAGE = "0^No Action Taken";
	private final String EXPECTED_FAILURE_MESSAGE ="-1^Error in required input";

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XMA03RenIT.class);

	private XMA03RenRequest xma03RenRequest;
	private XMA03RenResponse xma03RenResponse;

	@Before
	public void setUp() {
		xma03RenRequest = new XMA03RenRequest();
	}

	@After
	public void tearDown() {
		xma03RenRequest = null;
	}

	/**
	 * Test Case #1  No Action Taken
	 * 
	 * In this test case you will set the values for xmk to 3 and xmDuz to 53468.
	 * 
	 * The expected result from routine is:
	 *
	 * >D REN^XMWSOA01(.RESULT,.5,99999)
	 * 
	 *  >ZW RESULT
	 *  RESULT="0^No Action Taken"
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRen001() throws VistaWebServiceFault {
		
		
		xma03RenRequest.setXmDuz("99999");
		xma03RenRequest.setXmk(".5");

		// Execute request against mocked object backend.
		xma03RenResponse = service.ren(xma03RenRequest);

		assertNotNull(xma03RenResponse);
		String failMsg = String.format("Expected string to contain: %s, Actual string: %s", EXPECTED_NO_ACTION_MESSAGE, xma03RenResponse.getResults());
		assertTrue(failMsg, xma03RenResponse.getResults().contains(EXPECTED_NO_ACTION_MESSAGE));
	}
	/**
	 * Test Case #2  Error in required Input
	 * 
	 * >D REN^XMWSOA01(.RESULT,.5,)
	 * 
	 * >ZW RESULT
	 * RESULT="-1^Error in required input"
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRen002() throws VistaWebServiceFault {


		xma03RenRequest.setXmDuz("");
		xma03RenRequest.setXmk(".5");

		// Execute request against mocked object backend.
		xma03RenResponse = service.ren(xma03RenRequest);

		assertNotNull(xma03RenResponse);
		String failMsg = String.format("Expected string to contain: %s, Actual string: %s", EXPECTED_FAILURE_MESSAGE, xma03RenResponse.getResults());
		assertTrue(failMsg, xma03RenResponse.getResults().contains(EXPECTED_FAILURE_MESSAGE));
	}

	/**
	 * Test Case #3  Successful
	 * 
	 * >D REN^XMWSOA01(.RESULT.5,1)
	 * 
	 * ZW RESULT
	 * RESULT="0^Resequenced from 1 to 247."
	 *	
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRen003() throws VistaWebServiceFault {
		xma03RenRequest.setXmDuz("1");
		xma03RenRequest.setXmk(".5");

		// Execute request against mocked object backend.
		xma03RenResponse = service.ren(xma03RenRequest);

		assertNotNull(xma03RenResponse);
		String failMsg = String.format("Expected string to contain: '%s', Actual string: %s", EXPECTED_SUCCESS_MESSAGE, xma03RenResponse.getResults());
		assertTrue(failMsg, xma03RenResponse.getResults().contains(EXPECTED_SUCCESS_MESSAGE));
	}

	/**
	 * Test Case #4  Success
	 * 
	 * >D REN^XMWSOA01(.RESULT,1,.5)
	 * 
	 * >ZW RESULT
	 * RESULT="0^Resequenced from 1 to 0."
	 *  
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRen004() throws VistaWebServiceFault {
		xma03RenRequest.setXmDuz("1");
		xma03RenRequest.setXmk(".5");

		// Execute request against mocked object backend.
		xma03RenResponse = service.ren(xma03RenRequest);

		assertNotNull(xma03RenResponse);
		String failMsg = String.format("Expected string to contain: '%s', Actual string: %s", EXPECTED_SUCCESS_MESSAGE, xma03RenResponse.getResults());
		assertTrue(failMsg, xma03RenResponse.getResults().contains(EXPECTED_SUCCESS_MESSAGE));
	}
	
	//Internal Test helper class to return the endpoint.
	protected Class<XMA03RenEndpoint> getType()
	{
		return XMA03RenEndpoint.class;
	}

}
