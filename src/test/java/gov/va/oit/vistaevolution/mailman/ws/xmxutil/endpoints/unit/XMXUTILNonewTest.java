/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.XMXUTILResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.XMXUTILNonewEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.XMXUTILNonewEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILNonewRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILNonewResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Unit Test for NONEW method of XMXUTIL Webservice
 */
public class XMXUTILNonewTest extends VistaLinkContextTestParent {

	/**
	 * No Arguments Constructor
	 */
	public XMXUTILNonewTest() {
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

		String expectedOutput = "-1^Error in required input";

		XMXUTILNonewRequest request = new XMXUTILNonewRequest("", ".3", "100",
				"1");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMXUTILNonewEndpoint service = new XMXUTILNonewEndpointImpl(
				getVistaLinkContext(), new XMXUTILResponseFactory());

		XMXUTILNonewResponse response = service.nonew(request);

		assertNotNull(response);
		assertEquals("Error in required input", response.getMsgRoot().get(1));
	}

	/**
	 * <em>Test Case #2  </em>
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
	public void testNonew002() throws VistaWebServiceFault {
		String expectedOutput = "-1^Successful";

		XMXUTILNonewRequest request = new XMXUTILNonewRequest(".5", ".5",
				"58880", "0");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMXUTILNonewEndpoint service = new XMXUTILNonewEndpointImpl(
				getVistaLinkContext(), new XMXUTILResponseFactory());

		XMXUTILNonewResponse response = service.nonew(request);

		assertNotNull(response);
		assertEquals("Successful", response.getOutputData().get(1));
	}
}
