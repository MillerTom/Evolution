/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.XMXUTILResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.XMXUTILTpmsgctEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.XMXUTILTpmsgctEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILTpmsgctRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILTpmsgctResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Unit Test for TPMSGCT method of XMXUTIL Webservice
 */
public class XMXUTILTpmsgctTest extends VistaLinkContextTestParent {

	/**
	 * Default Empty Constructor
	 */
	public XMXUTILTpmsgctTest() {
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
		String expectedOutput = "1";

		XMXUTILTpmsgctRequest request = new XMXUTILTpmsgctRequest(".6");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMXUTILTpmsgctEndpoint service = new XMXUTILTpmsgctEndpointImpl(
				getVistaLinkContext(), new XMXUTILResponseFactory());

		XMXUTILTpmsgctResponse response = service.tpmsgct(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getTotNumOfNewPriorityMsgs());
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
		String expectedOutput = "-1^User's mailbox doesn't exist";

		XMXUTILTpmsgctRequest request = new XMXUTILTpmsgctRequest("9999999");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMXUTILTpmsgctEndpoint service = new XMXUTILTpmsgctEndpointImpl(
				getVistaLinkContext(), new XMXUTILResponseFactory());

		XMXUTILTpmsgctResponse response = service.tpmsgct(request);

		assertNotNull(response);
		assertEquals("User's mailbox doesn't exist",
				response.getMsgRoot().get(1));
	}
}
