/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.XMXUTILResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.XMXUTILMakenewEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.XMXUTILMakenewEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILMakenewRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILMakenewResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Unit Test for MAKENEW method of XMXUTIL Webservice
 */
public class XMXUTILMakenewTest extends VistaLinkContextTestParent {

	/**
	 * No Arguments Constructor
	 */
	public XMXUTILMakenewTest() {
		super();
	}

	/**
	 * <em>Test Case #1  </em>
	 * 
	 * Make a message new.
	 * 
	 * <pre>
	 * Input Data:
	 * >K RETURN
	 * >S XMDUZ=.5,XMK=1,XMZ=285424,XMLOCKIT=0
	 * 
	 * Procedure Call:
	 * >D MAKENEW^XMWSOA04(.RETURN,XMDUZ,XMK,XMZ,XMLOCKIT)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="0^Successful"
	 * 
	 * </pre>
	 */
	@Test
	public void testInit001() throws VistaWebServiceFault {

		String expectedOutput = "0^Successful";

		XMXUTILMakenewRequest request = new XMXUTILMakenewRequest();
		request.setXmduz(".5");
		request.setXmk("1");
		request.setXmz("285424");
		request.setXmlockit("0");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMXUTILMakenewEndpoint service = new XMXUTILMakenewEndpointImpl(
				getVistaLinkContext(), new XMXUTILResponseFactory());

		XMXUTILMakenewResponse response = service.makenew(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getAddMsgResult());

	}

	/**
	 * <em>Test Case #2  </em>
	 * 
	 * Make a message new. Have MailMan lock and unlock the mailbox global.
	 * 
	 * <pre>
	 * Input Data:
	 * >K RETURN
	 * >S XMDUZ=.5,XMK=1,XMZ=285425,XMLOCKIT=1
	 * 
	 * Procedure Call:
	 * >D MAKENEW^XMWSOA04(.RETURN,XMDUZ,XMK,XMZ,XMLOCKIT)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="0^Successful"
	 * 
	 * </pre>
	 */
	@Test
	public void testInit002() throws VistaWebServiceFault {

		String expectedOutput = "0^Successful";

		XMXUTILMakenewRequest request = new XMXUTILMakenewRequest();
		request.setXmduz(".5");
		request.setXmk("1");
		request.setXmz("285425");
		request.setXmlockit("1");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMXUTILMakenewEndpoint service = new XMXUTILMakenewEndpointImpl(
				getVistaLinkContext(), new XMXUTILResponseFactory());

		XMXUTILMakenewResponse response = service.makenew(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getAddMsgResult());

	}

}
