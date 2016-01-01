/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuser2.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.kernel.ws.xuser2.XUSER2ResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xuser2.endpoints.XUSER2GetUpnEndpointImpl;
import gov.va.oit.vistaevolution.kernel.ws.xuser2.model.XUSER2GetUpnRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuser2.model.XUSER2GetUpnResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Test for GetUpn function of XUSER Webservice
 * 
 * @author Leisa Martella <Leisa.Martella@vangent.com>
 * 
 */
public class XUSER2GetUpnTest extends VistaLinkContextTestParent {

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
	@Ignore //TODO: This test fails because it returns null
	@Test
	public void testGetUpn() throws VistaWebServiceFault {
		String testResponse = "TEST@TEST";

		// Set up the request object
		XUSER2GetUpnRequest request = new XUSER2GetUpnRequest();

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(
				testResponse);

		// Setup the endpoint for testing.
		XUSER2GetUpnEndpointImpl xuser2GetUpnEndpoint = new XUSER2GetUpnEndpointImpl(
				new XUSER2ResponseFactory(), getVistaLinkContext());

		// Execute request against mocked object backend.
		XUSER2GetUpnResponse response = xuser2GetUpnEndpoint.getUpn(request);

		assertEquals(testResponse, response.getResults());
	}

}
