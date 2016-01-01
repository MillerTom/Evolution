/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.XMXUtil2ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.XMXUTIL2QrespEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2QrespEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2QrespRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2QrespResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;

import org.junit.Test;

/**
 * @author Christopher Schuck
 *
 */
public class XMXUTIL2QrespTest extends VistaLinkContextTestParent {
	
	private static final String RPCCALL = "";

	/**
	 * Test method for {@link gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.XMXUTIL2QrespEndpointImpl#qresp(gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2QrespRequest)}.
	 */
	@Test
	public void testQresp() {
        String expectedOutput = "0";
        
        XMXUTIL2QrespRequest request = new XMXUTIL2QrespRequest();
        
        request.setXmz("73973");
        
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
        
        //  Set up Endpoint
        XMXUTIL2QrespEndpoint endpoint = new XMXUTIL2QrespEndpointImpl(this.getVistaLinkContext(),
                new XMXUtil2ResponseFactory());
        
        //  Execute request
        XMXUTIL2QrespResponse response = endpoint.qresp(request);        
        assertNotNull(response);
        assertEquals(expectedOutput, response.getResponse());
	}

}
