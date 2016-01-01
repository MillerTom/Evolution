/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmut7.endpoints;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import gov.va.oit.vistaevolution.mailman.ws.xmut7.endpoints.interfaces.XMUT7EntEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmut7.model.XMUT7EntRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmut7.model.XMUT7EntResponse;
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
public class XMUT7EntIT extends VistaLinkContextITParent {

	private final String EXPECTED_SUCCESS_RESULT ="Success";
	private final String EXPECTED_FAILURE_RESULT ="Failed";

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XMUT7EntIT.class);

	@Autowired
	private XMUT7EntEndpoint xmut7EntEndpoint;

	private XMUT7EntRequest xmut7EntRequest;
	private XMUT7EntResponse xmut7EntResponse;

	@Before
	public void setUp() {
		xmut7EntRequest = new XMUT7EntRequest();
	}

	@After
	public void tearDown() {
		xmut7EntRequest = null;
	}

	/**
	 * Test Case #1  Success
	 *
	 * D ENT^XMUT7(53469)
	 * 
	 * Note: this test was run on a VA development system, because it had 
	 * everything set up to communicate to the world.
	 * 
	 * Receive an email
	 * From: POSTMASTER@CARVDD.FO-ALBANY.MED.VA.GOV
	 * [mailto:POSTMASTER@CARVDD.FO-ALBANY.MED.VA.GOV] 
	 * 
	 * Sent: Friday, December 13, 2013 10:47 AM
	 * 
	 * To: User; POSTMASTER@CARVDD.FO-ALBANY.MED.VA.GOV
	 * Subject: Test new forwarding address for TEST,USER
	 * 
	 * This is a test to confirm that the forwarding address
	 * 
	 * TEST.USER@VA.GOV belonging to USER,TEST does not generate an error.
	 * 
	 * Please ignore this message.
	 *
	 * @throws VistaWebServiceFault
	 */
@Test
	public void testEnt001() throws VistaWebServiceFault {
		
		xmut7EntRequest.setDuz("53469");

		xmut7EntResponse = xmut7EntEndpoint.ent(xmut7EntRequest);
		assertNotNull(xmut7EntResponse);
		String failMsg = String.format("Expected string to contain: %s, Actual string: %s", EXPECTED_SUCCESS_RESULT, xmut7EntResponse.getResults());
		assertTrue(failMsg, xmut7EntResponse.getResults().contains(EXPECTED_SUCCESS_RESULT));

		// Fail
		fail("Failed due to internal error in running the XMUT7 Ent Service.");
	}

	/**
	 * Test Case #2 
	 *
	 * >D ENT^XMUT7(534609)
	 * 
	 * S XMPARM(2)=$P(^XMB(3.7,XMUSER,0),U,2) Q:XMPARM(2)=""
	 * 
	 *  ^
	 *  <UNDEFINED>ENT+6^XMUT7 ^XMB(3.7,534609,0)
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testEnt002() throws VistaWebServiceFault {
		
		xmut7EntRequest.setDuz("534609");
	
		xmut7EntResponse = xmut7EntEndpoint.ent(xmut7EntRequest);
		assertNotNull(xmut7EntResponse);
		String failMsg = String.format("Expected string to contain: %s, Actual string: %s", EXPECTED_SUCCESS_RESULT, xmut7EntResponse.getResults());
		assertTrue(failMsg, xmut7EntResponse.getResults().contains(EXPECTED_SUCCESS_RESULT));
	
		// Fail
		fail("Failed due to internal error in running the XMUT7 Ent Service.");
	}

	/**
	 * Test Case #3
	 *
	 * >D ENT^XMUT7()
	 * 
	 * S XMPARM(1)=$$NAME^XMXUTIL(XMUSER)
	 *  ^
	 *  <UNDEFINED>ENT+5^XMUT7 *XMUSER
	 *
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testEnt003() throws VistaWebServiceFault {
		
		xmut7EntRequest.setDuz("");
	
		xmut7EntResponse = xmut7EntEndpoint.ent(xmut7EntRequest);
		assertNotNull(xmut7EntResponse);
		String failMsg = String.format("Expected string to contain: %s, Actual string: %s", EXPECTED_FAILURE_RESULT, xmut7EntResponse.getResults());
		assertTrue(failMsg, xmut7EntResponse.getResults().contains(EXPECTED_FAILURE_RESULT));
	
		// Fail
		fail("Failed due to internal error in running the XMUT7 Ent Service.");
	}

	/**
	 * Test Case #4
	 *
	 * >D ENT^XMUT7(53466)
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testEnt004() throws VistaWebServiceFault {
		
		xmut7EntRequest.setDuz("53466");
	
		xmut7EntResponse = xmut7EntEndpoint.ent(xmut7EntRequest);
		assertNotNull(xmut7EntResponse);
		String failMsg = String.format("Expected string to contain: %s, Actual string: %s", EXPECTED_SUCCESS_RESULT, xmut7EntResponse.getResults());
		assertTrue(failMsg, xmut7EntResponse.getResults().contains(EXPECTED_SUCCESS_RESULT));
	
		// Fail
		fail("Failed due to internal error in running the XMUT7 Ent Service.");
	}

}
