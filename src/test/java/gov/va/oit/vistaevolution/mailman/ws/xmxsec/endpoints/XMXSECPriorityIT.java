/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxsec.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.model.XMXSECPriorityRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.model.XMXSECPriorityResponse;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Integration Test for PRIORITY method of XMXSEC Webservice
 */
public class XMXSECPriorityIT extends VistaLinkContextITParent {

	@Autowired
	private XMXSECPriorityEndpointImpl service;

	private XMXSECPriorityRequest request;
	private XMXSECPriorityResponse response;

	/**
	 * Default Empty Constructor
	 */
	public XMXSECPriorityIT() {
		super();
	}

	/**
	 * <em>Test Case #1  </em>
	 * 
	 * Check if a message is marked as Priority.
	 * 
	 * <pre>
	 * Input Data:
	 * >S XMZ=100     ***DBITPRO use:    >S XMZ=58880
	 * 
	 * Procedure Call:
	 * >D PRIORITY^XMWSOA06(.RETURN,XMZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN=0
	 * 
	 * </pre>
	 */
	@Test
	public void testPriority001() throws VistaWebServiceFault {

		request = new XMXSECPriorityRequest("58880");

		response = service.priority(request);

		assertNotNull(response);
		if (response.getIsPriorityMsg() != null) {
			assertEquals("0", response.getIsPriorityMsg());
		} else {
			fail(response.getMsgRoot().get(1));
		}

	}

	/**
	 * <em>Test Case #2  </em>
	 * 
	 * Check if a message is marked as Priority.
	 * 
	 * <pre>
	 * Input Data:
	 * >S XMZ=3214   ***DBITPRO use:    >S XMZ=59208
	 * 
	 * Procedure Call:
	 * >D PRIORITY^XMWSOA06(.RETURN,XMZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN=1
	 * 
	 * </pre>
	 */
	@Test
	public void testPriority002() throws VistaWebServiceFault {

		request = new XMXSECPriorityRequest("59208");

		response = service.priority(request);

		assertNotNull(response);
		if (response.getIsPriorityMsg() != null) {
			assertEquals("1", response.getIsPriorityMsg());
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
	 * >D PRIORITY^XMWSOA06(.RETURN,XMZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^Message not found"
	 * 
	 * </pre>
	 */
	@Test
	public void testPriority003() throws VistaWebServiceFault {

		request = new XMXSECPriorityRequest("999999");

		response = service.priority(request);

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
	 * >D PRIORITY^XMWSOA06(.RETURN,XMZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^Error in required input"
	 * 
	 * </pre>
	 */
	@Test
	public void testPriority004() throws VistaWebServiceFault {

		request = new XMXSECPriorityRequest("");

		response = service.priority(request);

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
	 * >S XMZ="`3214"
	 * 
	 * Procedure Call:
	 * >D PRIORITY^XMWSOA06(.RETURN,XMZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^Error in required input"
	 * 
	 * </pre>
	 */
	@Test
	public void testPriority005() throws VistaWebServiceFault {

		request = new XMXSECPriorityRequest("`3214");

		response = service.priority(request);

		assertNotNull(response);
		assertEquals("Error in required input", response.getMsgRoot().get(1));
	}
}
