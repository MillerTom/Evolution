/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.XMXUTIL1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.XMXUTIL1MmdtEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1MmdtEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1MmdtRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1MmdtResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author Leisa Martella
 *
 */
/*
 * XMWSOA FM2MM DT
 * 
 * This RPC takes a VA FileMan Date/Time input string and returns it as a
 * reformatted string:
 *     mm/dd/yy@hh:mm
 *     
 * If there's an error, it returns an error message.
 * 
 * Input Parameters:
 * 		XMDT		(Required) VA FileMan Date/Time input string.
 * 
 * Response:
 * 		Returns a reformatted VA FileMan Date/Time string:
 * 			mm/dd/yy@hh:mm
 * 		Example
 * 			XMDT=2940629.105744
 * 			Return:  06/29/94@10:57
 * 
 */
public class XMXUTIL1MmdtTest extends VistaLinkContextTestParent {
    
    private static final String RPCCALL = "";
    

    @Test
    public void testName() throws VistaWebServiceFault {
        
        String expectedOutput = "06/29/94@10:57";
        
        XMXUTIL1MmdtRequest request = new XMXUTIL1MmdtRequest();
        
        request.setXmDt("2940629.105744");
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
        
        //  Set up Endpoint
        XMXUTIL1MmdtEndpoint endpoint = new XMXUTIL1MmdtEndpointImpl(this.getVistaLinkContext(),
                new XMXUTIL1ResponseFactory());
        
        //  Execute request
        XMXUTIL1MmdtResponse response = endpoint.mmdt(request);        
        assertNotNull(response);
        assertEquals(expectedOutput, response.getResults());
        
    }
}
