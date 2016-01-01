/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxsec.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.model.XMXSECInfoRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.model.XMXSECInfoResponse;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Integration Test for INFO method of XMXSEC Webservice
 */
public class XMXSECInfoIT extends VistaLinkContextITParent {

	@Autowired
	private XMXSECInfoEndpointImpl service;

	private XMXSECInfoRequest request;
	private XMXSECInfoResponse response;

	/**
	 * Default Empty Constructor
	 */
	public XMXSECInfoIT() {
		super();
	}

	/**
	 * <em>Test Case #1  </em>
	 * 
	 * Check if a message is marked Information Only.
	 * 
	 * <pre>
	 * Input Data:
	 * >S XMZ=100
	 * 
	 * Procedure Call:
	 * >D INFO^XMWSOA06(.RETURN,XMZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN=0
	 * 
	 * </pre>
	 */
	@Test
	public void testInfo001() throws VistaWebServiceFault {

		request = new XMXSECInfoRequest("100");

		response = service.info(request);

		assertNotNull(response);
		if (response.getIsInfoOnlyMsg() != null) {
			assertEquals("0", response.getIsInfoOnlyMsg());
		} else {
			fail(response.getMsgRoot().get(1));
		}

	}

	/**
	 * <em>Test Case #2  </em>
	 * 
	 * Check if a message is marked Information Only.
	 * 
	 * <pre>
	 * Input Data:
	 * >S XMZ=2930
	 * 
	 * Procedure Call:
	 * >D INFO^XMWSOA06(.RETURN,XMZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN=1
	 * 
	 * </pre>
	 */
	@Test
	public void testInfo002() throws VistaWebServiceFault {

		request = new XMXSECInfoRequest("2930");

		response = service.info(request);

		assertNotNull(response);
		if (response.getIsInfoOnlyMsg() != null) {
			assertEquals("1", response.getIsInfoOnlyMsg());
		} else {
			fail(response.getMsgRoot().get(1));
		}
	}

	/**
	 * <em>Test Case #3  </em>
	 * 
	 * Error. Pass in IEN that has no message.
	 * 
	 * <pre>
	 * Input Data:
	 * >S XMZ=999999
	 * 
	 * Procedure Call:
	 * >D INFO^XMWSOA06(.RETURN,XMZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^Message not found"
	 * 
	 * 
	 * </pre>
	 */
	@Test
	public void testInfo003() throws VistaWebServiceFault {

		request = new XMXSECInfoRequest("999999");

		response = service.info(request);

		assertNotNull(response);
		assertEquals("Message not found", response.getMsgRoot().get(1));
	}

	/**
	 * <em>Test Case #4  </em>
	 * 
	 * Error. Pass in invalid IEN.
	 * 
	 * <pre>
	 * Input Data:
	 * >S XMZ=""
	 * 
	 * Procedure Call:
	 * >D INFO^XMWSOA06(.RETURN,XMZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^Error in required input"
	 * 
	 * </pre>
	 */
	@Test
	public void testInfo004() throws VistaWebServiceFault {

		request = new XMXSECInfoRequest("");

		response = service.info(request);

		assertNotNull(response);
		assertEquals("Error in required input", response.getMsgRoot().get(1));
	}

	/**
	 * <em>Test Case #5  </em>
	 * 
	 * Error. Pass in invalid IEN.
	 * 
	 * <pre>
	 * Input Data:
	 * >S XMZ="`2930"
	 * 
	 * Procedure Call:
	 * >D INFO^XMWSOA06(.RETURN,XMZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^Error in required input"
	 * 
	 * </pre>
	 */
	@Test
	public void testInfo005() throws VistaWebServiceFault {

		request = new XMXSECInfoRequest("`2930");

		response = service.info(request);

		assertNotNull(response);
		assertEquals("Error in required input", response.getMsgRoot().get(1));
	}
}
