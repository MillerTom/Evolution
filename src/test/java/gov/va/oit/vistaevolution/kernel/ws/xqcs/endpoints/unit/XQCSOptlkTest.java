/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xqcs.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.kernel.ws.xqcs.XQCSResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xqcs.endpoints.XQCSOptlkEndpointImpl;
import gov.va.oit.vistaevolution.kernel.ws.xqcs.endpoints.interfaces.XQCSOptlkEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xqcs.model.XQCSOptlkRequest;
import gov.va.oit.vistaevolution.kernel.ws.xqcs.model.XQCSOptlkResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Unit Test for OPTLK method of XQCS Webservice
 */
public class XQCSOptlkTest extends VistaLinkContextTestParent {

	/**
	 * No Arguments Constructor
	 */
	public XQCSOptlkTest() {
		super();
	}

	/**
	 * <em>Test Case #1  </em>
	 * 
	 * Lookup the Option named “XUCOMMAND” and return its IEN.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >S OPTION="XUCOMMAND"
	 * 
	 * Procedure Call:
	 * >S RETURN=$$OPTLK^XQCS(OPTION)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN=10
	 * 
	 * </pre>
	 */
	@Test
	public void testOptlk001() throws VistaWebServiceFault {

		String expectedOutput = "10";

		XQCSOptlkRequest request = new XQCSOptlkRequest();
		request.setXuopt("XUCOMMAND");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XQCSOptlkEndpoint service = new XQCSOptlkEndpointImpl(
				new XQCSResponseFactory(), getVistaLinkContext());

		XQCSOptlkResponse response = service.optlk(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getResult());

	}

	/**
	 * <em>Test Case #2  </em> Lookup the Option named “ZTESTOPTLKXQCS002” and
	 * return a null value.
	 * 
	 * <pre>
	 * Input Data:
	 * >S OPTION="ZTESTOPTLKXQCS002"
	 * 
	 * Procedure Call:
	 * >S RETURN=$$OPTLK^XQCS(OPTION)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN=""
	 * 
	 * </pre>
	 */
	@Test
	public void testOptlk002() throws VistaWebServiceFault {

		String expectedOutput = "";

		XQCSOptlkRequest request = new XQCSOptlkRequest();
		request.setXuopt("ZTESTOPTLKXQCS002");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XQCSOptlkEndpoint service = new XQCSOptlkEndpointImpl(
				new XQCSResponseFactory(), getVistaLinkContext());

		XQCSOptlkResponse response = service.optlk(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getResult());

	}
}
