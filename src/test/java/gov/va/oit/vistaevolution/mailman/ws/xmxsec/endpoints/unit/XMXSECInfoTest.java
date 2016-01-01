package gov.va.oit.vistaevolution.mailman.ws.xmxsec.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.XMXSECResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.endpoints.XMXSECInfoEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.endpoints.interfaces.XMXSECInfoEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.model.XMXSECInfoRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.model.XMXSECInfoResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * 
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Unit Test for INFO method of XMXSEC Webservice
 */
public class XMXSECInfoTest extends VistaLinkContextTestParent {

	/**
	 * Default Empty Constructor
	 */
	public XMXSECInfoTest() {
		super();
	}

	/**
	 * <em>Test Case #1  </em>
	 * 
	 * Check if a message is marked Information Only.
	 * 
	 * <pre>
	 * Input Data:
	 * >S XMZ=100
	 * 
	 * Procedure Call:
	 * >D INFO^XMWSOA06(.RETURN,XMZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN=0
	 * 
	 * </pre>
	 */
	@Test
	public void testInfo001() throws VistaWebServiceFault {
		String expectedOutput = "0";

		XMXSECInfoRequest request = new XMXSECInfoRequest("100");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMXSECInfoEndpoint service = new XMXSECInfoEndpointImpl(
				new XMXSECResponseFactory(), getVistaLinkContext());

		XMXSECInfoResponse response = service.info(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getIsInfoOnlyMsg());
	}

	/**
	 * <em>Test Case #2  </em>
	 * 
	 * Check if a message is marked Information Only.
	 * 
	 * <pre>
	 * Input Data:
	 * >S XMZ=2930
	 * 
	 * Procedure Call:
	 * >D INFO^XMWSOA06(.RETURN,XMZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN=1
	 * 
	 * </pre>
	 */
	@Test
	public void testInfo002() throws VistaWebServiceFault {
		String expectedOutput = "1";

		XMXSECInfoRequest request = new XMXSECInfoRequest("2930");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMXSECInfoEndpoint service = new XMXSECInfoEndpointImpl(
				new XMXSECResponseFactory(), getVistaLinkContext());

		XMXSECInfoResponse response = service.info(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getIsInfoOnlyMsg());
	}

}
