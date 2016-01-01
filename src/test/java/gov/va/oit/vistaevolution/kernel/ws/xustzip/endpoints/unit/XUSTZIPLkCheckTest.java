/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xustzip.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.kernel.ws.xustzip.XUSTZIPResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xustzip.endpoints.XUSTZIPLkCheckEndpointImpl;
import gov.va.oit.vistaevolution.kernel.ws.xustzip.model.XUSTZIPLkCheckRequest;
import gov.va.oit.vistaevolution.kernel.ws.xustzip.model.XUSTZIPLkCheckResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * 
 * @author Leisa Martella <Leisa.Martella@vangent.com>
 * 
 */
/**
 * 
 * XU SOA LKCHECK
 *
 *  This agreement allows the VistaLink package to use routine XUSTZIP
 *  to perform checks on Kernel IP/device locking during the VistaLink
 *  reauthentication process, which includes support for the login
 *  capabilities of FatKAAT and KAAJEE.
 *   
 * Input Parameters
 * 		LKCHECK1		(Required) IP Address
 * 
 * Response
 * 		Result on failure returns the FileMan date/time
 * 		that the IP address should be locked until.
 * 		
 * 		Result on success returns 0.
 *   
 */
public class XUSTZIPLkCheckTest extends VistaLinkContextTestParent {
	/**
	 * Test with valid IP address
	 * >K RR D LKCHECK1^XUSOAK1(.RR,"127.0.0.1") ZW RR
	 * RR=0
	 *
	 * @throws VistaWebServiceFault
	 */

	@Test
	public void testCheckLocking() throws VistaWebServiceFault {
		String testResponse = "0";

		// Set up the request object
		XUSTZIPLkCheckRequest request = new XUSTZIPLkCheckRequest("127.0.0.1");

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(
		testResponse);

		// Setup the endpoint for testing.
		XUSTZIPLkCheckEndpointImpl service = new XUSTZIPLkCheckEndpointImpl(
				getVistaLinkContext(), new XUSTZIPResponseFactory());

		// Execute request against mocked object backend
		XUSTZIPLkCheckResponse response = service.lkCheck(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getResults());
	}
}
