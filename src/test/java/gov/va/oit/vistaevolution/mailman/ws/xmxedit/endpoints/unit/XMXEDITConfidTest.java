/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.unit;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.apache.log4j.Logger;
import org.junit.Test;

import gov.va.oit.vistaevolution.mailman.ws.xmxedit.XMXEDITResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.XMXEDITConfidEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITConfidEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITConfidRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITConfidResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.XMXUTILBsktnameIT;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

/**
 * @author Christopher Schuck
 *
 */
public class XMXEDITConfidTest extends VistaLinkContextTestParent {
	
	private static final String RPCCALL = "";
	
	private static final Logger LOGGER = Logger.getLogger(XMXEDITConfidTest.class);

	/**
	 * Test method for {@link gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.XMXEDITConfidEndpointImpl#confid(gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITConfidRequest)}.
	 */
	@Test
	public void testConfid() throws VistaWebServiceFault {
		String expectedOutput = "0^’Confidential’ flag removed.^";
		
		XMXEDITConfidRequest request = new XMXEDITConfidRequest();
		
		request.setXmz("73994");
		request.setXminstr("");
		
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
		
		XMXEDITConfidEndpoint endpoint = new XMXEDITConfidEndpointImpl(this.getVistaLinkContext(), new XMXEDITResponseFactory());
		
		XMXEDITConfidResponse response = endpoint.confid(request);
		
		assertNotNull(response);
		
		LOGGER.info(response.getXmmsg() + " " + response.getXminstr());
		
		assertTrue(response.getXmmsg().equals(expectedOutput));
	}

}
