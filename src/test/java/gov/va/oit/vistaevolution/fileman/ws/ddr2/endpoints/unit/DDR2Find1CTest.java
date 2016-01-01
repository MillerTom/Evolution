/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.ddr2.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.fileman.ws.ddr2.DDR2ResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.ddr2.endpoints.DDR2Find1CEndpointImpl;
import gov.va.oit.vistaevolution.fileman.ws.ddr2.model.DDR2Find1CRequest;
import gov.va.oit.vistaevolution.fileman.ws.ddr2.model.DDR2Find1CResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author Leisa Martella
 * 
 */
public class DDR2Find1CTest extends VistaLinkContextTestParent {

	/**
	 * <pre>
	 * 
	 * </pre>
	 */
	@Test
	public void testDDR2Find1C() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("51");

		String testResponse = "51";

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(testResponse);

		// Setup the endpoint for testing.
		DDR2Find1CEndpointImpl service = new DDR2Find1CEndpointImpl(
				getVistaLinkContext(), new DDR2ResponseFactory());

		DDR2Find1CRequest request = new DDR2Find1CRequest();

		// Execute request against mocked object backend.
		request.setFile("5");
		request.setIens("");
		request.setValue("VA");
		List<String> flags = new ArrayList<String>();
		flags.add("M");
		flags.add("X");
		request.setFlags(flags);

		DDR2Find1CResponse response = service.find1C(request);

		assertNotNull(response);
		assertEquals(results.get(0), response.getDataList().get(0));
	}
}
