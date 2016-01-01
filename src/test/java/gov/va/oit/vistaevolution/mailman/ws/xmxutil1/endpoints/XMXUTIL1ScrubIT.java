/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1ScrubEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1ScrubRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1ScrubResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;

import org.junit.Test;

/**
 * @author rcollins
 *
 */
public class XMXUTIL1ScrubIT extends EvolutionIT<XMXUTIL1ScrubEndpoint> {
       

    @Override
    protected Class<XMXUTIL1ScrubEndpoint> getType() {
        return XMXUTIL1ScrubEndpoint.class;
    }
    
    
    @Test
    public void scrubTest001() {
        
        XMXUTIL1ScrubRequest request = new XMXUTIL1ScrubRequest();
        
        request.setXmxstring(" ABC XYZ ");
        
        XMXUTIL1ScrubResponse response = this.service.scrub(request);
        assertNotNull(response);
        assertEquals("ABC XYZ", response.getReturns());
    }
    

    @Test
    public void scrubTest002() {
        
        XMXUTIL1ScrubRequest request = new XMXUTIL1ScrubRequest();
        request.setXmxstring("\nABC\nXYZ\n");
        
        XMXUTIL1ScrubResponse response = this.service.scrub(request);
        assertNotNull(response);
        assertEquals("ABCXYZ", response.getReturns());
    }
    

    
}
