/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints;

import static org.junit.Assert.assertEquals;
import gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.DILFORefEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFORefRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFORefResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
public class DILFORefIT extends EvolutionIT<DILFORefEndpoint> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT#getType()
	 */
	@Override
	protected Class<DILFORefEndpoint> getType() {
		return DILFORefEndpoint.class;
	}

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

		// Execute request against mocked object backend.
		DILFORefResponse response = service.oref(request);

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
	@Test
	public void testGetStringFromClosedGAWithMultLevelArray()
			throws VistaWebServiceFault {
		String expectedResult = "^DIZ(999900,\"B\",40,";
		String testData = "^DIZ(999900,\"B\",40)";

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
	@Test
	public void testGetStringFromOpenGA() throws VistaWebServiceFault {
		String expectedResult = "^DIZ(999900,\"B\",40,";
		String testData = "^DIZ(999900,\"B\",40,";

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.

		executeService(expectedResult, testData);
	}

}
