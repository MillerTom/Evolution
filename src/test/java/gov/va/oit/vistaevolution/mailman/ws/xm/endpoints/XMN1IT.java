package gov.va.oit.vistaevolution.mailman.ws.xm.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xm.endpoints.interfaces.XMN1Endpoint;
import gov.va.oit.vistaevolution.mailman.ws.xm.model.XMN1Request;
import gov.va.oit.vistaevolution.mailman.ws.xm.model.XMN1Response;

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
public class XMN1IT extends EvolutionIT<XMN1Endpoint> {
	// 0^Successful
	// -1^Error in required input
	// -1^Mailbox already exists
	// -1^Failed to create mailbox
	// -1^XMDUZ <XMDUZ> does not exist

	private final String EXPECTED_SUCCESS_MESSAGE = "0^Successful";
	private final String EXPECTED_INPUT_ERROR_MESSAGE = "-1^Error in required input";
	private final String EXPECTED_MAILBOX_EXISTS_MESSAGE = "-1^Mailbox already exists";
	@SuppressWarnings("unused")
	private final String EXPECTED_CREATE_MAILBOX_FAILED_MESSAGE = "-1^Failed to create mailbox";

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(XMN1IT.class);

	private XMN1Request xmN1Request;
	private XMN1Response xmN1Response;
//
	@Before
	public void setUp() {
		xmN1Request = new XMN1Request();
	}

	@After
	public void tearDown() {
		xmN1Request = null;
	}

	
	protected Class<XMN1Endpoint> getType()
	{
		return XMN1Endpoint.class;
	}
	
	/**
	 * Test Case #1 Success
	 * 
	 * In this test case you will set the values for xmDuz to 65 and xmz to
	 * empty string.
	 * 
	 * The expected result is "0^Successful"
	 * 
	 * NOTE: IF YOU TRY TO CREATE A MAILBOX THAT HAS ALREADY BEEN CREATED THE
	 * TEST WILL FAIL
	 * 
	 * For this test a concession will be added to check for an already existing mailbox, 
	 * due to the likelihood that this will be the case unless a designated mailbox is destroyed before each creation.
	 * A method to destroy a mailbox isn't available at this time.
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testN1001() throws VistaWebServiceFault {
		
		xmN1Request.setXmDuz("1");
		xmN1Request.setXmz("");

		xmN1Response = service.n1(xmN1Request);
		assertNotNull(xmN1Response);
		if(EXPECTED_SUCCESS_MESSAGE.equals(xmN1Response.getResults()))
		{
			assertEquals(EXPECTED_SUCCESS_MESSAGE, xmN1Response.getResults());
		}
		else
		{
			assertEquals(EXPECTED_MAILBOX_EXISTS_MESSAGE, xmN1Response.getResults());
		}
	}

	/**
	 * Test Case #2 Success
	 * 
	 * In this test case you will set the values for xmDuz to 53 and xmz to 1.
	 * 
	 * The expected result is "0^Successful"
	 * 
	 * NOTE: IF YOU TRY TO CREATE A MAILBOX THAT HAS ALREADY BEEN CREATED THE
	 * TEST WILL FAIL
	 * 
	 * For this test a concession will be added to check for an already existing mailbox, 
	 * due to the likelihood that this will be the case unless a designated mailbox is destroyed before each creation.
	 * A method to destroy a mailbox isn't available at this time.
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testN1002() throws VistaWebServiceFault {
		xmN1Request.setXmDuz("1");
		xmN1Request.setXmz("1");

		xmN1Response = service.n1(xmN1Request);
		assertNotNull(xmN1Response);
		
		if(EXPECTED_SUCCESS_MESSAGE.equals(xmN1Response.getResults()))
		{
			assertEquals(EXPECTED_SUCCESS_MESSAGE, xmN1Response.getResults());
		}
		else
		{
			assertEquals(EXPECTED_MAILBOX_EXISTS_MESSAGE, xmN1Response.getResults());
		}

	}

	/**
	 * Test Case #3 Missing Required Input
	 * 
	 * In this test case you will set the values for xmDuz to empty string and
	 * xmz to 1.
	 * 
	 * The expected result is "-1^Error in required input"
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testN1003() throws VistaWebServiceFault {
		xmN1Request.setXmDuz("");
		xmN1Request.setXmz("1");

		xmN1Response = service.n1(xmN1Request);
		assertNotNull(xmN1Response);
		assertEquals(EXPECTED_INPUT_ERROR_MESSAGE, xmN1Response.getResults());
	}

	/**
	 * Test Case #4 Invalid Input
	 * 
	 * In this test case you will set the values for xmDuz to XCV and xmz to
	 * empty string.
	 * 
	 * The expected result is "-1^Error in required input"
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testN1004() throws VistaWebServiceFault {
		xmN1Request.setXmDuz("XCV");
		xmN1Request.setXmz("");

		xmN1Response = service.n1(xmN1Request);
		assertNotNull(xmN1Response);
		assertEquals(EXPECTED_INPUT_ERROR_MESSAGE, xmN1Response.getResults());

	}

	/**
	 * Test Case #5 Invalid Input
	 * 
	 * In this test case you will set the values for xmDuz to ABCD and xmz to 1.
	 * 
	 * The expected result is "-1^Error in required input"
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testN1005() throws VistaWebServiceFault {
		xmN1Request.setXmDuz("ABCD");
		xmN1Request.setXmz("1");

		xmN1Response = service.n1(xmN1Request);
		assertNotNull(xmN1Response);
		assertEquals(EXPECTED_INPUT_ERROR_MESSAGE, xmN1Response.getResults());

	}

	/**
	 * Test Case #6 Mailbox Already Exists
	 * 
	 * In this test case you will set the values for xmDuz to 53468 and xmz to
	 * 1.
	 * 
	 * The expected result is "-1^Mailbox already exists"
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testN1006() throws VistaWebServiceFault {
		xmN1Request.setXmDuz("1");
		xmN1Request.setXmz("1");

		xmN1Response = service.n1(xmN1Request);
		assertNotNull(xmN1Response);
		assertEquals(EXPECTED_MAILBOX_EXISTS_MESSAGE, xmN1Response.getResults());
	}

	/**
	 * Test Case #7 DUZ does not exist
	 * 
	 * In this test case you will set the values for xmDuz to 6546542 and xmz to
	 * 1.
	 * 
	 * The expected result is "-1^XMDUZ 6546542 does not exist"
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testN1007() throws VistaWebServiceFault {
		xmN1Request.setXmDuz("6546542");
		xmN1Request.setXmz("1");

		xmN1Response = service.n1(xmN1Request);
		assertNotNull(xmN1Response);
		assertEquals("-1^XMDUZ 6546542 does not exist",
				xmN1Response.getResults());

	}
}
