/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxsec.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.model.XMXSECConfidRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.model.XMXSECConfidResponse;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Integration Test for CONFID method of XMXSEC Webservice
 */
public class XMXSECConfidIT extends VistaLinkContextITParent {

	@Autowired
	private XMXSECConfidEndpointImpl service;

	private XMXSECConfidRequest request;
	private XMXSECConfidResponse response;

	/**
	 * Default Empty Constructor
	 * 
	 */
	public XMXSECConfidIT() {
		super();
	}

	/**
	 * <em>Test Case #1  </em>
	 * 
	 * Check a message that is marked Confidential.
	 * 
	 * <pre>
	 * Input Data:
	 * >S XMZ=281758
	 * 
	 * Procedure Call:
	 * >D CONFID^XMWSOA06(.RETURN,XMZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN=1
	 * 
	 * </pre>
	 */
	@Test
	public void testConfid001() throws VistaWebServiceFault {

		request = new XMXSECConfidRequest("281758");

		response = service.confid(request);

		assertNotNull(response);
		if (response.getMsgIsConfidential() != null) {
			assertEquals("1", response.getMsgIsConfidential());
		} else {
			fail(response.getMsgRoot().get(1));
		}

	}

	/**
	 * <em>Test Case #2  </em>
	 * 
	 * Check a message that is not marked Confidential.
	 * 
	 * <pre>
	 * Input Data:
	 * >S XMZ=281749
	 * 
	 * Procedure Call:
	 * >D CONFID^XMWSOA06(.RETURN,XMZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN=0
	 * 
	 * 
	 * </pre>
	 */
	@Test
	public void testConfid002() throws VistaWebServiceFault {

		request = new XMXSECConfidRequest("281749");

		response = service.confid(request);

		assertNotNull(response);
		if (response.getMsgIsConfidential() != null) {
			assertEquals("0", response.getMsgIsConfidential());
		} else {
			fail(response.getMsgRoot().get(1));
		}

	}

	/**
	 * <em>Test Case #3  </em>
	 * 
	 * Checka non-existent message.
	 * 
	 * <pre>
	 * Input Data:
	 * >S XMZ=9999999
	 * 
	 * Procedure Call:
	 * >D CONFID^XMWSOA06(.RETURN,XMZ)
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
	public void testConfid003() throws VistaWebServiceFault {

		request = new XMXSECConfidRequest("9999999");

		response = service.confid(request);

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
	 * >D CONFID^XMWSOA06(.RETURN,XMZ)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="-1^Error in required input"
	 * 
	 * 
	 * </pre>
	 */
	@Test
	public void testConfid004() throws VistaWebServiceFault {

		request = new XMXSECConfidRequest("");

		response = service.confid(request);

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
	 * >D CONFID^XMWSOA06(.RETURN,XMZ)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="-1^Error in required input"
	 * 
	 * </pre>
	 */
	@Test
	public void testConfid005() throws VistaWebServiceFault {

		request = new XMXSECConfidRequest("A");

		response = service.confid(request);

		assertNotNull(response);
		assertEquals("Error in required input", response.getMsgRoot().get(1));

	}
}
