/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusrb1.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.kernel.ws.xusrb1.XUSRB1ResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xusrb1.endpoints.XUSRB1EncrypEndpointImpl;
import gov.va.oit.vistaevolution.kernel.ws.xusrb1.model.XUSRB1EncrypRequest;
import gov.va.oit.vistaevolution.kernel.ws.xusrb1.model.XUSRB1EncrypResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * Test for Webservice XUSRB1 Encryp
 * 
 * @author Leisa Martella <Leisa.Martella@vangent.com>
 * 
 */
public class XUSRB1DecrypTest extends VistaLinkContextTestParent {

	/**
	 * XU SOA ENCRYP
	 * 
	 * Kernel and the RPC Broker provide encryption functions that can be used to
	 * encrypt messages sent between the client and the server.
	 * 
	 * 
	 * Input Variables	
	 * 		st1:	(required) The string that needs to be encrypted.
	 * 
	 * Response
	 * 		Returns  Encrypted string.
	 *		
	 */

	/**
	 * Test Case #1  
	 * 
	 *  >D ENCRYP1^XUSOAK1(.RESULT,"HELLO WORLD")
	 *  
	 *  >ZW RESULT
	 *  RESULT="$H4GG/0i/uG63"
	 *  
	 *  >D ENCRYP1^XUSOAK1(.RESULT,"HELLO WORLD")
	 *  
	 *  >ZW RESULT
	 *  RESULT="(fZeeg2Lgue` "
	 * 
	 * @throws VistaWebServiceFault
	 */

	@Test
	public void testEncryp() throws VistaWebServiceFault {
		String testResponse = "(fZeeg2Lgue` ";

		// Set up the request object
		XUSRB1EncrypRequest request = new XUSRB1EncrypRequest("HELLO WORLD");

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(
		testResponse);

		// Setup the endpoint for testing.
		XUSRB1EncrypEndpointImpl service = new XUSRB1EncrypEndpointImpl(
				getVistaLinkContext(), new XUSRB1ResponseFactory());

		// Execute request against mocked object backend
		XUSRB1EncrypResponse response = service.encryp(request);

		assertNotNull(response);
		assertEquals(testResponse, response.getData());
	}
}
