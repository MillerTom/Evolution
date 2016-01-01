/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.XMXUTIL1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.XMXUTIL1TimeDiffEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1TimeDiffEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1TimeDiffRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1TimeDiffResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author rcollins
 *
 */
public class XMXUTIL1TimeDiffTest extends VistaLinkContextTestParent {
    
    private static final String RPCCALL = "XMWSOA REFOREMAT TIME DIFF";

    @Test
    public void TimeDiffTest() {        

        String expectedOutput = "-0230";
        
        XMXUTIL1TimeDiffRequest request = new XMXUTIL1TimeDiffRequest();
        
        request.setXmdiff("-2.5");
        
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);

        XMXUTIL1TimeDiffEndpoint endpoint = new XMXUTIL1TimeDiffEndpointImpl(this.getVistaLinkContext(), new XMXUTIL1ResponseFactory());
        
        XMXUTIL1TimeDiffResponse response = endpoint.timediff(request);
        
        assertNotNull(response);      
        assertEquals(expectedOutput, response.getResponse());    
    }
   
    
    @Test(expected = VistaWebServiceFault.class)
    public void TimeDiffTestError() {        

        String expectedOutput = "-0230";
        
        XMXUTIL1TimeDiffRequest request = new XMXUTIL1TimeDiffRequest();
        
        request.setXmdiff("-2.5");
        
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenThrow(new VistaWebServiceFault("MOCKITO ERROR"));

        XMXUTIL1TimeDiffEndpoint endpoint = new XMXUTIL1TimeDiffEndpointImpl(this.getVistaLinkContext(), new XMXUTIL1ResponseFactory());
        
        XMXUTIL1TimeDiffResponse response = endpoint.timediff(request);
        
        assertNotNull(response);      
        assertEquals(expectedOutput, response.getResponse());    
    }
   
}
