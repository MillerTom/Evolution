/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.XMXUtil2ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.XMXUTIL2PriEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2PriEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2PriRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2PriResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author Leisa Martella
 *
 */
/**
 * XMWSOA PRIORITY MSG IND
 * 
 * This RPC returns a value indicating whether the message is priority or
 * not.  If there's an error, it returns an error message.
 * 
 * Input Parameters:
 * 	 XMZ    (Required) Message Internal Entry Number (IEN) in the MESSAGE file
 * 			(#3.9).
 * 
 * Returns:
 *  Is the message marked as priority?
 *   0-No
 *   1-Yes
 *   
 */

public class XMXUTIL2PriTest extends VistaLinkContextTestParent {
    
    private static final String RPCCALL = "";
    

    @Test
    public void testPri() throws VistaWebServiceFault {
        
        String expectedOutput = "";
        
        XMXUTIL2PriRequest request = new XMXUTIL2PriRequest();
        
        request.setXmz("");
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
        
        //  Set up Endpoint
        XMXUTIL2PriEndpoint endpoint = new XMXUTIL2PriEndpointImpl(this.getVistaLinkContext(),
                new XMXUtil2ResponseFactory());
        
        //  Execute request
        XMXUTIL2PriResponse response = endpoint.xmxutil2Pri(request);        
        assertNotNull(response);
        assertEquals(expectedOutput, response.getResults());
        
    }
}
