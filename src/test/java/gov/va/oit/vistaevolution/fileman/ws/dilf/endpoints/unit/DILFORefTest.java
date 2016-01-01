/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.DILFORefEndpointImpl;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFORefRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFORefResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
public class DILFORefTest extends VistaLinkContextTestParent {

	/**
	 * Common method of running the test cases.
	 * 
	 * @param expectedResult
	 * @param testData
	 * @throws VistaWebServiceFault
	 */
	private void executeService(String expectedResult, String testData)
			throws VistaWebServiceFault {
		DILFORefRequest request = new DILFORefRequest(testData);

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedResult);

		// Setup the endpoint for testing.
		DILFORefEndpointImpl iensDILFEndpoint = new DILFORefEndpointImpl(
				getVistaLinkContext());

		// Execute request against mocked object backend.
		DILFORefResponse response = iensDILFEndpoint
				.oref(request);

		assertEquals(expectedResult, response.getOpenRoot());
	}

	/**
	 * <em>Retrieve the open global array string from the closed global array with a subscript.</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >S DDR="^DIZ(99900)",DDRDATA=""
	 * 
	 * Procedure Call:
	 * 
	 * >D OREFR^DDR5(.DDRDATA,.DDR)
	 * 
	 * Expected Output:
	 * 
	 * > ZW DDRDATA
	 * DDRDATA="^DIZ(99900,”
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testGetStringFromClosedGAWithoutSubscript()
			throws VistaWebServiceFault {
		String expectedResult = "^DIZ(99900,";
		String testData = "^DIZ(99900)";

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.

		executeService(expectedResult, testData);
	}

	/**
	 * <em>Retrieve the open global array string from the closed global array without a subscript.</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >S DDR="^DIZ()",DDRDATA=""
	 * 
	 * Procedure Call:
	 * >D OREFR^DDR5(.DDRDATA,.DDR)
	 * 
	 * Expected Output:
	 * >ZW DDRDATA
	 * DDRDATA=”^DIZ(“
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testGetStringFromClosedGAWithSubscript()
			throws VistaWebServiceFault {
		String expectedResult = "^DIZ(";
		String testData = "^DIZ()";

		executeService(expectedResult, testData);
	}

	/**
	 * <em>Retrieve the open array string from a multi-level array string.</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >S DDR="^DIZ(999900,""B"",40)",DDRDATA=""
	 * 
	 * Procedure Call:
	 * >D OREFR^DDR5(.DDRDATA,.DDR)
	 * 
	 * Expected Output:
	 * >ZW DDRDATA
	 * DDRDATA="^DIZ(999900,""B"",40,"
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	public void testGetStringFromClosedGAWithMultLevelArray() throws VistaWebServiceFault {
		String expectedResult = "^DIZ(999900,\"B\",40)";
		String testData = "^DIZ(999900,\"B\",40,";

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.

		executeService(expectedResult, testData);
	}

	/**
	 * <em>Retrieve the open array string from an array string that ends in a “,” instead of a “)”.</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >S DDR="^DIZ(999900,""B"",40,",DDRDATA=""
	 * 
	 * Procedure Call:
	 * >D OREFR^DDR5(.DDRDATA,.DDR)
	 * 
	 * Expected Output:
	 * 
	 * > ZW DDRDATA
	 * DDRDATA="^DIZ(999900,""B"",40,"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	public void testGetStringFromOpenGA() throws VistaWebServiceFault {
		String expectedResult = "^DIZ(999900,\"B\",40,";
		String testData = "^DIZ(999900,\"B\",40,";

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.

		executeService(expectedResult, testData);
	}

}
