/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.unit;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.XMXUTILResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.XMXUTILBsktnameEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.XMXUTILBsktnameEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILBsktnameRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILBsktnameResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;

import org.junit.AfterClass;
import org.junit.Test;

/**
 * @author Christopher Schuck
 *
 */
public class XMXUTIL2BsktTest extends VistaLinkContextTestParent {
	
	private static final String RPCCALL = "";

	/**
	 * Test method for {@link gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.XMXUTIL2BsktEndpointImpl#bskt(gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2BsktRequest)}.
	 */
	@Test
	public void testBskt() {
        String expectedOutput = "0";
        
        XMXUTILBsktnameRequest request = new XMXUTILBsktnameRequest();
        
        request.setXmduz(".5");
        
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
        
        //  Set up Endpoint
        XMXUTILBsktnameEndpoint endpoint = new XMXUTILBsktnameEndpointImpl(this.getVistaLinkContext(),
                new XMXUTILResponseFactory());
        
        //  Execute request
        XMXUTILBsktnameResponse response = endpoint.bsktname(request);        
        assertNotNull(response);
        assertEquals(expectedOutput, response.getBsktIEN());
	}

}
