/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.unit;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.XMXEDITResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.XMXEDITTextEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITTextEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITTextRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITTextResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author Christopher Schuck
 *
 */
public class XMXEDITTextTest extends VistaLinkContextTestParent {
	
	private static final String RPCCALL = "";

	/**
	 * Test method for {@link gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.XMXEDITTextEndpointImpl#text(gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITTextRequest)}.
	 */
	@Test
	public void testText() {
		String expectedOutput = "0^Successful";
		
		List<String> xmbody = new ArrayList<String>();
		xmbody.add("LINE 1");
		xmbody.add("LINE 2");
		
		XMXEDITTextRequest request = new XMXEDITTextRequest("1", xmbody);
		
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
		
		XMXEDITTextEndpoint endpoint = new XMXEDITTextEndpointImpl(getVistaLinkContext(), new XMXEDITResponseFactory());
		
		XMXEDITTextResponse response = endpoint.text(request);
		
		assertNotNull(response);
		assertTrue(response.getResponse().equals(expectedOutput));
	}

}
