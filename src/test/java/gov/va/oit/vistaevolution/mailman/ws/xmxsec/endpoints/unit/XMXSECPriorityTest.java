/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxsec.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.XMXSECResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.endpoints.XMXSECPriorityEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.endpoints.interfaces.XMXSECPriorityEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.model.XMXSECPriorityRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec.model.XMXSECPriorityResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Unit Test for PRIORITY method of XMXSEC Webservice
 */
public class XMXSECPriorityTest extends VistaLinkContextTestParent {

	/**
	 * Default Empty Constructor
	 */
	public XMXSECPriorityTest() {
		super();
	}

	/**
	 * <em>Test Case #1  </em>
	 * 
	 * Check if a message is marked as Priority.
	 * 
	 * <pre>
	 * Input Data:
	 * >S XMZ=100     ***DBITPRO use:    >S XMZ=58880
	 * 
	 * Procedure Call:
	 * >D PRIORITY^XMWSOA06(.RETURN,XMZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN=0
	 * 
	 * </pre>
	 */
	@Test
	public void testPriority001() throws VistaWebServiceFault {

		String expectedOutput = "0";

		XMXSECPriorityRequest request = new XMXSECPriorityRequest("58880");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMXSECPriorityEndpoint service = new XMXSECPriorityEndpointImpl(
				getVistaLinkContext(), new XMXSECResponseFactory());

		XMXSECPriorityResponse response = service.priority(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getIsPriorityMsg());
	}

	/**
	 * <em>Test Case #2  </em>
	 * 
	 * Check if a message is marked as Priority.
	 * 
	 * <pre>
	 * Input Data:
	 * >S XMZ=3214   ***DBITPRO use:    >S XMZ=59208
	 * 
	 * Procedure Call:
	 * >D PRIORITY^XMWSOA06(.RETURN,XMZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN=1
	 * 
	 * </pre>
	 */
	@Test
	public void testPriority002() throws VistaWebServiceFault {

		String expectedOutput = "1";

		XMXSECPriorityRequest request = new XMXSECPriorityRequest("59208");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XMXSECPriorityEndpoint service = new XMXSECPriorityEndpointImpl(
				getVistaLinkContext(), new XMXSECResponseFactory());

		XMXSECPriorityResponse response = service.priority(request);

		assertNotNull(response);
		assertEquals(expectedOutput, response.getIsPriorityMsg());
	}

}
