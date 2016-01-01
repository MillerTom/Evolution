/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xqcs.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.kernel.ws.xqcs.XQCSResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xqcs.endpoints.XQCSChkEndpointImpl;
import gov.va.oit.vistaevolution.kernel.ws.xqcs.endpoints.interfaces.XQCSChkEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xqcs.model.XQCSChkRequest;
import gov.va.oit.vistaevolution.kernel.ws.xqcs.model.XQCSChkResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Unit Test for CHK method of XQCS Webservice
 */
public class XQCSChkTest extends VistaLinkContextTestParent {

	/**
	 * No Arguments Constructor
	 */
	public XQCSChkTest() {
		super();
	}

	/**
	 * <em>Test Case #1  </em>
	 * 
	 * Check whether a user has access to a menu option. Use the IEN of the menu
	 * option.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S XUIEN=1
	 * >S XUOPT=7
	 * >S XURPC=""
	 * 
	 * Procedure Call:
	 * >D CHKR^XUSOAR(.RETURN,XUIEN,XUOPT,XURPC)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN=1
	 * 
	 * </pre>
	 */
	@Test
	public void testChk001() throws VistaWebServiceFault {

		String expectedOutput = "1";

		XQCSChkRequest request = new XQCSChkRequest();
		request.setXuien("1");
		request.setXuopt("7");
		request.setXurpc("");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XQCSChkEndpoint service = new XQCSChkEndpointImpl(
				new XQCSResponseFactory(), getVistaLinkContext());

		XQCSChkResponse response = service.chk(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getResult());

	}

	/**
	 * <em>Test Case #2  </em>
	 * 
	 * Check whether a user has access to a non-existent menu option. Use a name
	 * for the menu option.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S XUIEN=1
	 * >S XUOPT="FAKE OPTION"
	 * >S XURPC=""
	 * 
	 * Procedure Call:
	 * >D CHKR^XUSOAR(.RETURN,XUIEN,XUOPT,XURPC)
	 * 
	 * Expected Output:
	 * 
	 * >ZW RETURN
	 * RETURN="No such option in the ""B"" cross reference of the Option File."
	 * 
	 * </pre>
	 */
	@Test
	public void testChk002() throws VistaWebServiceFault {

		String expectedOutput = "No such option in the \"\"B\"\" cross reference of the Option File.";

		XQCSChkRequest request = new XQCSChkRequest();
		request.setXuien("1");
		request.setXuopt("FAKE OPTION");
		request.setXurpc("");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XQCSChkEndpoint service = new XQCSChkEndpointImpl(
				new XQCSResponseFactory(), getVistaLinkContext());

		XQCSChkResponse response = service.chk(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getResult());

	}

}
