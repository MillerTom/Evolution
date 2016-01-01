/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.XMXUTILResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.XMXUTILTnmsgctEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.XMXUTILTnmsgctEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILTnmsgctRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILTnmsgctResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Unit Test for TNMSGCT method of XMXUTIL Webservice
 */
public class XMXUTILTnmsgctTest extends VistaLinkContextTestParent {

	/**
	 * Default Empty Constructor
	 */
	public XMXUTILTnmsgctTest() {
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
		String expectedOutput = "2206";

		XMXUTILTnmsgctRequest request = new XMXUTILTnmsgctRequest(".5");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMXUTILTnmsgctEndpoint service = new XMXUTILTnmsgctEndpointImpl(
				getVistaLinkContext(), new XMXUTILResponseFactory());

		XMXUTILTnmsgctResponse response = service.tnmsgct(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getTotNumOfNewMsgs());
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
		String expectedOutput = "-1^User's mailbox doesn't exist";

		XMXUTILTnmsgctRequest request = new XMXUTILTnmsgctRequest("9999999");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMXUTILTnmsgctEndpoint service = new XMXUTILTnmsgctEndpointImpl(
				getVistaLinkContext(), new XMXUTILResponseFactory());

		XMXUTILTnmsgctResponse response = service.tnmsgct(request);

		assertNotNull(response);
		assertEquals("User's mailbox doesn't exist",
				response.getMsgRoot().get(1));
	}
}
