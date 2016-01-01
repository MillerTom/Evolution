/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.XMXUTIL1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.XMXUTIL1TstampEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1TstampEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1TstampResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Unit Test for TSTAMP method of XMXUTIL1 Webservice
 */
public class XMXUTIL1TstampTest extends VistaLinkContextTestParent {

	/**
	 * Default Empty Constructor
	 */
	public XMXUTIL1TstampTest() {
		super();
	}

	/**
	 * <em>Test Case #1  </em>
	 * 
	 * Generate a current timestamp.
	 * 
	 * <pre>
	 * Input Data:
	 * None.
	 * 
	 * Procedure Call:
	 * >D TSTAMP^XMWSOA07(.RETURN)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN=5464917241
	 * 
	 * </pre>
	 */
	@Test
	public void testTstamp001() throws VistaWebServiceFault {
		String expectedOutput = "5464917241";

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMXUTIL1TstampEndpoint service = new XMXUTIL1TstampEndpointImpl(
				getVistaLinkContext(), new XMXUTIL1ResponseFactory());

		XMXUTIL1TstampResponse response = service.tstamp();

		assertNotNull(response);
		assertEquals(expectedOutput, response.getCurrentTimeStamp());
	}
}
