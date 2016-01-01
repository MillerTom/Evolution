/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xm.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import gov.va.oit.vistaevolution.mailman.ws.xm.endpoints.interfaces.XMNewEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xm.model.XMNewRequest;
import gov.va.oit.vistaevolution.mailman.ws.xm.model.XMNewResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
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
public class XMNewIT extends EvolutionIT<XMNewEndpoint> {
//	0^Successful
//	-1^Error in required input
//	-1^Mailbox already exists
//	-1^Failed to create mailbox

	private final String EXPECTED_SUCCESS_MESSAGE = "0^Successful";
	private final String EXPECTED_INPUT_ERROR_MESSAGE = "-1^Error in required input";
	private final String EXPECTED_MAILBOX_EXISTS_MESSAGE = "-1^Mailbox already exists";
	@SuppressWarnings("unused")
	private final String EXPECTED_CREATE_MAILBOX_FAILED_MESSAGE = "-1^Failed to create mailbox";

	private static final Logger LOG = Logger
			.getLogger(XMNewIT.class);

	private XMNewRequest xmNewRequest;
	private XMNewResponse xmNewResponse;

	@Before
	public void setUp() {
		xmNewRequest = new XMNewRequest();
	}

	@After
	public void tearDown() {
		xmNewRequest = null;
	}

	/**
	 * Test Case #1  Success
	 * 
	 * In this test case you will set the values for xmz to empty string and xmDuz to 50.
	 * 
	 * The expected result is "0^Successful"
	 * 
	 * NOTE: IF YOU TRY TO CREATE A MAILBOX THAT HAS ALREADY BEEN CREATED THE TEST WILL FAIL
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testNew001() throws VistaWebServiceFault {
				
		xmNewRequest.setXmz("2");
		xmNewRequest.setXmDuz("1");

		xmNewResponse = service.xmnew(xmNewRequest);
			LOG.debug("Called " + service.toString() + 
						"\n with request " + xmNewRequest.toString());
			
		assertNotNull(xmNewResponse);
			LOG.debug("Expected: " + EXPECTED_SUCCESS_MESSAGE + ", Returned: " + xmNewResponse.getResults());
			
			LOG.debug("request:" + xmNewRequest);
			LOG.debug("response:" + xmNewResponse);
		
		if(EXPECTED_SUCCESS_MESSAGE.equals(xmNewResponse.getResults()))
		{
			assertEquals(EXPECTED_SUCCESS_MESSAGE, xmNewResponse.getResults());;
		}
		else
		{
				LOG.debug("Technically this is a failed test with the expected error message of : '" + xmNewResponse.getResults() + 
							"', \n yet, due to currently not being able to delete a designated mailbox, this test is set to fail from the start.");
			assertEquals(EXPECTED_MAILBOX_EXISTS_MESSAGE, xmNewResponse.getResults());
		}

	}
	
	/**
	 * Test Case #2  Mailbox Exists
	 * 
	 * In this test case you will set the values for xmz to 1 and xmDuz to 50.
	 * 
	 * The expected result is "-1^Mailbox already exists"
	 * 
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testNew002() throws VistaWebServiceFault {
		xmNewRequest.setXmz("1");
		xmNewRequest.setXmDuz("1");

		xmNewResponse = service.xmnew(xmNewRequest);
			LOG.debug("Called " + service.toString() + 
						"\n with request " + xmNewRequest.toString());
		
		assertNotNull(xmNewResponse);
			LOG.debug("Expected: " + EXPECTED_SUCCESS_MESSAGE + ", Returned: " + xmNewResponse.getResults());
			
		assertEquals(EXPECTED_MAILBOX_EXISTS_MESSAGE, xmNewResponse.getResults());

	}

	/**
	 * Test Case #3  Required Input missing
	 * 
	 * In this test case you will set the values for xmz to 3.7 and xmDuz to empty string.
	 * 
	 * The expected result is "-1^Error in required input"
	 * 
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testNew003() throws VistaWebServiceFault {
		xmNewRequest.setXmz("3.7");
		xmNewRequest.setXmDuz("");

		xmNewResponse = service.xmnew(xmNewRequest);
			LOG.debug("Called " + service.toString() + 
				"\n with request " + xmNewRequest.toString());
		
		assertNotNull(xmNewResponse);
			LOG.debug("Expected: " + EXPECTED_SUCCESS_MESSAGE + ", Returned: " + xmNewResponse.getResults());
		assertEquals(EXPECTED_INPUT_ERROR_MESSAGE, xmNewResponse.getResults());

	}

	/**
	 * Test Case #4  Invalid Input 
	 * 
	 * In this test case you will set the values for xmz to empty string and xmDuz to ABC.
	 * 
	 * The expected result is "-1^Error in required input"
	 * 
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testNew004() throws VistaWebServiceFault {
		xmNewRequest.setXmz("");
		xmNewRequest.setXmDuz("ABC");

		xmNewResponse = service.xmnew(xmNewRequest);
			LOG.debug("Called " + service.toString() + 
					"\n with request " + xmNewRequest.toString());
		assertNotNull(xmNewResponse);
			LOG.debug("Expected: " + EXPECTED_SUCCESS_MESSAGE + ", Returned: " + xmNewResponse.getResults());
		
		assertEquals(EXPECTED_INPUT_ERROR_MESSAGE, xmNewResponse.getResults());

	}

	/**
	 * Test Case #5  Invalid Input 
	 * 
	 * In this test case you will set the values for xmz to 1 and xmDuz to ABC.
	 * 
	 * The expected result is "-1^Error in required input"
	 * 
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testNew005() throws VistaWebServiceFault {
		xmNewRequest.setXmz("1");
		xmNewRequest.setXmDuz("ABC");

		xmNewResponse = service.xmnew(xmNewRequest);
			LOG.debug("Called " + service.toString() + 
				"\n with request " + xmNewRequest.toString());
			
		assertNotNull(xmNewResponse);
			LOG.debug("Expected: " + EXPECTED_SUCCESS_MESSAGE + ", Returned: " + xmNewResponse.getResults());
		assertEquals(EXPECTED_INPUT_ERROR_MESSAGE, xmNewResponse.getResults());

	}
	
	//Internal Test helper class to return the endpoint.
	protected Class<XMNewEndpoint> getType()
	{
		return XMNewEndpoint.class;
	}
}
