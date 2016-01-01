/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusrb2.endpoints;


import gov.va.oit.vistaevolution.kernel.ws.xusrb2.endpoints.interfaces.DivGetXUSRB2Endpoint;
import gov.va.oit.vistaevolution.kernel.ws.xusrb2.model.DivGetXUSRB2Request;
import gov.va.oit.vistaevolution.kernel.ws.xusrb2.model.DivGetXUSRB2Response;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import org.springframework.beans.factory.annotation.Autowired;

//TODO RESULTS ARE ALWAYS RETURNED 0 FIND A BETTER WAY TO TEST

/**
 * @author Stephen Combs <Stephen.Combs@synaptekcorp.com>
 *
 */
public class DivGetXUSRB2IT extends VistaLinkContextITParent {

	private static final Logger LOG = Logger.getLogger(DivGetXUSRB2IT.class);
	
	private static final String EXPECTED_ERROR_CODE= "0";
	
	
	@Autowired
	private DivGetXUSRB2Endpoint divGetXUSRB2Endpoint;

	private DivGetXUSRB2Request divGetXUSRB2Request;
	private DivGetXUSRB2Response divGetXUSRB2Response;

	@Before
	public void setUp() {
		divGetXUSRB2Request = new DivGetXUSRB2Request();
	}

	@After
	public void tearDown() {
		divGetXUSRB2Request = null;
	}
	
	/**
	 * test to check for error message if DUZ input is not defined in session
	 * 
	 * */
	@Test
	public void jTestDivGetXUSRB2001() throws VistaWebServiceFault
	{
		divGetXUSRB2Request.setIEN("0");
			LOG.debug("IEN = " + divGetXUSRB2Request.getIEN());
			
		divGetXUSRB2Response = divGetXUSRB2Endpoint.divget(divGetXUSRB2Request);
			LOG.debug("Expected response: " + EXPECTED_ERROR_CODE + ", Actual Response: " + divGetXUSRB2Response.getRet().get(0));
			
		assertEquals(EXPECTED_ERROR_CODE, divGetXUSRB2Response.getRet().get(0));
	}
	
	
	/**
	 * A test to validate that, once records are added, the new results will show up
	 * 
	 * */
	@Test
	@Ignore
	public void jTestDivGetXUSRB2002() 
	{
		DivGetXUSRB2Response response2 = new DivGetXUSRB2Response();
		try {
			divGetXUSRB2Response = divGetXUSRB2Endpoint.divget(divGetXUSRB2Request);
		} catch (VistaWebServiceFault e) {
			fail("VistaWebServiceFault was thrown by the vista link connector.");
		}
		
		//TODO Add a record - using an external service
		
		try {
			response2 = divGetXUSRB2Endpoint.divget(divGetXUSRB2Request);
		} catch (VistaWebServiceFault e) {
			fail("VistaWebServiceFault was thrown by the vista link connector.");
		}
		
		//TODO Compare # of records returned between call 1 an call 2.
		fail("Test not complete.");
	}
	
	/**
	 * A test to showing that the second parameter is meaningless
	 * 
	 * */
	@Test
	@Ignore
	public void jTestDivGetXUSRB2003()
	{
		DivGetXUSRB2Response response = null;
		DivGetXUSRB2Request request = new DivGetXUSRB2Request("52");
		try {
			divGetXUSRB2Response = divGetXUSRB2Endpoint.divget(divGetXUSRB2Request);
		} catch (VistaWebServiceFault e) {
			fail("VistaWebServiceFault was thrown by the vista link connector.");
		}

		//TODO clarify what the "second" parameter is, in regards to the RPC call. Only the result name and ien are inputs that have defined in the SDD
		fail("Test not complete.");
	}
	
	/**
	 * A test to showing that the second parameter is meaningless
	 * 
	 * */
	@Test
	@Ignore
	public void jTestDivGetXUSRB2004()
	{
		DivGetXUSRB2Response response = null;
		DivGetXUSRB2Request request = new DivGetXUSRB2Request(null);
		try {
			divGetXUSRB2Response = divGetXUSRB2Endpoint.divget(divGetXUSRB2Request);
		} catch (VistaWebServiceFault e) {
			fail("VistaWebServiceFault was thrown by the vista link connector.");
		}

		//TODO clarify what the "second" parameter is, in regards to the RPC call. Only the result name and ien are inputs that have defined in the SDD
		fail("Test not complete.");
	}
	
	/**
	 * A test to use a different duz id
	 * 
	 * */
	@Test
	@Ignore
	public void jTestDivGetXUSRB2005()
	{
		DivGetXUSRB2Response response = null;
		DivGetXUSRB2Request request = new DivGetXUSRB2Request("53");
		try {
			divGetXUSRB2Response = divGetXUSRB2Endpoint.divget(divGetXUSRB2Request);
		} catch (VistaWebServiceFault e) {
			fail("VistaWebServiceFault was thrown by the vista link connector.");
		}

		//TODO verify that a number of records are blank 
		fail("Test not complete.");
	}
	
	/**
	 * A test to show that a user with only 1 division will come up empty
	 * 
	 * */
	@Test
	@Ignore
	public void jTestDivGetXUSRB2006()
	{
		DivGetXUSRB2Response response = null;
		DivGetXUSRB2Request request = new DivGetXUSRB2Request("53468");
		try {
			divGetXUSRB2Response = divGetXUSRB2Endpoint.divget(divGetXUSRB2Request);
		} catch (VistaWebServiceFault e) {
			fail("VistaWebServiceFault was thrown by the vista link connector.");
		}
		
		//TODO validate that a record count of 0 was returned.
		fail("Test not complete.");
	}

}
