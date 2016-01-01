/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.unit;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;

import gov.va.oit.vistaevolution.mailman.ws.xmxedit.XMXEDITResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.XMXEDITPriorityEndointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.interfaces.XMXEDITPriorityEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITPriorityRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITPriorityResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;

/**
 * @author Christopher Schuck
 *
 */
public class XMXEDITPriorityTest extends VistaLinkContextTestParent {

	private static final String RPCCALL = "";
	
	/**
	 * Test method for {@link gov.va.oit.vistaevolution.mailman.ws.xmxedit.endpoints.XMXEDITPriorityEndointImpl#priority(gov.va.oit.vistaevolution.mailman.ws.xmxedit.model.XMXEDITPriorityRequest)}.
	 */
	@Test
	public void testPriority() {
		String expectedOutput = "0^Successful";
		
		XMXEDITPriorityRequest request = new XMXEDITPriorityRequest("74457");
		
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);

		XMXEDITPriorityEndpoint endpoint = new XMXEDITPriorityEndointImpl(getVistaLinkContext(), new XMXEDITResponseFactory());
		
		XMXEDITPriorityResponse response = endpoint.priority(request);
		
		assertNotNull(response);
		
		assertTrue(response.getXmmsg().equals(expectedOutput));
	}

}
