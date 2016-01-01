/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.unit;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.XMXUtil2ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.XMXUTIL2InmsgEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2InmsgEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2InmsgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2InmsgResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;

/**
 * @author Christopher Schuck
 *
 */
public class XMXUTIL2InmsgTest extends VistaLinkContextTestParent {
	
	private static final String RPCCALL = "";

	/**
	 * Test method for {@link gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.XMXUTIL2InmsgEndpointImpl#inmsg(gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2InmsgRequest)}.
	 */
	@Test
	public void testInmsg() {
		String expectedOutput = "-1^Error in required input";
		
		XMXUTIL2InmsgRequest request = new XMXUTIL2InmsgRequest("", "0", "74457");
		
		//  Use Mockito to set up vistaLinkContext from parent class to return
		//  proper string.
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
				expectedOutput);

		XMXUTIL2InmsgEndpoint endpoint = new XMXUTIL2InmsgEndpointImpl(getVistaLinkContext(), new XMXUtil2ResponseFactory());
		
		XMXUTIL2InmsgResponse response = endpoint.inmsg(request);
		
		assertNotNull(response);
		
		assertEquals(expectedOutput, response.getError());
	}

}
