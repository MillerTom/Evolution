/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.XMXUTIL1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.XMXUtil1INDTEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUtil1INDTEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUtil1INDTRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUtil1INDTResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * 
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
public class XMXUtil1INDTTest extends VistaLinkContextTestParent {

	/**
	 * <em>Retrieve external date from a Fileman date</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >Set U=”^”,INDT=”3140113.133624”
	 * 
	 * Procedure Call:
	 * 
	 * >S DATA=$$INDT^XMXUTIL1(INDT)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DATA
	 * DATA="13 Jan 2014 13:36:24 -0500 (EST)"
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testConvertDateTime() throws VistaWebServiceFault {
		String testResponse = "13 Jan 2014 13:36:24 -0500 (EST)";

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(testResponse);

		XMXUtil1INDTRequest request = new XMXUtil1INDTRequest("3140113.133624");

		// Setup the endpoint for testing.
		XMXUtil1INDTEndpoint service = new XMXUtil1INDTEndpointImpl(
				getVistaLinkContext(), new XMXUTIL1ResponseFactory());

		// Execute request against mocked object backend.
		XMXUtil1INDTResponse response = service.indt(request);

		assertEquals(testResponse, response.getDate());

	}
}
