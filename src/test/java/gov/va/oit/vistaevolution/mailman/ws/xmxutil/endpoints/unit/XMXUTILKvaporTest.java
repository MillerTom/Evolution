/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.unit;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;

import gov.va.oit.vistaevolution.mailman.ws.xmxutil.XMXUTILResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.XMXUTILKvaporEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.XMXUTILKvaporEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILKvaporRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILKvaporResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;

/**
 * @author Christopher Schuck
 *
 */
public class XMXUTILKvaporTest extends VistaLinkContextTestParent {
	
	private static final String RPCCALL = "";

	/**
	 * Test method for {@link gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.XMXUTILKvaporEndpointImpl#kvapor(gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILKvaporRequest)}.
	 */
	@Test
	public void testKvapor() {
		String expectedOutput = "0^Successful";
		
		XMXUTILKvaporRequest request = new XMXUTILKvaporRequest(".6", "1", "74457", "3140317");
		
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);

        XMXUTILKvaporEndpoint endpoint = new XMXUTILKvaporEndpointImpl(new XMXUTILResponseFactory(), this.getVistaLinkContext());
        
        XMXUTILKvaporResponse response = endpoint.kvapor(request);
        
        assertNotNull(response);      
        assertTrue(response.getXmiu().equals(expectedOutput));
	}

}
