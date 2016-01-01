/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.XMXSEC1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.XMXSEC1PakmanEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.endpoints.interfaces.XMXSEC1PakmanEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1PakmanRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model.XMXSEC1PakmanResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author Leisa Martella
 *
 */
/**
 * XMWSOA IS MSG PAKMAN
 * 
 * This RPC returns a value indicating whether a message is a PackMan message
 * or not (0 = No; 1 = Yes).  If there's an error, it returns an error
 * message.
 * 
 * Input Parameters:
 * 	 XMZ    (Required) Message Internal Entry Number (IEN) in the MESSAGE file
 * 			(#3.9).
 * 
 * Returns:
 *   0-No, the message is not a PackMan message.
 *   1-Yes, the message is a PackMan message.
 *   
 */

public class XMXSEC1PakmanTest extends VistaLinkContextTestParent {
    
    private static final String RPCCALL = "";
    
    /**
     * Test Case 1
     * 
     * 
     */

    @Test
    public void testPakman() throws VistaWebServiceFault {
        
        String expectedOutput = "1";
        
        XMXSEC1PakmanRequest request = new XMXSEC1PakmanRequest();
        
        request.setXmz("");
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
        
        //  Set up Endpoint
        XMXSEC1PakmanEndpoint endpoint = new XMXSEC1PakmanEndpointImpl(this.getVistaLinkContext(),
                new XMXSEC1ResponseFactory());
        
        //  Execute request
        XMXSEC1PakmanResponse response = endpoint.xmxsec1Pakman(request);        
        assertNotNull(response);
        assertEquals(expectedOutput, response.getResults());
        
    }
}
