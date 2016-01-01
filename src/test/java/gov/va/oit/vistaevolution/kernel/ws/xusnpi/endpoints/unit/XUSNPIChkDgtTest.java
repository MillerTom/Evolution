/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusnpi.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.kernel.ws.xusnpi.XUSNPIResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xusnpi.endpoints.XUSNPIChkDgtEndpointImpl;
import gov.va.oit.vistaevolution.kernel.ws.xusnpi.model.XUSNPIChkDgtRequest;
import gov.va.oit.vistaevolution.kernel.ws.xusnpi.model.XUSNPIChkDgtResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author Leisa Martella
 * 
 */
/**
 * XU SOA CHKDGT
 * 
 * This RPC call is used to validate the format of an NPI number, checking the length
 * and if numeric. Also whether the check digit is valid.
 * 
 *  
 * Input Variables	
 * 	XUSNPI1:	(required) The National Provider Identifier.
 * 
 * Response
 * 		If check digit is valid 1, else 0.
 * 
 */
public class XUSNPIChkDgtTest extends VistaLinkContextTestParent {

	@Test
	//TODO: Implement this test when the RPC Broker call is available
	public void testAhistory() throws VistaWebServiceFault {
		String expectedResult = "1";

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(
				expectedResult);

		// Setup the endpoint for testing.
		XUSNPIChkDgtEndpointImpl service = new XUSNPIChkDgtEndpointImpl(
				getVistaLinkContext(), new XUSNPIResponseFactory());

		XUSNPIChkDgtRequest request = new XUSNPIChkDgtRequest();

		// Execute request against mocked object backend.
		request.setXusNpi("");

		XUSNPIChkDgtResponse response = service.chkDgt(request);

		assertNotNull(response);
		assertEquals(expectedResult, response.getData());
	}
}
