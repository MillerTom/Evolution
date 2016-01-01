package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.XUAF4ResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.XUAF4PADDEndpointImpl;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4PADDEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4PADDRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4PADDResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

public class XUAF4PADDTest extends VistaLinkContextTestParent {

	public XUAF4PADDTest() {
		super();
	}

	/**
	 * <em>Retrieve site address for specified IEN</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >Set U=”^”,IEN=516
	 * 
	 * Procedure Call:
	 * 
	 * >S DATA=$$PADD^XUAF4(IEN)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DATA
	 * DATA="10000 BAY PINES BLVD^ST PETERSBURG^FL^33744"
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void test() throws VistaWebServiceFault {
		String testResponse = "10000 BAY PINES BLVD^ST PETERSBURG^FL^33744";

		XUAF4PADDRequest request = new XUAF4PADDRequest("516");

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(testResponse);

		// set up endpoint for testing
		XUAF4PADDEndpoint service = new XUAF4PADDEndpointImpl(
				new XUAF4ResponseFactory(), getVistaLinkContext());

		XUAF4PADDResponse response = service.PADD(request);

		assertNotNull(response);
		String[] splitTestResponse = testResponse.split("\\^");
		assertEquals(splitTestResponse[0], response.getStreetAddress());
		assertEquals(splitTestResponse[1], response.getCity());
		assertEquals(splitTestResponse[2], response.getState());
		assertEquals(splitTestResponse[3], response.getZipCode());

	}
}
