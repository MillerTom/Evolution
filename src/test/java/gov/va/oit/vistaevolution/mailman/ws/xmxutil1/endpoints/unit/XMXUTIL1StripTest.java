/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.XMXUTIL1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.XMXUTIL1StripEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1StripEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1StripRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1StripResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;

import org.junit.Test;

/**
 * @author Christopher Schuck
 *
 */
public class XMXUTIL1StripTest extends VistaLinkContextTestParent {
	
	private static final String RPCCALL = "XMWSOA STRIP STRING";

	/**
	 * Test method for {@link gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.XMXUTIL1StripEndpointImpl#strip(gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1StripRequest)}.
	 */
	@Test
	public void testStrip() {
        String expectedOutput = "A String";
        
        XMXUTIL1StripRequest request = new XMXUTIL1StripRequest();
        
        request.setXmstring(" A String ");
        
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);

        XMXUTIL1StripEndpoint endpoint = new XMXUTIL1StripEndpointImpl(this.getVistaLinkContext(), new XMXUTIL1ResponseFactory());
        
        XMXUTIL1StripResponse response = endpoint.strip(request);
        
        assertNotNull(response);      
        assertEquals(expectedOutput, response.getResponse());        
	}

}
