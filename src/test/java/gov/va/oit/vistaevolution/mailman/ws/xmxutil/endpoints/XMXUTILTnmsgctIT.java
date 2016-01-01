/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILTnmsgctRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILTnmsgctResponse;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 * 
 *         Integration Test for TNMSGCT method of XMXUTIL Webservice
 */
public class XMXUTILTnmsgctIT extends VistaLinkContextITParent {

	@Autowired
	private XMXUTILTnmsgctEndpointImpl service;

	private XMXUTILTnmsgctRequest request;
	private XMXUTILTnmsgctResponse response;

	/**
	 * Default Empty Constructor
	 */
	public XMXUTILTnmsgctIT() {
		super();
	}

	/**
	 * <em>Test Case #1  </em>
	 * 
	 * Check a user’s mailbox.
	 * 
	 * <pre>
	 * Input Data:
	 * >S XMDUZ=.5
	 * 
	 * Procedure Call:
	 * >D TNMSGCT^XMWSOA07(.RETURN,XMDUZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN=2206
	 * 
	 * </pre>
	 */
	@Test
	public void testTnmsgct001() throws VistaWebServiceFault {

		request = new XMXUTILTnmsgctRequest(".5");

		response = service.tnmsgct(request);

		assertNotNull(response);
		if (response.getTotNumOfNewMsgs() != null) {
			assertEquals("2206", response.getTotNumOfNewMsgs());
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
	 * >D TNMSGCT^XMWSOA07(.RETURN,XMDUZ)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="-1^User's mailbox doesn't exist"
	 * 
	 * </pre>
	 */
	@Test
	public void testTnmsgct002() throws VistaWebServiceFault {

		request = new XMXUTILTnmsgctRequest("9999999");

		response = service.tnmsgct(request);

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
	 * >D TNMSGCT^XMWSOA07(.RETURN,XMDUZ)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="-1^Error in required input"
	 * 
	 * </pre>
	 */
	@Test
	public void testTnmsgct003() throws VistaWebServiceFault {

		request = new XMXUTILTnmsgctRequest("");

		response = service.tnmsgct(request);

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
	 * >D TNMSGCT^XMWSOA07(.RETURN,XMDUZ)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="-1^Error in required input"
	 * 
	 * </pre>
	 */
	@Test
	public void testTnmsgct004() throws VistaWebServiceFault {

		request = new XMXUTILTnmsgctRequest("A");

		response = service.tnmsgct(request);

		assertNotNull(response);
		if (response.getMsgRoot() != null) {
			assertEquals("Error in required input", response.getMsgRoot()
					.get(1));
		} else {
			fail("msgRoot is NULL !!!");
		}
	}

}
