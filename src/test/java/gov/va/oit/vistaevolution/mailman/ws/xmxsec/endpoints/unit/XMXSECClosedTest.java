package gov.va.oit.vistaevolution.mailman.ws.xmxsec.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.XMXSECResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.endpoints.XMXSECClosedEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.endpoints.interfaces.XMXSECClosedEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.model.XMXSECClosedRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.model.XMXSECClosedResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * 
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Unit Test for CLOSED method of XMXSEC Webservice
 */
public class XMXSECClosedTest extends VistaLinkContextTestParent {

	/**
	 * Default Empty Constructor
	 */
	public XMXSECClosedTest() {
		super();
	}

	/**
	 * <em>Test Case #1  </em>
	 * 
	 * Check a message that is marked Closed.
	 * 
	 * <pre>
	 * Input Data:
	 * >S XMZ=281769
	 * 
	 * Procedure Call:
	 * >D CLOSED^XMWSOA06(.RETURN,XMZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN=1
	 * 
	 * </pre>
	 */
	@Test
	public void testClosed001() throws VistaWebServiceFault {

		String expectedOutput = "1";

		XMXSECClosedRequest request = new XMXSECClosedRequest("281769");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMXSECClosedEndpoint service = new XMXSECClosedEndpointImpl(
				new XMXSECResponseFactory(), getVistaLinkContext());

		XMXSECClosedResponse response = service.closed(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getMsgIsClosed());
	}

	/**
	 * <em>Test Case #2  </em>
	 * 
	 * Check a message that is not marked Closed.
	 * 
	 * <pre>
	 * Input Data:
	 * >S XMZ=281749
	 * 
	 * Procedure Call:
	 * >D CLOSED^XMWSOA06(.RETURN,XMZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN=0
	 * 
	 * </pre>
	 */
	@Test
	public void testClosed002() throws VistaWebServiceFault {

		String expectedOutput = "0";

		XMXSECClosedRequest request = new XMXSECClosedRequest("281749");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMXSECClosedEndpoint service = new XMXSECClosedEndpointImpl(
				new XMXSECResponseFactory(), getVistaLinkContext());

		XMXSECClosedResponse response = service.closed(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getMsgIsClosed());
	}

}
