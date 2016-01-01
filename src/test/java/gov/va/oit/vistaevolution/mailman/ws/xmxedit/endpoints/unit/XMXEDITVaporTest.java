/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.unit;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.XMXEDITResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.XMXEDITVaporEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITVaporEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITVaporRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITVaporResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @author Christopher Schuck
 *
 */
public class XMXEDITVaporTest extends VistaLinkContextTestParent {
	
	private static final String RPCCALL = "";
	
	private static final Logger LOGGER = Logger.getLogger(XMXEDITVaporTest.class);

	/**
	 * Test method for {@link gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.XMXEDITVaporEndpointImpl#vapor(gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITVaporRequest)}.
	 */
	@Test
	public void testVapor() {
		String expectedOutput = "0^Successful";
		
		XMXEDITVaporRequest request = new XMXEDITVaporRequest("74457", "3140318");
		
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
		
		XMXEDITVaporEndpoint endpoint = new XMXEDITVaporEndpointImpl(getVistaLinkContext(), new XMXEDITResponseFactory());
		
		XMXEDITVaporResponse response = endpoint.vapor(request);
		
		assertNotNull(response);
		
		LOGGER.debug(response.getXmmsg());
		
		assertTrue(response.getXmmsg().equals(expectedOutput));
	}

}
