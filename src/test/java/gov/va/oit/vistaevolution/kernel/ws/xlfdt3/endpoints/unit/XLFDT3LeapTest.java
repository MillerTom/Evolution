/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xlfdt3.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.kernel.ws.xlfdt3.XLFDT3ResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xlfdt3.endpoints.XLFDT3LeapEndpointImpl;
import gov.va.oit.vistaevolution.kernel.ws.xlfdt3.model.XLFDT3LeapRequest;
import gov.va.oit.vistaevolution.kernel.ws.xlfdt3.model.XLFDT3LeapResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * Test for Leap function of XLFDT3 Webservice
 * 
 * @author Leisa Martella <Leisa.Martella@vangent.com>
 * 
 */
public class XLFDT3LeapTest extends VistaLinkContextTestParent {

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

	/**
	 * Test Case #1  
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
	public void testIsLeapYear() throws VistaWebServiceFault {
		String testResponse = "1";

		// Set up the request object
		XLFDT3LeapRequest request = new XLFDT3LeapRequest("2004");

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(
		testResponse);

		// Setup the endpoint for testing.
		XLFDT3LeapEndpointImpl xlfdt3LeapEndpoint = new XLFDT3LeapEndpointImpl(
				getVistaLinkContext(), new XLFDT3ResponseFactory());

		// Execute request against mocked object backend
		XLFDT3LeapResponse response = xlfdt3LeapEndpoint.leap(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getResults());
	}
}
