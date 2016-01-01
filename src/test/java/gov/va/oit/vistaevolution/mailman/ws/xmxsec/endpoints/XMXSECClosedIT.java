/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxsec.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.model.XMXSECClosedRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.model.XMXSECClosedResponse;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Integration Test for CLOSED method of XMXSEC Webservice
 */
public class XMXSECClosedIT extends VistaLinkContextITParent {

	@Autowired
	private XMXSECClosedEndpointImpl service;

	private XMXSECClosedRequest request;
	private XMXSECClosedResponse response;

	/**
	 * Default Empty Constructor
	 */
	public XMXSECClosedIT() {
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

		request = new XMXSECClosedRequest("281769");

		response = service.closed(request);

		assertNotNull(response);
		if (response.getMsgIsClosed() != null) {
			assertEquals("1", response.getMsgIsClosed());
		} else {
			fail(response.getMsgRoot().get(1));
		}

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

		request = new XMXSECClosedRequest("281749");

		response = service.closed(request);

		assertNotNull(response);
		if (response.getMsgIsClosed() != null) {
			assertEquals("0", response.getMsgIsClosed());
		} else {
			fail(response.getMsgRoot().get(1));
		}

	}

	/**
	 * <em>Test Case #3  </em>
	 * 
	 * Check a non-existent message.
	 * 
	 * <pre>
	 * Input Data:
	 * >S XMZ=9999999
	 * 
	 * Procedure Call:
	 * >D CLOSED^XMWSOA06(.RETURN,XMZ)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="-1^Message not found"
	 * 
	 * 
	 * </pre>
	 */
	@Test
	public void testClosed003() throws VistaWebServiceFault {

		request = new XMXSECClosedRequest("9999999");

		response = service.closed(request);

		assertNotNull(response);
		assertEquals("Message not found", response.getMsgRoot().get(1));
	}

	/**
	 * <em>Test Case #4  </em>
	 * 
	 * Try to call the API with no message IEN.
	 * 
	 * <pre>
	 * Input Data:
	 * >S XMZ=””
	 * 
	 * Procedure Call:
	 * >D CLOSED^XMWSOA06(.RETURN,XMZ)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="-1^Error in required input"
	 * 
	 * </pre>
	 */
	@Test
	public void testClosed004() throws VistaWebServiceFault {

		request = new XMXSECClosedRequest("");

		response = service.closed(request);

		assertNotNull(response);
		assertEquals("Error in required input", response.getMsgRoot().get(1));

	}

	/**
	 * <em>Test Case #5  </em>
	 * 
	 * Try to call the API with an invalid XMZ parameter.
	 * 
	 * <pre>
	 * Input Data:
	 * >S XMZ=”A”
	 * 
	 * Procedure Call:
	 * >D CLOSED^XMWSOA06(.RETURN,XMZ)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="-1^Error in required input"
	 * 
	 * </pre>
	 */
	@Test
	public void testClosed005() throws VistaWebServiceFault {

		request = new XMXSECClosedRequest("A");

		response = service.closed(request);

		assertNotNull(response);
		assertEquals("Error in required input", response.getMsgRoot().get(1));

	}
}
