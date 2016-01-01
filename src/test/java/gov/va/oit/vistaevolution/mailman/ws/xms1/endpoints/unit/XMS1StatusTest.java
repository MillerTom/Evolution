/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xms1.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xms1.XMS1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xms1.endpoints.XMS1StatusEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xms1.model.XMS1StatusRequest;
import gov.va.oit.vistaevolution.mailman.ws.xms1.model.XMS1StatusResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * 
 * @author Leisa Martella <Leisa.Martella@vangent.com>
 * 
 *         Unit Test for Status method of XMS1 Status Webservice
 * 
 */
public class XMS1StatusTest extends VistaLinkContextTestParent {

	/**
	 * No Arguments Constructor
	 */
	public XMS1StatusTest() {
		super();
	}

	/**
	 * <em>Test Case #1</em>
	 * 
	 * Error. Do not pass in the Message IEN or the Server Name.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >K RETURN
	 * >S XMZ=""
	 * >S XMSER=""
	 * 
	 * Procedure Call:
	 * >D STATUS^XMWSOA01(.RETURN,XMZ,XMSER)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="-1^Error in required input"
	 * 
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStatus001() throws VistaWebServiceFault {

		String expectedOutput = "-1^Error in required input";

		XMS1StatusRequest request = new XMS1StatusRequest();
		request.setXmz("");
		request.setXmser("");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMS1StatusEndpointImpl service = new XMS1StatusEndpointImpl(
				new XMS1ResponseFactory(), getVistaLinkContext());

		XMS1StatusResponse response = service.status(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getResult());

	}

	/**
	 * <em>Test Case #2</em>
	 * 
	 * Pass in avalid Message IEN and a valid Server Name.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >K RETURN
	 * >S XMZ="29"
	 * >S XMSER="XXX@Q-ASI.MED.VA.GOV"
	 * 
	 * Procedure Call:
	 * >D STATUS^XMWSOA01(.RETURN,XMZ,XMSER)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN="0^Awaiting transmission."
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testStatus002() throws VistaWebServiceFault {

		String expectedOutput = "0^Awaiting transmission.";

		XMS1StatusRequest request = new XMS1StatusRequest();
		request.setXmz("29");
		request.setXmser("XXX@Q-ASI.MED.VA.GOV");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMS1StatusEndpointImpl service = new XMS1StatusEndpointImpl(
				new XMS1ResponseFactory(), getVistaLinkContext());

		XMS1StatusResponse response = service.status(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getResult());
	}

}
