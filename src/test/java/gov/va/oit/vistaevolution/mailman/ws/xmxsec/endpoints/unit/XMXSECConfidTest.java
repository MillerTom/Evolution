package gov.va.oit.vistaevolution.mailman.ws.xmxsec.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.XMXSECResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.endpoints.XMXSECConfidEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.endpoints.interfaces.XMXSECConfidEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.model.XMXSECConfidRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.model.XMXSECConfidResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * 
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Unit Test for CONFID method of XMXSEC Webservice
 */
public class XMXSECConfidTest extends VistaLinkContextTestParent {

	/**
	 * Default Empty Constructor
	 */
	public XMXSECConfidTest() {
		super();
	}

	/**
	 * <em>Test Case #1  </em>
	 * 
	 * Check a message that is marked Confidential.
	 * 
	 * <pre>
	 * Input Data:
	 * >S XMZ=281758
	 * 
	 * Procedure Call:
	 * >D CONFID^XMWSOA06(.RETURN,XMZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN=1
	 * 
	 * </pre>
	 */
	@Test
	public void testConfid001() throws VistaWebServiceFault {
		String expectedOutput = "1";

		XMXSECConfidRequest request = new XMXSECConfidRequest("281758");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMXSECConfidEndpoint service = new XMXSECConfidEndpointImpl(
				getVistaLinkContext(), new XMXSECResponseFactory());

		XMXSECConfidResponse response = service.confid(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getMsgIsConfidential());
	}

	/**
	 * <em>Test Case #2  </em>
	 * 
	 * Check a message that is not marked Confidential.
	 * 
	 * <pre>
	 * Input Data:
	 * >S XMZ=281749
	 * 
	 * Procedure Call:
	 * >D CONFID^XMWSOA06(.RETURN,XMZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN=0
	 * 
	 * 
	 * </pre>
	 */
	@Test
	public void testConfid002() throws VistaWebServiceFault {
		String expectedOutput = "0";

		XMXSECConfidRequest request = new XMXSECConfidRequest("281749");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMXSECConfidEndpoint service = new XMXSECConfidEndpointImpl(
				getVistaLinkContext(), new XMXSECResponseFactory());

		XMXSECConfidResponse response = service.confid(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getMsgIsConfidential());
	}

}
