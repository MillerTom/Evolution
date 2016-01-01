/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuser2.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.kernel.ws.xuser2.endpoints.interfaces.XUSER2GetUpnEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuser2.model.XUSER2GetUpnRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuser2.model.XUSER2GetUpnResponse;
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
/**
 * XUS PKI GET UPN
 * 
 * This RPC gets the SUBJECT ALTERNATIVE NAME field from the New Person (#200) 
 * file field 501.2.  It is used to check that the correct PIV card has been 
 * put into the reader. 
 * 
 * Input Parameters:
 *   None
 * 
 * Returns:
 *   String Subject Alternative Name field
 *   
 */

public class XUSER2GetUpnIT extends EvolutionIT<XUSER2GetUpnEndpoint> {

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(XUSER2GetUpnIT.class);

	private XUSER2GetUpnRequest xuser2GetUpnRequest;
	private XUSER2GetUpnResponse xuser2GetUpnResponse;

	@Before
	public void setUp() {
		xuser2GetUpnRequest = new XUSER2GetUpnRequest();
	}

	@After
	public void tearDown() {
		xuser2GetUpnRequest = null;
	}
	
	protected Class<XUSER2GetUpnEndpoint> getType()
	{
		return XUSER2GetUpnEndpoint.class;
	}

	/** TODO: Need to figure out how to set DUZ (Leisa)
	 * Test Case #1  DUZ=53473
	 * 
	 * There are no input parameters for this method
	 * 
	 *  The expected result from RPC Broker is:
	 *  
	 *  RESULT="TEST@TEST"
	 *	
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testGetUpn001() throws VistaWebServiceFault {
		String testResult = "ONE@PROGRAMMER1";
		xuser2GetUpnRequest.setDuz("1");
		
		xuser2GetUpnResponse = service.getUpn(xuser2GetUpnRequest);
		assertNotNull(xuser2GetUpnResponse);
		assertEquals(testResult, xuser2GetUpnResponse.getResults());

	}

	/** TODO: Need to figure out how to set DUZ (Leisa)
	 * Test Case #2  DUZ=53468
	 * 
	 * There are no input parameters for this method
	 * 
	 *  The expected result from RPC Broker is:
	 *  
	 *  RESULT="ZIM @ MAN"
	 *	
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testGetUpn002() throws VistaWebServiceFault {
		String testResult = "ZIM @ MAN";
		
		xuser2GetUpnResponse = service.getUpn(xuser2GetUpnRequest);
		assertNotNull(xuser2GetUpnResponse);
		assertEquals(testResult, xuser2GetUpnResponse.getResults());

	}
	/** TODO: Need to figure out how to set DUZ (Leisa)
	 * Test Case #3  DUZ=53469
	 * 
	 * There are no input parameters for this method
	 * 
	 *  The expected result from RPC Broker is:
	 *  
	 *  RESULT=""
	 *	
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testGetUpn003() throws VistaWebServiceFault {
		String testResult = "";
		
		xuser2GetUpnResponse = service.getUpn(xuser2GetUpnRequest);
		assertNotNull(xuser2GetUpnResponse);
		assertEquals(testResult, xuser2GetUpnResponse.getResults());

	}

}
