/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmrent.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmrent.XMRENTResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmrent.endpoints.XMRENTNetEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmrent.endpoints.interfaces.XMRENTNetEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmrent.model.XMRENTNetRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmrent.model.XMRENTNetResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author Leisa Martella
 *
 */
/**
 * XMWSOA NET
 * 
 * This RPC  returns an ^-delimited string of information about a message. If
 * message does not exist, returns null.
 * 
 * Input Parameters:
 *		XMZ		(Required) Message Internal Entry Number (IEN) in the MESSAGE file (#3.9).
 *
 * Response:
 * 		Piece 1: Message date, in the following format: MAY 25, 1999@08:16:00, if
 * 				 local, or as sent, if remote.
 * 		Piece 2: Scramble hint, if any; otherwise null.
 * 		Piece 3: Message from (external).
 * 		Piece 4: Message ID at originating site (XMZ@sitename, if local).
 * 		Piece 5: Message sender, usually surrogate (external).
 * 		Piece 6: Message subject (external).
 * 		Piece 7: Message ID of original message, if this is a reply
 * 				 (XMZ@sitename, if local).
 * 		Piece 8: Message type (Piece 7 of the message's zero node).
 *  	-1^[error text]
 *   
 */

public class XMRENTNetTest extends VistaLinkContextTestParent {
    
    private static final String RPCCALL = "";
    
    /**
     * Test Case 1
     * 
     * 
     */

    @Test
    public void testNet() throws VistaWebServiceFault {
        
        String expectedOutput = "1";
        
        XMRENTNetRequest request = new XMRENTNetRequest();
        
        request.setXmz("");
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
        
        //  Set up Endpoint
        XMRENTNetEndpoint endpoint = new XMRENTNetEndpointImpl(this.getVistaLinkContext(),
                new XMRENTResponseFactory());
        
        //  Execute request
        XMRENTNetResponse response = endpoint.xmrentNet(request);        
        assertNotNull(response);
        assertEquals(expectedOutput, response.getResults());
        
    }
}
