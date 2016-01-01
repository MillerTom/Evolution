package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.XUAF4ResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.XUAF4ParentEndpointImpl;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4ParentEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4ParentRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4ParentResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

public class XUAF4ParentTest extends VistaLinkContextTestParent {

	public XUAF4ParentTest() {
		super();
	}

	/**
	 * <em>Retrieve site address for specified IEN and ASSO equal to “PARENT FACILITY” </em>
	 * 
	 * <pre>
	 * Input Data:
	 * >Set U=”^”,IEN=516,ASSO=”PARENT FACILITY”
	 * 
	 * Procedure Call:
	 * 
	 * >D PARENT^XUAF4(“DATA”,IEN,ASSO)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DATA
	 * DATA("P",516)="BAY PINES VA HCS^516"
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testRetrieveWithIEN() throws VistaWebServiceFault {
		String testResponse = "BAY PINES VA HCS^516";

		XUAF4ParentRequest request = new XUAF4ParentRequest("516",
				"PARENT FACILITY");

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(testResponse);

		// set up endpoint for testing
		XUAF4ParentEndpoint service = new XUAF4ParentEndpointImpl(
				new XUAF4ResponseFactory(), getVistaLinkContext());

		XUAF4ParentResponse response = service.parent(request);

		assertNotNull(response);
		assertEquals("BAY PINES VA HCS", response.getValue());

	}

}
