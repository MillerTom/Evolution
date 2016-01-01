/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILNonewRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILNonewResponse;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Integration Test for NONEW method of XMXUTIL Webservice
 */
public class XMXUTILNonewIT extends VistaLinkContextITParent {

	@Autowired
	private XMXUTILNonewEndpointImpl service;

	private XMXUTILNonewRequest request;
	private XMXUTILNonewResponse response;

	/**
	 * No Arguments Constructor
	 */
	public XMXUTILNonewIT() {
		super();
	}

	/**
	 * <em>Test Case #1  </em>
	 * 
	 * Error. XMDUZ is set to null.
	 * 
	 * <pre>
	 * Input Data:
	 * >S XMDUZ=""
	 * >S XMK=.3
	 * >S XMZ=100
	 * >S XMLOCKIT=1
	 * 
	 * Procedure Call:
	 * >D NONEW^XMWSOA04(.RETURN,XMDUZ,XMK,XMZ,XMLOCKIT)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^Error in required input"
	 * 
	 * </pre>
	 */
	@Test
	public void testNonew001() throws VistaWebServiceFault {

		request = new XMXUTILNonewRequest("", ".3", "100", "1");

		response = service.nonew(request);

		assertNotNull(response);
		if (response.getMsgRoot() != null) {
			assertEquals("Error in required input", response.getMsgRoot()
					.get(1));
		} else {
			fail("msgRoot is NULL !!");
		}
	}

	/**
	 * <em>Test Case #2  </em>
	 * 
	 * Error. Mailbox IEN is null.
	 * 
	 * <pre>
	 * Input Data:
	 * >S XMDUZ=.5
	 * >S XMK=""
	 * >S XMZ=100
	 * >S XMLOCKIT=1
	 * 
	 * Procedure Call:
	 * >D NONEW^XMWSOA04(.RETURN,XMDUZ,XMK,XMZ,XMLOCKIT)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^Error in required input"
	 * 
	 * </pre>
	 */
	@Test
	public void testNonew002() throws VistaWebServiceFault {

		request = new XMXUTILNonewRequest(".5", "", "100", "1");

		response = service.nonew(request);

		assertNotNull(response);
		if (response.getMsgRoot() != null) {
			assertEquals("Error in required input", response.getMsgRoot()
					.get(1));
		} else {
			fail("msgRoot is NULL !!");
		}
	}

	/**
	 * <em>Test Case #3  </em>
	 * 
	 * Error. Message IEN is null.
	 * 
	 * <pre>
	 * Input Data:
	 * >S XMDUZ=.5
	 * >S XMK=.3
	 * >S XMZ=""
	 * >S XMLOCKIT=1
	 * 
	 * Procedure Call:
	 * >D NONEW^XMWSOA04(.RETURN,XMDUZ,XMK,XMZ,XMLOCKIT)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^Error in required input"
	 * 
	 * </pre>
	 */
	@Test
	public void testNonew003() throws VistaWebServiceFault {

		request = new XMXUTILNonewRequest(".5", ".3", "", "1");

		response = service.nonew(request);

		assertNotNull(response);
		if (response.getMsgRoot() != null) {
			assertEquals("Error in required input", response.getMsgRoot()
					.get(1));
		} else {
			fail("msgRoot is NULL !!");
		}
	}

	/**
	 * <em>Test Case #4  </em>
	 * 
	 * Error. User DUZ is invalid.
	 * 
	 * <pre>
	 * Input Data:
	 * >S XMDUZ=999999
	 * >S XMK=.3
	 * >S XMZ=100
	 * >S XMLOCKIT=1
	 * 
	 * Procedure Call:
	 * >D NONEW^XMWSOA04(.RETURN,XMDUZ,XMK,XMZ,XMLOCKIT)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^Not a valid user"
	 * 
	 * </pre>
	 */
	@Test
	public void testNonew004() throws VistaWebServiceFault {

		request = new XMXUTILNonewRequest("999999", ".3", "100", "1");

		response = service.nonew(request);

		assertNotNull(response);
		if (response.getMsgRoot() != null) {
			assertEquals("Not a valid user", response.getMsgRoot().get(1));
		} else {
			fail("msgRoot is NULL !!");
		}
	}

	/**
	 * <em>Test Case #5  </em>
	 * 
	 * Error. Invalid message IEN
	 * 
	 * <pre>
	 * Input Data:
	 * >S XMDUZ=.5
	 * >S XMK=.3
	 * >S XMZ=999999
	 * >S XMLOCKIT=1
	 * 
	 * Procedure Call:
	 * >D NONEW^XMWSOA04(.RETURN,XMDUZ,XMK,XMZ,XMLOCKIT)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^Message not found"
	 * 
	 * </pre>
	 */
	@Test
	public void testNonew005() throws VistaWebServiceFault {

		request = new XMXUTILNonewRequest(".5", ".3", "999999", "1");

		response = service.nonew(request);

		assertNotNull(response);
		if (response.getMsgRoot() != null) {
			assertEquals("Message not found", response.getMsgRoot().get(1));
		} else {
			fail("msgRoot is NULL !!");
		}
	}

	/**
	 * <em>Test Case #6  </em>
	 * 
	 * Error. Invalid Mailbox.
	 * 
	 * <pre>
	 * Input Data:
	 * >S XMDUZ=.5
	 * >S XMK=.6
	 * >S XMZ=1000
	 * >S XMLOCKIT=1
	 * 
	 * Procedure Call:
	 * >D NONEW^XMWSOA04(.RETURN,XMDUZ,XMK,XMZ,XMLOCKIT)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^Not a valid mailbox"
	 * 
	 * </pre>
	 */
	@Test
	public void testNonew006() throws VistaWebServiceFault {

		request = new XMXUTILNonewRequest(".5", ".6", "1000", "1");

		response = service.nonew(request);

		assertNotNull(response);
		if (response.getMsgRoot() != null) {
			assertEquals("Not a valid mailbox", response.getMsgRoot().get(1));
		} else {
			fail("msgRoot is NULL !!");
		}
	}

	/**
	 * <em>Test Case #7  </em>
	 * 
	 * Make a message not New and update the message count. Let MailMan do the
	 * locking/unlocking.
	 * 
	 * <pre>
	 * Input Data:
	 * >S XMDUZ=.5
	 * >S XMK=.5
	 * >S XMZ=1000     ***DBITPRO use   >S XMZ=58880
	 * >S XMLOCKIT=1
	 * 
	 * Procedure Call:
	 * >D NONEW^XMWSOA04(.RETURN,XMDUZ,XMK,XMZ,XMLOCKIT)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^Successful"
	 * 
	 * </pre>
	 */
	@Test
	public void testNonew007() throws VistaWebServiceFault {

		request = new XMXUTILNonewRequest(".5", ".5", "58880", "1");

		response = service.nonew(request);

		assertNotNull(response);
		if (response.getOutputData() != null) {
			assertEquals("Successful", response.getOutputData().get(1));
		} else {
			fail("outputData is NULL !!");
		}
	}

	/**
	 * <em>Test Case #8  </em>
	 * 
	 * Make a message not New and update the message count. Let calling
	 * application do the locking/unlocking (XMLOCKIT=0).
	 * 
	 * <pre>
	 * Input Data:
	 * >S XMDUZ=.5
	 * >S XMK=.5
	 * >S XMZ=1000    ***DBITPRO use   >S XMZ=58880
	 * >S XMLOCKIT=0
	 * 
	 * Procedure Call:
	 * >D NONEW^XMWSOA04(.RETURN,XMDUZ,XMK,XMZ,XMLOCKIT)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^Successful"
	 * 
	 * </pre>
	 */
	@Test
	public void testNonew008() throws VistaWebServiceFault {

		request = new XMXUTILNonewRequest(".5", ".5", "58880", "0");

		response = service.nonew(request);

		assertNotNull(response);
		if (response.getOutputData() != null) {
			assertEquals("Successful", response.getOutputData().get(1));
		} else {
			fail("outputData is NULL !!");
		}
	}
}
