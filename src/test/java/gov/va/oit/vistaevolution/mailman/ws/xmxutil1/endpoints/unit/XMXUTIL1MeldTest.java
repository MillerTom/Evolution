/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.XMXUTIL1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.XMXUTIL1MeldEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1MeldEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1MeldRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1MeldResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author Leisa Martella
 *
 */
/*
 * XMWSOA MELD STRING
 * This RPC combines a string and a number to form a new string of a given
 * length. The string will be right justified; the number left-justified,
 * with at least two spaces separating the string and number. The string will
 * be truncated, if necessary.  If there's an error, it returns an error
 * message.
 * 
 * Input Parameters:
 * 		XMSTRING	(Required) The input string.
 * 		XMNUMBER	(Optional) The number.
 * 		XMLEN		(Required) The length of the new string to be formed.
 * 
 * Response:
 * 		Returns the newly formed string.
 * 
 * 			Example 1
 * 				XMSTRING="Lotus blossom",XMNUM=123,XMLEN=10
 * 				Lotus 123
 * 			
 * 			Example 2
 * 				XMSTRING="Lotus blossom",XMNUM=123,XMLEN=15
 * 				Lotus blos 123
 * 
 */
public class XMXUTIL1MeldTest extends VistaLinkContextTestParent {
    
    private static final String RPCCALL = "";
    

    @Test
    public void testName() throws VistaWebServiceFault {
        
        String expectedOutput = "Lotus 123";
        
        XMXUTIL1MeldRequest request = new XMXUTIL1MeldRequest();
        
        request.setXmString("Lotus blossom");
        request.setXmNumber("123");
        request.setXmLen("10");
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
        
        //  Set up Endpoint
        XMXUTIL1MeldEndpoint endpoint = new XMXUTIL1MeldEndpointImpl(this.getVistaLinkContext(),
                new XMXUTIL1ResponseFactory());
        
        //  Execute request
        XMXUTIL1MeldResponse response = endpoint.meld(request);        
        assertNotNull(response);
        assertEquals(expectedOutput, response.getResults());
        
    }
}
