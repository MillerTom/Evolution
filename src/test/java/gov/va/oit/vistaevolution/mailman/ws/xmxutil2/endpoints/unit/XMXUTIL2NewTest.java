/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.XMXUtil2ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.XMXUTIL2NewEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2NewEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2NewRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2NewResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author Leisa Martella
 *
 */
/**
 * XMWSOA NEW MSG INDICATOR

 * This extrinsic function returns a value indicating whether or not a
 * message is new for this user in this basket.  If there's an error, it
 * returns an error message.
 * 
 * Input Parameters:
 *   XMDUZ	(Required) DUZ of user
 *   XMK	(Required) Internal Entry Number (IEN) of basket.
 * 	 XMZ    (Required) Message Internal Entry Number (IEN) in the MESSAGE file
 * 			(#3.9).
 * 
 * Returns:
 *  0-No
 *  1-Yes
 *   
 */

public class XMXUTIL2NewTest extends VistaLinkContextTestParent {
    
    private static final String RPCCALL = "";
    
    /**
     * Test Case 1
     * 
     * Look for message 59111 in mailbox 1 of user .5
     * 
     * >D NEW^XMWSOA07(.RESULT,.5,1,59111)
     * >ZW RESULT
     * RESULT=1
     * 
     */

    @Test
    public void testNew() throws VistaWebServiceFault {
        
        String expectedOutput = "1";
        
        XMXUTIL2NewRequest request = new XMXUTIL2NewRequest();
        
        request.setXmDuz(".5");
        request.setXmz("1");
        request.setXmk("59111");
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
        
        //  Set up Endpoint
        XMXUTIL2NewEndpoint endpoint = new XMXUTIL2NewEndpointImpl(this.getVistaLinkContext(),
                new XMXUtil2ResponseFactory());
        
        //  Execute request
        XMXUTIL2NewResponse response = endpoint.xmxutil2New(request);        
        assertNotNull(response);
        assertEquals(expectedOutput, response.getResults());
        
    }
}
