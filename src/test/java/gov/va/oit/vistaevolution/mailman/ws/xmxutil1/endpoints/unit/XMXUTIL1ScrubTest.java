/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.XMXUTIL1ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.XMXUTIL1ScrubEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1ScrubEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1ScrubRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1ScrubResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author rcollins
 *
 */
public class XMXUTIL1ScrubTest extends VistaLinkContextTestParent {
    
    private static final String RPCCALL = "XMWSOA SCRUB STRING";
    
    @Test
    public void testScrub() {        
        
        String expectedOutput = "A String";
        
        XMXUTIL1ScrubRequest request = new XMXUTIL1ScrubRequest();
        
        request.setXmxstring(" A String ");
        
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);

        XMXUTIL1ScrubEndpoint endpoint = new XMXUTIL1ScrubEndpointImpl(this.getVistaLinkContext(), new XMXUTIL1ResponseFactory());
        
        XMXUTIL1ScrubResponse response = endpoint.scrub(request);
        
        assertNotNull(response);      
        assertEquals(expectedOutput, response.getReturns());        
    }
    
    
    @Test(expected = VistaWebServiceFault.class)
    public void testScrubError() {        
        
        String expectedOutput = "A String";
        
        XMXUTIL1ScrubRequest request = new XMXUTIL1ScrubRequest();
        
        request.setXmxstring(" A String ");
        
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenThrow(new VistaWebServiceFault("Mockito ERROR"));  
        

        XMXUTIL1ScrubEndpoint endpoint = new XMXUTIL1ScrubEndpointImpl(this.getVistaLinkContext(), new XMXUTIL1ResponseFactory());
        
        XMXUTIL1ScrubResponse response = endpoint.scrub(request);
        
        assertNotNull(response);      
        assertEquals(expectedOutput, response.getReturns());        
    }
    
    
}
