/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xma1b.endpoints.unit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.XMA1BResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.endpoints.XMA1BKlqEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.endpoints.interfaces.XMA1BKlqEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.model.XMA1BKlqRequest;
import gov.va.oit.vistaevolution.mailman.ws.xma1b.model.XMA1BKlqResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author rcollins
 *
 */
public class XMA1BklqTest extends VistaLinkContextTestParent {
    
    private static final String RPCCALL = "";
    
    @Test
    public void deleteMessageTest() throws VistaWebServiceFault {
        
        String expectedOutput = "0^Successful";
        
        XMA1BKlqRequest request = new XMA1BKlqRequest(); 
        
        request.setXmduz(".5");
        request.setXmk("");  
        request.setXmz("CODE GENERATED MAIL MESSAGE #10");
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
        
        XMA1BKlqEndpoint endpoint = new XMA1BKlqEndpointImpl(this.getVistaLinkContext(), 
                new XMA1BResponseFactory());
        
        XMA1BKlqResponse response = endpoint.klq(request);
        
        assertNotNull(response);
        assertTrue(response.getResponse().equalsIgnoreCase("0^Successful"));
        
    }
    
}
