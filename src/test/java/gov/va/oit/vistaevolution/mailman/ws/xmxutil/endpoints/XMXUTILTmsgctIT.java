/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILTmsgctRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILTmsgctResponse;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Integration Test for TMSGCT method of XMXUTIL Webservice
 */
public class XMXUTILTmsgctIT extends VistaLinkContextITParent {

	@Autowired
	private XMXUTILTmsgctEndpointImpl service;

	private XMXUTILTmsgctRequest request;
	private XMXUTILTmsgctResponse response;

	/**
	 * Default Empty Constructor
	 */
	public XMXUTILTmsgctIT() {
		super();
	}

	/**
	 * <em>Test Case #1  </em>
	 * 
	 * Check a user’s mailbox..
	 * 
	 * <pre>
	 * Input Data:
	 * >S XMDUZ=.5
	 * 
	 * Procedure Call:
	 * >D TMSGCT^XMWSOA07(.RETURN,XMDUZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN=67897
	 * 
	 * </pre>
	 */
	@Test
	public void testTmsgct001() throws VistaWebServiceFault {

		request = new XMXUTILTmsgctRequest(".5");

		response = service.tmsgct(request);

		assertNotNull(response);
		if (response.getTotNumOfMsgs() != null) {
			assertEquals("67897", response.getTotNumOfMsgs());
		} else {
			fail(response.getMsgRoot().get(1));
		}
	}

	/**
	 * <em>Test Case #2  </em>
	 * 
	 * Check a non-existent mailbox.
	 * 
	 * <pre>
	 * Input Data:
	 * >S XMDUZ=9999999
	 * 
	 * Procedure Call:
	 * >D TMSGCT^XMWSOA07(.RETURN,XMDUZ)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="-1^User's mailbox doesn't exist"
	 * 
	 * </pre>
	 */
	@Test
	public void testTmsgct002() throws VistaWebServiceFault {

		request = new XMXUTILTmsgctRequest("9999999");

		response = service.tmsgct(request);

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
	 * Try to call the API with an invalid XMDUZ parameter.
	 * 
	 * <pre>
	 * Input Data:
	 * >S XMDUZ=”A”
	 * 
	 * Procedure Call:
	 * >D CLOSED^XMWSOA06(.RETURN,XMZ)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="-1^User's mailbox doesn't exist"
	 * 
	 * </pre>
	 */
	@Test
	public void testTmsgct003() throws VistaWebServiceFault {

		request = new XMXUTILTmsgctRequest("A");

		response = service.tmsgct(request);

		assertNotNull(response);
		if (response.getMsgRoot() != null) {
			assertEquals("User's mailbox doesn't exist", response.getMsgRoot()
					.get(1));
		} else {
			fail("msgRoot is NULL !!!");
		}
	}
}
