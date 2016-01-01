/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.unit;

import gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.DILFFDAEndpointImpl;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFFDAIENSRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFFDAResponse;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
public class DILFFDATest extends VistaLinkContextTestParent {

	@Autowired
	DILFFDAEndpointImpl service;

	/**
	 * <em>Standard IEN usage of loading the FDA array.</em>
	 * 
	 * <pre>
	 * Input Data:
	 * > S DDR("FILE")=80,DDR("IENS")=12443,DDR("FIELD")=.01,DDR("VALUE")="TEST DATA",DDR("FLAG")="",DDRDATA=""
	 * 
	 * Procedure Call:
	 * >D FDAR^DDR5(.DDRDATA,.DDR)
	 * 
	 * Expected Output:
	 * >ZW DDRDATA
	 * DDRDATA=""
	 * DDRDATA(80,"12443,",.01)="TEST DATA"
	 * 
	 * <pre>
	 * @throws VistaWebServiceFault
	 */
	@Test
	@Ignore
	public void testRetrieve() throws VistaWebServiceFault {

		// Set up the request object
		DILFFDAIENSRequest request = new DILFFDAIENSRequest("80", "12443",
				".01", Arrays.asList("TEST DATA"));

		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		// when(
		// this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
		// null)).thenReturn("");

		// Setup the endpoint for testing.
		// DILFFDAEndpointImpl fdaDILFEndpoint = new DILFFDAEndpointImpl(
		// getVistaLinkContext(), new DILFResponseFactory());

		// Execute request against mocked object backend.
		DILFFDAResponse response = service.FDA(request);
		System.out.println(response.getResponse());
	}

}
