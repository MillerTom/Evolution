/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILTpmsgctRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILTpmsgctResponse;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Integration Test for TPMSGCT method of XMXUTIL Webservice
 */
public class XMXUTILTpmsgctIT extends VistaLinkContextITParent {

	@Autowired
	private XMXUTILTpmsgctEndpointImpl service;

	private XMXUTILTpmsgctRequest request;
	private XMXUTILTpmsgctResponse response;

	/**
	 * Default Empty Constructor
	 */
	public XMXUTILTpmsgctIT() {
		super();
	}

	/**
	 * <em>Test Case #1  </em>
	 * 
	 * Check a user’s mailbox.
	 * 
	 * <pre>
	 * Input Data:
	 * >S XMDUZ=.6
	 * 
	 * Procedure Call:
	 * >D TPMSGCT^XMWSOA07(.RETURN,XMDUZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN=1
	 * 
	 * </pre>
	 */
	@Test
	public void testTpmsgct001() throws VistaWebServiceFault {

		request = new XMXUTILTpmsgctRequest(".6");

		response = service.tpmsgct(request);

		assertNotNull(response);
		if (response.getTotNumOfNewPriorityMsgs() != null) {
			assertEquals("1", response.getTotNumOfNewPriorityMsgs());
		} else {
			fail(response.getMsgRoot().get(1));
		}
	}

	/**
	 * <em>Test Case #2  </em>
	 * 
	 * Checka non-existent mailbox.
	 * 
	 * <pre>
	 * Input Data:
	 * >S XMDUZ=9999999
	 * 
	 * Procedure Call:
	 * >D TPMSGCT^XMWSOA07(.RETURN,XMDUZ)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="-1^User's mailbox doesn't exist"
	 * 
	 * </pre>
	 */
	@Test
	public void testTpmsgct002() throws VistaWebServiceFault {

		request = new XMXUTILTpmsgctRequest("9999999");

		response = service.tpmsgct(request);

		assertNotNull(response);
		if (response.getMsgRoot() != null) {
			assertEquals("User's mailbox doesn't exist", response.getMsgRoot()
					.get(1));
		} else {
			fail("msgRoot is NULL !!!");
		}
	}

	/**
	 * <em>Test Case #3  </em>
	 * 
	 * Try to call the API with a null user IEN.
	 * 
	 * <pre>
	 * Input Data:
	 * >S XMDUZ=””
	 * 
	 * Procedure Call:
	 * >D TPMSGCT^XMWSOA07(.RETURN,XMDUZ)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="-1^Error in required input"
	 * 
	 * </pre>
	 */
	@Test
	public void testTpmsgct003() throws VistaWebServiceFault {

		request = new XMXUTILTpmsgctRequest("");

		response = service.tpmsgct(request);

		assertNotNull(response);
		if (response.getMsgRoot() != null) {
			assertEquals("Error in required input", response.getMsgRoot()
					.get(1));
		} else {
			fail("msgRoot is NULL !!!");
		}
	}

	/**
	 * <em>Test Case #4  </em>
	 * 
	 * Try to call the API with an invalid user IEN.
	 * 
	 * <pre>
	 * Input Data:
	 * >S XMDUZ=”A”
	 * 
	 * Procedure Call:
	 * >D TPMSGCT^XMWSOA07(.RETURN,XMDUZ)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="-1^Error in required input"
	 * 
	 * </pre>
	 */
	@Test
	public void testTpmsgct004() throws VistaWebServiceFault {

		request = new XMXUTILTpmsgctRequest("A");

		response = service.tpmsgct(request);

		assertNotNull(response);
		if (response.getMsgRoot() != null) {
			assertEquals("Error in required input", response.getMsgRoot()
					.get(1));
		} else {
			fail("msgRoot is NULL !!!");
		}
	}
}
