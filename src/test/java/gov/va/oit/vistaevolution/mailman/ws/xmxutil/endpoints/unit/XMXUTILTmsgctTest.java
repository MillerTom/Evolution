/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.XMXUTILResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.XMXUTILTmsgctEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.XMXUTILTmsgctEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILTmsgctRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILTmsgctResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Unit Test for TMSGCT method of XMXUTIL Webservice
 */
public class XMXUTILTmsgctTest extends VistaLinkContextTestParent {

	/**
	 * Default Empty Constructor
	 */
	public XMXUTILTmsgctTest() {
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
		String expectedOutput = "67897";

		XMXUTILTmsgctRequest request = new XMXUTILTmsgctRequest(".5");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMXUTILTmsgctEndpoint service = new XMXUTILTmsgctEndpointImpl(
				getVistaLinkContext(), new XMXUTILResponseFactory());

		XMXUTILTmsgctResponse response = service.tmsgct(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getTotNumOfMsgs());
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
		String expectedOutput = "-1^User's mailbox doesn't exist";

		XMXUTILTmsgctRequest request = new XMXUTILTmsgctRequest("9999999");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMXUTILTmsgctEndpoint service = new XMXUTILTmsgctEndpointImpl(
				getVistaLinkContext(), new XMXUTILResponseFactory());

		XMXUTILTmsgctResponse response = service.tmsgct(request);

		assertNotNull(response);
		assertEquals("User's mailbox doesn't exist",
				response.getMsgRoot().get(1));
	}
}
